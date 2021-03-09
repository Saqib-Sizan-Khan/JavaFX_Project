/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.employee.Connect.saveData;
import static javafx.employee.UapCse.employeeList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class IncreaseSalaryController implements Initializable {

    @FXML
    private TextField idbar;
    @FXML
    private TextField ambar;
    @FXML
    private Label idl;
    @FXML
    private Label aml;
    @FXML
    private Label sl;

    @FXML
    private void backAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void submitAction(ActionEvent event) throws IOException {

        boolean f = false;
        boolean fi = false;
        String id = idbar.getText();

        for (int i = 0; i < id.length(); i++) {
            if (id.charAt(i) >= '0' && id.charAt(i) <= '9') {
                fi = true;
            } else {
                fi = false;
                idl.setText("ID should be in Digit");
                sl.setText("Unable to Increase");
                idbar.setText("");
                break;
            }
        }

        if (fi == true) {
            for (EmployeeType emp : employeeList) {

                if (emp.getId().equals(id)) {
                    f = true;
                    try {
                        double r = Double.parseDouble(ambar.getText());
                        if (r >= 0) {
                            emp.increaseSalary(r);
                            saveData();
                            sl.setText("Salary Updated");
                            idl.setText("");
                            aml.setText("");
                        } else {
                            aml.setText("Amount is Negative");
                            sl.setText("Unable to Increase");
                            ambar.setText("");
                            idl.setText("");
                        }

                    } catch (NumberFormatException e) {
                        ambar.setText("");
                        aml.setText("Amount should be in double");
                        sl.setText("Unable to Increase");
                    }
                    break;
                }
            }
        }

        if (f == false && fi == true) {
            sl.setText("Employee not in the List");
        }
    }

    @FXML
    private void cleartAction(ActionEvent event) throws IOException {

        idbar.setText("");
        ambar.setText("");
        idl.setText("");
        aml.setText("");
        sl.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
