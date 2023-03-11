package models

class Employee(firstName: String?, lastName: String?, var status: Int, var id: Int, var rate: Int) :
        Human(firstName, lastName) {

    //private int hoursPerMonth = 120;
    private var workedHoursThisMonth = 0
    fun doWork(howMuchTime: Int): Int {
        workedHoursThisMonth += howMuchTime
        return workedHoursThisMonth
    }

    protected fun salary(): Double {
        return (workedHoursThisMonth * rate).toDouble()
    }

    fun countAllEmployeesForCompany(employees: Array<Employee?>): Int {
        return employees.size
    }
}