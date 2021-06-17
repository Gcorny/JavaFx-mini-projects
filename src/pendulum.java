import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.QuadCurve;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class pendulum extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		BorderPane pane = new BorderPane();
		
		QuadCurve curve = new QuadCurve(100, 220, 300, 500, 500, 220);
		
		curve.setFill(Color.WHITE);
		curve.setStroke(Color.RED);
		Circle circle = new Circle(250, 250,20, Color.RED);
		pane.getChildren().addAll(curve,circle );
		
		PathTransition pt = new PathTransition();
		pt.setPath(curve);
		pt.setNode(circle);
		pt.setCycleCount(Timeline.INDEFINITE);
		pt.setDuration(Duration.millis(1000));
		pt.setAutoReverse(true);
		pt.play();
		
		Scene scene =new Scene(pane, 600, 500);
		stage.setScene(scene);
		stage.show();
//		scene.setOnMousePressed(e -> {
//			double x = e.getSceneX();
//			double y = e.getSceneY();
//			text.setX(x);
//			text.setY(y);
//			text.setText("(" + x + ", " + y + ")");
//		});
		//group.requestFocus();
	}

}
