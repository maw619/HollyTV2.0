package com.wolff.app;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class App extends Application{

	 public void start(Stage stage) throws IOException {
	        Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("channels.fxml"));
	        Scene scene = new Scene(root);
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.show();
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }

}
