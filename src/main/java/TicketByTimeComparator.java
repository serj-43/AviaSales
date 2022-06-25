import java.util.Comparator;

public class TicketByTimeComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        return o1.getInFlight() - o2.getInFlight();
    }
}