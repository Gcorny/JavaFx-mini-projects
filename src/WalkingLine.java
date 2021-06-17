/*
 * self-avoiding random walking line
 * 
 * Overrall, the class will consists of two sets which will contain the x and y positions that the line have walked
 * functions that will check whether the new positions have already been walked
 * functions that will draw new line depending on the random generated direction
 * a function that will check whether the line is at the edge.
 */
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;


public class WalkingLine extends Pane{
	private List<Integer>[] graph; //this will help checking if the next position has already connected to the current
	private double x = 250;
	private double y = 250;
	private Timeline animation;
	
	
	/** empty constructor **/
	public WalkingLine() {
		graph = new List[51];
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> walk((int)(Math.random() * 4))));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	
	
	public void walkUp() {
		getChildren().add(new Line(x,y, x, y -10));
		y -= 10;
		
	}
	
	public void walkDown() {
		getChildren().add(new Line(x,y, x, y +10));
		y += 10;
		}

		
	
	public void walkLeft() {
		getChildren().add(new Line(x, y, x - 10, y));
		x -= 10;
	}
	
	public void walkRight() {
		getChildren().add(new Line(x, y , x + 10, y));
		x += 10;
		
	}
	
	public void play() {
		animation.play();
	}
	
	public void pause() {
		animation.pause();
	}
	

	
	public boolean isEdge() {
		if(x == 0 || x == getWidth() || y == 0 || y == getHeight()) return true;
		return false;
	}
	
	
	public void walk(int direction) {
		if(isEdge()) { //stop once the line reaches the edge.
			getChildren().clear();
			x = 250;
			y = 250;
			return;
		}
		switch(direction) {
		case 0: walkUp(); break;
		case 1: walkDown(); break;
		case 2: walkLeft(); break;
		case 3: walkRight(); break;
		}
		
	}
	
	
	
}
