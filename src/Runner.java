import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.stage.Stage;  
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;  

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
		WritableImage wImg = new WritableImage(500, 500);
		PixelWriter writer = wImg.getPixelWriter();
		
		double xVal = 3.14;
		double yVal = 1.25;
		double xStep = 0.1;
		double yStep = 0.1;
		
		for(int i = 0; i < 500; i ++) {
			for(int j = 0; j < 500; j ++) {
				double noiseVal = (generator.noise(xVal, yVal, 7) + 1.0)/2.0;
				//System.out.println(generator.noise(xVal, yVal, 7));
				writer.setColor(j, i, Color.rgb(0, 0, 0, noiseVal));
				xVal += xStep;
			}
			
			xVal = 3.14;
			yVal += yStep;
		}
		
		
		ImageView imageView = new ImageView(wImg);
		root.getChildren().add(imageView);
		//root.getChildren().add(wImg);
		
		Scene scene = new Scene(root);
		
		
		stage.setScene(scene);  
        stage.setTitle("First JavaFX Application");  
        stage.show();  
		
	}
}
