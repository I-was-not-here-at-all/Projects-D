package Sprites;

import java.util.Random;

import javafx.scene.image.Image;

public class Boss extends Sprite {
	public static final int MAX_FISH_SPEED = 1;
	public static int boss_phase = 0;

//	public final static Image FISH_IMAGE = new Image("images/fish.png",Fish.FISH_WIDTH,Fish.FISH_WIDTH,false,false);

	public static int health = 100;
	private static Image Boss_Idle = new Image(Bullet.class.getResource("/images/bossidle.gif").toExternalForm(),
			Boss.FISH_WIDTH, Boss.FISH_WIDTH, false, false);
	private static Image Boss_Atacking = new Image(
			Bullet.class.getResource("/images/bossatacking.gif").toExternalForm(), Boss.FISH_WIDTH, Boss.FISH_WIDTH,
			false, false);
	private static Image Boss_Attacked = new Image(
			Bullet.class.getResource("/images/bossattacked.gif").toExternalForm(), Boss.FISH_WIDTH, Boss.FISH_WIDTH,
			false, false);

	public final static int FISH_WIDTH = 100;
	private static boolean alive;
	// attribute that will determine if a fish will initially move to the right
	private boolean moveRight;
	private int speed;

	public Boss(int x, int y) {
		super(x, y);
		this.alive = true;
		if (boss_phase == 0) {
			this.loadImage(Boss.Boss_Idle);
		} else if (boss_phase == 1) {
			this.loadImage(Boss.Boss_Atacking);
		} else if (boss_phase == 2) {
			this.loadImage(Boss.Boss_Attacked);
		}

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
	public void move(int xpos, int ypos) {

		int mcxpos = xpos;
		int mcypos = ypos;

		if (this.x < mcxpos) {
			this.x += 1;
		} else if (this.x > mcxpos) {
			this.x -= 1;
		}

		if (this.y < mcypos) {
			this.y += 1;
		} else if (this.y > mcypos) {
			this.y -= 1;
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
