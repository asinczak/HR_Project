package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.data.Employee;

import java.util.Scanner;

public class MenuService {

        public void displayEditDataMenu (){
            System.out.println("****************************");
            System.out.println("Please choose data to change :");
            System.out.println("1 -> Surname (only women)");
            System.out.println("2 -> Department number");
            System.out.println("3 -> Salary");
            System.out.println("4 -> Age");
            System.out.println("5 -> Number of children");
            System.out.println("6 -> Marital status");
            System.out.println("7 -> Finish");
        }

        public void editDataMenu (Employee employee){
            Scanner sc = new Scanner(System.in);
            boolean switchgoes = true;

            do {

                displayEditDataMenu();
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
                        System.out.println("Enter the new number of children :");
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
                    case 7:
                        System.out.println("Finish");
                        switchgoes = false;
                        break;
                    default:
                        System.out.println("Wrong number! Choose one more time!");
                }
            } while (switchgoes);
        }

        public void displayAdditionalFunctionsMenu (){
            System.out.println("****************************");
            System.out.println("Please choose one option :");
            System.out.println("1 -> Count the number of employees which have salary higher than given salary");
            System.out.println("2 -> Count the average of salary in given department");
            System.out.println("3 -> Display the highest salary from all women and from all men");
            System.out.println("4 -> Display all departments and the information if majority of employees is women or men");
            System.out.println("5 -> Display ratio of average women's salary to average men's salary");
            System.out.println("6 -> Increase of salary by 10 percent and by additional feature");
            System.out.println("7 -> Increase of salary by given amount. Display the sum of rise and ratio of rise for women and men");
            System.out.println("8 -> Sort employees in file according to surname");
            System.out.println("9 -> Sort employees in file according to the high of salary");
            System.out.println("10 -> Finish");
        }


    public void additionalFunctionsMenu() {
            Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();
            boolean switchgoes = true;

        do {

            displayAdditionalFunctionsMenu();
            int menuNumber = sc.nextInt();

            switch (menuNumber) {
                case 1:
                    System.out.println("Enter the salary to compare :");
                    float givenSalary = sc.nextFloat();
                   employeeService.countNumberOfEmp(givenSalary);
                    break;
                case 2:
                    System.out.println("Enter the branch number :");
                    int branch = sc.nextInt();
                    employeeService.countAverageSalary(branch);
                    break;
                case 3:
                    employeeService.displayHighestSalary();
                    break;
                case 4:
                    employeeService.displayAllDepartments();
                    break;
                case 5:
                    employeeService.displayRatioOfSalary();
                    break;
                case 6:
                    employeeService.increaseSalary10per();
                    break;
                case 7:
                    System.out.println("Enter amount to increase salary");
                    float amount = sc.nextFloat();
                    employeeService.increaseSalaryByAmount(amount);
                    break;
                case 8:
                    System.out.println("Enter -true- if you want to sort crescively");
                    System.out.println("Enter -false- if you want to sort in descending order");
                    boolean howSort = sc.nextBoolean();
                    employeeService.sortForSurname(howSort);
                    break;
                case 9:
                    System.out.println("Enter -true- if you want to sort crescively");
                    System.out.println("Enter -false- if you want to sort in descending order");
                    boolean howSort2 = sc.nextBoolean();
                    employeeService.sortForSalary(howSort2);
                    break;
                case 10:
                    System.out.println("Finish");
                    switchgoes = false;
                    break;
                default:
                    System.out.println("Wrong number! Choose one more time!");
            }
        } while (switchgoes);
    }

    public void displayAdditionalFunctionsForFilesMenu () {
        System.out.println("******************************");
        System.out.println("Please choose one option :");
        System.out.println("1 -> Display data with employee who has the longest surname");
        System.out.println("2 -> Count average age of employees who have children");
        System.out.println("3 -> Encode some data in file");
        System.out.println("4 -> Create file = Employees.html");
        System.out.println("5 -> Finish");
    }

    public void additionalFunctionsForFilesMenu () {
        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();
        boolean switchgoes = true;

        do {

            displayAdditionalFunctionsForFilesMenu();
            int menuNumber = sc.nextInt();

            switch (menuNumber) {
                case 1:
                   employeeService.displayLongestSurname();
                    break;
                case 2:
                   employeeService.countAverageAge();
                    break;
                case 3:
                   employeeService.encodeData();
                    break;
                case 4:
                    employeeService.createFile();
                    break;
                case 5:
                    System.out.println("Finish");
                    switchgoes = false;
                    break;
                default:
                    System.out.println("Wrong number! Choose one more time!");
            }
        } while (switchgoes);
    }

    public void displayMainMenu (){
        System.out.println("******************************");
        System.out.println("Please choose one option :");
        System.out.println("1 -> Display list of employees in short way");
        System.out.println("2 -> Add new employee");
        System.out.println("3 -> Export data to file");
        System.out.println("4 -> Remove employee");
        System.out.println("5 - > Edit data");
        System.out.println("6 -> Additional functions");
        System.out.println("7 -> Additional functions for files");
        System.out.println("8 -> Information about program");
        System.out.println("9 -> Enter own name of file");
        System.out.println("10 -> Finish");
    }

    public void mainMenu (){
        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeService();
        boolean switchgoes = true;

        do {

            displayMainMenu();
            int menuNumber = sc.nextInt();

            switch (menuNumber) {
                case 1:
                    employeeService.displayList();
                    break;
                case 2:
                    System.out.println("Enter data to add employee. Enter name :");
                    String name = sc.next();
                    System.out.println("Enter the surname :");
                    String surname = sc.next();
                    System.out.println("Enter the sex : ");
                    char sex = sc.next().charAt(0);
                    System.out.println("Enter the number of department :");
                    int nr_branch = sc.nextInt();
                    System.out.println("Enter the salary :");
                    float salary = sc.nextFloat();
                    System.out.println("Enter the age :");
                    int age = sc.nextInt();
                    System.out.println("Enter the number of children :");
                    int nr_children = sc.nextInt();
                    System.out.println("Enter -true- if employee is married");
                    System.out.println("Enter -false- if emploee is not married");
                    boolean isMarried = sc.nextBoolean();
                    employeeService.addEmployee(name, surname, sex, nr_branch, salary, age, nr_children, isMarried);
                    break;
                case 3:
                    employeeService.updateListFile();
                    break;
                case 4:
                    employeeService.removeEmployee();
                    break;
                case 5:
                    employeeService.editData();
                    break;
                case 6:
                    employeeService.additionalFunctions();
                    break;
                case 7:
                    employeeService.additionalFunctionsForFiles();
                    break;
                case 8:
                    employeeService.infoProgram();
                    break;
                case 9:
                    employeeService.enterFileName();
                    break;
                case 10:
                    System.out.println("Finish");
                    switchgoes = false;
                    break;
                default:
                    System.out.println("Wrong number! Choose one more time!");
            }
        } while (switchgoes);
    }
}
