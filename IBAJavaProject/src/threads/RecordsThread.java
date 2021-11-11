package threads;

import models.Appointment;
import models.MedicalCenter;

import java.util.List;
import java.util.Random;

public class RecordsThread extends Thread{

    private MedicalCenter medicalCenter;
    public RecordsThread(String name, MedicalCenter medicalCenter) {
        super(name);
        this.medicalCenter = medicalCenter;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " started...\n");

        long beginTime = System.nanoTime();
        final long MINUTE = 60 *1000 * 1000 * 1000L;
        long endTime = beginTime + MINUTE;
        while(System.nanoTime() <= endTime) {
            int time = (int)(( Math.random() * (10 - 0 + 1) + 0));

            try {
                Thread.sleep(time*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Random random = new Random();
            Appointment record = new Appointment(
                    "Patient" + (medicalCenter.getCountOfRecords() + 1),
                    random.nextBoolean(),
                    this.medicalCenter.getLastArrivalTime() + time
            );
            System.out.println(
                    record.getFirstName() + " " +
                            record.ticketAvailability() + " arrived to " +
                            record.getTimeArrived() + "\n"
            );
            medicalCenter.therapistTraffic(record);

            System.out.println("Doctor " + medicalCenter.getDoctorsName() + " is there");
            List<Appointment> queue = medicalCenter.getQueue();
            for (Appointment _record : queue) {
                System.out.println(_record);
            }
            System.out.println();
        }
        System.out.println(Thread.currentThread().getName() + " finished...");
    }
}
