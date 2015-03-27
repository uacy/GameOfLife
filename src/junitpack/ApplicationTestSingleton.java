package junitpack;

import static org.junit.Assert.*;
import mainpackage.Application;

import org.junit.Test;

public class ApplicationTestSingleton {

	
//se verifica daca se creaza 2 instante au acelasi hash
//adica sunt aceasi instanta
	@Test
	public void test() {
		int[][] board = new int[3][3];
		Application first = Application.getInstance(board);
		int hashfirst = first.hashCode();
		
		Application second = Application.getInstance(board);
		
		assertEquals(hashfirst, second.hashCode());
	}

}
