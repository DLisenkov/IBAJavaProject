package models

class Company {
    var name: String? = null
    var city: String? = null
    private val TAX = 0.13
    private var employees: MutableList<Employee>? = null

    internal constructor() {}
    internal constructor(name: String?, city: String?) {
        this.name = name
        this.city = city
        employees = ArrayList()
    }

    fun getEmployees(): List<Employee>? {
        return employees
    }

    fun spawnEmployee(employee: Employee) {
        employees!!.add(employee)
    }
}