package junitpack;

import static org.junit.Assert.*;
import mainpackage.Application;

import org.junit.Test;

public class ApplicationTestUpdateNoGrid {

//se testeaza urmatoarea generatie cu margini
	@Test
	public void test() {
		int[][] board = new int[3][3];
		int[][] boardtest = new int[3][3];
		
		board[0][0] = 1;
		board[0][1] = 1;
		board[0][2] = 1;
		
		boardtest[1][1] = 1;
		boardtest[1][0] = 1;
		boardtest[1][2] = 1;
		
		Application test = Application.getInstance(board);
		for(int i = 0; i<3;++i){
			for(int j=0; j < 3; ++j)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		test.updateNoGrid();
		for(int i = 0; i<3;++i){
			for(int j=0; j < 3; ++j)
				System.out.print(board[i][j] + " ");
			System.out.println();
		}
		for(int i = 0; i<3;++i){
			for(int j=0; j < 3; ++j)
				System.out.print(boardtest[i][j] + " ");
			System.out.println();
		}
		
		
		assertArrayEquals(board, boardtest);
	}

}
