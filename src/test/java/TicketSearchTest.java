import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TicketSearchTest {
    Ticket ticket1 = new Ticket(1, 3000, "DME", "MAD", 120);
    Ticket ticket2 = new Ticket(2, 2200, "DME", "MAD", 150);
    Ticket ticket3 = new Ticket(3, 21000, "DME", "MAD", 156);
    Ticket ticket4 = new Ticket(4, 1000, "DME", "MAD", 245);
    Ticket ticket5 = new Ticket(5, 5000, "DME", "BAJ", 124);
    Ticket ticket6 = new Ticket(6, 5000, "DME", "BAJ", 350);
    Ticket ticket7 = new Ticket(7, 7000, "VKO", "KVX", 120);
    Ticket ticket8 = new Ticket(8, 19000, "VKO", "KVX", 140);
    Ticket ticket9 = new Ticket(9, 8000, "VKO", "KVX", 169);
    Ticket ticket10 = new Ticket(10, 11000, "VKO", "BAJ", 480);

    @Test
    public void SortTest() {
        TicketInfo ticketrep = new TicketInfo();
        TicketManager manager = new TicketManager(ticketrep);
        Ticket[] expected = {ticket7, ticket9, ticket8};
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Ticket[] actual = manager.findAll("VKO", "KVX");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SortTest2() {
        TicketInfo ticketrep = new TicketInfo();
        TicketManager manager = new TicketManager(ticketrep);
        Ticket[] expected = {ticket4, ticket2, ticket1, ticket3};
        manager.add(ticket4);
        manager.add(ticket9);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket5);
        manager.add(ticket1);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket10);
        manager.add(ticket6);
        Ticket[] actual = manager.findAll("DME", "MAD");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SortTest3() {
        TicketInfo ticketrep = new TicketInfo();
        TicketManager manager = new TicketManager(ticketrep);
        Ticket[] expected = {ticket6, ticket5};
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket6);
        manager.add(ticket5);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Ticket[] actual = manager.findAll("DME", "BAJ");
        Assertions.assertArrayEquals(expected, actual);
    }
}