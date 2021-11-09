package mypackage;

import models.MedicalCenter;
import models.Visitor;
import threads.PatientThread;

import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " started...");

        MedicalCenter medicalCenter = new MedicalCenter("Plushkin");

        ArrayList<Visitor> visitors = new ArrayList<>();
        visitors.add(new Visitor("Patient1", "LastName1", true, 10));
        visitors.add(new Visitor("Patient2", "LastName2", false, 9));
        visitors.add(new Visitor("Patient3", "LastName3", true, 11));
        visitors.add(new Visitor("Patient4", "LastName4", false, 10));
        visitors.add(new Visitor("Patient5", "LastName5", true, 15));
        visitors.add(new Visitor("Patient6", "LastName6", true, 17));

        medicalCenter.initialQueue(visitors);

        PatientThread thread = new PatientThread("PatientThread", medicalCenter);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}