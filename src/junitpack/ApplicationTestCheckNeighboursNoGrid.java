package junitpack;

import static org.junit.Assert.*;
import mainpackage.Application;

import org.junit.Test;

public class ApplicationTestCheckNeighboursNoGrid {

	
//se testeaza daca functia care gaseste vecini cand nu sunt margini merge
	@Test
	public void test() {
		int[][] board = new int[3][3];
		Application test = Application.getInstance(board);
		
		board[0][0] = 1;
		board[0][1] = 1;
		board[0][2] = 1;
		
		int counter = test.checkNeighboursNoGrid(1, 2);
		assertEquals(3, counter);
	}

}
