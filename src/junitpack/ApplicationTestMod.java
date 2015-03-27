package junitpack;

import static org.junit.Assert.*;
import mainpackage.Application;

import org.junit.Test;

public class ApplicationTestMod {

//se testeaza daca merge functia care ajuta la gasirea
//numarul de vecini cand nu exista margini
//trebuie sa returneze marginea din partea cealalta
	@Test
	public void test() {
		int[][] board = new int[3][3];
		Application test = Application.getInstance(board);
		
		
		assertEquals(49, test.mod(-1,50));
		assertEquals(0, test.mod(50, 50));
	}

}
