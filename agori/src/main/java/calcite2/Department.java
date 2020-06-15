package calcite2;

import java.util.List;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/5
 */
public class Department {

    public final int deptno;
    public final String name;

    @org.apache.calcite.adapter.java.Array(component = Employee.class)
    public final List<Employee> employees;

    public Department(int deptno, String name, List<Employee> employees) {
        this.deptno = deptno;
        this.name = name;
        this.employees = employees;
    }

    @Override public boolean equals(Object obj) {
        return obj == this
            || obj instanceof Department
            && deptno == ((Department) obj).deptno;
    }

    public String toString() {
        return "Department [deptno: " + deptno + ", name: " + name
            + ", employees: " + employees + "]";
    }

}
