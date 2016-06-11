package siit.java3.exceptions;

public abstract class Ticket {
	private int category;
	private int ticketPrice;
	private int ticketsRemaining;
	private int soldTickets;

	public int getSoldTickets() {
		return soldTickets;
	}

	public void setSoldTickets(int soldTickets) {
		this.soldTickets = soldTickets;
	}

	public Ticket(int ticketsRemaining) {
		super();
		this.ticketsRemaining = ticketsRemaining;

	}

	public Ticket() {
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public int getTicketsRemaining() {
		return ticketsRemaining;
	}

	public void setTicketsRemaining(int ticketsRemaining) {
		this.ticketsRemaining = ticketsRemaining;
	}

	public int getTicketCategory() {
		return category;

	}

}
