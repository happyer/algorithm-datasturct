package calcite2;

/**
 * @author : cuxjdk@gmail.com
 * @since : 2020/6/5
 */
public class Employee {
    public final int empid;
    public final int deptno;
    public final String name;
    public final float salary;
    public final Integer commission;

    public Employee(int empid, int deptno, String name, float salary, Integer commission) {
        this.empid = empid;
        this.deptno = deptno;
        this.name = name;
        this.salary = salary;
        this.commission = commission;
    }

    @Override public boolean equals(Object obj) {
        return obj == this
            || obj instanceof Employee
            && empid == ((Employee) obj).empid;
    }

    public String toString() {
        return "Employee [empid: " + empid + ", deptno: " + deptno
            + ", name: " + name + "]";
    }
}
