package Sprites;

import javafx.scene.image.Image;

public class Bullet extends Sprite {
	private final int BULLET_SPEED = 20;
	public static int MCFacing = 0;

	private final int FinalOrientation = MCFacing;
	private static final Image BULLET_IMAGE_PIERCE = new Image(
			Bullet.class.getResource("/images/pierce.gif").toExternalForm(), Bullet.BULLET_WIDTH, Bullet.BULLET_WIDTH,
			false, false);
	private static final Image BULLET_IMAGE_ONE_TAP = new Image(
			Bullet.class.getResource("/images/onetap.gif").toExternalForm(), Bullet.BULLET_WIDTH, Bullet.BULLET_WIDTH,
			false, false);
//	public final static Image BULLET_IMAGE = new Image("images/bullet.png",Bullet.BULLET_WIDTH,Bullet.BULLET_WIDTH,false,false);
	private static final Image BULLET_IMAGE = new Image(Bullet.class.getResource("/images/M1.gif").toExternalForm(),
			Bullet.BULLET_WIDTH, Bullet.BULLET_WIDTH, false, false);
	public static int weapon = 0;

	public final static int BULLET_WIDTH = 20;

	public Bullet(int x, int y) {
		super(x, y);
		this.loadImage(Bullet.BULLET_IMAGE);
		if (weapon == 0) {
			this.loadImage(Bullet.BULLET_IMAGE);
		} else if (weapon == 1) {
			this.loadImage(Bullet.BULLET_IMAGE_PIERCE);
		} else if (weapon == 2) {
			this.loadImage(Bullet.BULLET_IMAGE_ONE_TAP);
		}
	}

	// method that will move/change the x position of the bullet
	public void move() {

		if (this.FinalOrientation == 0) {
			this.x += BULLET_SPEED;
		} else if (this.FinalOrientation == 1) {
			this.x -= BULLET_SPEED;
		}

		if (this.x > 750) {
			this.setVisible(false);
		}
		if (this.x < 0) {
			this.setVisible(false);
		}
		/*
		 * TODO: Change the x position of the bullet depending on the bullet speed. If
		 * the x position has reached the right boundary of the screen, set the bullet's
		 * visibility to false.
		 */

	}
}