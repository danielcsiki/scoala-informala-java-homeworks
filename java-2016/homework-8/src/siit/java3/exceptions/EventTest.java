package siit.java3.exceptions;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTest {

	@Test
	public void test() throws CategoryTicketsSoldoutException {
		
		int N = 20;
		Event tennisGame = new Event(20);
		for (int i = 1; i < N+13; i++) {
			if (i%17==0){
				tennisGame.sellTicketCat3();
				
			} else {
				tennisGame.sellTicketCat3();
			}
			
		}
		
	}

}
