package application;

import java.util.Timer;
import java.util.TimerTask;
import menu.*;
import Sprites.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import menu.About;

public class GameStage {
	public static final int WINDOW_HEIGHT = 500;
	public static final int WINDOW_WIDTH = 800;
	private Scene scene;
	private static Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private static GameTimer gametimer;
	private Image Icon;
	private Text Timer;
	private Text Score;
	private Text PierceCount;
	private Text OnehitCount;
	private int second = 300 + 1;
	private Rectangle Healthbar;
	private ImageView MCIcon;
	private ImageView PierceIcon;
	private ImageView OnehitIcon;
	public static Image OnehitInActive = new Image("/images/onehit-icon-inactive.png");
	public static Image OneHit = new Image("/images/onehit-icon-active.png");
	public static Image Pierce = new Image("/images/piercing-icon-active.png");
	public static Image PierceInActive = new Image("/images/piercing-icon-inactive.png");
	public static boolean Winner = false;
	public static boolean Loser = false;
	public static boolean Quit = false;

	// the class constructor
	public GameStage() {
		this.root = new Group();

		this.scene = new Scene(root, GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT);
		this.canvas = new Canvas(GameStage.WINDOW_WIDTH, GameStage.WINDOW_HEIGHT);

		this.Icon = new Image("images/MewgicIcon.png");
		this.gc = canvas.getGraphicsContext2D();
		this.Timer = new Text("");
		this.Score = new Text("");
		this.PierceCount = new Text("");
		this.OnehitCount = new Text("");
		this.MCIcon = new ImageView("images/mc-icon.png");
		this.Healthbar = new Rectangle();
		this.PierceIcon = new ImageView(Pierce);
		this.OnehitIcon = new ImageView(OneHit);
		// instantiate an animation timer
		this.gametimer = new GameTimer(this.gc, this.scene);
	}

	// method to add the stage elements
	public void setStage(Stage stage) {
		this.stage = stage;
		this.stage.getIcons().add(Icon);
		// set stage elements here

		this.root.getChildren().add(canvas);
		this.root.getChildren().add(Timer);
		this.root.getChildren().add(Score);
		this.root.getChildren().add(MCIcon);
		this.root.getChildren().add(Healthbar);
		this.root.getChildren().add(PierceCount);
		this.root.getChildren().add(OnehitCount);
		this.root.getChildren().add(PierceIcon);
		this.root.getChildren().add(OnehitIcon);

		// icons

		// pierce amount
		this.PierceCount.setFont(Font.font("Verdana", 15));
		this.PierceCount.setY(50);
		this.PierceCount.setX(95);

		// Onehit Amount
		this.OnehitCount.setFont(Font.font("Verdana", 15));
		this.OnehitCount.setY(50);
		this.OnehitCount.setX(155);

		// powerup-pierce
		this.PierceIcon.setFitWidth(30);
		this.PierceIcon.setFitHeight(30);
		this.PierceIcon.setY(30);
		this.PierceIcon.setX(60);

		// onehit-powerup
		this.OnehitIcon.setFitWidth(30);
		this.OnehitIcon.setFitHeight(30);
		this.OnehitIcon.setY(30);
		this.OnehitIcon.setX(120);

		// mc
		this.MCIcon.setX(5);
		this.MCIcon.setY(5);
		this.MCIcon.setFitWidth(50);
		this.MCIcon.setFitHeight(50);

		this.Healthbar.setY(20);
		this.Healthbar.setX(60);

		this.Timer.setFont(Font.font("Verdana", 25));
		this.Timer.setY(30);
		this.Timer.setX(350);

		this.Score.setFont(Font.font("Verdana", 25));
		this.Score.setY(30);
		this.Score.setX(600);

		timer();
		Update();
		this.stage.setTitle("Meowmic Adventures");
		this.stage.setScene(this.scene);

		// invoke the start method of the animation timer
		this.gametimer.start();

		this.stage.show();
	}

	private void SetTimer(String value) {
		this.Timer.setText(value);
	}

	private void setScore() {
		this.Score.setText("Score: " + GameTimer.getScore());
	}

	private void setHealth() {

		if (GameTimer.getHealth() < 70) {
			this.Healthbar.setFill(Color.RED);
		} else if (GameTimer.getHealth() < 150) {
			this.Healthbar.setFill(Color.YELLOW);
		} else {
			this.Healthbar.setFill(Color.GREENYELLOW);
		}

		this.Healthbar.setWidth(GameTimer.getHealth());
		this.Healthbar.setHeight(10);
	}

	public static void WinOrLose() {

		if (Quit) {
			WelcomeStage NewWindow = new WelcomeStage();
			NewWindow.setStage(new Stage());
			gametimer.stop();
			GameTimer.onetapCount = 0;
			GameTimer.piercingCount = 0;
			Quit = false;
			Winner = false;
			Loser = false;
			stage.close();
		} else if (Winner) {
			Winner NewWindow = new Winner();
			NewWindow.setStage(new Stage());
			gametimer.stop();
			GameTimer.onetapCount = 0;
			GameTimer.piercingCount = 0;
			Quit = false;
			Winner = false;
			Loser = false;
			stage.close();
		} else if (Loser) { // do win like this
			Loser NewWindow = new Loser();
			NewWindow.setStage(new Stage());
			gametimer.stop();
			GameTimer.onetapCount = 0;
			GameTimer.piercingCount = 0;
			Quit = false;
			Loser = false;
			stage.close();
		}
	}

	private void SetPowerUp() {

		this.PierceCount.setText("X" + GameTimer.piercingCount);
		this.OnehitCount.setText("X" + GameTimer.onetapCount);
		if (GameTimer.powerUpActivated) {
			this.PierceIcon.setImage(PierceInActive);
			this.OnehitIcon.setImage(OnehitInActive);
		} else {
			this.PierceIcon.setImage(Pierce);
			this.OnehitIcon.setImage(OneHit);
		}
	}

	private void timer() {
		Timer timer = new Timer();

		TimerTask task = new TimerTask() {
			int seconds = 60; // for 1 minutes hehehe

			public void run() {
				setScore();
				if (second > 0) {
					// do while timer is active
					if (seconds == -1) {
						seconds = 59;
					}
					if (second == 301) { // 5
						SetTimer("5:00");
					} else if (second >= 241) { // 4
						if (second < 251) {
							SetTimer("4:0" + seconds);
						} else {
							SetTimer("4:" + seconds);
						}
					} else if (second >= 181) { // 3
						if (second < 191) {
							SetTimer("3:0" + seconds);
						} else {
							SetTimer("3:" + seconds);
						}
					} else if (second >= 121) { // 2
						if (second < 131) {
							SetTimer("2:0" + seconds);
						} else {
							SetTimer("2:" + seconds);
						}
					} else if (second >= 61) { // 1
						if (second < 71) {
							SetTimer("1:0" + seconds);
						} else {
							SetTimer("1:" + seconds);
						}
					} else {
						if (second < 11) {
							SetTimer("0:0" + seconds);
						} else {
							SetTimer("0:" + seconds);
						}
					}
					seconds--;
					second--;

				} else {
					timer.cancel();
				}
			}
		};
		timer.scheduleAtFixedRate(task, 0, 1000);

	}

	private void Update() {
		Timer update = new Timer();

		TimerTask updatetask = new TimerTask() {

			public void run() {
				if (second > 0) {
					setHealth();
					setScore();
					SetPowerUp();

				} else {

					update.cancel();
				}
			}
		};
		update.scheduleAtFixedRate(updatetask, 0, 1);

	}

}
