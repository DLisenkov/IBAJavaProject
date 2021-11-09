package models;

class Employee extends Person{
    private int status;
    private int id;
    private int rate;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    private Company company;
    //private int hoursPerMonth = 120;
    private int workedHoursThisMonth = 0;

    /*
     * private String firstName = "John";
     * private String lastName = "Doe";
     */

    Employee(String firstName, String lastName, int status, int id, int rate) {
        super(firstName, lastName);
        this.status = status;
        this.id = id;
        this.rate = rate;
        this.company = null;
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

    /*
     * public void setFirstName(String new_name) {
     *     this.firstName = new_name;
     * }
     */

    /*
     * public String getFirstName() {
     *     return this.firstName;
     * }
     */

    /* private String GET_FIRST_NAME() {
     *     this.id = 0;
     *     this.lastName = "DO";
     *     return this.firstName;
     * }
     */

    public int doWork(int howMuchTime) {
        this.workedHoursThisMonth += howMuchTime;
        //this.firstName = "Joe";
        return this.workedHoursThisMonth;
    }

    protected double salary() {
        return this.workedHoursThisMonth * this.rate;
    }

    public int countAllEmployeesForCompany(Employee[] employees) {
        return employees.length;
    }
}
