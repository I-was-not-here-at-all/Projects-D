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
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;

import application.*;

public class About {
	public static final int WINDOW_HEIGHT = 500;
	public static final int WINDOW_WIDTH = 800;
	private Scene scene;
	private Stage stage;
	private Group root;
	private Canvas canvas;
	private GraphicsContext gc;
	private Button BtnBack;
	private StackPane stack;

	private Image Background;
	private Image Icon;
	private String CSS;
	private Button BtnLore;
	private Button BtnMembers;
	private Button BtnExplanation;
	public String Tab = "About_Home";
	// bg
	private Rectangle LoreBG;
	private Rectangle MembersBG;
	private Rectangle ExplanationBG;

	private Text Lore;
	private Text Members;
	private Text Explanation;
	private Text Title;
	private AudioClip hover;
	private AudioClip click;

	// the class constructor

	public About() {
		this.root = new Group();
		this.scene = new Scene(root, About.WINDOW_WIDTH, About.WINDOW_HEIGHT, Color.BLACK);
		this.BtnBack = new Button("Back");
		this.Background = new Image("images/MainBG.png");
		this.Icon = new Image("images/MewgicIcon.png");
		this.BtnLore = new Button("Lore");
		this.BtnMembers = new Button("Members");
		this.BtnExplanation = new Button("Explanation");
		this.canvas = new Canvas(About.WINDOW_WIDTH, About.WINDOW_HEIGHT);
		this.CSS = this.getClass().getResource("../Css/application.css").toExternalForm();
		this.gc = canvas.getGraphicsContext2D();
		this.click = new AudioClip(new File("Music/Pick.mp3").toURI().toString());
		this.hover = new AudioClip(new File("Music/Hover.mp3").toURI().toString());

		// lore
		this.LoreBG = new Rectangle(600, 400);
		this.Lore = new Text(
				"Cici is a cute little black witch cat. She was raised by a loving family.\ncici is naturally a curious cat,\nas she grew older, the curiosity only burned brighter.\ncici wanted to explore the world beyond of what she knew at home,\nso she set on a lone journey with her family's support.\nalong the way, she encountered a lot of challenges,\nwill she successfully reach the end of her journey?");
		// members
		this.MembersBG = new Rectangle(600, 400);
		this.Members = new Text(
				"Game Developer:\nMark Ronnel Salazar\n\nUI and Design:            Sprites:\nLian Clhoe Cocosa      Ariam Andrei Santos\nAngelica Villarico\nLeonell Albelda\n\nBGM/SFX:\nKyle Adrian Limjoco");
		// explanation
		this.ExplanationBG = new Rectangle(600, 400);
		this.Explanation = new Text(
				"Meowgic Adventures is a top-down styled \nshooteresque game developed by Group 3. \nPlayers control a cat-like character named \n\"Cici\" as she fights with monsters \nto progress through the forest \nand continue on with her adventure.");
		// instantiate an animation timer

	}

	public void DisplayLore() {
		this.Title = new Text("Lore");
		this.stack = new StackPane(LoreBG, Title, Lore);

		this.stack.setLayoutY(20);
		this.stack.setLayoutX(100);
		this.LoreBG.setFill(Color.web("#9558c6"));
		this.LoreBG.setArcWidth(30.0);
		this.LoreBG.setArcHeight(30.0);
		this.Lore.setTranslateY(15);
		this.Lore.setFont(Font.font("Garamond", FontWeight.BOLD, 20));
		this.Lore.setStyle("-fx-alignment: BASELINE_Center;-fx-fill: white;");
		this.Title.setTranslateY(-150);
		this.Title.setFont(Font.font("Garamond", FontWeight.BOLD, FontPosture.ITALIC, 46));
		this.Title.setStyle("-fx-alignment: BASELINE_Center;-fx-fill: white;");

		this.root.getChildren().add(stack);

		// styling

	}

	public void DisplayMembers() {
		this.Title = new Text("Members:");
		this.stack = new StackPane(MembersBG, Title, Members);
		// Styling

		this.root.getChildren().add(stack);
		this.stack.setLayoutY(20);
		this.stack.setLayoutX(100);
		this.MembersBG.setFill(Color.web("#9558c6"));
		this.MembersBG.setArcWidth(30.0);
		this.MembersBG.setArcHeight(30.0);
		this.Members.setTranslateY(15);
		this.Members.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
		this.Members.setStyle("-fx-alignment: BASELINE_Center;-fx-fill: white;");
		this.Title.setTranslateY(-150);
		this.Title.setFont(Font.font("Garamond", FontWeight.BOLD, FontPosture.ITALIC, 20));
		this.Title.setStyle("-fx-alignment: BASELINE_Center;-fx-fill: white;");

	}

