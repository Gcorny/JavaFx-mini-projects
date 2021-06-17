import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AlternatingMessage extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		
		BorderPane pane = new BorderPane();
		Text text = new Text("Welcome to Java");
		Scene scene = new Scene(pane, 500, 500);
		pane.setCenter(text);
		scene.setOnMouseClicked(e -> {
			if (text.getText() == "Welcome to Java") {
				text.setText("LearningJavaFX");
			}
			else {
				text.setText("Welcome to Java");
			}
		});
		
		
		
		
		stage.setScene(scene);
		stage.show();
		
	}

}
