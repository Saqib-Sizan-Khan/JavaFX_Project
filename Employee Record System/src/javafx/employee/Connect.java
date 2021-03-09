package javafx.employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import static javafx.employee.UapCse.employeeList;

public class Connect {

    String searchId = "";
    double amt;
    static UapCse myUap = new UapCse("University of Asia Pacific");
    
    static String fileName = "data.txt";

    public void salaried(String name, String id, String des, double sal) {

        myUap.addNewEmployees(name, id, des, sal);

    }

    public void hourly(String name, String id, String des, double hr, int hw) {

        myUap.addNewEmployees(name, id, des, hr, hw);

    }

    public void commission(String name, String id, String des, double comissionRate, double comisionSale) {

        myUap.addNewEmployees(name, id, des, comissionRate, comisionSale);

    }

    public ArrayList<EmployeeType> showres() {
        ArrayList<EmployeeType> em = myUap.employeeList;
        return em;
    }

    public String searchID() {
        EmployeeType e = myUap.findEmployee(searchId);
        String ob = e.display();
        return ob;
    }

    public String updateSalary() {
        EmployeeType e = myUap.findEmployee(searchId);
        if (e == null) {
            return "No";
        } else {
            e.increaseSalary(amt);
            return "Yes";
        }

    }

    public String Salary() {
        EmployeeType e = myUap.findEmployee(searchId);
        String name = e.getName();
        String id = e.getId();
        double sal = e.getSalary();
        return "Name: " + name + " Id: " + id + " Salary: " + sal;

    }
    
    public static void readData() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);

            employeeList = (ArrayList<EmployeeType>) ois.readObject();
            //System.out.println(bs.books.size());
            //return bs;
        } catch (IOException | ClassNotFoundException e) {
            //System.out.println("No data available");
            //e.printStackTrace();
        }

    }

    public static void saveData() {
        try {
            ObjectOutputStream p = new ObjectOutputStream(new FileOutputStream(fileName));
            p.writeObject(employeeList);
            p.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
        }
    }
}
