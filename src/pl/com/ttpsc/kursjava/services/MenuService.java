package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.data.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class MenuService {

    private static final MenuService menuService = new MenuService();

    private MenuService () {}

    public static MenuService getInstance() {
        return menuService;
    }
    EmployeeService employeeService = EmployeeService.getInstance();
    DisplayService displayService = new DisplayService();
    FileService fileService = FileService.getInstance();

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
                        employee.setNrBranch(newNr_Dept);
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
                        employee.setNrChildren(newNr_Children);
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

            boolean switchgoes = true;

        do {

            displayAdditionalFunctionsMenu();
            int menuNumber = sc.nextInt();

            switch (menuNumber) {
                case 1:
                    System.out.println("Enter the salary to compare :");
                    float givenSalary = sc.nextFloat();
                    System.out.println("Number of employees which salary is higher than "+givenSalary+ " : "+employeeService.countNumberOfEmp(givenSalary));
                    break;
                case 2:
                    System.out.println("Enter the branch number :");
                    int branch = sc.nextInt();
                    System.out.println("The average salary in branch nr "+branch+ " : "+employeeService.countAverageSalary(branch));
                    break;
                case 3:
                    displayService.displayHighestSalary();
                    break;
                case 4:
                    displayAllDepartments();
                    break;
                case 5:
                    displayService.displayRatioOfSalary();
                    break;
                case 6:
                    displayService.displayIncreaseSalary10per();
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

        boolean switchgoes = true;

        do {

            displayAdditionalFunctionsForFilesMenu();
            int menuNumber = sc.nextInt();

            switch (menuNumber) {
                case 1:
                   displayService.displayLongestSurname();
                    break;
                case 2:
                   displayService.displayCountAverageAge();
                    break;
                case 3:
                   employeeService.encodeData();
                    break;
                case 4:
                    fileService.createTable();
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

        boolean switchgoes = true;

        do {

            displayMainMenu();
            int menuNumber = sc.nextInt();

            switch (menuNumber) {
                case 1:
                    displayService.displayList();
                    break;
                case 2:
                    System.out.println("Enter data to add employee. Enter name :");
                    String name = sc.next();

                    System.out.println("Enter the surname :");
                    String surname = sc.next();

                    char sex;
                    do {
                        System.out.println("Enter the sex ( k / m ) : ");
                        char check = sc.next().charAt(0);
                        if (check == 'k' || check == 'm'){
                             sex = check;
                             break;
                        }
                        else  {
                            System.out.println("Wrong data! Enter one more time ");
                        }
                    }while (true);

                    int nrBranch;
                    do {

                        int checking = readInt("Enter the number of department (1-10) :");
                        if (checking <= 10 & checking >= 1) {
                            nrBranch = checking;
                            break;
                        } else {
                            System.out.println("Wrong data! Enter one more time ");
                        }
                    }while (true);

                    float salary = readFloat("Enter the salary :");

                    int age = readInt("Enter the age :");

                    int nr_children = readInt("Enter the number of children :");

                    boolean isMarried = readBoolean ("Enter -true- if employee is married or -fasle- if not");

                    Employee employee = new Employee(name,surname,sex,nrBranch,salary,age,nr_children,isMarried);
                    employeeService.addEmployee(employee);
                    break;
                case 3:
                    employeeService.updateListFile();
                    break;
                case 4:
                    displayService.displayRemoveEmployee();
                    break;
                case 5:
                    displayService.displayEditData();
                    break;
                case 6:
                   additionalFunctionsMenu();
                    break;
                case 7:
                    additionalFunctionsForFilesMenu();
                    break;
                case 8:
                    displayService.infoProgram();
                    break;
                case 9:
                    System.out.println("Enter your own name of file :");
                    String nameFile = sc.next();
                    fileService.changeFileName(nameFile);
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

    private boolean readBoolean(String s) {
            Scanner sc = new Scanner(System.in);
            boolean checking = true;
            boolean loop = true;

            while (loop){
                try {

                    System.out.println(s);
                    checking = sc.nextBoolean();
                    loop = false;
                } catch (InputMismatchException e){
                    System.out.println("Wrong data! Try one more time");
                    sc.next();

                }
            }
            return checking;
    }

    private int readInt (String str){
        Scanner sc = new Scanner(System.in);
        int checking = 0;
        boolean loop = true;

        while (loop){
            try {

                System.out.println(str);
                checking = sc.nextInt();
                loop = false;
            } catch (InputMismatchException e){
                System.out.println("Wrong data! Try one more time");
                sc.next();

            }
        }
           return checking;
    }

    private float readFloat (String str){
        Scanner sc = new Scanner(System.in);
        float checking = 0;
        boolean loop = true;

        while (loop){
            try {

                System.out.println(str);
                checking = sc.nextFloat();
                loop = false;
            } catch (InputMismatchException e){
                System.out.println("Wrong data! Try one more time");
                sc.next();

            }
        }
        return checking;
    }

    public void displayAllDepartments() {
        employeeService.list = employeeService.getList();
        int nrBranch = 0;
        int counterWomen = 0;
        int counterMen = 0;
        for (int i = 0; i <employeeService.list.size(); i++){
            if(nrBranch != employeeService.list.get(i).getNrBranch()) {
                nrBranch = employeeService.list.get(i).getNrBranch();
                if (employeeService.list.get(i).getSex() == 'k') {
                    counterWomen++;
                } else {
                    counterMen++;

                }
                if (counterWomen > counterMen) {
                    System.out.println("In branch nr " + employeeService.list.get(i).getNrBranch() + " most employees are women");
                    employeeService.countAverageSalary(nrBranch);
                }
                if (counterWomen < counterMen) {
                    System.out.println("In branch nr " + employeeService.list.get(i).getNrBranch() + " most employees are men");
                    employeeService.countAverageSalary(nrBranch);
                }
                if (counterWomen == counterMen) {
                    System.out.println("In branch nr " + employeeService.list.get(i).getNrBranch() + " number of women is the same as number of men");
                    employeeService.countAverageSalary(nrBranch);
                }
            }
        }
    }
}
