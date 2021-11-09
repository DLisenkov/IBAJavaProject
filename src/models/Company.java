package models;

import java.util.ArrayList;

class Company {
    private String name;
    private String city;
    private final double TAX = 0.13;
    //private Employee[] employees;
    private ArrayList<Employee> employees;

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

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void spawnEmployee(Employee employee) {
        employees.add(employee);
    }

    public boolean checkAnEmployeeInCompany(String firstName) {
        for (Employee employee: employees) {
            if (firstName.equals(employee.getFirstName())) {
                return true;
            }
        }
        return false;
    }

    /*
     * public Employee spawnEmployee() {
     *     return new Employee();
     * }
     */

    /*
     * protected String changeEmployeeName(Employee employee, String newName) {
     *     employee.setFirstName(newName);
     *     return employee.getFirstName();
     * }
     */
}
