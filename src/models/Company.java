package models;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String city;
    private final double TAX = 0.13;
    private List<Employee> employees;

    Company() {}

    Company(String name, String city) {
        this.name = name;
        this.city = city;
        employees = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void spawnEmployee(Employee employee) {
        employees.add(employee);
    }
}
