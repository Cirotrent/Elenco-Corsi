package Ciro.Corsi;
	
import Ciro.Corsi.Model.Model;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;
/*
 * Restituisci l'elenco dei corsi di un determinato periodo didattico
 * (tabella corso del database iscrittiCorsi)
 * 
 * INSERENDO UNA MATRICOLA NELLA CASELLA MI RESTITUISCE IL NOME E IL COGNOME DELLO STUDENTE
 * (tabella studente del database iscrittiCorsi)
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader= new FXMLLoader(getClass().getResource("Corsi.fxml"));
			
			
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			
			CorsiController controller= loader.getController();
			
			Model model=new Model();
			controller.setModel(model);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
