package calcite;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap.Builder;
import java.io.File;
import java.util.Map;
import org.apache.calcite.schema.Table;
import org.apache.calcite.schema.impl.AbstractSchema;
import org.apache.calcite.util.Source;
import org.apache.calcite.util.Sources;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/5
 */
public class CustomSchema extends AbstractSchema {


   private final String path ="/Users/chauncy/Downloads/code/algorithm-datasturct/agori/src/main/resources/data.csv";

    private Map<String, Table> tableMap;

    @Override
    protected Map<String, Table> getTableMap() {
//        URL url = CustomSchema.class.getResource(path);
        Source source = Sources.of(new File(path));
        if (tableMap == null){
            Builder builder =  ImmutableMap.builder();
            builder.put("TEST01",new CustomTable(source));
            tableMap = builder.build();
        }
        return tableMap;
    }
}
