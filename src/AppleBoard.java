import java.time.*;
import java.util.*;


public class AppleBoard {
	
	private int score;
	private int t_row = -1, t_col = -1, t_value = -1;
	private int[][] board = new int[12][15];
	private boolean first = true;
	private boolean second = false;
	private boolean target = false;
	private int t_gold = 0;
	
	public AppleBoard(){
		createNewBoard();
	}
	
	public void createNewBoard() {
		Random rd = new Random();
		int[] button_count = {0,0,0,0,0,0,0,0,0};
		int gold_count = 0;
		
		for (int row = 0; row < 12; row++)
			for (int col = 0; col < 15; col++) {
				int apple_no = rd.nextInt(9);
				while(button_count[apple_no] == 20) { apple_no = rd.nextInt(9); }
				if (rd.nextInt(100) < 7 && gold_count != 10) {
					board[row][col] = 10 * (apple_no + 1);
					gold_count++;
				}
				else
					board[row][col] = apple_no + 1;
				button_count[apple_no]++;
			}
	}
	
	public boolean isFirst() { return target; }
	
	public void targetOn() { target = true;}
	public void targetOff() { target = false;}
	public void setTarget(int[] info) {
		t_row = info[0];
		t_col = info[1];
		t_value = info[2];
		t_gold = info[3];
		System.out.println(""+t_row+" "+t_col+" "+t_value+" "+t_gold);
	}
	
	public int[][] getGameBoard() { return board; }
	
	public boolean check(int[] info) {
		if(t_row == info[0] && t_col != info[1]) {
			
			if(info[1] > t_col) {
					int sum = 0;
					for(int i = t_col ; i <= info[1] ; i++)
						sum = sum + normalize(board[t_row][i]);
					if (sum == 10) {
						for(int i = t_col ; i <= info[1] ; i++)
							board[t_row][i] = 0;
						return true; 
						}
					else return false;
					}
			else if(info[1] < t_col) {
					int sum = 0;
					for(int i = info[1] ; i <= t_col ; i++)
						sum = sum + normalize(board[t_row][i]);
					if (sum == 10){
						for(int i = info[1] ; i <= t_col ; i++)
							board[t_row][i] = 0;
						return true; 
						}
					else return false;
					}
		}
		else if(t_row != info[0] && t_col == info[1]) {
			
			if(info[0] > t_row) {
					int sum = 0;
					for(int i = t_row ; i <= info[0] ; i++)
						sum = sum + normalize(board[i][t_col]);
					if (sum == 10) {
						for(int i = t_row ; i <= info[0] ; i++)
							board[i][t_col] = 0;
						return true; 
						}
					else return false;
					}
			else if(info[0] < t_row) {
					int sum = 0;
					for(int i = info[0] ; i <= t_row ; i++)
						sum = sum + normalize(board[i][t_col]);
					if (sum == 10){
						for(int i = info[0] ; i <= t_row ; i++)
							board[i][t_col] = 0;
						return true; 
						}
					else return false;
					}
		}
		else if(t_row != info[0] && t_col != info[1]) {
			
			if((info[0] > t_row) && (info[1] > t_col)) {
				int sum = 0;
				for(int i = t_row; i <= info[0] ; i++)
					for(int j = t_col; j <= info[1] ; j++)
						sum = sum + board[i][j];
				if(sum == 10) {
					for(int i = t_row; i <= info[0] ; i++)
						for(int j = t_col; j <= info[1] ; j++)
							board[i][j] = 0;
					return true;
					}
				else return false;
			}
			else if((info[0] < t_row) && (info[1] > t_col)) {
				int sum = 0;
				for(int i = info[0]; i <= t_row ; i++)
					for(int j = t_col; j <= info[1] ; j++)
						sum = sum + board[i][j];
				if(sum == 10) {
					for(int i = info[0]; i <= t_row ; i++)
						for(int j = t_col; j <= info[1] ; j++)
							board[i][j] = 0;
					return true;
					}
				else return false;
			}
			else if((info[0] > t_row) && (info[1] < t_col)) {
				int sum = 0;
				for(int i = t_row; i <= info[0] ; i++)
					for(int j = info[1]; j <= t_col ; j++)
						sum = sum + board[i][j];
				if(sum == 10) {
					for(int i = t_row; i <= info[0] ; i++)
						for(int j = info[1]; j <= t_col ; j++)
							board[i][j] = 0;
					return true;
					}
				else return false;			
			}
			else if((info[0] < t_row) && (info[1] < t_col)) {
				int sum = 0;
				for(int i = info[0]; i <= t_row ; i++)
					for(int j = info[1]; j <= t_col ; j++)
						sum = sum + board[i][j];
				if(sum == 10) {
					for(int i = info[0]; i <= t_row ; i++)
						for(int j = info[1]; j <= t_col ; j++)
							board[i][j] = 0;
					return true;
					}
				else return false;		
			}
		}
		return false;
	}
	
	public boolean isTarget(int[] info) {
		if((t_row == info[0])&&(t_col == info[1]))
			return true;
		return false;
	}
	
	public int normalize(int value) {
		if(value > 9)
			return value / 10;
		else
			return value;
	}
	
	public void time_start() {
		
	}
}
