package mypackage;

import models.Appointment;
import models.Human;
import models.MedicalCenter;
import threads.RecordsThread;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started...");

        MedicalCenter medicalCenter = new MedicalCenter("Plushkin");

        List<Appointment> queue = new ArrayList<>();
        queue.add(new Appointment(new Human("Patient1", "LastName1"),  true, 10));
        queue.add(new Appointment(new Human("Patient2", "LastName2"),  false, 9));
        queue.add(new Appointment(new Human("Patient3", "LastName3"),  true, 11));
        queue.add(new Appointment(new Human("Patient4", "LastName4"),  false, 10));
        queue.add(new Appointment(new Human("Patient5", "LastName5"), true, 15));
        queue.add(new Appointment(new Human("Patient6", "LastName6"),true, 17));

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