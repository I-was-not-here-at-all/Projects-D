package Sprites;

import javafx.scene.image.Image;

public class HealthUp extends Sprite {
	private static final Image POWER_UP_IMAGE = new Image(
			HealthUp.class.getResource("/images/Heal.gif").toExternalForm(), HealthUp.POWER_WIDTH, HealthUp.POWER_WIDTH,
			false, false);
	public final static int POWER_WIDTH = 30;

	public HealthUp(int x, int y) {
		super(x, y);
		this.loadImage(HealthUp.POWER_UP_IMAGE);
	}
}