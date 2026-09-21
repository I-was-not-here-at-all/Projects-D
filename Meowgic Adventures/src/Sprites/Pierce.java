package Sprites;

import javafx.scene.image.Image;

public class Pierce extends Sprite {
	private static final Image POWER_UP_IMAGE = new Image(
			Pierce.class.getResource("/images/powerupPierce.gif").toExternalForm(), Pierce.POWER_WIDTH,
			Pierce.POWER_WIDTH, false, false);
	public final static int POWER_WIDTH = 30;

	public Pierce(int x, int y) {
		super(x, y);
		this.loadImage(Pierce.POWER_UP_IMAGE);
	}
}