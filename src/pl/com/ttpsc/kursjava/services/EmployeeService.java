package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.data.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService {

    List<Employee> list = new ArrayList<>();
    FileService fileService = new FileService();
    MenuService menuService = new MenuService();

   public List <Employee> getList () {
//       for (Employee employee : fileService.readObject()){
//           System.out.println(employee.shortDisplay());
//       }
      return fileService.readObject();
   }

    private void updateListFile() {
        fileService.writeObject(list);
    }

    public void addEmployee (Employee employee){
        list.add(employee);
        updateListFile();
    }

    public void removeEmployee () {

        Employee employeeToRemove = null;

        System.out.println("List of all employees :");
        getList();

        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("Please choose the employee to remove. Enter the name :");
                String name = sc.nextLine();
                System.out.println("Enter the surname :");
                String surname = sc.nextLine();

                for (int i = 0; i < list.size();i++){
                    if (list.get(i).getName().equals(name) & list.get(i).getSurname().equals(surname)){
                         employeeToRemove = list.get(i);
                    }
                }
                if (employeeToRemove != null) {
                    list.remove(employeeToRemove);
                    updateListFile();
                    break;
                } else {
                    throw new IncorrectDataException();
                }
            } catch (IncorrectDataException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }

    public void editData ( ) {

        Employee employeeToEdit = null;

        System.out.println("List of all employees :");
        getList();

        do {
            try {

                Scanner sc = new Scanner(System.in);
                System.out.println("Please choose the employee to edit. Enter the surname :");
                String surname = sc.nextLine();

                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getSurname().equals(surname)) {
                        employeeToEdit = list.get(i);
                    }
                }

                if (employeeToEdit != null) {
                    System.out.println("You've chosen this employee :");
                    System.out.println(employeeToEdit.specialDisplay());
                    menuService.editDataMenu(employeeToEdit);
                    System.out.println("Employee data after changes :");
                    System.out.println(employeeToEdit);
                    updateListFile();
                    break;
                } else {
                    throw new IncorrectDataException();
                }
            } catch (IncorrectDataException e) {
                System.out.println(e.getMessage());
                }
            } while (true);
        }

        public void additionalFunctions (){
       menuService.additionalFunctionsMenu();
        }

    public void countNumberOfEmp(float givenSalary) {
       list = getList();
        int counter = 0;
        for(int i = 0; i<list.size(); i++){
            if (list.get(i).getSalary() > givenSalary){
                counter++;
            }
        }
        System.out.println("Number of employees which salary is higher than "+givenSalary+ " : "+counter);
    }

    public void countAverageSalary(int branch) {
       list = getList();
       int counter = 0;
       float allSalary = 0;

       for(int i = 0; i<list.size(); i++){
           if(list.get(i).getNr_branch() == branch){
               float salary = list.get(i).getSalary();
               allSalary = allSalary + salary;
               counter++;
           }
       }
        float averageSalary = allSalary / counter;

        System.out.println("The average salary in branch nr "+branch+ " : "+averageSalary);
    }

    public void displayHighestSalary() {
       list = getList();
       float highSalaryWomen = 0;
       float highSalaryMen = 0;

       for(int i = 0; i<list.size(); i++){
           float salary = list.get(i).getSalary();
           if (list.get(i).getSex() == 'k'){
               if(highSalaryWomen < salary) {
                   highSalaryWomen = salary;
                    }
               } else {
                   if (highSalaryMen < salary){
                       highSalaryMen = salary;
                   }
               }
           }
        System.out.println("The highest women's salary is : "+ highSalaryWomen);
        System.out.println("The higest men's salary is : "+ highSalaryMen);
    }

    public void displayAllDepartments() {
    }

    public void displayRatioOfSalary() {
    }

    public void increaseSalary10per() {
    }

    public void increaseSalaryByAmount() {
    }

    public void sortForSurname() {
    }

    public void sortForSalary() {
    }
}


