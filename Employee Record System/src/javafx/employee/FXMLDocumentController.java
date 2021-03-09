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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private void addEmployeeAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("EmployeeType.fxml"));
        Scene scene = new Scene(root);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();        
    }
    
    @FXML
    private void SalaryInfoAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("SalaryInfo.fxml"));
        Scene scene = new Scene(root);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();        
    }
    
    @FXML
    private void IncreaseSalaryAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("IncreaseSalary.fxml"));
        Scene scene = new Scene(root);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();        
    }
    
    @FXML
    private void DSAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("Display Specific.fxml"));
        Scene scene = new Scene(root);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();        
    }
    
    @FXML
    private void DAAction(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("DisplayAll.fxml"));
        Scene scene = new Scene(root);
        
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();        
    }
    
    @FXML
    private void ExitAction(ActionEvent event) throws IOException {
        
        saveData();
        
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
