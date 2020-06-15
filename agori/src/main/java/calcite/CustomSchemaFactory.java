package calcite;

import java.util.Map;
import org.apache.calcite.schema.Schema;
import org.apache.calcite.schema.SchemaFactory;
import org.apache.calcite.schema.SchemaPlus;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/5
 */
public class CustomSchemaFactory implements SchemaFactory {


    @Override
    public Schema create(SchemaPlus schemaPlus, String s, Map<String, Object> map) {
        return new CustomSchema();
    }
}
