import java.util.List;

public interface Department {
    String getName();
    List<Employee> getEmployees();
    void addEmployee(Employee employee);
}
