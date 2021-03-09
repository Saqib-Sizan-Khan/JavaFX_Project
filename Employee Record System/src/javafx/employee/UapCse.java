package javafx.employee;

import java.io.Serializable;
import java.util.ArrayList;

public class UapCse implements Serializable {

    static ArrayList<EmployeeType> employeeList = new ArrayList<>();

    String name;

    public UapCse(String name) {
        super();
        this.name = name;
    }

    private void addNewEmployee(EmployeeType e) {
        employeeList.add(e);
    }

    public void addNewEmployees(String n, String i, String d, double s) {
        EmployeeType E = new SalariedEmployee(n, i, d, s);
        addNewEmployee(E);
    }

    public void addNewEmployees(String n, String i, String d, double hr, int hw) {
        EmployeeType E = new HourlyEmployee(n, i, d, hr, hw);
        addNewEmployee(E);
    }

    public void addNewEmployees(String n, String i, String d, double p, double s) {
        EmployeeType E = new CommissionEmployee(n, i, d, p, s);
        addNewEmployee(E);
    }

    public EmployeeType findEmployee(String id) {
        for (int i = 0; i < employeeList.size(); i++) {

            EmployeeType E = employeeList.get(i);
            if (E.getId().equals(id)) {
                return E;
            }
        }
        return null;
    }

    public void increaseSalary(String id, double amt) {
        EmployeeType E = findEmployee(id);

        if (E != null) {
            E.increaseSalary(amt);
        } else {
            System.out.println("Employee isn't Exits");
        }
    }

    double getSalary(String id) {
        EmployeeType E = findEmployee(id);

        if (E != null) {
            double salary = E.getSalary();
            return salary;
        } else {
            System.out.println("Employee isn't Exits");
            return 0;
        }
    }

    void displayInfo(String id) {
        EmployeeType E = findEmployee(id);

        if (E != null) {
            E.display();
        } else {
            System.out.println("Employee isn't Exits");
        }
    }

    void display() {
        for (int i = 0; i < employeeList.size(); i++) {

            EmployeeType E = employeeList.get(i);
            E.display();
        }
    }
}
