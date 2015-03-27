package mainpackage;

import javax.swing.*;
import java.awt.*;

public class Graphic extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JFrame frame;

	
	public Graphic(){
		frame = new JFrame("Game of Life");
		frame.setVisible(true);
		frame.setSize(900,700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
	}
	

	public void paint(Graphics g, int[][] board)
	{
		super.paintComponent(g); 

		int coordX = 0;
		int coordY = 0;
		
		for (int i = 0; i < board.length; i++)
		{
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] == 1) g.setColor(Color.BLUE);
				else g.setColor(Color.WHITE);
				
				g.fillRect(coordX, coordY, 10,10);
			
				coordX += 12;
			}
			
			coordY += 12;
			coordX = 0;
		}
	}
	
	public void redraw(int[][] board)
	{
		Graphics g = getGraphics();
		if (g != null) paint(g, board);
	 }
}

