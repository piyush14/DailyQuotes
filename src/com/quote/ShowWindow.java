package com.quote;

import java.io.IOException;

import org.json.JSONException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.HBoxBuilder;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ShowWindow extends Application {
	@Override
	public void start(Stage stage) {
		FlowPane flowPane = new FlowPane();
		Text quoteText = new Text();
		Text authorNameText = new Text();
		Button refreshButton = new Button("Refresh");

		
		
//		Image image = new Image("https://source.unsplash.com/random/600x300");

//		VBox vbox = new VBox();
//		vbox.setPrefSize(400, 400);
//		vbox.setLayoutX(150);
//		vbox.setLayoutY(50);
//		vbox.setPadding(new Insets(30));
//		vbox.setSpacing(25);
//		vbox.setBackground(new Background(new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT,
//				BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
//		vbox.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, null, new BorderWidths(3))));

		
		
		
		quoteText.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
		quoteText.setText(MainClass.getQuote());

		authorNameText.setFont(Font.font("verdana", FontWeight.SEMI_BOLD, FontPosture.REGULAR, 15));
		authorNameText.setText("\t - " + MainClass.getAuthor());

		quoteText.setX(50);
		quoteText.setY(50);

		authorNameText.setX(50);
		authorNameText.setY(180);

		Image imageDecline = new Image(getClass().getResourceAsStream("refresh-icon-16-182094.png"));
		refreshButton.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 10));
		refreshButton.setLayoutX(250);
		refreshButton.setLayoutY(250);
		// refreshButton.setAlignment(Pos.CENTER);
		refreshButton.setGraphic(new ImageView(imageDecline));

		Group root = new Group(quoteText, authorNameText, refreshButton);

		Scene scene = new Scene(root, 600, 300);

		stage.setTitle("Quote");

		stage.setScene(scene);
		stage.setResizable(false);
		stage.getIcons()
				.add(new Image("https://static.wixstatic.com/media/6318fc_2d82cd4f2c3f445e8ac27973ee1b37dd.png_256"));
		stage.show();

		
//		vbox.getChildren().add(quoteText);
//		vbox.getChildren().add(authorNameText);
//		root.getChildren().add(vbox);
//		stage.setScene(scene);
//        stage.show();
		
		refreshButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
			public void handle(MouseEvent event) {
				try {
					String jsonData = MainClass.GETData(MainClass.GET_URL);
					MainClass.ExtractJSONData(jsonData);
					quoteText.setText(MainClass.getQuote());
					authorNameText.setText("\t - " + MainClass.getAuthor());
				} catch (IOException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}));

	}

	public static void myinit() {
		launch();
	}
}
