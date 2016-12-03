package employee.view;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;

import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.AutoCompletionBinding.AutoCompletionEvent;
import org.controlsfx.control.textfield.TextFields;

import employee.Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AddNewEmployeeController {

	ObservableList<String> martialStatusList = FXCollections.observableArrayList("Single", "Married","Divorced");
	
	
	// Contact Informations
	
	@FXML
	private TextField nameField;
	@FXML
	private TextField addressField;
	@FXML
	private TextField cityField;
	@FXML
	private TextField phoneField;
	@FXML
	private TextField emailField;
	
	
	// personal Information
	@FXML
	private DatePicker dateOfBirth;
	@FXML
	private TextField ageField;
	
	@FXML
	private ChoiceBox martialStatusBox;	
	
	
    @FXML
    private TextField txtAuto;


	@FXML
	private void initialize(){
		martialStatusBox.setValue(martialStatusList.get(0));
		martialStatusBox.setItems(martialStatusList);	
	}
	
	
	@FXML
	private void showAge(){
		Calendar now = Calendar.getInstance();
		int year = now.get(Calendar.YEAR);
		int birthYear = (dateOfBirth.getValue().getYear());
		int age = year - birthYear;
		ageField.setText(Integer.toString(age) + " Years");
		
	}
	
}
