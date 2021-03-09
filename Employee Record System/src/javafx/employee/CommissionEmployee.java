package javafx.employee;

import java.io.Serializable;

public class CommissionEmployee extends EmployeeType implements Serializable {

    double commission;
    double sale;

    public CommissionEmployee(String name, String id, String designation, double commission, double sale) {
        super(name, id, designation);
        this.commission = commission;
        this.sale = sale;
    }

    double getSalary(double sale) {

        return commission * sale;
    }

    @Override
    double getSalary() {

        return commission * sale;
    }

    @Override
    void increaseSalary(double amt) {
        commission += amt;
    }

    @Override
    String display() {
        String s = "Name: "+getName() + " ID: " + getId() + " Designation: " + getDesignation() + " Salary: " + this.getSalary() + " (Commission Employee)";
        return s;
    }
    
    @Override
    String display2() {
        String s = "ID: " + getId() + "\nSalary: " + this.getSalary() + "\nCommission: "+commission+"\nSale: "+sale;
        return s;
    }
}
