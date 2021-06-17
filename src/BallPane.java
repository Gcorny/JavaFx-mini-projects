import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class BallPane  extends BorderPane{
	private double radius = 20;
	//private double x = radius , y = radius;
	private double dx = 1, dy = 1;
	Timeline animation;
	//Circle circle = new Circle(radius);
	
	public BallPane() {
		//circle.setFill(Color.GREEN);
		//getChildren().add(circle);
		
		animation = new Timeline(new KeyFrame(Duration.millis(50), e ->  moveBall()));
		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	
	public void play() {
		animation.play();
	}
	
	public void add() {
		//Ball ball = new Ball(radius, radius,radius, Color.RED);

		getChildren().add(new Ball(radius, radius, radius, Color.RED));
	}
	
	public void pause() {
		animation.pause();
	}
	
	public void increaseSpeed() {
		animation.setRate(animation.getRate() + 0.5);
	}
	
	public void decreaseSpped() {
		animation.setRate(animation.getRate() > 0 ? animation.getRate() - 0.5 : 0);
	}
	
	public DoubleProperty rateProperty() {
		return animation.rateProperty();
	}
	
//	public void moveBall() {
//		// check Boundaries
////		Circle c = (Circle) this.getChildren();
////		if(x < radius || x > getWidth() - radius) {
////			dx *= -1;
////		}
////		if ( y < radius || y > getHeight() - radius) {
////			dy *= -1;
////		}
////		
////		x += dx;
////		y += dy;
////		c.setCenterX(x);
////		c.setCenterY(y);
//		
//	}
	protected void moveBall() {
	      for (Node node: this.getChildren()) {
	        Ball ball = (Ball)node;
	        // Check boundaries
	        if (ball.getCenterX() < ball.getRadius() || 
	            ball.getCenterX() > getWidth() - ball.getRadius()) {
	          ball.dx = ball.dx >  0 ? Math.random() * -1 : Math.random();
	          // Change ball move direction
	        }
	        if (ball.getCenterY() < ball.getRadius() || 
	            ball.getCenterY() > getHeight() - ball.getRadius()) {
	          ball.dy =ball.dy > 0 ? Math.random() * -1 : Math.random(); // Change ball move direction
	          
	        }

	        // Adjust ball position
	        ball.setCenterX(ball.dx + ball.getCenterX());
	        ball.setCenterY(ball.dy + ball.getCenterY());
	        
	        
	      }
	    }
	  
}

class Ball extends Circle {
    public double dx = Math.random(), dy = Math.random();

    Ball(double x, double y, double radius, Color color) {
      super(x, y, radius);
      setFill(color); // Set ball color
    }
  }
