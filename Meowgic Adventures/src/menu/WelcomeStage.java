package menu;

import application.GameStage;
import javafx.application.Platform;
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

public class WelcomeStage {
	public static final int WINDOW_HEIGHT = 500;
	public static final int WINDOW_WIDTH = 800;
	private Scene scene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private Image Icon;
	private Image Background;
	private ImageView TitleofGame;
	private Button BtnStart;
	private Button BtnAbout;
	private Button BtnInstructions;
	private Button BtnExit;
	private ImageView MC;
	private String CSS;
	private Media media;
	private MediaPlayer mediaPlay;
	private AudioClip hover;
	private AudioClip click;

	// the class constructor

	public WelcomeStage() {
		this.root = new Group();
		this.scene = new Scene(root, WelcomeStage.WINDOW_WIDTH, WelcomeStage.WINDOW_HEIGHT, Color.BLACK);
		this.Icon = new Image("images/MewgicIcon.png");
		this.Background = new Image("images/MainBG.png");
		this.MC = new ImageView("images/Title Screen (char).png");
		this.TitleofGame = new ImageView("images/Title Screen (text).png");
		this.BtnStart = new Button("Play");
		this.BtnAbout = new Button("About");
		this.BtnInstructions = new Button("Instructions");
		this.BtnExit = new Button("Exit");
		this.CSS = this.getClass().getResource("../Css/application.css").toExternalForm();
		this.canvas = new Canvas(WelcomeStage.WINDOW_WIDTH, WelcomeStage.WINDOW_HEIGHT);
		this.gc = canvas.getGraphicsContext2D();
		this.click = new AudioClip(new File("Music/Pick.mp3").toURI().toString());
		this.hover = new AudioClip(new File("Music/Hover.mp3").toURI().toString());
		this.media = new Media(new File("Music/HomeBGM.mp3").toURI().toString());
		this.mediaPlay = new MediaPlayer(media);
		// instantiate an animation timer

	}

	public void DisplayHome() {
		this.root.getChildren().add(MC);
		this.root.getChildren().add(TitleofGame); // what the hell get children??? rikko call the police
		this.root.getChildren().add(BtnStart);
		this.root.getChildren().add(BtnAbout);
		this.root.getChildren().add(BtnInstructions);
		this.root.getChildren().add(BtnExit);

		// Window
		this.stage.setTitle("Meowmic Adventures");
		this.gc.drawImage(Background, 0, 0, canvas.getWidth(), canvas.getHeight());
		this.stage.getIcons().add(Icon);

		// Start Button
		this.BtnStart.setLayoutX(500);
		this.BtnStart.setLayoutY(240);

		// About Button
		this.BtnAbout.setLayoutX(500);
		this.BtnAbout.setLayoutY(310);

		// Instruction Button
		this.BtnInstructions.setLayoutX(500);
		this.BtnInstructions.setLayoutY(380);

		// Exit Button
		this.BtnExit.setLayoutX(20);
		this.BtnExit.setLayoutY(430);

		// MC
		this.MC.setFitHeight(500);
		this.MC.setFitWidth(500);
		this.MC.setY(0);
		this.MC.setX(0);

		// Title
		this.TitleofGame.setFitHeight(250);
		this.TitleofGame.setFitWidth(350);
		this.TitleofGame.setY(10);
		this.TitleofGame.setX(450);

		// Set the css for other class

	}

	public void RemoveHome() {

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
		this.BtnInstructions.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				click.play();
				Instructions NewWindow = new Instructions();
				NewWindow.setStage(new Stage());
				mediaPlay.stop();
				stage.close();
			}
		});

		this.BtnAbout.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				click.play();
				About NewWindow = new About();
				NewWindow.setStage(new Stage());
				mediaPlay.stop();
				stage.close();
			}
		});

		this.BtnExit.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				click.play();
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

		this.BtnInstructions.setOnMouseEntered(new EventHandler<MouseEvent>() {
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

		this.BtnExit.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				hover.play();
			}
		});

		mediaPlay.setCycleCount(MediaPlayer.INDEFINITE);
		mediaPlay.setVolume(0.1);
		mediaPlay.play();
		this.stage.setScene(this.scene);

		this.stage.show();

	}

}
