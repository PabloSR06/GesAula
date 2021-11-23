package dad.gesaula.controller;

import java.time.LocalDate;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MainModel {
	
	private DoubleProperty examProperty = new SimpleDoubleProperty();
	private DoubleProperty practicasProperty = new SimpleDoubleProperty();
	private DoubleProperty actitudProperty = new SimpleDoubleProperty();
	
	private StringProperty nameGroupProperty = new SimpleStringProperty();
	
	private StringProperty denominacionProperty = new SimpleStringProperty();
    private ObjectProperty<LocalDate> startDateProperty = new SimpleObjectProperty<>();
    private ObjectProperty<LocalDate> endDateProperty = new SimpleObjectProperty<>();
    
	public final DoubleProperty examPropertyProperty() {
		return this.examProperty;
	}
	
	public final double getExamProperty() {
		return this.examPropertyProperty().get();
	}
	
	public final void setExamProperty(final double examProperty) {
		this.examPropertyProperty().set(examProperty);
	}
	
	public final DoubleProperty practicasPropertyProperty() {
		return this.practicasProperty;
	}
	
	public final double getPracticasProperty() {
		return this.practicasPropertyProperty().get();
	}
	
	public final void setPracticasProperty(final double practicasProperty) {
		this.practicasPropertyProperty().set(practicasProperty);
	}
	
	public final DoubleProperty actitudPropertyProperty() {
		return this.actitudProperty;
	}
	
	public final double getActitudProperty() {
		return this.actitudPropertyProperty().get();
	}
	
	public final void setActitudProperty(final double actitudProperty) {
		this.actitudPropertyProperty().set(actitudProperty);
	}
	
	public final StringProperty nameGroupPropertyProperty() {
		return this.nameGroupProperty;
	}
	
	public final String getNameGroupProperty() {
		return this.nameGroupPropertyProperty().get();
	}
	
	public final void setNameGroupProperty(final String nameGroupProperty) {
		this.nameGroupPropertyProperty().set(nameGroupProperty);
	}
	
	public final StringProperty denominacionPropertyProperty() {
		return this.denominacionProperty;
	}
	
	public final String getDenominacionProperty() {
		return this.denominacionPropertyProperty().get();
	}
	
	public final void setDenominacionProperty(final String denominacionProperty) {
		this.denominacionPropertyProperty().set(denominacionProperty);
	}
	
	public final ObjectProperty<LocalDate> endDatePropertyProperty() {
		return this.endDateProperty;
	}
	
	public final LocalDate getEndDateProperty() {
		return this.endDatePropertyProperty().get();
	}
	
	public final void setEndDateProperty(final LocalDate endDateProperty) {
		this.endDatePropertyProperty().set(endDateProperty);
	}

	public final ObjectProperty<LocalDate> startDatePropertyProperty() {
		return this.startDateProperty;
	}
	

	public final LocalDate getStartDateProperty() {
		return this.startDatePropertyProperty().get();
	}
	

	public final void setStartDateProperty(final LocalDate startDateProperty) {
		this.startDatePropertyProperty().set(startDateProperty);
	}
	
	

	
	
	

}
