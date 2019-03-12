package pl.com.ttpsc.kursjava.comparators;

import pl.com.ttpsc.kursjava.data.Employee;

import java.util.Comparator;

public class EmployeeSalaryComparator implements Comparator<Employee> {

    @Override
    public int compare (Employee e1, Employee e2){
        return (int) (e1.getSalary() - (e2.getSalary()));
    }
}
