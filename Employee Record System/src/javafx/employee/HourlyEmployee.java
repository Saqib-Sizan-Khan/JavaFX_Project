package javafx.employee;

import java.io.Serializable;

public class HourlyEmployee extends EmployeeType implements Serializable {

    double hourlyRate;
    int hourWorked;

    public HourlyEmployee(String name, String id, String designation, double hourlyRate, int hourWorked) {
        super(name, id, designation);
        this.hourlyRate = hourlyRate;
        this.hourWorked = hourWorked;
    }

    double getSalary(int hWorked) {

        return hourlyRate * hWorked;
    }

    @Override
    void increaseSalary(double amt) {

        hourlyRate += amt;
    }

    @Override
    double getSalary() {

        return hourlyRate * hourWorked;
    }

    @Override
    String display() {
        String s = "Name: " + getName() + " ID: " + getId() + " Designation: " + getDesignation() + " Salary: " + this.getSalary() + " (Hourly Employee)";
        return s;
    }
    
    @Override
    String display2() {
        String s = "ID: " + getId()+ "\nSalary: " + this.getSalary() + "\nHourlyRate: "+hourlyRate+"\nHourWorked: "+hourWorked;
        return s;
    }
}
