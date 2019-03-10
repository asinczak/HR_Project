package pl.com.ttpsc.kursjava.data;

import java.util.Comparator;

public class EmployeeSalaryComparator_Up implements Comparator<Employee> {

    @Override
    public int compare (Employee e1, Employee e2){
        return (int) (e1.getSalary() - (e2.getSalary()));
    }
}
