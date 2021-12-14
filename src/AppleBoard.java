import java.time.*;
import java.util.*;


public class AppleBoard {
	
	private int score = 0;
	private int t_row = -1, t_col = -1, t_value = -1;
	private int[][] board = new int[12][15];
	private boolean target = false;
	private int gold_count = 0;
	private int temp_gold = 0;
	private int score_count = 0;
	private LocalTime start_time;
	private LocalTime end_time;
	
	public AppleBoard(){
		createNewBoard();
		start_time = LocalTime.now();
		end_time = start_time.plusMinutes(1);
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

	public int getScore() { return score; }

	public void targetOn() { target = true;}
	public void targetOff() { target = false;}
	public void setTarget(int[] info) {
		t_row = info[0];
		t_col = info[1];
		t_value = info[2];
		System.out.println(""+t_row+" "+t_col+" "+t_value);
	}
	
	public int[][] getGameBoard() { return board; }
	public void makeZero(int row, int col){
		if(board[row][col] != 0)
			score_count += 1;
		board[row][col] = 0;
	}
	public void calcScore(){
		score += score_count * (int)Math.pow(2.0, gold_count);
		score_count = 0;
		gold_count = 0;
	}
	public boolean check(int[] info) {
		if(t_row == info[0] && t_col != info[1]) {
			
			if(info[1] > t_col) {
					System.out.println("case1");
					int sum = 0;
					for(int i = t_col ; i <= info[1] ; i++)
						sum = sum + normalize(board[t_row][i]);
					if (sum == 10) {
						for(int i = t_col ; i <= info[1] ; i++)
							makeZero(t_row, i);
						gold_count += temp_gold;
						temp_gold = 0;
						calcScore();
						return true; 
						}
					else {
						temp_gold = 0;
						return false;
					}
					}
			else {
				System.out.println("case2");
					int sum = 0;
					for(int i = info[1] ; i <= t_col ; i++)
						sum = sum + normalize(board[t_row][i]);
					if (sum == 10){
						for(int i = info[1] ; i <= t_col ; i++)
							makeZero(t_row, i);
						gold_count += temp_gold;
						temp_gold = 0;
						calcScore();
						return true; 
						}
					else {
						temp_gold = 0;
						return false;
					}
			}
		}
		else if(t_row != info[0] && t_col == info[1]) {
			
			if(info[0] > t_row) {
				System.out.println("case3");
					int sum = 0;
					for(int i = t_row ; i <= info[0] ; i++)
						sum = sum + normalize(board[i][t_col]);
					if (sum == 10) {
						for(int i = t_row ; i <= info[0] ; i++)
							makeZero(i,t_col);
						gold_count += temp_gold;
						temp_gold = 0;
						calcScore();
						return true; 
						}
					else {
						temp_gold = 0;
						return false;
					}
			}
			else {
				System.out.println("case4");
					int sum = 0;
					for(int i = info[0] ; i <= t_row ; i++)
						sum = sum + normalize(board[i][t_col]);
					if (sum == 10){
						for(int i = info[0] ; i <= t_row ; i++)
							makeZero(i,t_col);
						gold_count += temp_gold;
						temp_gold = 0;
						calcScore();
						return true; 
						}
					else {
						temp_gold = 0;
						return false;
					}
			}
		}
		else if(t_row != info[0]) {
			
			if((info[0] > t_row) && (info[1] > t_col)) {
				System.out.println("case5");
				int sum = 0;
				for(int i = t_row; i <= info[0] ; i++)
					for(int j = t_col; j <= info[1] ; j++)
						sum = sum + normalize(board[i][j]);
				if(sum == 10) {
					for(int i = t_row; i <= info[0] ; i++)
						for(int j = t_col; j <= info[1] ; j++)
							makeZero(i,j);
					gold_count += temp_gold;
					temp_gold = 0;
					calcScore();
					return true;
					}
				else {
					temp_gold = 0;
					return false;
				}
			}
			else if((info[0] < t_row) && (info[1] > t_col)) {
				System.out.println("case6");
				int sum = 0;
				for(int i = info[0]; i <= t_row ; i++)
					for(int j = t_col; j <= info[1] ; j++)
						sum = sum + normalize(board[i][j]);
				if(sum == 10) {
					for(int i = info[0]; i <= t_row ; i++)
						for(int j = t_col; j <= info[1] ; j++)
							makeZero(i,j);
					gold_count += temp_gold;
					temp_gold = 0;
					calcScore();
					return true;
					}
				else {
					temp_gold = 0;
					return false;
				}
			}
			else if(info[0] > t_row) {
				System.out.println("case7");
				int sum = 0;
				for(int i = t_row; i <= info[0] ; i++)
					for(int j = info[1]; j <= t_col ; j++)
						sum = sum + normalize(board[i][j]);
				if(sum == 10) {
					for(int i = t_row; i <= info[0] ; i++)
						for(int j = info[1]; j <= t_col ; j++)
							makeZero(i,j);
					gold_count += temp_gold;
					temp_gold = 0;
					calcScore();
					return true;
					}
				else {
					temp_gold = 0;
					return false;
				}
			}
			else {
				System.out.println("case8");
				int sum = 0;
				for(int i = info[0]; i <= t_row ; i++)
					for(int j = info[1]; j <= t_col ; j++)
						sum = sum + normalize(board[i][j]);
				if(sum == 10) {
					for(int i = info[0]; i <= t_row ; i++)
						for(int j = info[1]; j <= t_col ; j++)
							makeZero(i,j);
					gold_count += temp_gold;
					temp_gold = 0;
					calcScore();
					return true;
					}
				else{
					temp_gold = 0;
					return false;
				}
			}
		}
		return false;
	}
	
	public boolean isTarget(int[] info) { return (t_row == info[0]) && (t_col == info[1]); }
	
	public int normalize(int value) {
		if(value > 9) {
			temp_gold += 1;
			return value / 10;
		}
		else
			return value;
	}

	public LocalTime getStart_time(){ return start_time; }
	public LocalTime getEnd_time(){ return end_time; }
}
