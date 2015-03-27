package mainpackage;

public class Application {

	public int[][] board;
	int C,R;
	Graphic frame = new Graphic();
	
	public static Application instance = null;

//constructorul privat al acestei clase
	private Application(int[][] board){
		this.board = board;
		C = board.length;
		R = board[0].length;
	}

//functia care se asigura ca aceasta clasa este initializata o singura data(Singleton)
	public static synchronized Application getInstance(int[][] board) {
        if (instance == null) {
            instance = new Application(board);
        }
 
        return instance;
    }
	
	public void simulate() throws InterruptedException{

//se deseneaza matricea initiala
		frame.redraw(board);
		
		while(true){
			printBoard();
//se face o pauza intre framuri
			Thread.sleep(100);
//se updateaza matricea
			update();
//se redeseneaza matricea updatata
			frame.redraw(board);
			
		}
		
	}
	
//simuleaza jocul cu regula fara margini
	public void simulateNoGrid() throws InterruptedException {

//se deseneaza matricea initiala
	frame.redraw(board);
		
		while(true){
			printBoard();
//se face o pauza intre framuri
			Thread.sleep(100);
//se updateaza matricea
			updateNoGrid();
//se redeseneaza matricea updatata
			frame.redraw(board);
			
		}
		
	}

	
//functia care scria matricea celulelor, care m-a ajutat inainte
//sa fac interfata grafica
	public void printBoard() {
		for(int i=0;i<C;i++){
          for(int j=0;j<R;j++)
              System.out.print(board[i][j] + " ");
          System.out.println();
      }
		System.out.println();
	}

//updateaza matricea celulelor vi/moarte si foloseste functia de verificat
//vecinii tinand cont de margini
	public void update(){
		int[][] updatedBoard = new int[C][R];
		for(int i = 0; i < C; ++i){
			for(int j = 0; j < R; ++j){
				if(board[i][j] == 0){
					if(checkNeighbours(i,j) == 3){
						updatedBoard[i][j] = 1;
					}
					else{
						updatedBoard[i][j] = 0;
					}
				}
				if(board[i][j] == 1){
					if(checkNeighbours(i,j) < 2 || checkNeighbours(i,j) > 3){
						updatedBoard[i][j] = 0;
					}
					else{
						updatedBoard[i][j] = 1;
					}
				}
			}
		}
		this.board = updatedBoard;
	}
	
//returneaza numarul de  vecinii unei celule tinand cont de margini
	public int checkNeighbours(int i, int j) {
		int counter = 0;

		if(i != 0){
			if(board[i-1][j] == 1){
				counter++;
			}
		}
		
		if(i != C - 1){
			if(board[i+1][j] == 1){
				counter++;
			}
		}

		if(j != 0){
			if(board[i][j-1] == 1){
				counter++;
			}
		}
		 
		if(j != R - 1){
			if(board[i][j+1] == 1){
				counter++;
			}
		}
		
		if(i != 0 && j != 0){
			if(board[i-1][j-1] == 1){
				counter++;
			}
		}
		
		if(i != 0 && j != R - 1){
			if(board[i-1][j+1] == 1){
				counter++;
			}
		}
		
		if(i != C - 1 && j != 0){
			if(board[i+1][j-1] == 1){
				counter++;
			}
		}
		
		if(i != C - 1 && j != R - 1){
			if(board[i+1][j+1] == 1){
				counter++;
			}
		}
		
		return counter;
	}

//updateaza matricea celulelor vi/moarte si foloseste functia de verificat
//vecinii fara sa tina cont de margini
	public void updateNoGrid(){
		int[][] updatedBoard = new int[C][R];
		for(int i = 0; i < C; ++i){
			for(int j = 0; j < R; ++j){
				if(board[i][j] == 0){
					if(checkNeighboursNoGrid(i,j) == 3){
						updatedBoard[i][j] = 1;
					}
					else{
						updatedBoard[i][j] = 0;
					}
				}
				if(board[i][j] == 1){
					if(checkNeighboursNoGrid(i,j) < 2 || checkNeighboursNoGrid(i,j) > 3){
						updatedBoard[i][j] = 0;
					}
					else{
						updatedBoard[i][j] = 1;
					}
				}
			}
		}
		this.board = updatedBoard;
	}

//returneaza numarul de vecini in cazul in care nu se tine cont de margini	
	public int checkNeighboursNoGrid(int i, int j) {
		int counter = 0;
		if (board[mod(i+1,C)][j] == 1){
			counter++;
		}
		if (board[mod(i+1,C)][mod(j+1, R)] == 1){
			counter++;
		}
		if (board[i][mod(j+1,R)] == 1){
			counter++;
		}
		if (board[i][mod(j-1,R)] == 1){
			counter++;
		}
		if (board[mod(i+1,C)][mod(j-1,R)] == 1){
			counter++;
		}
		if (board[mod(i-1,C)][j] == 1){
			counter++;
		}
		if (board[mod(i-1,C)][mod(j-1,R)] == 1){
			counter++;
		}
		if (board[mod(i-1,C)][mod(j+1,R)] == 1){
			counter++;
		}
		return counter;
	}
//se ocupa de returnarea parametrilor de langa margini
//se aigura sa nu se foloseasca un indice negativ
	public int mod(int i, int max) {
		return (i % max + max) % max;

	}
	
	

}
