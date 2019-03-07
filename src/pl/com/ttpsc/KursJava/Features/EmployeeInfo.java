package pl.com.ttpsc.KursJava.Features;

import pl.com.ttpsc.KursJava.Data.Employee;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeInfo {

    List<Employee> list = new ArrayList<>();

    public void shortDisplayList (){
        for (Employee employee : list){
            employee.shortDisplay();
        }
    }

    public void addEmployee (Employee employee){
        list.add(employee);
    }

    public void writeData () throws IOException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the name of the file");
        String fileName = sc.nextLine();
        FileOutputStream file = new FileOutputStream(new File (fileName));
        ObjectOutputStream obj = new ObjectOutputStream(file);

        for (Employee employee : list){
            obj.writeObject(employee.writeToFile());
        }
    }

    public void removeEmployee (){
        System.out.println("List of all employees :");
        for(Employee employee : list){
            employee.toString();
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose the employee to remove. Enter the name :");
        String name = sc.nextLine();
        System.out.println("Enter the surname :");
        String surname = sc.nextLine();

        for (Employee employee : list){
            if (employee.getName().equals(name) & employee.getSurname().equals(surname)){
                list.remove(employee);
            }
        }
    }

}
