package models;

public class Appointment  implements Comparable<Appointment>{
    private String firstName;
    private boolean hasTicket;
    private int timeArrived;

    public Appointment(String firstName, boolean hasTicket, int timeArrived) {
        this.firstName = firstName;
        this.hasTicket = hasTicket;
        this.timeArrived = timeArrived;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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
        return this.firstName + " " + this.hasTicket + " " + this.timeArrived;
    }

    @Override
    public int compareTo(Appointment attendance) {
        return this.timeArrived - attendance.timeArrived;
    }

}
