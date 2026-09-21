package menu;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import application.*;

public class Instructions {
	public static final int WINDOW_HEIGHT = 500;
	public static final int WINDOW_WIDTH = 800;
	private Scene scene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private Button BtnBack;
	private Image Background;
	private Image Icon;
	private String CSS;

	// the class constructor

	public Instructions() {
		this.root = new Group();
		this.scene = new Scene(root, Instructions.WINDOW_WIDTH, Instructions.WINDOW_HEIGHT, Color.BLACK);
		this.BtnBack = new Button("Back");
		this.Background = new Image("images/Instructions.png");
		this.Icon = new Image("images/MewgicIcon.png");

		this.CSS = this.getClass().getResource("../Css/application.css").toExternalForm();
		this.canvas = new Canvas(Instructions.WINDOW_WIDTH, Instructions.WINDOW_HEIGHT);
		this.gc = canvas.getGraphicsContext2D();

		// instantiate an animation timer

	}

	public void DisplayContent() {

		this.root.getChildren().add(BtnBack);

		// Window
		this.gc.drawImage(Background, 0, 0, canvas.getWidth(), canvas.getHeight());
		this.stage.setTitle("Meowmic Adventures");
		this.stage.getIcons().add(Icon);

		// Game Title

		this.BtnBack.setFont(Font.font("Garamond", FontWeight.BOLD, FontPosture.ITALIC, 25));
		this.BtnBack.setTextFill(Color.WHITE);
		this.BtnBack.setPrefWidth(250);
		this.BtnBack.setPrefHeight(40);
		this.BtnBack.setLayoutX(20);
		this.BtnBack.setLayoutY(430);

		// Start Button

		// About Button

		// Instruction Button

		// Exit Button

		// MC

	}

	public void RemoveHome() {

	}

	// method to add the stage elements
	public void setStage(Stage stage) {

		this.root.getChildren().add(canvas); // what the hell get children???? rikko call the police
		this.scene.getStylesheets().add(CSS);
		this.stage = stage;

		// set stage elements here
		DisplayContent();
		// Event handlers

		this.BtnBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				WelcomeStage NewWindow = new WelcomeStage();
				NewWindow.setStage(new Stage());
				stage.close();
			}
		});

		this.stage.setScene(this.scene);
		this.stage.show();
	}

}
