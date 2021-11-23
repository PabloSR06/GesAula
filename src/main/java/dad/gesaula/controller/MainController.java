package dad.gesaula.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Formatter;
import java.util.ResourceBundle;
import java.util.logging.SimpleFormatter;

import javax.xml.stream.events.StartDocument;

import dad.gesaula.main.Main;
import dad.gesaula.ui.model.Grupo;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

	@FXML
	private Label ActitudLabel;

	@FXML
	private BorderPane RootView;
	
	@FXML
	private TextField denominacionText;

	@FXML
	private Slider actitudSlider;

	@FXML
	private TableView<?> alumnoTable;

	@FXML
	private DatePicker beginningDate;

	@FXML
	private TableColumn<?, ?> dateColumn;

	@FXML
	private Button deleteAlumnoButton;

	@FXML
	private DatePicker endDate;

	@FXML
	private Label examLabel;

	@FXML
	private Slider examSlider;

	@FXML
	private TableColumn<?, ?> nameColumn;

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
	
	private MainModel model;
	
	
	private Grupo grupo;
	

	public MainController() throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/RootView.fxml"));
		loader.setController(this);
		loader.load();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		model = new MainModel();
		//binds sliders
	
		model.examPropertyProperty().bind(examSlider.valueProperty());
		model.examPropertyProperty().addListener((o, ov ,nv) -> examLabel.setText(nv.intValue()+"%"));
		
		model.practicasPropertyProperty().bind(practicaSlider.valueProperty());
		model.practicasPropertyProperty().addListener((o, ov ,nv) -> practicaLabel.setText(nv.intValue()+"%"));
		
		model.actitudPropertyProperty().bind(actitudSlider.valueProperty());
		model.actitudPropertyProperty().addListener((o, ov ,nv) -> ActitudLabel.setText(nv.intValue()+"%"));
		
		model.nameGroupPropertyProperty().bindBidirectional(nameText.textProperty());
		
		//bind grupo
		model.endDatePropertyProperty().bindBidirectional(endDate.valueProperty());
		model.startDatePropertyProperty().bindBidirectional(beginningDate.valueProperty());
		model.denominacionPropertyProperty().bindBidirectional(denominacionText.textProperty());
		
		
		
		
	}

	@FXML
	void onDeleteAlumnoAction(ActionEvent event) {

	}

	@FXML
	void onNewAction(ActionEvent event) {
		grupo = new Grupo();
	
	}

	@FXML
	void onNewAlumnoAction(ActionEvent event) {

	}

	@FXML
	void onSaveAction(ActionEvent event) {
		try {
			//grupo.save(new File( model.getNameGroupProperty()));
			System.out.println(model.getEndDateProperty());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BorderPane getView() {
		return RootView;
	}

}
