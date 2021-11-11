package mypackage

import models.Appointment
import models.MedicalCenter
import threads.RecordsThread

//import models.Employee;
//import models.Human;
internal object Main {
    @JvmStatic
    fun main(args: Array<String>) {
        println(Thread.currentThread().name + " started...")
        val medicalCenter = MedicalCenter("Plushkin")
        val queue: MutableList<Appointment> = ArrayList()
        queue.add(Appointment("Patient1", true, 10))
        queue.add(Appointment("Patient2", false, 9))
        queue.add(Appointment("Patient3", true, 11))
        queue.add(Appointment("Patient4", false, 10))
        queue.add(Appointment("Patient5", true, 15))
        queue.add(Appointment("Patient6", true, 17))
        medicalCenter.initialQueue(queue)
        val thread = RecordsThread("RecordsThread", medicalCenter)
        thread.start()
        try {
            thread.join()
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        /*
        System.out.println("Human - " + medicalCenter.calculateCostOfInsurance(new Human("Denis", "Lisenkov")));
        System.out.println("Employee - " + medicalCenter.calculateCostOfInsurance(
                new Employee("Denis", "Lisenkov", 100, 1, 100))
        );
         */println(Thread.currentThread().name + " finished...")
    }
}