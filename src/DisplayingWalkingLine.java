/*Displaying self-avoid random walking line*/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DisplayingWalkingLine extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	
	@Override
	public void start(Stage stage) {
		WalkingLine w = new WalkingLine();
		
		Scene scene = new Scene(w, 500, 500);
		stage.setScene(scene);
		stage.show();
	}

}
