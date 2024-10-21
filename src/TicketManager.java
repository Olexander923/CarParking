import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

// класс для управления коллекцией запросов, создания и изменения статусов запросов
public class TicketManager {

    private List<Support> tickets = new ArrayList<>();

    void addTicket(Support support) {
        tickets.add(support);
    }
    public Support findTicketID(String ticketID) {
        for(Support ticket : tickets) {
            if(ticket.getTicketID().equals(ticketID)) {
                return ticket;
            }
        }
        throw new NoSuchElementException();

    }
    public void updateTicketStatus(String ticketID, String status) {
        Support ticket = findTicketID(ticketID);
        if(ticket != null) {
            ticket.setStatus(status);
        }

    }
}











