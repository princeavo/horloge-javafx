package com;

import java.time.LocalDateTime;
import java.util.Calendar;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Horloge extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Label hourLabel = new Label("Heure");
		Label hourText = new Label("00");
		hourLabel.setGraphic(hourText);
		hourLabel.setContentDisplay(ContentDisplay.BOTTOM);
		
		Label minLabel = new Label("Minutes");
		Label minText = new Label("00");
		minLabel.setGraphic(minText);
		minLabel.setContentDisplay(ContentDisplay.BOTTOM);
		
		Label secLabel = new Label("Secondes");
		Label secText = new Label("00");
		secLabel.setGraphic(secText);
		secLabel.setContentDisplay(ContentDisplay.BOTTOM);
		
		HBox hbox = new HBox(30);
		hbox.getChildren().addAll(hourLabel,minLabel,secLabel);
		hbox.setAlignment(Pos.CENTER);
		hbox.setPadding(new Insets(30));
		hbox.setBackground(new Background(new BackgroundFill(Color.GREEN, null, null)));
		
		VBox root = new VBox(hbox);
		root.setAlignment(Pos.CENTER);
		root.setBackground(new Background(new BackgroundFill(Color.YELLOW, null, null)));
		root.setPadding(new Insets(40));
		
		Timeline timeLine = new Timeline(new KeyFrame(Duration.seconds(1), e->{
			LocalDateTime date = LocalDateTime.now();
			secText.setText(date.getSecond()+" ");
			minText.setText(date.getMinute()+" ");
			hourText.setText(date.getHour()+" ");
		}));
		timeLine.setCycleCount(Animation.INDEFINITE);
		timeLine.play();
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("style.css").toString());
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
