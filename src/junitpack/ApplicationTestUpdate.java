package junitpack;

import static org.junit.Assert.*;
import mainpackage.Application;

import org.junit.Test;

public class ApplicationTestUpdate {

	
//se testeaza daca merge urmatoarea generatie cu margini	
	@Test
	public void test() {
		int[][] board = new int[3][3];
		int[][] boardtest = new int[3][3];
		

		Application test = Application.getInstance(board);
		test.update();
		assertArrayEquals(board, boardtest);
	}

}
