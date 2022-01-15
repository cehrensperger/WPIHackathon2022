import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;  
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Runner extends Application{
	static SimplexNoiseGenerator generator = new SimplexNoiseGenerator();
	double zVal = 70.0;
	double zStep = 0.01;
	double health = 100.0;
	double mouseX;
	double mouseY;
	double score = 0;
	ImageView imageView = new ImageView();
	WritableImage wImg = new WritableImage(500, 500);
	PixelWriter writer = wImg.getPixelWriter();
	AnimationTimer animator = new Animator();
	Text healthText = new Text();
	Text scoreText = new Text();
	public static void main(String[] args) {
		launch(args);
		   System.out.println(generator.noise(3.14,42,7));
	}
	@Override
	public void start(Stage stage) throws Exception {
		animator.start();
		StackPane root = new StackPane();
		imageView = new ImageView(wImg);
		healthText.setTextOrigin(VPos.TOP);
		healthText.setFont(new Font(20));
		healthText.setText("health: " + health);
		healthText.setFill(Color.RED);
		root.getChildren().add(imageView);
		root.getChildren().add(healthText);
		
		Scene scene = new Scene(root);
		
		
		stage.setScene(scene);  
        stage.setTitle("WPI Hackathon Lava Lamp Survival Game");  
        stage.show();  
		
        
        EventHandler<MouseEvent> mouseMoved = new EventHandler<MouseEvent>() {
        	

			@Override
			public void handle(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
				
			}
        };
        
        EventHandler<MouseEvent> mouseExited = new EventHandler<MouseEvent>() {
        	

			@Override
			public void handle(MouseEvent e) {
				animator.stop();
			}
        };
        
        EventHandler<MouseEvent> mouseEntered = new EventHandler<MouseEvent>() {
        	

			@Override
			public void handle(MouseEvent e) {
				if(health > 0) {
					animator.start();
				}
			}
        };
        
        stage.addEventHandler(MouseEvent.MOUSE_EXITED_TARGET, mouseExited);
        stage.addEventHandler(MouseEvent.MOUSE_ENTERED_TARGET, mouseEntered);
        stage.addEventHandler(MouseEvent.MOUSE_MOVED, mouseMoved);

	}
	private class Animator extends AnimationTimer {

		@Override
		public void handle(long arg0) {
			healthText.setText("health: " + health + "\n" + "score: " + score);
			zVal += zStep;
			System.out.println(health);
			
			if(!wImg.getPixelReader().getColor((int)mouseX, (int)mouseY).toString().equals("0x323232ff")) {	
				health -= 0.5;
				if(health <= 0) {
					animator.stop();
				}
			} 
			
			zStep += 0.0001;
			if(health > 0) {
				score = (int)((zVal - 70) * 200);
			}
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
					
					double noiseVal = ((generator.noise(xVal, yVal, zVal) + 1.0)/2.0);
					double noiseVal2 = (generator.noise(xVal, zVal, zVal) + 1.0)/2.0;
					double noiseVal3 = (generator.noise(zVal, yVal, zVal) + 1.0)/2.0;
					
					int r = (int)(noiseVal*255);
					int g = (int)(noiseVal2*255);
					int b = (int)(noiseVal3*255);
					if(noiseVal < 0.5) {					
						writer.setColor(j, i, Color.rgb(r, g, b, 1.0));
					} else {
						writer.setColor(j, i, Color.rgb(50, 50, 50, 1));
					}
					xVal += xStep;
				}
				
				xVal = 3.14;
				yVal += yStep;
			}
			
			
		}
		
	}
}

