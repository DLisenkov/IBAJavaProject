package mypackage;

import models.Appointment;
//import models.Employee;
//import models.Human;
import models.MedicalCenter;
import threads.RecordsThread;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started...");

        MedicalCenter medicalCenter = new MedicalCenter("Plushkin");

        List<Appointment> queue = new ArrayList<>();
        queue.add(new Appointment("Patient1",  true, 10));
        queue.add(new Appointment("Patient2",  false, 9));
        queue.add(new Appointment("Patient3",  true, 11));
        queue.add(new Appointment("Patient4",  false, 10));
        queue.add(new Appointment("Patient5",  true, 15));
        queue.add(new Appointment("Patient6",  true, 17));

        medicalCenter.initialQueue(queue);

        RecordsThread thread = new RecordsThread("RecordsThread", medicalCenter);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
        System.out.println("Human - " + medicalCenter.calculateCostOfInsurance(new Human("Denis", "Lisenkov")));
        System.out.println("Employee - " + medicalCenter.calculateCostOfInsurance(
                new Employee("Denis", "Lisenkov", 100, 1, 100))
        );
         */

        System.out.println(Thread.currentThread().getName() + " finished...");

    }
}