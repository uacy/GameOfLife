package mainpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameOfLife {


	public static void main(String[] args) 
			throws FileNotFoundException, InterruptedException {

		int C,R;
		int[][] board;
		int grid;
		
//se face citirea din fisier a matrici necesare pentru joc
//pe prima linie este numarul de linii si coloane
//pe al 2-lea este modul testului (cu sau fara margini)
//dupa care urmeaza toata matricea in care sunt stocate toate celulele
		
		Scanner input = new Scanner(new File("src/test4.txt"));
		R = input.nextInt();
		C = input.nextInt();
		grid = input.nextInt();
		board = new int[C][R];
		for(int i = 0; i < C; ++i)
		{
		    for(int j = 0; j < R; ++j)
		    {
		        if(input.hasNextInt())
		        {
		            board[i][j] = input.nextInt();
		        }
		    }
		}
		input.close();
		
// se initiaza aplicatia		
		Application App = Application.getInstance(board);
		
// in functie de cum se doreste rulata aplicatia(cu sau fara margine) se simuleaza		
		if(grid == 0){
			App.simulateNoGrid();
		}else{
			App.simulate();
		}
	
	}
}