import model.Employee;
import repository.EmployeeRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println(findAll());
//        System.out.println(findById());
//        System.out.println(save());
//        System.out.println(update());
        System.out.println(delete());
    }

    public static List<Employee> findAll() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        return employeeRepository.findAll();
    }

    public static Employee findById() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        return employeeRepository.findById(1);
    }

    public static Employee save() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee(1, "Alberto", "Cruz", "", "", 1000.0);
        return employeeRepository.save(employee);
    }

    public static Employee update() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Employee employee = new Employee(3, "Alberto", "Cruz 1", "", "", 1000.0);
        return employeeRepository.update(employee);
    }

    public static String delete() {
        EmployeeRepository employeeRepository = new EmployeeRepository();
        return employeeRepository.delete(3);
    }
}
