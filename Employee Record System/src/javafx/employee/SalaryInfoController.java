/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.employee.UapCse.employeeList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SalaryInfoController implements Initializable {

    @FXML
    private TextField idbar;
    @FXML
    private TextArea disbar;
    @FXML
    private Label unl;

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

        disbar.setText("");

        String id = idbar.getText();
        boolean f = false;
        boolean fi = false;

        for (int i = 0; i < id.length(); i++) {

            if (id.charAt(i) >= '0' && id.charAt(i) <= '9') {
                fi = true;
            } else {
                fi = false;
                idbar.setText("");
                unl.setText("ID should be in Digit");
                break;
            }
        }

        if (fi == true) {
            for (EmployeeType emp : employeeList) {

                if (emp.getId().equals(id)) {
                    f = true;
                    String s = String.valueOf(emp.getSalary());
                    disbar.setText(emp.display2());
                    break;
                }
            }
        }

        if (f == false && fi == true) {
            disbar.setText("Employee not in the List");
            unl.setText("");
        }
    }

    @FXML
    private void cleartAction(ActionEvent event) throws IOException {

        idbar.setText("");
        disbar.setText("");
        unl.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
