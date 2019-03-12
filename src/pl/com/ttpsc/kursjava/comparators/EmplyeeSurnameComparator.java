package pl.com.ttpsc.kursjava.comparators;

import pl.com.ttpsc.kursjava.data.Employee;

import java.util.Comparator;

public class EmplyeeSurnameComparator implements Comparator <Employee> {

    @Override
    public int compare (Employee e1, Employee e2){
        return e1.getSurname().compareTo(e2.getSurname());
    }
}
