package calcite2;

import java.util.Arrays;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/5
 */
public class HrSchema {

    public    Employee [] emps;
    public    Department [] depts;


    public HrSchema() {

        this.emps = new Employee[]{
            new Employee(100,1,"test1",100,1000),
            new Employee(200,1,"test2",100,1000),
            new Employee(300,2,"test3",100,1000),
            new Employee(400,3,"test4",100,1000),
        };

        this.depts = new Department[]{
            new Department(1,"d1", Arrays.asList(emps[0],emps[1])),
            new Department(2,"d2", Arrays.asList(emps[2])),
            new Department(3,"d3", Arrays.asList(emps[3])),
        };
    }
}
