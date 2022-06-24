public class TicketInfo {
    private Ticket[] items = new Ticket[0];

    public Ticket[] findAll() {
        return items;
    }

    public Ticket findById(int id) {
        for (int i = 0; i < items.length; i++) {
            if (items[i].getId() == id) {
                return items[i];
            }
        }
        return null;
    }

    public void save(Ticket ticket) {
        if (this.findById(ticket.getId()) != null) {
            throw new AlreadyExistsException("Повторяется элемент с id: " + ticket.getId());
        } else {
            Ticket[] tmp = new Ticket[items.length + 1];
            System.arraycopy(items, 0, tmp, 0, items.length);
            tmp[tmp.length - 1] = ticket;
            items = tmp;
        }
    }

    public void removeById(int id) {
        if (this.findById(id) == null) {
            throw new NotFoundException("Не найден элемент с id: " + id);
        } else {
            int copyIndex = 0;
            Ticket[] tmp = new Ticket[items.length - 1];
            for (int i = 0; i < items.length; i++) {
                if (items[i].getId() != id) {
                    tmp[copyIndex] = items[i];
                    copyIndex++;
                }
            }
            items = tmp;
        }
    }
}
