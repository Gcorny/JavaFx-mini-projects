/*Displaying self-avoid random walking line*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class DisplayingWalkingLine extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	@Override
	public void start(Stage stage) {
		WalkingLine w = new WalkingLine();
		
		Button step = new Button("step");
		Button pause = new Button("pause");
		Button refresh = new Button("refresh");
		Button start = new Button("start");
		Button chillMode = new Button("chill");
		HBox box = new HBox(refresh, start,pause, step, chillMode);
		box.setAlignment(Pos.CENTER);
		box.setSpacing(10);
		BorderPane pane =new BorderPane();
		pane.setCenter(w);
		pane.setBottom(box);
		start.setOnAction(e -> w.play());
		refresh.setOnAction(e -> w.refresh());
		pause.setOnAction(e -> w.pause());
		step.setOnAction(e -> w.step((int)(Math.random()*4)));
		chillMode.setOnAction(e -> w.chillMode());
		
		
		
		Scene scene  = new Scene(pane, 500, 500);
		stage.setScene(scene);
		stage.show();
	}

}
