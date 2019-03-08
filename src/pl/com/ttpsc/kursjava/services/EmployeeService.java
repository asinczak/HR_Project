package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.data.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {

    List<Employee> list = new ArrayList<>();

   public List getList () {
       FileService fileService = new FileService();

      for (Employee employee : fileService.readObject()){
          System.out.println(employee.shortDisplay());
      }

       return fileService.readObject();
   }

    private void updateListFile() {
        FileService fileService = new FileService();
        fileService.writeObject(list);
    }

    public void addEmployee (Employee employee){
        list.add(employee);
        updateListFile();
    }

    public void removeEmployee (){
        System.out.println("List of all employees :");
        getList();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose the employee to remove. Enter the name :");
        String name = sc.nextLine();
        System.out.println("Enter the surname :");
        String surname = sc.nextLine();

        for (int i = 0; i < list.size();i++){
            if (list.get(i).getName().equals(name) & list.get(i).getSurname().equals(surname)){
                list.remove(list.get(i));
            }
        }
        updateListFile();
    }

    public void editData ( ){
        System.out.println("List of all employees :");
        for(Employee employee : list){
            employee.toString();
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose the employee to edit. Enter the surname :");
        String surname = sc.nextLine();

        System.out.println("You've chosen this employee :");
        for (Employee employee : list){
            if(employee.getSurname().equals(surname)){
                employee.specialDisplay();
            }
        }

    }

}