	public void DisplayExplanation() {
		this.Title = new Text("Game Explanation");
		this.stack = new StackPane(ExplanationBG, Title, Explanation);
		this.root.getChildren().add(stack);

		this.stack.setLayoutY(20);
		this.stack.setLayoutX(100);
		this.ExplanationBG.setFill(Color.web("#9558c6"));
		this.ExplanationBG.setArcWidth(30.0);
		this.ExplanationBG.setArcHeight(30.0);
		this.Explanation.setTranslateY(15);
		this.Explanation.setFont(Font.font("Garamond", FontWeight.BOLD, 30));
		this.Explanation.setStyle("-fx-alignment: BASELINE_Center;-fx-fill: white;");
		this.Title.setTranslateY(-150);
		this.Title.setFont(Font.font("Garamond", FontWeight.BOLD, FontPosture.ITALIC, 46));
		this.Title.setStyle("-fx-alignment: BASELINE_Center;-fx-fill: white;");
	}

	public void DisplayContent() {

		this.root.getChildren().add(BtnLore);
		this.root.getChildren().add(BtnMembers);
		this.root.getChildren().add(BtnExplanation);

		// Window
		this.gc.drawImage(Background, 0, 0, canvas.getWidth(), canvas.getHeight());
		this.stage.setTitle("Meowmic Adventures");
		this.stage.getIcons().add(Icon);

		// Lore
		this.BtnLore.setLayoutX(300);
		this.BtnLore.setLayoutY(110);

		// About Button
		this.BtnMembers.setLayoutX(300);
		this.BtnMembers.setLayoutY(180);

		// Instruction Button
		this.BtnExplanation.setLayoutX(300);
		this.BtnExplanation.setLayoutY(250);

		this.BtnBack.setLayoutX(300);
		this.BtnBack.setLayoutY(320);
	}

	public void RemoveAbout() {
		this.root.getChildren().remove(BtnLore);
		this.root.getChildren().remove(BtnMembers);
		this.root.getChildren().remove(BtnExplanation);

	}

	public void RemoveContent() {
		this.root.getChildren().remove(stack);
	}

	// method to add the stage elements
	public void setStage(Stage stage) {

		this.root.getChildren().add(canvas); // what the hell get children???? rikko call the police
		this.scene.getStylesheets().add(CSS);
		this.root.getChildren().add(BtnBack);
		this.stage = stage;

		// set stage elements here
		DisplayContent();

		// Event handlers
		this.BtnLore.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				hover.play();

			}
		});
		this.BtnMembers.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				hover.play();

			}
		});
		this.BtnExplanation.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				hover.play();

			}
		});
		this.BtnBack.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				hover.play();

			}
		});

		this.BtnLore.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				RemoveAbout();
				DisplayLore();
				BtnBack.setLayoutX(20);
				BtnBack.setLayoutY(430);
				click.play();
				Tab = "About_Lore";

			}
		});
		this.BtnMembers.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				RemoveAbout();
				DisplayMembers();
				BtnBack.setLayoutX(20);
				BtnBack.setLayoutY(430);
				click.play();
				Tab = "About_Members";

			}
		});
		this.BtnExplanation.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				RemoveAbout();
				DisplayExplanation();
				BtnBack.setLayoutX(20);
				BtnBack.setLayoutY(430);
				click.play();
				Tab = "About_Explanation";

			}
		});

		this.BtnBack.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				click.play();
				if (Tab == "About_Home") {
					WelcomeStage NewWindow = new WelcomeStage();
					NewWindow.setStage(new Stage());
					stage.close();
				} else if (Tab == "About_Lore") {
					RemoveContent();
					DisplayContent();
					BtnBack.setLayoutX(300);
					BtnBack.setLayoutY(320);
					Tab = "About_Home";

				} else if (Tab == "About_Members") {
					RemoveContent();
					DisplayContent();
					BtnBack.setLayoutX(300);
					BtnBack.setLayoutY(320);
					Tab = "About_Home";

				} else if (Tab == "About_Explanation") {
					RemoveContent();
					DisplayContent();
					BtnBack.setLayoutX(300);
					BtnBack.setLayoutY(320);
					Tab = "About_Home";

				}

//				WelcomeStage NewWindow = new WelcomeStage();
//				NewWindow.setStage(new Stage());
//				stage.close();
			}
		});

		this.stage.setScene(this.scene);
		this.stage.show();
	}

}
