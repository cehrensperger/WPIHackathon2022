import java.util.Random;
import java.util.random.RandomGenerator;

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
		double xStep = 0.01;
		double yStep = 0.01;
		
		Random random = new Random();
		double rangeMin = 1.0;
		double rangeMax = 70.0;
		double z1 = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
		double z2 = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
		double z3 = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
		for(int i = 0; i < 500; i ++) {
			for(int j = 0; j < 500; j ++) {
				
				double noiseVal = ((generator.noise(xVal, yVal, z1) + 1.0)/2.0);
				double noiseVal2 = (generator.noise(xVal, yVal, z2) + 1.0)/2.0;
				double noiseVal3 = (generator.noise(xVal, yVal, z3) + 1.0)/2.0;
				
				int r = (int)(noiseVal*255);
				int g = (int)(noiseVal2*255);
				int b = (int)(noiseVal3*255);
				//System.out.println(generator.noise(xVal, yVal, 7));
				//if(noiseVal < 0.5) {					
					writer.setColor(j, i, Color.rgb(r, g, b, 1.0));
				//} else {
				//	writer.setColor(j, i, Color.rgb(50, 50, 50, 1));
				//}
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
