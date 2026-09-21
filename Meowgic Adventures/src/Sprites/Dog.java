package Sprites;

import java.util.Random;

import javafx.scene.image.Image;

public class Dog extends Sprite {
	public static final int MAX_FISH_SPEED = 5;
//	public final static Image FISH_IMAGE = new Image("images/fish.png",Fish.FISH_WIDTH,Fish.FISH_WIDTH,false,false);

	private static int health = 100;
	private static final Image FISH_IMAGE = new Image(Bullet.class.getResource("/images/Dog.gif").toExternalForm(),
			Dog.FISH_WIDTH, Dog.FISH_WIDTH, false, false);

	public final static int FISH_WIDTH = 50;
	private static boolean alive;
	// attribute that will determine if a fish will initially move to the right
	private boolean moveRight;
	private int speed;

	public Dog(int x, int y) {
		super(x, y);
		this.alive = true;
		this.loadImage(Dog.FISH_IMAGE);
		/*
		 * TODO: Randomize speed of fish and moveRight's initial value
		 */
		Random rand = new Random();

		// Randomize speed between 1 and MAX_FISH_SPEED
		this.speed = rand.nextInt(MAX_FISH_SPEED) + 5;

		// Randomize initial direction (true or false)
		this.moveRight = rand.nextBoolean();

	}

	// method that changes the x position of the fish
	public void move() {
		/*
		 * TODO: If moveRight is true and if the fish hasn't reached the right boundary
		 * yet, move the fish to the right by changing the x position of the fish
		 * depending on its speed else if it has reached the boundary, change the
		 * moveRight value / move to the left Else, if moveRight is false and if the
		 * fish hasn't reached the left boundary yet, move the fish to the left by
		 * changing the x position of the fish depending on its speed. else if it has
		 * reached the boundary, change the moveRight value / move to the right
		 */
		if (moveRight) {

			if (this.x + speed < 750 - FISH_WIDTH) {
				this.x += speed;
			} else {

				moveRight = false;
				this.x -= speed; // Move left immediately after changing direction
			}
		} else {

			if (this.x - speed > 0) {
				this.x -= speed;
			} else {

				moveRight = true;
				this.x += speed;
			}
		}
	}

	// getter
	public static boolean isAlive() {
		if (health < 0) {
			health = 0;
		}
		if (health == 0) {
			return alive = false;
		}
		return alive;

	}
}
