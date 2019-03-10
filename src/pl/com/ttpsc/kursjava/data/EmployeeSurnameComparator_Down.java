package pl.com.ttpsc.kursjava.data;

import java.util.Comparator;

public class EmployeeSurnameComparator_Down implements Comparator <Employee> {

    @Override
    public int compare (Employee e1, Employee e2){
        return e2.getSurname().compareTo(e1.getSurname());
    }

}
