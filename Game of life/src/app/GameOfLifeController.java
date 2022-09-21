package app;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class GameOfLifeController {
	
	GameOfLifeMatrix gameOfLifeMatrix;
	private int matrixHeight = 10;
	private int matrixWidth = 10;
	
    @FXML
    private Canvas canvas;
    
    @FXML
    void stepSimulation(ActionEvent event) { 	
    	
    	gameOfLifeMatrix.calculateNextStepMatrix();  	
    	draw();
    }
    
    public void initialize() {
    	
    	gameOfLifeMatrix = new GameOfLifeMatrix(matrixHeight,matrixWidth);
    	draw();
    }
    
public void draw() {
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
    	
    	double cellWidth = canvas.getWidth()/matrixWidth;
    	double cellHeight = canvas.getHeight()/matrixHeight;
    	
    	for (int i = 0 ; i<matrixHeight; i++) {
    		for(int j = 0 ; j<matrixWidth ; j++) {
    			
    			if (gameOfLifeMatrix.getLifeMatrix()[i][j]==1) {
        			gc.setFill(Color.GREY);
    				gc.fillRect(j*cellWidth,i*cellHeight,cellWidth,cellHeight );
        		}
    			else {
    				gc.setFill(Color.WHITE);
    				gc.fillRect(j*cellWidth,i*cellHeight,cellWidth,cellHeight );
    			}
    		}
    	}
    	
    	//draws grids
    	for (int i = 0 ; i<=matrixHeight; i++) {
    		gc.strokeLine(0, i*cellHeight, canvas.getWidth(),i*cellHeight);
    	}
    	for (int i = 0 ; i<=matrixWidth; i++) {
    		gc.strokeLine(i*cellWidth,0, i*cellWidth,canvas.getHeight());
    	} 	
	}
}
