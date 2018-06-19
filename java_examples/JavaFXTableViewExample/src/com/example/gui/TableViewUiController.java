package com.example.gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.entity.Employee;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * @author Michael Williams blueskyworkshop.com Oct 2012
 */
public class TableViewUiController implements Initializable {

	@FXML
	private Label TitleLbl;
	@FXML
	private HBox HBox4Btns;

	@FXML
	private Label LblAddText;
	@FXML
	private TableView<Employee> tableViewMain;
	@FXML
	private TableColumn<Employee, Integer> id;
	@FXML
	private TableColumn<Employee, String> name;
	@FXML
	private TableColumn<Employee, String> surName;
	@FXML
	private TableColumn<Employee, Double> salery;

	@FXML
	private TextField txtName;
	@FXML
	private TextField txtSurname;
	@FXML
	private TextField txtSalery;

	@FXML
	private Button BtnAdd;
	@FXML
	private Button BtnDelete;

	int counter = 0;
	
	final ObservableList<Employee> tableItems = FXCollections
			.observableArrayList(new Employee(counter++, "Homo", "Sapiens", 1234.56));



	// Add event handlers
	@FXML
	private void addAction() {
		Employee employee = new Employee(counter++, txtName.getText(), txtSurname.getText(),
				Double.parseDouble(txtSalery.getText()));
		tableItems.add(employee);
	}

	@FXML
	private void deleteAction(ActionEvent action) {
		int selectedItem = tableViewMain.getSelectionModel().getSelectedIndex();
		tableItems.remove(selectedItem);
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		tableViewMain.setItems(tableItems);

		id.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("id"));
		name.setCellValueFactory(new PropertyValueFactory<Employee, String>("name"));
		surName.setCellValueFactory(new PropertyValueFactory<Employee, String>("surName"));
		salery.setCellValueFactory(new PropertyValueFactory<Employee, Double>("salery"));

	}
}
