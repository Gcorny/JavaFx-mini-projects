import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class DrawingLine extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	double x = 100, y =100;
	@Override
	public void start(Stage stage) {
		
		
		Pane pane = new Pane();
		
		
		Scene scene = new Scene(pane,500 , 500);
		stage.setScene(scene);
		stage.show();
		
		scene.setOnKeyPressed(e -> {
			switch(e.getCode()) {
						
				case UP: if(y > 10) {
							pane.getChildren().add(new Line(x, y, x , y -10));
							y = y -10;
							}
						break;
				case DOWN:if(y <= pane.getHeight() - 10) {
					pane.getChildren().add(new Line(x,y,x, y+10));
					y += 10;
				}
						break;
						
				case LEFT: if(x >= 10) {
					pane.getChildren().add(new Line(x, y, x -10 , y));
					x -= 10;
				}
							break;
				case RIGHT: if(x <= pane.getWidth() -10) {
					pane.getChildren().add(new Line(x, y , x + 10, y));
					x += 10;
				}
							
							break;
			}
		});
	}

}

