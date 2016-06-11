package siit.java3.exceptions;

public class TicketCat2 extends Ticket{
	private int category = 2;
	private int ticketPrice = 80;
	private int ticketsRemaining;
	private int soldTickets;
	

	public TicketCat2(int ticketsRemaining) {
		super(ticketsRemaining);
		category= 2;
		ticketPrice=80;
		
	}
	public int getTicketCategory() {
		return category;
		
		

	}
	
	public int getSoldTickets() {
		return soldTickets;
	}
	public void setSoldTickets(int soldTickets) {
		this.soldTickets = soldTickets;
	}
}


