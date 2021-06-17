import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;
import javafx.util.Duration;

public class RotatingEliipse extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	@Override
	public void start(Stage stage) {
		BorderPane pane = new BorderPane();
		
		Rotating ellipse = new Rotating();
		Button bt = new Button("reverse");
		pane.setCenter(ellipse);
		HBox box = new HBox(bt);
		box.setAlignment(Pos.CENTER);
		pane.setBottom(box);
		bt.setOnAction(el -> {
			ellipse.setReverse();
		});
		
		
		
		Scene scene = new Scene(pane, 500, 500);
		stage.setScene(scene);
		stage.show();
	}

}


class Rotating extends Pane{
	private Ellipse e;
	private Timeline anime;
	private boolean isReverse;
	public Rotating() {
		
		e = new Ellipse(250, 250, 30 , 50);
		this.getChildren().add(e);
		e.setFill(Color.WHEAT);
		e.setStroke(Color.RED);
		anime = new Timeline(new KeyFrame(Duration.millis(30), el -> {
			
			if (!isReverse()) {
				rerotate();
			}
			else {
				rotate();
			}
		}));
		isReverse = false;
		anime.setCycleCount(Timeline.INDEFINITE);
		//anime.setAutoReverse(true);
		anime.play();
		
	}
	
	public boolean isReverse() {
		return isReverse;
	}
	
	public void setReverse() {
		isReverse = !isReverse;
	}
	
	public void play() {
		anime.play();
	}
	
	public void pause() {
		anime.pause();
	}
	
	
	public void rotate() {
		e.setRotate(e.getRotate() + 30);
	}
	public void rerotate() {
		e.setRotate(e.getRotate() - 30);
	}
}