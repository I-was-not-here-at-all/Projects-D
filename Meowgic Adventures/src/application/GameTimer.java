package application;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import Sprites.*;
import java.util.Timer;
import java.util.TimerTask;
/*
 * The GameTimer is a subclass of the AnimationTimer class. It must override the handle method. 
 */

public class GameTimer extends AnimationTimer {

	private GraphicsContext gc;
	private Scene theScene;
	private MainCharacter myShip;

	private ArrayList<Spider> fishes;
	private ArrayList<Dog> dogs;
	private ArrayList<Boss> FinalBoss;
	private ArrayList<Pierce> piercing;
	private ArrayList<Onetap> onehit;
	private ArrayList<HealthUp> heal;
	public static final int MAX_NUM_FISHES = 30;
	private Image Background;
	private AudioClip Fire;
	private AudioClip Dead;
	private static int scores;

	private static int health;
	private int second = 300;
	private int doghit = 0;
	private static boolean activatedPiercing = false;
	private static boolean activatedOnetap = false;
	public static boolean powerUpActivated = false;
	public static int piercingCount = 0;
	public static int onetapCount = 0;
	private Media media;
	private MediaPlayer mediaPlay;
	int seconds;
	private int bossHealth = 2000;

	GameTimer(GraphicsContext gc, Scene theScene) {
		// innitialization of values
		this.gc = gc;
		this.theScene = theScene;
		this.Fire = new AudioClip(new File("Music/ShootSound.mp3").toURI().toString());
		this.Dead = new AudioClip(new File("Music/die.mp3").toURI().toString());
		this.media = new Media(new File("Music/bossfight.mp3").toURI().toString());
		this.mediaPlay = new MediaPlayer(media);

		this.myShip = new MainCharacter("Going merry", 100, 100);
		this.health = 200;

		this.fishes = new ArrayList<Spider>();
		this.dogs = new ArrayList<Dog>();
		this.FinalBoss = new ArrayList<Boss>();
		this.piercing = new ArrayList<Pierce>();
		this.onehit = new ArrayList<Onetap>();
		this.heal = new ArrayList<HealthUp>();
		this.Background = new Image("images/GameBG.png");

		this.spawnFishes(7);
		this.handleKeyPressEvent();
		this.timer();
		this.AutoAttack();

	}

	@Override
	public void handle(long currentNanoTime) {
		// renders stuffs here so rendering objects is here
		this.gc.clearRect(0, 0, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT);
		this.gc.drawImage(Background, 0, 0, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT);
		// renders text

		this.myShip.move();

		// render the ship
		this.myShip.render(this.gc);

		this.renderFishes();
		this.moveFishes();
		this.renderBullets();
		this.moveBullets();
		this.CheckBulletCollision();
		this.CheckPlayerCollision();
		this.moveDogs();
		this.renderdog();
		this.renderBoss();
		GameStage.WinOrLose();
		this.renderPowerups();

	}

	// functions

	// purpose: to make enemies like it is a wave i guess enemy spawns every 30
	// second but start at minimal amount

