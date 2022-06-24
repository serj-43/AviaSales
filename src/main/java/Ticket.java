import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Ticket implements Comparable<Ticket> {
    private int id;
    private int cost;
    private String Flight;
    private String Arival;
    private int InFlight;

    @Override
    public int compareTo(Ticket ticket) {
        if (cost > ticket.cost) {
            return 1;
        }
        else if (cost < ticket.cost) {
            return -1;
        }
        else return 0;
    }
}
