package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.data.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {

    List<Employee> list = new ArrayList<>();
    FileService fileService = new FileService();
    MenuService menu = new MenuService();

   public List <Employee> getList () {
      for (Employee employee : fileService.readObject()){
          System.out.println(employee.shortDisplay());
      }
      return fileService.readObject();
   }

    private void updateListFile() {
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
        getList();

        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose the employee to edit. Enter the surname :");
        String surname = sc.nextLine();

        System.out.println("You've chosen this employee :");
        for (Employee employee : list) {
            if (employee.getSurname().equals(surname)) {
                employee.specialDisplay();

                menu.displayEditDataMenu();
                int menuNumber = sc.nextInt();

                switch (menuNumber) {
                    case 1:
                        if (employee.getSex() == 'k') {
                            System.out.println("Enter the new surname :");
                            String newSurname = sc.nextLine();
                            employee.setSurname(newSurname);
                        } else {
                            System.out.println("You can't change man's surname");
                        }
                        break;
                    case 2:
                        System.out.println("Enter the new number of department : ");
                        int newNr_Dept = sc.nextInt();
                        employee.setNr_branch(newNr_Dept);
                        break;
                    case 3:
                        System.out.println("Enter the new salary :");
                        float newSalary = sc.nextFloat();
                        employee.setSalary(newSalary);
                        break;
                    case 4:
                        System.out.println("Enter the new age :");
                        int newAge = sc.nextInt();
                        employee.setAge(newAge);
                        break;
                    case 5:
                        System.out.println("Enter the new number of chldren");
                        int newNr_Children = sc.nextInt();
                        employee.setNr_children(newNr_Children);
                        break;
                    case 6:
                        if (employee.isMaritalStatus()) {
                            employee.setMaritalStatus(false);
                            System.out.println("Marital status changed - not married");
                        } else {
                            employee.setMaritalStatus(true);
                            System.out.println("Marital status changed - married");
                        }
                        break;
                    default:
                        System.out.println("Wrong number! Choose one more time!");
                }
            }

        }

    }

}