	private void timer() {
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {

			public void run() {
				if (second > 0) {
					if (!(myShip.isAlive())) {
						GameStage.Loser = true;
						timer.cancel();
					} else {

						if (second == 270 || second == 285 || second == 250) {// 4min
							spawnFishes(10);
							spawndog(3);
						}
						if (second == 230 || second == 215 || second == 200) {// 4min
							spawnFishes(15);
						}
						if (second == 230 || second == 215 || second == 200) {// 4min
							spawnFishes(15);
							spawndog(5);
						}
						if (second == 190 || second == 175 || second == 160) {// 3min
							spawnFishes(15);
							spawndog(7);
						}
						if (second == 145 || second == 130 || second == 120) {// 3min - 2min
							spawnFishes(10);
							spawndog(8);
						}
						if (second == 100 || second == 60) {// 2min - 1min
							spawnFishes(15);
							spawndog(9);
						}
						if (second == 120) {// 2min - 1min //boss spawn here
							BossBattle();
						}
						// do while timer is active

						mediaPlay.stop();

						second--;
					}

				} else {
					// do if timer is gone
					GameStage.Winner = true;
					myShip.die();
					timer.cancel(); // Stops the timer
				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 1000);

	}

	// Powerup System

	private void Piercing() {
		Timer timer = new Timer();
		seconds = 10;
		TimerTask task = new TimerTask() {
			public void run() {
				if (seconds > 0) {
					if (!(myShip.isAlive())) {
						timer.cancel();
					} else {
						powerUpActivated = true;

						seconds--;
					}

				} else {
					// do if timer is gone

					Bullet.weapon = 0;
					seconds = 0;
					powerUpActivated = false;
					activatedPiercing = false;

					timer.cancel(); // Stops the timer
				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 1000);

	}

	private void Onetap() {
		Timer timer = new Timer();
		seconds = 10;
		TimerTask task = new TimerTask() {
			public void run() {

				if (seconds > 0) {
					seconds--;
					if (!(myShip.isAlive())) {
						timer.cancel();
					} else {
						powerUpActivated = true;
						seconds--;
					}

				} else {
					// do if timer is gone

					Bullet.weapon = 0;
					powerUpActivated = false;
					activatedOnetap = false;

					timer.cancel(); // Stops the timer
				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 1000);

	}

	private void AutoAttack() {

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			public void run() {

				if (second > 0) {
					if (!(myShip.isAlive())) {
						timer.cancel();
					}
					Fire.play();
					myShip.shoot();

				} else {
					// do if timer is gone
					timer.cancel(); // Stops the timer

				}
			}
		};

		timer.scheduleAtFixedRate(task, 0, 400);

	}

	private void BossBattle() {
		spawnBoss();
		mediaPlay.play();
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			int seconds = 4;

			public void run() {

				if (seconds > 0) {

					if (!(myShip.isAlive())) {
						timer.cancel();
					}

					if (seconds == 4) {
						Boss.boss_phase = 0;
					}
					if (seconds == 2) {
						Boss.boss_phase = 1;
						removeboss();
						spawnBoss();
					}
					seconds--;

				} else {
					// do if timer is gone
					Boss.boss_phase = 2;
					removeboss();
					spawnBoss();
					MoveBoss();
					timer.cancel(); // Stops the timer

				}
			}
		};

		timer.scheduleAtFixedRate(task, 0, 1000);

	}

	// getters
	public static int getScore() {
		return scores;
	}

	public static int getHealth() {
		return health;
	}

	private void removeboss() {
		for (int j = FinalBoss.size() - 1; j >= 0; j--) {
			Boss boss = FinalBoss.get(j);
			boss.setVisible(false);
			this.FinalBoss.remove(j);

		}

	}

	// collisions
	// do random drop
	private void CheckPlayerCollision() {

		for (int j = fishes.size() - 1; j >= 0; j--) {
			Spider spider = fishes.get(j);

			if (this.myShip.isAlive() && spider.isAlive() && this.myShip.collidesWith(spider)) {
				// Collision detected
				this.health -= 10.2;
				if (this.health < 0) {
					this.health = 0;
					myShip.die();
				}
				spider.setVisible(false);
				this.fishes.remove(j);

			}
		}
		for (int j = dogs.size() - 1; j >= 0; j--) {
			Dog dog = dogs.get(j);

			if (this.myShip.isAlive() && dog.isAlive() && this.myShip.collidesWith(dog)) {
				// Collision detected
				this.health -= 25.2;
				if (this.health < 0) {
					this.health = 0;
					myShip.die();
				}
				dog.setVisible(false);
				this.dogs.remove(j);

			}

		}
		// heal collision
		for (int j = heal.size() - 1; j >= 0; j--) {
			HealthUp Heal = heal.get(j);

			if (this.myShip.isAlive() && this.myShip.collidesWith(Heal)) {
				// Collision detected
				this.health += 25;
				if (this.health > 200) {
					this.health = 200;
				}

				Heal.setVisible(false);
				this.heal.remove(j);

			}

		}
		// pierce collision
		for (int j = piercing.size() - 1; j >= 0; j--) {
			Pierce pierce = piercing.get(j);

			if (this.myShip.isAlive() && this.myShip.collidesWith(pierce)) {
				// Collision detected
				this.piercingCount += 1;
				if (this.piercingCount > 3) {
					this.piercingCount = 3;
				}

				pierce.setVisible(false);
				this.piercing.remove(j);

			}

		}
		// onetap collision
		for (int j = onehit.size() - 1; j >= 0; j--) {
			Onetap onetap = onehit.get(j);

			if (this.myShip.isAlive() && this.myShip.collidesWith(onetap)) {
				// Collision detected
				this.onetapCount += 1;
				if (this.onetapCount > 3) {
					this.onetapCount = 3;
				}

				onetap.setVisible(false);
				this.onehit.remove(j);

			}

		}

		// boss colision
		for (int j = FinalBoss.size() - 1; j >= 0; j--) {
			Boss boss = FinalBoss.get(j);

			if (this.myShip.isAlive() && this.myShip.collidesWith(boss)) {
				// Collision detected
				// Collision detected
				this.health -= 1;
				bossHealth -= 1;
				if (this.health < 0) {
					this.health = 0;
					myShip.die();
				}
				if (bossHealth < 0) {
					boss.setVisible(false);
					this.FinalBoss.remove(j);
				}

			}

		}

	}

	private void CheckBulletCollision() {
		ArrayList<Bullet> bullets = myShip.getBullets();

		for (int i = bullets.size() - 1; i >= 0; i--) {
			Bullet bullet = bullets.get(i);

			for (int j = this.fishes.size() - 1; j >= 0; j--) {
				Spider spider = this.fishes.get(j);

				if (bullet.isVisible() && spider.isAlive() && bullet.collidesWith(spider)) {
					// Bullet Hit
					this.Dead.play();

					// checks if special powerup was in used
					if (this.activatedPiercing) {
						spider.setVisible(false);
						this.scores += 5;
						this.fishes.remove(j);
						this.spawndrop(spider.getX(), spider.getY());

					} else if (this.activatedOnetap) {
						spider.setVisible(false);
						bullet.setVisible(false);

						this.scores += 5;
						bullets.remove(i);
						this.fishes.remove(j);
						this.spawndrop(spider.getX(), spider.getY());
						break;
					} else {

						spider.setVisible(false);
						bullet.setVisible(false);

						this.scores += 5;
						bullets.remove(i);
						this.fishes.remove(j);
						this.spawndrop(spider.getX(), spider.getY());
						break;
					}

				}

			}
			for (int j = this.dogs.size() - 1; j >= 0; j--) {
				Dog dog = this.dogs.get(j);

				if (bullet.isVisible() && dog.isAlive() && bullet.collidesWith(dog)) {

					// bullet hit
					this.doghit += 3;
					// checks if special powerup was in used
					if (this.activatedPiercing) {

						if (this.doghit > 15) {
							dog.setVisible(false);
							this.scores += 15;
							this.dogs.remove(j);
							this.spawndrop(dog.getX(), dog.getY());
							this.Dead.play();
							doghit = 0;
						}

					} else if (this.activatedOnetap) {
						dog.setVisible(false);
						bullet.setVisible(false);

						this.scores += 5;
						bullets.remove(i);
						this.dogs.remove(j);
						this.spawndrop(dog.getX(), dog.getY());
						this.Dead.play();
						break;
					} else {
						bullet.setVisible(false);
						if (this.doghit > 10) {
							dog.setVisible(false);
							this.scores += 15;
							this.dogs.remove(j);
							this.spawndrop(dog.getX(), dog.getY());
							this.Dead.play();
							doghit = 0;
							break;
						}

					}

				}

			}
			// boss bullet
			for (int j = this.FinalBoss.size() - 1; j >= 0; j--) {
				Boss boss = this.FinalBoss.get(j);

				if (bullet.isVisible() && boss.isAlive() && bullet.collidesWith(boss)) {

					// bullet hit

					// checks if special powerup was in used
					if (this.activatedPiercing) {
						this.bossHealth -= 3;
						if (this.bossHealth < 0) {
							boss.setVisible(false);
							this.scores += 5000;
							this.FinalBoss.remove(j);
							this.spawndrop(boss.getX(), boss.getY());
							this.Dead.play();
							bossHealth = 2000;
						}

					} else if (this.activatedOnetap) {
						this.bossHealth -= 50;
						if (this.bossHealth < 0) {
							boss.setVisible(false);
							bullet.setVisible(false);
							this.FinalBoss.remove(j);
							this.spawndrop(boss.getX(), boss.getY());
							this.Dead.play();
							this.scores += 5000;

						}
						bullets.remove(i);
						break;

					} else {
						bullet.setVisible(false);
						this.bossHealth -= 3;
						if (this.bossHealth < 0) {
							boss.setVisible(false);
							this.scores += 5000;
							this.FinalBoss.remove(j);
							this.spawndrop(boss.getX(), boss.getY());
							this.Dead.play();

							break;
						}

					}

				}

			}

		}
	}

	// renders
	// method that will render/draw the fishes to the canvas
	private void renderFishes() {
		for (Spider f : this.fishes) {
			f.render(this.gc);
		}
	}

	// render boss
	private void renderBoss() {
		for (Boss f : this.FinalBoss) {
			f.render(this.gc);
		}
	}

	private void renderPowerups() {
		for (Pierce f : this.piercing) {
			f.render(this.gc);
		}
		for (HealthUp f : this.heal) {
			f.render(this.gc);
		}
		for (Onetap f : this.onehit) {
			f.render(this.gc);
		}

	}

	// method that will render/draw the bullets to the canvas
	private void renderBullets() {
		/*
		 * TODO: Loop through the bullets arraylist of myShip and render each bullet to
		 * the canvas
		 */

		for (Bullet bullet : this.myShip.getBullets()) {
			bullet.render(this.gc);

		}
	}

	private void renderdog() {
		for (Dog f : this.dogs) {
			f.render(this.gc);
		}
	}
	// spawns

	// method that will spawn/instantiate three fishes at a random x,y location
	// spawn mechanic
	// Spawn Spiders
	private void spawnFishes(int wave_amount) {
		Random r = new Random();
		for (int i = 0; i < GameTimer.MAX_NUM_FISHES; i++) {

			if (i <= wave_amount) {
//				int x = r.nextInt(GameStage.WINDOW_WIDTH + 200);
				int x = 750;
				int y = r.nextInt(GameStage.WINDOW_HEIGHT - 50);
				Spider spider = new Spider(x, y);
				this.fishes.add(spider);
			}

		}

	}

	// spawn boss
	private void spawnBoss() {
		Random r = new Random();
		for (int i = 0; i < 1; i++) {
			int x = 730;
			int y = 240;
			Boss boss = new Boss(x, y);
			this.FinalBoss.add(boss);
		}

	}

	private void spawndrop(int xpos, int ypos) {
		Random r = new Random();

		int drop = r.nextInt(100);
		if (drop > 50 && drop < 65) { // drops health
			HealthUp healths = new HealthUp(xpos, ypos);
			this.heal.add(healths);
		} else if (drop > 30 && drop < 45) { // drops piercing
			Pierce pierce = new Pierce(xpos, ypos);
			this.piercing.add(pierce);
		} else if (drop > 10 && drop < 15) { // drops one tap
			Onetap onehit = new Onetap(xpos, ypos);
			this.onehit.add(onehit);
		}

	}

	// Spawndogs
	private void spawndog(int wave_amount) {
		Random r = new Random();
		for (int i = 0; i < GameTimer.MAX_NUM_FISHES; i++) {

			if (i <= wave_amount) {
				int x = 750;
				int y = r.nextInt(GameStage.WINDOW_HEIGHT - 50);
				Dog dog = new Dog(x, y);
				this.dogs.add(dog);
			}

		}

	}

	// move

	private void BossAttack() {
		// Loop through the fishes arraylist
		for (int i = 0; i < this.FinalBoss.size(); i++) {
			Boss f = this.FinalBoss.get(i);
			if (f.isAlive()) {

				f.move(this.myShip.getX(), this.myShip.getY());
			} else {
				this.dogs.remove(i);
			}

		}
	}

	private void MoveBoss() {

		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			public void run() {

				if (Boss.isAlive()) {
					if (!(myShip.isAlive())) {
						timer.cancel();
					}
					BossAttack();

				} else {
					// do if timer is gone
					mediaPlay.stop();
					timer.cancel(); // Stops the timer

				}
			}
		};

		timer.scheduleAtFixedRate(task, 0, 10);

	}

	private void moveDogs() {
		// Loop through the fishes arraylist
		for (int i = 0; i < this.dogs.size(); i++) {
			Dog f = this.dogs.get(i);
			if (f.isAlive()) {
				f.move();
			} else {
				this.dogs.remove(i);
			}

		}
	}

	// method that will move the bullets shot by a ship
	private void moveBullets() {
		// create a local arraylist of Bullets for the bullets 'shot' by the ship
		ArrayList<Bullet> bList = this.myShip.getBullets();

		// Loop through the bullet list and check whether a bullet is still visible.
		for (int i = 0; i < bList.size(); i++) {
			Bullet b = bList.get(i);

			if (b.isVisible()) {
				b.move();

			} else {
				bList.remove(i);
			}

		}
	}

	// method that will move the fishes
	private void moveFishes() {
		// Loop through the fishes arraylist
		for (int i = 0; i < this.fishes.size(); i++) {
			Spider f = this.fishes.get(i);
			if (f.isAlive()) {
				f.move();
			} else {
				this.fishes.remove(i);
			}

		}
	}

	// key events
	// method that will listen and handle the key press events
	private void handleKeyPressEvent() {
		this.theScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				KeyCode code = e.getCode();
				moveMyShip(code);
			}
		});

		this.theScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent e) {
				KeyCode code = e.getCode();
				stopMyShip(code);
			}
		});
	}

	// method that will move the ship depending on the key pressed

	private void moveMyShip(KeyCode ke) {
		if (ke == KeyCode.W) {
			this.myShip.setDY(-5);
			this.myShip.Walk_Image();
		}

		if (ke == KeyCode.A) {

			this.myShip.setDX(-5);
			this.myShip.Walk_Image();
		}

		if (ke == KeyCode.S) {

			this.myShip.setDY(5);
			this.myShip.Walk_Image();
		}

		if (ke == KeyCode.D) {

			this.myShip.setDX(5);
			this.myShip.Walk_Image();
		}
		// mark for destruction
//		if(ke==KeyCode.SPACE) { 
//			this.myShip.shoot();
//			
//			}	
		if (ke == KeyCode.Q) {
			if (!(powerUpActivated)) {
				if (piercingCount > 0) {
					Bullet.weapon = 1;
					activatedPiercing = true;
					piercingCount--;
					Piercing();
				}

			}

		}
		if (ke == KeyCode.E) {

			if (!(powerUpActivated)) {
				if (onetapCount > 0) {
					Bullet.weapon = 2;
					activatedOnetap = true;
					onetapCount--;
					Onetap();
				}

			}

		}
		if (ke == KeyCode.LEFT) {
			Bullet.MCFacing = 1;

		}
		if (ke == KeyCode.RIGHT) {

			Bullet.MCFacing = 0;

		}
		if (ke == KeyCode.ESCAPE) {
			GameStage.Quit = true;
			myShip.die();
		}

//		System.out.println(ke+" key pressed.");
	}

	// method that will stop the ship's movement; set the ship's DX and DY to 0
	private void stopMyShip(KeyCode ke) {
		this.myShip.setDX(0);
		this.myShip.setDY(0);
	}

}
