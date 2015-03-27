package junitpack;

import static org.junit.Assert.*;

import mainpackage.Application;

import org.junit.Test;

public class ApplicationTestConstructor {

//se testeaza daca se construieste bine Aplicatia
	
	@Test
	public void testconstructor() {
		int[][] boardtest = new int[3][3];
		Application test = Application.getInstance(boardtest);
		assertArrayEquals(test.board, boardtest);
		
	}

}
