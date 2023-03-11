package models

import java.util.*

class MedicalCenter(var doctorsName: String) {
    private val INSURANCE = 100
    var queue: MutableList<Appointment> = ArrayList()

    @JvmName("getQueue1")
    fun getQueue(): List<Appointment> {
        return queue
    }

    fun calculateCostOfInsurance(person: Person?): Double {
        return Appointment.discountCalculation(person) * INSURANCE
    }

    fun initialQueue(queue: List<Appointment>) {
        Collections.sort(queue)
        for (record in queue) {
            therapistTraffic(record)
        }
    }

    fun therapistTraffic(record: Appointment) {
        var flag = false
        if (record.isHasTicket) {
            for (i in queue.indices) {
                if (!queue[i].isHasTicket) {
                    if (i <= 2) {
                        queue.add(i, record)
                        flag = true
                        break
                    } else {
                        if (queue[i - 1].isHasTicket && queue[i - 2].isHasTicket && queue[i - 3].isHasTicket) {
                            continue
                        } else {
                            queue.add(i, record)
                            flag = true
                            break
                        }
                    }
                }
            }
            if (!flag) {
                queue.add(record)
            }
        } else {
            queue.add(record)
        }
    }

    val lastArrivalTime: Int
        get() = if (queue.size == 0) {
            0
        } else {
            val queue: List<Appointment> = ArrayList(queue)
            Collections.sort(queue)
            queue[queue.size - 1].timeArrived
        }
    val countOfRecords: Int
        get() = queue.size

}