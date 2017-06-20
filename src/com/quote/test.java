package com.quote;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class test extends Application {
    
    public static void main(String[] args) {
        
        Application.launch(args);
    }
    
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("VBox");
        
        Group root = new Group();
        Scene scene = new Scene(root, 700, 500, Color.GREY);
        
        Image image = new Image ("https://source.unsplash.com/random/600x300");
        
        VBox vbox = new VBox();
        vbox.setPrefSize(400,400);
        vbox.setLayoutX(150);
        vbox.setLayoutY(50);
        vbox.setPadding(new Insets(30));
        vbox.setSpacing(25);
        vbox.setBackground(new Background(new BackgroundImage(image,BackgroundRepeat.REPEAT,
                                                                  BackgroundRepeat.REPEAT,
                                                                  BackgroundPosition.DEFAULT,
                                                                  BackgroundSize.DEFAULT)));
        vbox.setBorder(new Border(new BorderStroke(Color.WHITE,BorderStrokeStyle.SOLID,
                                                             null,new BorderWidths(3))));
        Button btn[] = new Button[4];
        for(int i=0;i<4;i++) 
        {
            btn[i]=new Button("Button "+i);
        }
  
        vbox.getChildren().addAll(btn);
        root.getChildren().add(vbox);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}