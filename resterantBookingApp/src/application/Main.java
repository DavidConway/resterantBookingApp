package application;
	

import application.TableList.Table;
import application.bookingList.booking;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class Main extends Application {
	public static TableList tableList = new TableList();
	public static menuItem menuItems = new menuItem();
	public static Stage stage;
	public static SceanManager Scean_Manager = new SceanManager();
	

	@Override
	
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;		   
			Scean_Manager.tableScene();
						

		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
	

}
