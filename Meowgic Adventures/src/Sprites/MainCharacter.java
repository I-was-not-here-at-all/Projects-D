package Sprites;

import java.util.ArrayList;
import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainCharacter extends Sprite {
	private String name;
	private static int strength;
	private boolean alive;
	private Image attack;
	private Image walk;

	private ArrayList<Bullet> bullets;
//	public final static Image SHIP_IMAGE = new Image("images/ship.png",Ship.SHIP_WIDTH,Ship.SHIP_WIDTH,false,false);

	private static final Image SHIP_IMAGE = new Image(Bullet.class.getResource("/images/Idle.gif").toExternalForm(),
			MainCharacter.SHIP_WIDTH, MainCharacter.SHIP_WIDTH, false, false);

	private final static int SHIP_WIDTH = 50;

	public MainCharacter(String name, int x, int y) {
		super(x, y);
		this.name = name;
		Random r = new Random();
		this.strength = r.nextInt(151) + 100;
		this.alive = true;
		this.bullets = new ArrayList<Bullet>();
		this.attack = new Image(Bullet.class.getResource("/images/MC-attack.gif").toExternalForm(),
				MainCharacter.SHIP_WIDTH, MainCharacter.SHIP_WIDTH, false, false);
		this.walk = new Image(Bullet.class.getResource("/images/MC-attack.gif").toExternalForm(),
				MainCharacter.SHIP_WIDTH, MainCharacter.SHIP_WIDTH, false, false);
		this.loadImage(MainCharacter.SHIP_IMAGE);
	}

	public static int getStrength() {
		return strength;
	}

	public void Walk_Image() { // mark as useless for now....
		this.loadImage(walk);
	}

	public boolean isAlive() {
		if (this.alive)
			return true;
		return false;
	}

	public String getName() {
		return this.name;
	}

	public void die() {
		this.alive = false;
	}

	// method that will get the bullets 'shot' by the ship
	public ArrayList<Bullet> getBullets() {
		return this.bullets;
	}

	// method called if spacebar is pressed
	public void shoot() {
		int y = (int) (this.y + this.height / 2);

		this.loadImage(attack);

		Bullet bullet = new Bullet(x, y);
		bullet.MCFacing = bullet.MCFacing;
		this.bullets.add(bullet);

	}

	// method called if up/down/left/right arrow key is pressed.
	public void move() {

		if (this.x > 750) {
			this.x = 750;
		}
		if (this.y > 450) {
			this.y = 450;
		}
		if (this.y < 0) {
			this.y = 0;
		}
		if (this.x < 0) {
			this.x = 0;
		}
		this.x += this.dx;
		this.y += this.dy;

	}

}
