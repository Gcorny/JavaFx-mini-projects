import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class BounceControl extends Application{
	public static void main(String[] args){
		Application.launch(args);
		
	}
	
	@Override
	public void start(Stage stage) {
		
		BallPane ball = new BallPane();
		
		
		ball.setOnMousePressed(e -> ball.pause());
		ball.setOnMouseReleased(e -> ball.play());
		ball.setOnKeyPressed(e -> {
			
			if(e.getCode() == KeyCode.UP) {
				ball.increaseSpeed();
			}
			if(e.getCode() == KeyCode.DOWN) {
				ball.decreaseSpped();
			}
		});
		 Button btAdd = new Button("+");
		 btAdd.setOnAction(e -> ball.add());
		 
		    Button btSubtract = new Button("-");
		    btSubtract.setOnAction(e -> ball.increaseSpeed());
		    HBox hBox = new HBox(10);
		    hBox.getChildren().addAll(btAdd, btSubtract);
		    hBox.setAlignment(Pos.CENTER);
		    
		    
		    BorderPane pane = new BorderPane();
		    pane.setCenter(ball);
		    //pane.setTop(sbSpeed);
		    pane.setBottom(hBox);
		
		
		Scene scene = new Scene(pane,500, 500);
		stage.setScene(scene);
		stage.show();
		ball.requestFocus();
	}

}
