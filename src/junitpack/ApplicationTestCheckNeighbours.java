package junitpack;

import static org.junit.Assert.*;
import mainpackage.Application;

import org.junit.Test;

public class ApplicationTestCheckNeighbours {

//se testeaza daca functia care returneaza vecini cand sunt margini merge
	@Test
	public void test() {
		int[][] board = new int[3][3];
		Application test = Application.getInstance(board);
		
		board[1][1] = 1;
		board[0][1] = 1;
		
		int counter = test.checkNeighbours(1, 0);
		assertEquals(2, counter);
	}

}
