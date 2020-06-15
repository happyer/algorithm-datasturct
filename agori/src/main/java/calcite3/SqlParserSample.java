package calcite3;

import org.apache.calcite.config.Lex;
import org.apache.calcite.sql.SqlNode;
import org.apache.calcite.sql.dialect.OracleSqlDialect;
import org.apache.calcite.sql.parser.SqlParseException;
import org.apache.calcite.sql.parser.SqlParser;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/6
 */
public class SqlParserSample {


    public static void main(String[] args) throws SqlParseException {
        String sql = "select * from emps where id = 1";

        SqlParser.Config mysqlConfig = SqlParser.configBuilder().setLex(Lex.MYSQL).build();

        SqlParser parser = SqlParser.create(sql, mysqlConfig);

        SqlNode sqlNode = parser.parseQuery();

        System.out.println(sqlNode.toSqlString(OracleSqlDialect.DEFAULT));


    }
}
