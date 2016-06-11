package siit.java3.exceptions;

public class TicketCat3 extends Ticket{
	private int category ;
	private int ticketPrice;
	private int ticketsRemaining;
	private int soldTickets;
	
	

	
	public TicketCat3(int ticketsRemaining) {
		super(ticketsRemaining);
		category = 3;
		ticketPrice = 50;
		
	}public int getTicketCategory() {
		return category;

	}
	public int getSoldTickets() {
		return soldTickets;
	}
	public void setSoldTickets(int soldTickets) {
		this.soldTickets = soldTickets;
	}
}

