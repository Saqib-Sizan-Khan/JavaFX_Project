/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EmployeeTypeController implements Initializable {
    
    @FXML
    private void SalaryAction(ActionEvent event) throws IOException {
          
            Parent root = FXMLLoader.load(getClass().getResource("SalariedEmployee.fxml"));
            Scene scene = new Scene(root);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();  
    }
    
    @FXML
    private void CommissionAction(ActionEvent event) throws IOException {
          
            Parent root = FXMLLoader.load(getClass().getResource("CommissionEmployee.fxml"));
            Scene scene = new Scene(root);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();  
    }
    
    @FXML
    private void HourlyAction(ActionEvent event) throws IOException {
          
            Parent root = FXMLLoader.load(getClass().getResource("HourlyEmployee.fxml"));
            Scene scene = new Scene(root);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();  
    }
    
    @FXML
    private void backAction(ActionEvent event) throws IOException {
          
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();  
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
