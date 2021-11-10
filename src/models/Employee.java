package models;

public class Employee extends Human{
    private int status;
    private int id;
    private int rate;
    //private int hoursPerMonth = 120;
    private int workedHoursThisMonth = 0;

    public Employee(String firstName, String lastName, int status, int id, int rate) {
        super(firstName, lastName);
        this.status = status;
        this.id = id;
        this.rate = rate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int doWork(int howMuchTime) {
        this.workedHoursThisMonth += howMuchTime;
        return this.workedHoursThisMonth;
    }

    protected double salary() {
        return this.workedHoursThisMonth * this.rate;
    }

    public int countAllEmployeesForCompany(Employee[] employees) {
        return employees.length;
    }
}
