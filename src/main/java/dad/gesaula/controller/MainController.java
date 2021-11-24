package dad.gesaula.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Formatter;
import java.util.ResourceBundle;
import java.util.logging.SimpleFormatter;

import javax.xml.stream.events.StartDocument;

import dad.gesaula.alumnoController.AlumnoController;
import dad.gesaula.main.GesAulaApp;
import dad.gesaula.main.Main;
import dad.gesaula.ui.model.Alumno;
import dad.gesaula.ui.model.Grupo;
import dad.gesaula.ui.model.Pesos;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class MainController implements Initializable {

	// MODEL
	private MainModel model;

	private Grupo grupo;

	// tabla

	private ListProperty<Alumno> tabla = new SimpleListProperty<>(FXCollections.observableArrayList());

	private ObjectProperty<Alumno> seleccionado = new SimpleObjectProperty<>();

	// VIEW
	@FXML
	private Label ActitudLabel;

	@FXML
	private BorderPane RootView;

	@FXML
	private TextField denominacionText;

	@FXML
	private Slider actitudSlider;

	@FXML
	private DatePicker beginningDate;

	@FXML
	private TableView<Alumno> alumnoTable;

	@FXML
	private TableColumn<Alumno, LocalDate> dateColumn;

	@FXML
	private TableColumn<Alumno, String> nameColumn;

	@FXML
	private TableColumn<Alumno, String> surnameColumn;

	@FXML
	private Button deleteAlumnoButton;

	@FXML
	private DatePicker endDate;

	@FXML
	private Label examLabel;

	@FXML
	private Slider examSlider;

	@FXML
	private TextField nameText;

	@FXML
	private Button newAlumnoButton;

	@FXML
	private Button newButton;

	@FXML
	private Label practicaLabel;

	@FXML
	private Slider practicaSlider;

	@FXML
	private Button saveButton;

	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		model = new MainModel();
		// binds sliders

		model.examPropertyProperty().bind(examSlider.valueProperty());
		model.examPropertyProperty().addListener((o, ov, nv) -> examLabel.setText(nv.intValue() + "%"));

		model.practicasPropertyProperty().bind(practicaSlider.valueProperty());
		model.practicasPropertyProperty().addListener((o, ov, nv) -> practicaLabel.setText(nv.intValue() + "%"));

		model.actitudPropertyProperty().bind(actitudSlider.valueProperty());
		model.actitudPropertyProperty().addListener((o, ov, nv) -> ActitudLabel.setText(nv.intValue() + "%"));

		model.nameGroupPropertyProperty().bindBidirectional(nameText.textProperty());

		// bind grupo
		model.endDatePropertyProperty().bindBidirectional(endDate.valueProperty());
		model.startDatePropertyProperty().bindBidirectional(beginningDate.valueProperty());
		model.denominacionPropertyProperty().bindBidirectional(denominacionText.textProperty());
		
		
		//bind tabla
		
		seleccionado.bind(alumnoTable.getSelectionModel().selectedItemProperty());
		
		alumnoTable.itemsProperty().bind(tabla);
		
		nameColumn.setCellValueFactory(v -> v.getValue().nombreProperty());
		surnameColumn.setCellValueFactory(v -> v.getValue().apellidosProperty());
		dateColumn.setCellValueFactory(v -> v.getValue().fechaNacimientoProperty());
		

	}

	

	@FXML
	void onNewAction(ActionEvent event) {
		//grupo = new Grupo();

		//seleccionado;
		AlumnoController controller = new AlumnoController();
		controller.showOnStage(GesAulaApp.getPrimaryStage());
		
		Alumno alumno = new Alumno();
		alumno.setNombre("nuevo");
		//pruebas para pantalla dividida
	}

	@FXML
	void onNewAlumnoAction(ActionEvent event) {
		Alumno x = new Alumno();
		x.setNombre("Sin nombre");
		x.setApellidos("Sin apellidos");
		tabla.add(x);
	}
	
	@FXML
	void onDeleteAlumnoAction(ActionEvent event) {
		System.out.println();
		tabla.remove(seleccionado.getValue());
		//TODO CONFIRMACION
	}

	@FXML
	void onSaveAction(ActionEvent event) {
		try {
			Pesos pesos = new Pesos();
			pesos.setActitud(model.getActitudProperty());
			pesos.setExamenes(model.getExamProperty());
			pesos.setPracticas(model.getActitudProperty());

			grupo.setDenominacion(model.getDenominacionProperty());
			grupo.setIniCurso(model.startDatePropertyProperty().getValue());
			grupo.setFinCurso(model.endDatePropertyProperty().getValue());
			grupo.setPesos(pesos);

			grupo.save(new File(model.getNameGroupProperty()));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BorderPane getView() {
		return RootView;
	}

}
