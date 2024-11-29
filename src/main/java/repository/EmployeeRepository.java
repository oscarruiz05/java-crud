package repository;

import model.Employee;
import util.DatabaseQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements Repository<Employee> {

    @Override
    public List<Employee> findAll() {
        List<Employee> employees = new ArrayList<>();
        try {
            ResultSet resultSet = DatabaseQuery.executeQuery("SELECT * FROM employees");
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setLas_name(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setSalary(resultSet.getDouble("salary"));
                employees.add(employee);
            }
            return employees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee findById(int id) {
        Employee employee = new Employee();
        String query = "SELECT * FROM employees WHERE id = ?";
        try {
            ResultSet resultSet = DatabaseQuery.executeQuery(query, id);
            if (resultSet.next()) {
                employee.setId(resultSet.getInt("id"));
                employee.setName(resultSet.getString("name"));
                employee.setLas_name(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employee.setPhone(resultSet.getString("phone"));
                employee.setSalary(resultSet.getDouble("salary"));
            }
            return employee;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee save(Employee employee) {
        String query = "INSERT INTO employees (name, last_name, email, phone, salary) VALUES (?, ?, ?, ?, ?)";
        try {
            int rows = DatabaseQuery.executeUpdate(query, employee.getName(), employee.getLas_name(), employee.getEmail(), employee.getPhone(), employee.getSalary());
            if (rows == 1) {
                return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Employee update(Employee employee) {
        String query = "UPDATE employees SET name = ?, last_name = ?, email = ?, phone = ?, salary = ? WHERE id = ?";
        try {
            int rows = DatabaseQuery.executeUpdate(query, employee.getName(), employee.getLas_name(), employee.getEmail(), employee.getPhone(), employee.getSalary(), employee.getId());
            if (rows == 1) {
                return employee;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String delete(int id) {
        String query = "DELETE FROM employees WHERE id = ?";
        try {
            int rows = DatabaseQuery.executeUpdate(query, id);
            if (rows == 1) {
                return "Employee deleted";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error deleting employee";
    }
}
