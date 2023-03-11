package models

class Student(firstName: String?, lastName: String?, var university: String, var course: Int) :
        Human(firstName, lastName)