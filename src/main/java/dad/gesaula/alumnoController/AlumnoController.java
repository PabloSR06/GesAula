package dad.gesaula.alumnoController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import dad.gesaula.ui.model.Sexo;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

public class AlumnoController implements Initializable {

	private Stage stage;
	
	@FXML
    private DatePicker dateAlumnoDate;

    @FXML
    private TextField nameAlumnoText;

    @FXML
    private CheckBox repiteAlumnoCheck;

    @FXML
    private ComboBox<Sexo> sexoAlumnoCombo;

    @FXML
    private TextField surnameAlumnoText;
    
    @FXML
    private BorderPane view;
    
    public AlumnoController() {
    	try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NewAlumnoView.fxml"));
			loader.setController(this);
			loader.load();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}
	
	
	public BorderPane getView() {
		return view;
	}
	
	public void showOnStage(Window owner) {
		stage = new Stage();
		stage.getIcons().addAll(((Stage)owner).getIcons());
		stage.setTitle("Editar propiedad");
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.initOwner(owner);
		stage.setScene(new Scene(view, 400, 200));
		stage.showAndWait();
	}

}
