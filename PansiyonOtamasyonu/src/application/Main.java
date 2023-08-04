package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane root = (AnchorPane)FXMLLoader.load(getClass().getResource("ANASAYFA.fxml"));
			Scene scene = new Scene(root,1004,798);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
            String iconPath = getClass().getResource("./görseller--main/aicon.png").toExternalForm();
            Image icon = new Image(iconPath);
            primaryStage.getIcons().add(icon);
            primaryStage.setTitle("Anasayfa"); 
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
