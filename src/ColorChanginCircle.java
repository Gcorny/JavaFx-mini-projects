import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorChanginCircle extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		Circle circle = new Circle(250, 250, 50);
		BorderPane pane =new BorderPane();
		pane.setCenter(circle);
		Text text = new Text();
		pane.getChildren().add(text);
		circle.setOnMousePressed(e -> circle.setFill(Color.RED));
		circle.setOnMouseReleased(e -> circle.setFill(Color.BLUE));
		
		Scene scene = new Scene(pane, 500, 500);
		stage.setScene(scene);
		stage.show();
//		scene.setOnMousePressed(e -> {
//			double x = e.getSceneX();
//			double y = e.getSceneY();
//			text.setX(x);
//			text.setY(y);
//			text.setText("(" + x + ", " + y + ")");
//		});
//		scene.setOnMouseReleased(e -> text.setText(""));
		scene.setOnMouseMoved(e -> {
			double x = e.getSceneX();
			double y = e.getSceneY();
			text.setX(x);
			text.setY(y);
			text.setText("(" + x + ", " + y + ")");
		});
		//scene.setOnMousePressed(e -> pane.getChildren().add( new Text(e.getSceneX(),e.getSceneY(), "(" +e.getSceneX() + ", " + e.getSceneY())));
	}
	

}
