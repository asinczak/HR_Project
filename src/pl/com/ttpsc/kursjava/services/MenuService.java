package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.data.Employee;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class MenuService {

    private static final MenuService menuService = new MenuService();
    private String chosenLanguage = "";
    private MenuService () {}

    public static MenuService getInstance() {
        return menuService;
    }
    EmployeeService employeeService = EmployeeService.getInstance();
    DisplayService displayService = new DisplayService();
    FileService fileService = FileService.getInstance();


        public void editDataMenu (Employee employee){
            Scanner sc = new Scanner(System.in);
            boolean switchgoes = true;

            do {
                readEditDataMenu();
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

    public void additionalFunctionsMenu() {
            Scanner sc = new Scanner(System.in);

            boolean switchgoes = true;

        do {

            readAdditionalFunctionsMenu();
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




    public void additionalFunctionsForFilesMenu () {
        Scanner sc = new Scanner(System.in);

        boolean switchgoes = true;

        do {

            readAdditionalFunctionsForFilesMenu();
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


    public void mainMenu (){
        Scanner sc = new Scanner(System.in);

        PropertiesService.setMenuDefaultLanguage();

        boolean switchgoes = true;

        do {

            readMainMenu();
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
                        System.out.println("Choose the language for displaying: 'pl' or 'eng'");
                         chosenLanguage = sc.next();
                    if (chosenLanguage.equals("pl") || chosenLanguage.equals("eng")){
                        PropertiesService.changeMenuLahguage(chosenLanguage);
                    } else {
                        System.out.println("Wrong language! Default language will be set");
                        PropertiesService.setMenuDefaultLanguage();
                    }
                    break;
                case 11:
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


    public void readMainMenu() {
            chosenLanguage = PropertiesService.readMenuLanguage();

            if (chosenLanguage.equals("en")){
                System.out.println(GeneralMessages.MAIN_MENU1);
                System.out.println(GeneralMessages.MAIN_MENU2);
                System.out.println(GeneralMessages.MAIN_MENU3);
                System.out.println(GeneralMessages.MAIN_MENU4);
                System.out.println(GeneralMessages.MAIN_MENU5);
                System.out.println(GeneralMessages.MAIN_MENU6);
                System.out.println(GeneralMessages.MAIN_MENU7);
                System.out.println(GeneralMessages.MAIN_MENU8);
                System.out.println(GeneralMessages.MAIN_MENU9);
                System.out.println(GeneralMessages.MAIN_MENU10);
                System.out.println(GeneralMessages.MAIN_MENU11);
                System.out.println(GeneralMessages.MAIN_MENU12);
                System.out.println(GeneralMessages.MAIN_MENU13);
            }
            if (chosenLanguage.equals("pl")){
                System.out.println(GeneralMessages_pl.MAIN_MENU1);
                System.out.println(GeneralMessages_pl.MAIN_MENU2);
                System.out.println(GeneralMessages_pl.MAIN_MENU3);
                System.out.println(GeneralMessages_pl.MAIN_MENU4);
                System.out.println(GeneralMessages_pl.MAIN_MENU5);
                System.out.println(GeneralMessages_pl.MAIN_MENU6);
                System.out.println(GeneralMessages_pl.MAIN_MENU7);
                System.out.println(GeneralMessages_pl.MAIN_MENU8);
                System.out.println(GeneralMessages_pl.MAIN_MENU9);
                System.out.println(GeneralMessages_pl.MAIN_MENU10);
                System.out.println(GeneralMessages_pl.MAIN_MENU11);
                System.out.println(GeneralMessages_pl.MAIN_MENU12);
                System.out.println(GeneralMessages_pl.MAIN_MENU13);
            }
    }

    private void readEditDataMenu() {
        chosenLanguage = PropertiesService.readMenuLanguage();

        if(chosenLanguage.equals("en")){
            System.out.println(GeneralMessages.EDIT_DATA_MENU1);
            System.out.println(GeneralMessages.EDIT_DATA_MENU2);
            System.out.println(GeneralMessages.EDIT_DATA_MENU3);
            System.out.println(GeneralMessages.EDIT_DATA_MENU4);
            System.out.println(GeneralMessages.EDIT_DATA_MENU5);
            System.out.println(GeneralMessages.EDIT_DATA_MENU6);
            System.out.println(GeneralMessages.EDIT_DATA_MENU7);
            System.out.println(GeneralMessages.EDIT_DATA_MENU8);
            System.out.println(GeneralMessages.EDIT_DATA_MENU9);
        }
        if(chosenLanguage.equals("pl")){
            System.out.println(GeneralMessages_pl.EDIT_DATA_MENU1);
            System.out.println(GeneralMessages_pl.EDIT_DATA_MENU2);
            System.out.println(GeneralMessages_pl.EDIT_DATA_MENU3);
            System.out.println(GeneralMessages_pl.EDIT_DATA_MENU4);
            System.out.println(GeneralMessages_pl.EDIT_DATA_MENU5);
            System.out.println(GeneralMessages_pl.EDIT_DATA_MENU6);
            System.out.println(GeneralMessages_pl.EDIT_DATA_MENU7);
            System.out.println(GeneralMessages_pl.EDIT_DATA_MENU8);
            System.out.println(GeneralMessages_pl.EDIT_DATA_MENU9);
        }
    }

    private void readAdditionalFunctionsMenu() {
            chosenLanguage = PropertiesService.readMenuLanguage();

            if (chosenLanguage.equals("en")){
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU1);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU2);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU3);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU4);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU5);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU6);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU7);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU8);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU9);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU10);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU11);
                System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU12);
            }
            if (chosenLanguage.equals("pl")){
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU1);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU2);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU3);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU4);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU5);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU6);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU7);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU8);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU9);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU10);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU11);
                System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU12);
            }
    }

    private void readAdditionalFunctionsForFilesMenu() {
        chosenLanguage = PropertiesService.readMenuLanguage();

        if(chosenLanguage.equals("en")){
            System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES1);
            System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES2);
            System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES3);
            System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES4);
            System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES5);
            System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES6);
            System.out.println(GeneralMessages.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES7);
        }
        if(chosenLanguage.equals("pl")){
            System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES1);
            System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES2);
            System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES3);
            System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES4);
            System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES5);
            System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES6);
            System.out.println(GeneralMessages_pl.ADDITIONAL_FUNCTIONS_MENU_FOR_FILES7);
        }

    }
}
