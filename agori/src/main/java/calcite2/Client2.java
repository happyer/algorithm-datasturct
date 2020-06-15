package calcite2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.calcite.adapter.java.ReflectiveSchema;
import org.apache.calcite.jdbc.CalciteConnection;
import org.apache.calcite.schema.SchemaPlus;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/5
 */
public class Client2 {


    /**
     * CalciteServerStatement statement = connection.createStatement().unwrap(CalciteServerStatement.class);
     *         CalcitePrepare.Context prepareContext = statement.createPrepareContext();
     *         // 解析配置 - mysql设置
     *         SqlParser.Config mysqlConfig = SqlParser.configBuilder().setLex(Lex.MYSQL).build();
     *         // 创建解析器
     *         SqlParser parser = SqlParser.create("", mysqlConfig);
     *         // Sql语句
     *         String sql = "select * from tutorial.user_info where id = 1 order by id";
     *         // 解析sql
     *         SqlNode sqlNode = parser.parseQuery(sql);
     *         // 还原某个方言的SQL
     *         System.out.println(sqlNode.toSqlString(OracleSqlDialect.DEFAULT));
     *         // sql validate（会先通过Catalog读取获取相应的metadata和namespace）
     *         SqlTypeFactoryImpl factory = new SqlTypeFactoryImpl(RelDataTypeSystem.DEFAULT);
     *         CalciteCatalogReader calciteCatalogReader = new CalciteCatalogReader(
     *                 prepareContext.getRootSchema(),
     *                 prepareContext.getDefaultSchemaPath(),
     *                 factory,
     *                 new CalciteConnectionConfigImpl(new Properties()));
     *
     *         // 校验（包括对表名，字段名，函数名，字段类型的校验。）
     *         SqlValidator validator = SqlValidatorUtil.newValidator(SqlStdOperatorTable.instance(),
     *                 calciteCatalogReader, factory, SqlConformanceEnum.DEFAULT
     *         );
     *         // 校验后的SqlNode
     *         SqlNode validateSqlNode = validator.validate(sqlNode);
     *         // scope
     *         SqlValidatorScope selectScope = validator.getSelectScope((SqlSelect) validateSqlNode);
     *         // namespace
     *         SqlValidatorNamespace namespace = validator.getNamespace(sqlNode);
     *         System.out.println(validateSqlNode);
     *         List<SqlMoniker> sqlMonikerList = new ArrayList<>();
     *         selectScope.findAllColumnNames(sqlMonikerList);
     *         System.out.println(selectScope);
     *         for (SqlMoniker sqlMoniker : sqlMonikerList) {
     *             System.out.println(sqlMoniker.id());
     *         }
     *         System.out.println(namespace);
     *         System.out.println(namespace.fieldExists("nameCC"));
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.calcite.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:calcite:lex=JAVA");
        CalciteConnection calciteConnection = connection.unwrap(CalciteConnection.class);
        final SchemaPlus rootSchema = calciteConnection.getRootSchema();
        rootSchema.add("hr", new ReflectiveSchema(new HrSchema()));
        calciteConnection.setSchema("hr");  // 设置默认Schema
        Statement statement = calciteConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(
            "select d.deptno, min(e.empid) from hr.emps as e join hr.depts as d on e.deptno = d.deptno " +
                "where e.deptno = 1 group by d.deptno having count(*) > 1");


        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        int lineIndex = 1;
        while (resultSet.next()) {
            System.out.println("行序号 => " + lineIndex);
            for (int i = 1; i < columnCount + 1; i++) {
                Object value = resultSet.getObject(i);
                System.out.println(String.format("\t列序号 => %s, 值 => %s, 类型 => %s", i, value, metaData.getColumnTypeName(i)));
            }
            lineIndex += 1;
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

}
