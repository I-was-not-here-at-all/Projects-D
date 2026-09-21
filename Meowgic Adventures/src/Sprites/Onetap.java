package Sprites;

import javafx.scene.image.Image;

public class Onetap extends Sprite {
	private static final Image POWER_UP_IMAGE = new Image(
			Onetap.class.getResource("/images/Atk boost.gif").toExternalForm(), Onetap.POWER_WIDTH, Onetap.POWER_WIDTH,
			false, false);
	public final static int POWER_WIDTH = 30;

	public Onetap(int x, int y) {
		super(x, y);
		this.loadImage(Onetap.POWER_UP_IMAGE);
	}
}