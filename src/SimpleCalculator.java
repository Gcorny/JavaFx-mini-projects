import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class SimpleCalculator extends Application{
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage stage) {
		HBox hbox = new HBox();
		Label l1 = new Label("Number 1:");
		TextField t1 = new TextField();
		setWidth(t1);
		Label l2 = new Label("Number 2:");
		TextField t2 = new TextField();
		setWidth(t2);
		
		Label l3 = new Label("Result: ");
		TextField t3 = new TextField();
		setWidth(t3);
		hbox.getChildren().addAll(l1,t1,l2,t2, l3,t3);
		Button add = b("Add");
		Button subtract = b("Subtract");
		Button Mul = b("Multiply");
		Button Divide = b("Divide");
		
		
		HBox box2 = new HBox(add, subtract, Mul, Divide);
		box2.setAlignment(Pos.CENTER);
		box2.setSpacing(10);
		BorderPane pane  = new BorderPane();
		pane.setTop(hbox);
		pane.setBottom(box2);
		
		add.setOnAction(e -> {
			t3.setText(String.valueOf(add(Double.parseDouble(t1.getText()), Double.parseDouble(t2.getText()))));
		});
		subtract.setOnAction(e -> {
			t3.setText(String.valueOf(subtract(Double.parseDouble(t1.getText()), Double.parseDouble(t2.getText()))));
		});
		Mul.setOnAction(e -> {
			t3.setText(String.valueOf(mul(Double.parseDouble(t1.getText()), Double.parseDouble(t2.getText()))));
		});
		Divide.setOnAction(e -> {
			t3.setText(String.valueOf(divide(Double.parseDouble(t1.getText()), Double.parseDouble(t2.getText()))));
		});
		
		
		Scene scene = new Scene(pane, 350, 100);
		stage.setScene(scene);
		stage.show();
	}
	
	public void setWidth(TextField t) {
		t.setPrefWidth(60);
	}
	
	public Button b(String s) {
		return new Button(s);
	}
	
	// add two numbers
	public double add(double a, double b) {
		return a+b;
	}
	
	//subtract two numbers
	public double subtract(double a , double b) {
		return a-b;
	}
	
	//multiply two numbers
	public double mul(double a , double b) {
		return a*b;
	}
	
	public double divide(double a, double b) {
		return a/b;
	}

}
