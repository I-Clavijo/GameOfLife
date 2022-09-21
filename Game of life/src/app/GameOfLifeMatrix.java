package app;
import java.util.Random;

public class GameOfLifeMatrix {
	
	private int height;
	private int width;
	private int[][] lifeMatrix;
	
	
	public GameOfLifeMatrix(int height, int width) {
		
		this.height = height;
		this.width = width;
		this.lifeMatrix = new int[height][width];
		randomizeLife();
	}
	
	public void randomizeLife() {
			
		Random ranNum = new Random();
		for(int i=0 ; i<height ; i++) {
			for(int j=0 ; j<width ; j++) {
				if(ranNum.nextInt(3)==1) {
				this.lifeMatrix[i][j] = 1;  
				}
			}
		}
	}
	
	
	public void calculateNextStepMatrix() {
		int[][] neighborsMatrix = new int[this.height][this.width];
		int counter = 0;
		for (int i = 0 ; i<this.height; i++) {
			for (int j = 0 ; j<this.width; j++) {
				
				if(i>0 && j>0)
					counter+= lifeMatrix[i-1][j-1];		
				if(i>0)
					counter+= lifeMatrix[i-1][j];
				if(i>0 && j<this.width-1)
					counter+= lifeMatrix[i-1][j+1];
				if(i<this.height-1 && j<this.width-1)
					counter+= lifeMatrix[i+1][j+1];
				if(j<this.width-1)
					counter+= lifeMatrix[i][j+1];
				if(j>0)
					counter+= lifeMatrix[i][j-1];
				if(i<this.height-1)
					counter+= lifeMatrix[i+1][j];
				if(i<this.height-1 && j>0)
					counter+= lifeMatrix[i+1][j-1];
				
				neighborsMatrix[i][j]=counter;
				counter=0;
			}	
		}

		for (int i = 0 ; i<this.height; i++) {
			for (int j = 0 ; j<this.width; j++) {
				if (lifeMatrix[i][j]== 0 && neighborsMatrix[i][j] == 3) {
					lifeMatrix[i][j]= 1;
				}
				if (lifeMatrix[i][j]==1 && (neighborsMatrix[i][j] >=4 || neighborsMatrix[i][j] <= 1)) {
					lifeMatrix[i][j]= 0;
				}
				if(lifeMatrix[i][j]==1 && (neighborsMatrix[i][j] == 3 || neighborsMatrix[i][j] == 2)) {
					lifeMatrix[i][j]= 1;
				}
				if(lifeMatrix[i][j]==0 && (neighborsMatrix[i][j] <3 || neighborsMatrix[i][j] >3)) {
					lifeMatrix[i][j]= 0;
				}
			}
		}	
	}
	
	public int[][] getLifeMatrix() {
		
		return this.lifeMatrix;
	}
	
}