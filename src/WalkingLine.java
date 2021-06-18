/*
 * self-avoiding random walking line
 * 
 * Overrall, the class will consists of two sets which will contain the x and y positions that the line have walked
 * functions that will check whether the new positions have already been walked
 * functions that will draw new line depending on the random generated direction
 * a function that will check whether the line is at the edge.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;


public class WalkingLine extends Pane{
	private Set<Pair> set = new HashSet<>(); //this will help checking if the next position has already connected to the current
	private int x = 250;
	private int y = 250;
	private Timeline animation;
	
	
	/** empty constructor **/
	public WalkingLine() {
		set.add(new Pair(x,y));
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> walk((int)(Math.random() * 4))));
		animation.setCycleCount(Timeline.INDEFINITE);
		
	}
	public void chillMode() {
		animation = new Timeline(new KeyFrame(Duration.millis(50), e -> chilWalk((int)(Math.random() *4))));
		animation.setCycleCount(Timeline.INDEFINITE);
	}
	
	
	public void walkUp() {
		int nextY = y -10;
		if(!set.contains(new Pair(x,nextY))) {
			getChildren().add(new Line(x,y, x, nextY));
			y = nextY;
			set.add(new Pair(x, nextY));
		}
		
		
	}
	
	public void walkDown() {
		int nextY = y +10;
		if(!set.contains(new Pair(x,nextY))) {
			getChildren().add(new Line(x,y, x, nextY));
			y = nextY;
			set.add(new Pair(x, nextY));
		}
	}

		
	
	public void walkLeft() {
		int nextX = x -10;
		if(!set.contains(new Pair(nextX, y))) {
			getChildren().add(new Line(x, y, nextX, y));
			x = nextX;
			set.add(new Pair(nextX, y));
		}
		
	}
	
	public void walkRight() {
		int nextX = x +10;
		if(!set.contains(new Pair(nextX, y))) {
			getChildren().add(new Line(x, y, nextX, y));
			x = nextX;
			set.add(new Pair(nextX, y));
		}
		
	}
	public void up() {
		getChildren().add(new Line(x, y, x , y -10));
		y -= 10;
	}
	
	public void down() {
		getChildren().add(new Line(x ,y, x , y +10));
		y += 10;
		
	}
	
	public void left() {
		getChildren().add(new Line(x, y, x -10, y));
		x -= 10;
	}
	
	public void right() {
		getChildren().add(new Line(x, y, x + 10, y));
		x += 10;
	}
	
	public void play() {
		animation.play();
	}
	
	public void pause() {
		animation.pause();
	}
	
	public void refresh() {
		getChildren().clear();
		x = 250;
		y = 250;
		set.clear();
		play();
	}
	
	public void step(int direction) {
		walk(direction);
	}
	

	
	public boolean isEdge() {
		if(x == 0 || x == getWidth() || y == 0 || y == getHeight()) return true;
		return false;
	}
	public boolean isCornered() {
		if(set.contains(new Pair(x + 10, y)) && set.contains(new Pair(x - 10, y)) &&
				set.contains(new Pair(x, y + 10)) && set.contains(new Pair(x , y -10))) return true;
		return false;
	}
	
	public void chilWalk(int direction) {
		if(isEdge()) { //stop once the line reaches the edge.
			animation.stop();
			
		}
		if(isCornered()) {
			animation.stop();
		}
		
		switch(direction) {
		case 0: up(); break;
		case 1: down(); break;
		case 2: left(); break;
		case 3: right(); break;
		}
		
	}
	public void walk(int direction) {
		if(isEdge()) { //stop once the line reaches the edge.
			animation.stop();
			
		}
		if(isCornered()) {
			animation.stop();
		}
		
		switch(direction) {
		case 0: walkUp(); break;
		case 1: walkDown(); break;
		case 2: walkLeft(); break;
		case 3: walkRight(); break;
		}
		
	}
	class Pair{
		protected int x;
		protected int y;
		
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
			
		}
		public int hashCode() {
			return x + y;
		}
		public int getX() {
			return x;
		}
		
		public int getY() {
			return y;
		}
		public boolean equals(Object o ) {
			return x == ((Pair)o).x && y ==((Pair)o).y;
		}
	}
}
