package patten.adapter;

import java.io.IOException;

/**
 * Created by chauncy on 2018/7/26.
 */
public class AppProperties {

    public static void main(String[] args) throws IOException {


        FileIO fileIO = new FileProperties();
        fileIO.setValue("test","test-value");
        fileIO.writeToFile("new_file_name");

    }
}
