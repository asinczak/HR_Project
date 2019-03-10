package pl.com.ttpsc.kursjava.data;

import java.util.Comparator;

public class EmployeeSalaryComparator_Down implements Comparator <Employee> {

    @Override
    public int compare (Employee e1, Employee e2){
        return (int) (e2.getSalary() - (e1.getSalary()));
    }
}
