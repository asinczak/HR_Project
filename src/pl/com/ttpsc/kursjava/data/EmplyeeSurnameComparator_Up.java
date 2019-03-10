package pl.com.ttpsc.kursjava.data;

import java.util.Comparator;

public class EmplyeeSurnameComparator_Up implements Comparator <Employee> {

    @Override
    public int compare (Employee e1, Employee e2){
        return e1.getSurname().compareTo(e2.getSurname());
    }
}
