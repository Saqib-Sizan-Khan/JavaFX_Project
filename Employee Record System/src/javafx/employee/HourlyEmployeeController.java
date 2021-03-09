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

public class HourlyEmployeeController implements Initializable {

    @FXML
    private TextField namebar;
    @FXML
    private TextField idbar;
    @FXML
    private TextField desbar;
    @FXML
    private TextField hrbar;
    @FXML
    private TextField hwbar;
    @FXML
    private Label namel;
    @FXML
    private Label idl;
    @FXML
    private Label desl;
    @FXML
    private Label hrl;
    @FXML
    private Label hwl;
    @FXML
    private Label sl;

    @FXML
    private void backAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("EmployeeType.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void HomeAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void submitAction(ActionEvent event) throws IOException {

        String name = namebar.getText();
        String id = idbar.getText();
        String designation = desbar.getText();
        boolean f = true;
        boolean fn = true;
        boolean fd = true;
        boolean fc = true;
        double hourlyRate = 0;
        int hourWorked = 0;

        namel.setText("");
        idl.setText("");
        desl.setText("");
        hrl.setText("");
        hwl.setText("");

        for (int i = 0; i < name.length(); i++) {

            if (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z' || name.charAt(i) >= 'a' && name.charAt(i) <= 'z' || name.charAt(i) == ' ') {
                fn = true;
            } else {
                fn = false;
                namebar.setText("");
                namel.setText("Name should be Alphabet");
                break;
            }
        }

        for (int i = 0; i < designation.length(); i++) {

            if (designation.charAt(i) >= 'A' && designation.charAt(i) <= 'Z' || designation.charAt(i) >= 'a' && designation.charAt(i) <= 'z' || designation.charAt(i) == ' ') {
                fd = true;
            } else {
                fd = false;
                desbar.setText("");
                desl.setText("Designation should be Alphabetic");
                break;
            }
        }

        for (int i = 0; i < id.length(); i++) {

            if (id.charAt(i) >= '0' && id.charAt(i) <= '9') {
                f = true;
            } else {
                f = false;
                idbar.setText("");
                idl.setText("ID should be in Digit");
                break;
            }
        }

        for (EmployeeType emp : employeeList) {
            if (emp.getId().equals(id)) {
                f = false;
                idl.setText("ID should be Unique");
                idbar.setText("");
                break;
            }
        }

        try {
            hourlyRate = Double.parseDouble(hrbar.getText());
            if (hourlyRate < 0) {
                fc = false;
                hrl.setText("Number should be Positive");
            }
        } catch (NumberFormatException e) {
            hrbar.setText("");
            hrl.setText("Invalid Hourly Rate");
        }

        try {
            hourWorked = Integer.parseInt(hwbar.getText());
            if (hourWorked < 0) {
                fc = false;
                hwl.setText("Number should be Positive");
            }
        } catch (NumberFormatException e) {
            hwbar.setText("");
            hwl.setText("Invalid Hourly Worked");
        }

        if (hrl.getText().equals("Invalid Hourly Rate") || hwl.getText().equals("Invalid Hourly Worked") || fc == false) {
            sl.setText("Unable to add in List");
        } else if (f == false) {
            sl.setText("Unable to add in List");
        } else if (fn == false) {
            sl.setText("Unable to add in List");
        } else if (fd == false) {
            sl.setText("Unable to add in List");
        } else {
            Connect c = new Connect();
            c.hourly(name, id, designation, hourlyRate, hourWorked);
            saveData();
            sl.setText("Successfully added in the List");
        }
    }

    @FXML
    private void cleartAction(ActionEvent event) throws IOException {

        namebar.setText("");
        idbar.setText("");
        desbar.setText("");
        hrbar.setText("");
        hwbar.setText("");
        sl.setText("");
    }

    @FXML
    private void showAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Display Specific.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void showlistAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("DisplayAll.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}
