import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketInfo repository;

    public TicketManager(TicketInfo repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        this.repository.save(ticket);
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] ans = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (ticket.getArival() == to && ticket.getFlight() == from) {
                Ticket[] tmp = new Ticket[ans.length + 1];
                for (int i = 0; i < ans.length; i++) {
                    tmp[i] = ans[i];
                }
                tmp[tmp.length - 1] = ticket;
                ans = tmp;
            }
        }
        Arrays.sort(ans, comparator);
        return ans;
    }
}
