package models;

public class Appointment implements Comparable<Appointment> {
    private Person person;
    private boolean hasTicket;
    private int timeArrived;

    public Appointment(Person person, boolean hasTicket, int timeArrived) {
        this.person = person;
        this.hasTicket = hasTicket;
        this.timeArrived = timeArrived;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public boolean isHasTicket() {
        return hasTicket;
    }

    public void setHasTicket(boolean hasTicket) {
        this.hasTicket = hasTicket;
    }

    public int getTimeArrived() {
        return timeArrived;
    }

    public void setTimeArrived(int timeArrived) {
        this.timeArrived = timeArrived;
    }

    public static double discountCalculation(Person person) {
        double discount = 1;
        if (person instanceof Employee) {
            discount = 0.75;
        }
        return discount;
    }

    public String ticketAvailability() {
        if (this.hasTicket) {
            return "with ticket";
        } else {
            return "without ticket";
        }
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "person=" + person +
                ", hasTicket=" + hasTicket +
                ", timeArrived=" + timeArrived +
                '}';
    }

    @Override
    public int compareTo(Appointment attendance) {
        return this.timeArrived - attendance.timeArrived;
    }

}
