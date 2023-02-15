package models

class Appointment(var firstName: String, var isHasTicket: Boolean, var timeArrived: Int) :
    Comparable<Appointment?> {

    fun ticketAvailability(): String {
        return if (isHasTicket) {
            "with ticket"
        } else {
            "without ticket"
        }
    }

    override fun toString(): String {
        return firstName + " " + isHasTicket + " " + timeArrived
    }

    override operator fun compareTo(attendance: Appointment?): Int {
        if (attendance != null) {
            return timeArrived - attendance.timeArrived
        }
        return 0;
    }

    companion object {
        fun discountCalculation(person: Person?): Double {
            var discount = 1.0
            if (person is Employee) {
                discount = 0.75
            }
            return discount
        }
    }
}