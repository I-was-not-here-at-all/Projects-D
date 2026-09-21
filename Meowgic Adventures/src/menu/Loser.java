package menu;

import application.GameStage;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.media.AudioClip;
import java.net.URL;

public class Loser {
	public static final int WINDOW_HEIGHT = 500;
	public static final int WINDOW_WIDTH = 800;
	private Scene scene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private Image Icon;
	private Image Background;
	private Button BtnStart;
	private Button BtnAbout;

	private String CSS;
	private Media media;
	private MediaPlayer mediaPlay;
	private AudioClip hover;
	private AudioClip click;

	// the class constructor

	public Loser() {
		this.root = new Group();
		this.scene = new Scene(root, Loser.WINDOW_WIDTH, Loser.WINDOW_HEIGHT, Color.BLACK);
		this.Icon = new Image("images/MewgicIcon.png");
		this.Background = new Image("images/LostBG.png");
		this.BtnStart = new Button("Restart");
		this.BtnAbout = new Button("Menu");
		this.CSS = this.getClass().getResource("../Css/application.css").toExternalForm();
		this.canvas = new Canvas(Loser.WINDOW_WIDTH, Loser.WINDOW_HEIGHT);
		this.gc = canvas.getGraphicsContext2D();
		this.click = new AudioClip(new File("Music/Pick.mp3").toURI().toString());
		this.hover = new AudioClip(new File("Music/Hover.mp3").toURI().toString());
		this.media = new Media(new File("Music/LostAudio.wav").toURI().toString());
		this.mediaPlay = new MediaPlayer(media);
		// instantiate an animation timer

	}

	public void DisplayHome() {
		this.root.getChildren().add(BtnStart);
		this.root.getChildren().add(BtnAbout);

		// Window
		this.stage.setTitle("Meowmic Adventures");
		this.gc.drawImage(Background, 0, 0, canvas.getWidth(), canvas.getHeight());
		this.stage.getIcons().add(Icon);

		// Start Button
		this.BtnStart.setLayoutX(300);
		this.BtnStart.setLayoutY(200);

		// About Button
		this.BtnAbout.setLayoutX(300);
		this.BtnAbout.setLayoutY(270);

	}

	// method to add the stage elements
	public void setStage(Stage stage) {

		this.root.getChildren().add(canvas); // what the hell get children???? rikko call the police
		this.scene.getStylesheets().add(CSS);
		this.stage = stage;

		// set stage elements here
		DisplayHome();

		// Event handlers

		// click
		this.BtnStart.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				click.play();
				GameStage NewWindow = new GameStage();
				NewWindow.setStage(new Stage());
				mediaPlay.stop();
				stage.close();
			}
		});

		this.BtnAbout.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				click.play();
				WelcomeStage NewWindow = new WelcomeStage();
				NewWindow.setStage(new Stage());
				mediaPlay.stop();
				stage.close();
			}
		});

		// hover
		this.BtnStart.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				hover.play();
			}
		});

		this.BtnAbout.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				hover.play();
			}
		});

		mediaPlay.setVolume(0.5);
		mediaPlay.play();
		this.stage.setScene(this.scene);

		this.stage.show();

	}

}
