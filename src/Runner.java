import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;  
import javafx.stage.Stage;  
import javafx.scene.layout.StackPane;  

public class Runner extends Application{
	static PerlinNoiseGenerator generator = new PerlinNoiseGenerator();
	public static void main(String[] args) {
		launch(args);
		   System.out.println(generator.noise(3.14,42,7));
	}
	@Override
	public void start(Stage stage) throws Exception {
		StackPane root = new StackPane();
		Button btn = new Button("test button");
		root.getChildren().add(btn);
		
		Scene scene = new Scene(root);
		
		stage.setScene(scene);  
        stage.setTitle("First JavaFX Application");  
        stage.show();  
		
	}
}
