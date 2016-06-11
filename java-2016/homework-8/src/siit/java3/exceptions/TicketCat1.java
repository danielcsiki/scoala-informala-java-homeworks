package siit.java3.exceptions;

public class TicketCat1 extends Ticket {
	private int category;
	private int ticketPrice;
	private int ticketsRemaining;
	private int soldTickets;
	

	public TicketCat1(int ticketsRemaining) {
		super(ticketsRemaining);
		category = 1;
		ticketPrice = 120;
		
	}
	public int getTicketCategory() {
		return category;}

		public int getTicketPrice() {
			return ticketPrice;
	}
		public int getSoldTickets() {
			return soldTickets;
		}
		public void setSoldTickets(int soldTickets) {
			this.soldTickets = soldTickets;
		}

	
}
