package siit.java3.exceptions;

import java.util.HashMap;
import java.util.Map.Entry;

public class Event {

	private Ticket ticketsCat3 = new TicketCat3(0);
	private Ticket ticketsCat2 = new TicketCat2(0);
	private Ticket ticketsCat1 = new TicketCat1(0);
	private HashMap<Integer, Integer> ticketsLeft = new HashMap<>();

	/**
	 * Constructor of an event
	 * 
	 * @param ticketsToBeSold
	 *            number of tickets to be sold
	 */
	public Event(int ticketsToBeSold) {
		super();
		ticketsCat3.setTicketsRemaining((int) (ticketsToBeSold * 0.5));
		ticketsCat2.setTicketsRemaining((int) (ticketsToBeSold * 0.35));
		ticketsCat1.setTicketsRemaining((int) (ticketsToBeSold * 0.15));

	}

	/**
	 * sells ticket of category 3 if tickets from category 3, are not available
	 * anymore, tickets for category 2 will be sold
	 * 
	 * @throws CategoryTicketsSoldoutException
	 *             no more tickets available
	 */
	public void sellTicketCat3() throws CategoryTicketsSoldoutException {

		try {
			if (ticketsCat3.getTicketsRemaining() == 0) {
				throw new CategoryTicketsSoldoutException("SOLD");

			}
			ticketsCat3.setTicketsRemaining(ticketsCat3.getTicketsRemaining() - 1);
			ticketsCat3.setSoldTickets(ticketsCat3.getSoldTickets() + 1);
			System.out.println("Ticket sold -  Category: " + ticketsCat3.getTicketCategory() + ", Price: "
					+ ticketsCat3.getTicketPrice() + ", Tickets remaining in category: "
					+ ticketsCat3.getTicketsRemaining());

		} catch (CategoryTicketsSoldoutException e) {
			System.out.println("Nu mai sunt bilete la categoria 3.");
			sellTicketCat2();
		}

	}

	/**
	 * sells ticket of category 2 if tickets from category 2, are not available
	 * anymore, tickets for category 1 will be sold
	 * 
	 * @throws CategoryTicketsSoldoutException
	 *             no more tickets available
	 */

	public void sellTicketCat2() throws CategoryTicketsSoldoutException {
		try {
			if (ticketsCat2.getTicketsRemaining() == 0) {
				throw new CategoryTicketsSoldoutException("SOLD");

			}
			ticketsCat2.setTicketsRemaining(ticketsCat2.getTicketsRemaining() - 1);
			ticketsCat2.setSoldTickets(ticketsCat2.getSoldTickets() + 1);
			System.out.println("Ticket sold -  Category: " + ticketsCat2.getTicketCategory() + ", Price: "
					+ ticketsCat2.getTicketPrice() + ", Tickets remaining in category: "
					+ ticketsCat2.getTicketsRemaining());

		} catch (CategoryTicketsSoldoutException e) {
			System.out.println("Nu mai sunt bilete la categoria 2.");
			sellTicketCat1();
		}

	}

	/**
	 * sells ticket of category 1 if tickets from category 1, are not available
	 * anymore, status of sold tickets will be printed
	 * 
	 * @throws CategoryTicketsSoldoutException
	 *             no more tickets available
	 */

	public void sellTicketCat1() {
		try {
			if (ticketsCat1.getTicketsRemaining() == 0) {
				throw new SoldoutException("SOLD");

			}
			ticketsCat1.setTicketsRemaining(ticketsCat1.getTicketsRemaining() - 1);
			ticketsCat1.setSoldTickets(ticketsCat1.getSoldTickets() + 1);
			System.out.println("Ticket sold -  Category: " + ticketsCat1.getTicketCategory() + ", Price: "
					+ ticketsCat1.getTicketPrice() + ", Tickets remaining in category: "
					+ ticketsCat1.getTicketsRemaining());

		} catch (SoldoutException e) {
			System.out.println("Toate biletele au fost vandute");
			soldTicketsStatus();
		}

	}

	/**
	 * Prints on console the remaining number of tickets for each category
	 */

	public void ticketsStatus() {

		System.out.println("Cat3: " + ticketsCat3.getTicketsRemaining());
		System.out.println("Cat2: " + ticketsCat2.getTicketsRemaining());
		System.out.println("Cat1: " + ticketsCat1.getTicketsRemaining());

	}

	/**
	 * Prints on console the status for sold tickets for each category and total
	 */
	public void soldTicketsStatus() {
		System.out.println("Cat 3 tickets sold: " + ticketsCat3.getSoldTickets() + ", Total price: "
				+ ticketsCat3.getSoldTickets() * 50);
		System.out.println("Cat 2 tickets sold: " + ticketsCat2.getSoldTickets() + ", Total price: "
				+ ticketsCat2.getSoldTickets() * 80);
		System.out.println("Cat 1 tickets sold: " + ticketsCat1.getSoldTickets() + ", Total price: "
				+ ticketsCat1.getSoldTickets() * 120);
		System.out.println("Total sales " + (ticketsCat3.getSoldTickets() * 50 + ticketsCat2.getSoldTickets() * 80
				+ ticketsCat1.getSoldTickets() * 120));
	}

}
