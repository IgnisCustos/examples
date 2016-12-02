package employee;


import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage primaryStage; 
	private static BorderPane mainLayout;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Employee App");
		showMainView();
		showMainItems();
	}
	
	private void showMainView() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		
		Scene scene = new Scene(mainLayout,800,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void showMainItems() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainItems.fxml"));
		BorderPane mainItems = loader.load();
		mainLayout.setCenter(mainItems);
	}
	
	public static void showElectricalScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("electrical/ElectricalDep.fxml"));
		BorderPane electricalDep = loader.load();
		mainLayout.setCenter(electricalDep);
	}
	
	public static void showMechanicalScene() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("mechanical/MechanicalDep.fxml"));
		BorderPane machanicalDep = loader.load();
		mainLayout.setCenter(machanicalDep);
	}
	public static void showAddStage() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/AddNewEmployee.fxml"));
		BorderPane addNewEmployee = loader.load();
		
		Stage addDialogStage = new Stage();
		addDialogStage.setTitle("Add New Employee");
		addDialogStage.initModality(Modality.WINDOW_MODAL);
		addDialogStage.initOwner(primaryStage);
		
		Scene scene = new Scene(addNewEmployee);
		addDialogStage.setScene(scene);
		addDialogStage.showAndWait();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
