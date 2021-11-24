package dad.gesaula.alumnoController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Sexo;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;


public class AlumnoController implements Initializable {

	// mode

	private ObjectProperty<Alumno> alumno = new SimpleObjectProperty<>();
	
	//VIEW

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
		
		alumno.addListener((o, ov, nv) -> onAlumnoChanged(o, ov, nv));
		
		//sexoAlumnoCombo.selectionModelProperty().set(h);
	}

	private void onAlumnoChanged(ObservableValue<? extends Alumno> o, Alumno ov, Alumno nv) {
		
		if (ov != null) {
			this.nameAlumnoText.textProperty().unbindBidirectional(ov.nombreProperty());
			this.surnameAlumnoText.textProperty().unbindBidirectional(ov.apellidosProperty());
			this.dateAlumnoDate.valueProperty().unbindBidirectional(ov.fechaNacimientoProperty());
			this.sexoAlumnoCombo.valueProperty().unbindBidirectional(ov.sexoProperty());
			this.repiteAlumnoCheck.selectedProperty().unbindBidirectional(ov.repiteProperty());
		}

		if (nv != null) {
			this.nameAlumnoText.textProperty().bindBidirectional(nv.nombreProperty());
			this.surnameAlumnoText.textProperty().bindBidirectional(nv.apellidosProperty());
			this.dateAlumnoDate.valueProperty().bindBidirectional(nv.fechaNacimientoProperty());
			this.sexoAlumnoCombo.valueProperty().bindBidirectional(nv.sexoProperty());
			this.repiteAlumnoCheck.selectedProperty().bindBidirectional(nv.repiteProperty());
		}
	}

	public BorderPane getView() {
		return view;
	}


	public final ObjectProperty<Alumno> alumnoProperty() {
		return this.alumno;
	}
	

	public final Alumno getAlumno() {
		return this.alumnoProperty().get();
	}
	

	public final void setAlumno(final Alumno alumno) {
		this.alumnoProperty().set(alumno);
	}

}
