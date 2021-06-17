/*
 * self-avoiding random walking line
 * 
 * Overrall, the class will consists of two sets which will contain the x and y positions that the line have walked
 * functions that will check whether the new positions have already been walked
 * functions that will draw new line depending on the random generated direction
 * a function that will check whether the line is at the edge.
 */
import java.util.HashSet;
import java.util.Set;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
public class WalkingLine extends Pane{
	private Set<Double> setX, setY;
	private Timeline animation;
	private boolean isEdge;
	
	
	/** empty constructor **/
	public WalkingLine() {
		setX = new HashSet<>();
		setY = new HashSet<>();
		animation = new Timeline(new KeyFrame(Duration.millis(400), e -> walk()));
	}
	
	
	public void walkUp() {
		
	}
	
	public void WalkDown() {
		
	}
	
	public void walkLeft() {
		
	}
	
	public void walkRight() {
		
	}
	
	public boolean isEdge() {
		
	}
	
	
	public void walk() {
		
	}
	
	
	
}
