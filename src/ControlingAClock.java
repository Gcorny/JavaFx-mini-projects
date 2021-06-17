import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ControlingAClock extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	@Override
	public void start(Stage stage) {
		BorderPane pane = new BorderPane();
		ClockPane clock = new ClockPane();
		
		pane.setCenter(clock);
		Button stop = new Button("stop");
		Button start = new Button("start");
		HBox box = new HBox(stop, start);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		pane.setBottom(box);
		stop.setOnAction(e -> clock.pause());
		start.setOnAction(e -> clock.play());
		
		
		
		
		Scene scene = new Scene(pane, 500, 500);
		stage.setScene(scene);
		stage.show();
		
	}

}
