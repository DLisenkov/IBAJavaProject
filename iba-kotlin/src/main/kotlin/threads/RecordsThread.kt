package threads

import models.Appointment
import models.MedicalCenter
import java.util.*

class RecordsThread(name: String?, private val medicalCenter: MedicalCenter) : Thread(name) {
    override fun run() {
        println(currentThread().name + " started...\n")
        val beginTime = System.nanoTime()
        val MINUTE = 60 * 1000 * 1000 * 1000L
        val endTime = beginTime + MINUTE
        while (System.nanoTime() <= endTime) {
            val time = (Math.random() * (10 - 0 + 1) + 0).toInt()
            try {
                sleep((time * 1000).toLong())
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            val random = Random()
            val record = Appointment(
                "Patient" + (medicalCenter.countOfRecords + 1),
                random.nextBoolean(),
                medicalCenter.lastArrivalTime + time
            )
            println(
                record.firstName + " " +
                        record.ticketAvailability() + " arrived to " +
                        record.timeArrived + "\n"
            )
            medicalCenter.therapistTraffic(record)
            println("Doctor " + medicalCenter.doctorsName + " is there")
            val queue = medicalCenter.getQueue()
            for (_record: Appointment? in queue) {
                println(_record)
            }
            println()
        }
        println(currentThread().name + " finished...")
    }
}