package javafx.employee;

import java.io.Serializable;

public class SalariedEmployee extends EmployeeType implements Serializable {

    double monthlySalary;

    public SalariedEmployee(String name, String id, String designation, double monthlySalary) {
        super(name, id, designation);
        this.monthlySalary = monthlySalary;
    }

    @Override
    void increaseSalary(double amt) {

        monthlySalary += amt;
    }

    @Override
    double getSalary() {

        return monthlySalary;
    }

    @Override
    String display() {
        String s = "Name: " + getName() + " ID: " + getId() + " Designation: " + getDesignation() + " Salary: " + this.getSalary() + " (Salaried Employee)";
        return s;
    }
    
    @Override
    String display2() {
        String s = "ID: " + getId() + "\nSalary: " + this.getSalary() + "\nMonthlySalary: "+monthlySalary;
        return s;
    }
}
