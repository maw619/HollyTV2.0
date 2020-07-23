//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.wolff.controller;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

import com.wolff.app.App;
import com.wolff.dao.Conexion;
import com.wolff.dao.Dbhelper;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TVController extends Conexion implements Initializable {
   
    @FXML
    private Button channel;
    
    @FXML
    private Label lblCount;
    
    @FXML
    private ImageView imageView;
    
    @FXML
    private TextField txtUrl;
    
    private Dbhelper db;
    
    private int id;
    
    public void initialize(URL url, ResourceBundle rb) {
    	
    	

    	
    	
    	
    	this.getConn();
    	String sql= "SELECT COUNT(*) FROM tvlist";
    	try {
    		PreparedStatement ps = this.conn.prepareStatement(sql);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			lblCount.setText(String.valueOf(rs.getInt(1)));
    			System.out.println(lblCount.getText());
    		}
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    }
    
    @FXML
    public void update() throws IOException {

    	txtUrl.setText(db.updateUrl(txtUrl.getText(), id));
    	
    	Platform.runLater( () -> {
			try {
				new App().start( new Stage() );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} );
    	
    	//// calling stage again after it closes using Platform.runLater since I don't know how to refresh
    	Stage stage = new Stage();;
    	Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("channels.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @FXML
    public void getChannel(ActionEvent event) {
    	
    	db= new Dbhelper();
    	
    	this.getConn();
    	String sql = "select * from tvlist where channel = ?";
    	
    	channel = (Button) event.getSource();
    	
    	
    	
    	try {
    		
    		
    		
    		channel = (Button) event.getSource();

    		
    		PreparedStatement ps = this.conn.prepareStatement(sql);
    		ps.setString(1, channel.getText());
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			 this.channel.setOnAction(new EventHandler<ActionEvent>() {
    		            public void handle(ActionEvent e) {
    		                try {
    		                    Desktop.getDesktop().browse(new URI(rs.getString("url")));
    		                    txtUrl.setText(rs.getString("url"));
    		                    id = rs.getInt(1);
    		                } catch (Exception var3) {
    		                    var3.printStackTrace();
    		                }
    		            }
    		        });
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
    
    @FXML
    public void updateChannel() {
    	this.getConn();
    	String sql= "SELECT * FROM tvlist";
    	try {
    		PreparedStatement ps = this.conn.prepareStatement(sql);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			lblCount.setText(String.valueOf(rs.getFetchSize()));
    			System.out.println(lblCount.getText());
    		}
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    }
    
    @FXML
    public void channelCount() {
    	this.getConn();
    	String sql= "SELECT * FROM tvlist";
    	try {
    		PreparedStatement ps = this.conn.prepareStatement(sql);
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) {
    			lblCount.setText(String.valueOf(rs.getFetchSize()));
    			System.out.println(lblCount.getText());
    		}
    	}catch(Exception e) {
    		
    		e.printStackTrace();
    	}
    }
    
      @FXML
    public void apagar() {
    }

    @FXML
    public void exit() {
        Platform.exit();
    }
}
