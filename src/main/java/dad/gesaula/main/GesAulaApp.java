package dad.gesaula.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import dad.gesaula.controller.MainController;

public class GesAulaApp extends Application {
	
	private MainController MainController;
	
	private static Stage primaryStage;

	@Override
	public void start(Stage primaryStage) throws Exception {
		GesAulaApp.primaryStage = primaryStage;
		MainController = new MainController();
		
		primaryStage.setScene(new Scene(MainController.getView(),800, 600));
		primaryStage.setTitle("GesAula");
		primaryStage.getIcons().add(new Image("images/app-icon-64x64.png"));	
		primaryStage.show();
		
	}
	
	public static boolean confirm(String header) {
		Alert confirm = new Alert(AlertType.CONFIRMATION);
		confirm.initOwner(getPrimaryStage());
		confirm.setTitle("Eliminar Alumno");
		confirm.setHeaderText("Se va a eliminar al alumno " + header);
		confirm.setContentText("¿Está seguro?");
		return confirm.showAndWait().get().equals(ButtonType.OK);
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
