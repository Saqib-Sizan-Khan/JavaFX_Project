/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx.employee;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.employee.Connect.readData;
import static javafx.employee.UapCse.employeeList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class DisplayAllController implements Initializable {

    @FXML
    private ListView listbar;

    @FXML
    private void backAction(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
    
    @FXML
    private void ETAction(ActionEvent event) throws IOException {
          
            Parent root = FXMLLoader.load(getClass().getResource("EmployeeType.fxml"));
            Scene scene = new Scene(root);
            
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();  
    }

    @FXML
    private void showAction(ActionEvent event) throws IOException {
        
        listbar.getItems().clear();
        readData();

        for (EmployeeType emp : employeeList) {

            listbar.getItems().add(emp.display());
        }
        
        if(employeeList.isEmpty()){
            listbar.getItems().add("List is Empty");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
