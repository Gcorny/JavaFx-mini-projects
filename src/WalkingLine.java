/*
 * self-avoiding random walking line
 * 
 * the class will consists of two sets which will contain the x and y positions that the line have walked
 * functions that will check whether the new positions have already been walked
 * functions that will draw new line depending on the random generated direction
 * a function that will check whether the line is at the edge.
 */
import java.util.HashSet;
import java.util.Set;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;
public class WalkingLine extends Pane{
	private Set<Double> setX, setY;
	private Timeline animation;
	private double x = 250; // initial positions
	private double y = 250;
	
	
	/** empty constructor **/
	public WalkingLine() {
		setX = new HashSet<>();
		setY = new HashSet<>();
		setX.add(x);
		setY.add(y);
		animation = new Timeline(new KeyFrame(Duration.millis(100), e -> walk((int)(Math.random()*4))));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	
	
	public void play() {
		animation.play();
	}
	
	/*stop the walk once the line is at the edge*/
	public void pause() {
		animation.pause();
	}
	
	public void walkUp() {
		if(setX.contains(x) && !setY.contains(y - 10)) {
			getChildren().add(new Line(x,y, x, y - 10));
			updateY(y - 10);
		}
		
		
	}
	
	public void walkDown() {
		if(setX.contains(x) && !setY.contains(y + 10)) {
			getChildren().add(new Line(x,y, x, y + 10));
			updateY(y +10);
		}
		
	}
	
	public void walkLeft() {
		if(setY.contains(y) && !setX.contains(x - 10)) {
			getChildren().add(new Line(x, y, x -10, y));
			updateX(x - 10);
		}
	
	}
	
	public void walkRight() {
		if(setY.contains(y) && !setX.contains(x + 10)) {
			getChildren().add(new Line(x, y, x +10, y));
			updateX(x + 10);
		}
		
		
	}
	/*check if the position is at the edge*/
	public boolean isEdge() {
		if(x == 0 || x == getWidth() || y == 0 || y == getHeight()) return true;
		return false;
	}
	
	
	/*create new line based on the given direction */
	public void walk(int direction) {
		if(isEdge()) {
			pause();
			return;
		}
		
		switch(direction) {
		case 0: walkUp(); break;
		case 1: walkDown(); break;
		case 2: walkLeft(); break;
		case 3: walkRight(); break;
		}
	}
	
	/* update the new position of x and also add it to setX */
	public void updateX(double newX) {
		setX.add(newX);
		this.x = newX;
	}
	/*update new position for y and add it to setY*/
	public void updateY(double newY) {
		setY.add(newY);
		this.y = newY;
		
		
	}
	
	
}
