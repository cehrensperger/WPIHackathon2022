
public class Runner {
	static PerlinNoiseGenerator generator = new PerlinNoiseGenerator();
	public static void main(String[] args) {
		   System.out.println(generator.noise(3.14,42,7));
	}
}
