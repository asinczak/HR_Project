package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.comparators.EmployeeSalaryComparator;
import pl.com.ttpsc.kursjava.comparators.EmplyeeSurnameComparator;
import pl.com.ttpsc.kursjava.data.*;
import java.util.*;

public final class EmployeeService {

    private final static EmployeeService employeeService = new EmployeeService();

    private EmployeeService () {}

    public static EmployeeService getInstance() {
        return employeeService;
    }

   Employees list = null;

    FileService fileService = FileService.getInstance();
    MenuService menuService = MenuService.getInstance();

   public Employees getEmployees () {
       list = new Employees();
      return list;
   }

     void updateListFile() {
        fileService.writeObject(getEmployees().getList());
    }

    public static String enterDataCorrectly (String str) {
       String correctStr = str.substring(0,1).toUpperCase() + str.substring(1).toLowerCase().replaceAll("\\s\\d", "");
       return correctStr;
    }

    public boolean CheckingSalary (double salary, Employee employee){
        if (employee.getSalary() > salary){
            return true;
        } else {
            return false;
        }
    }

    public void countRise (float percent, Employee employee) {
       float employeeSalary = employee.getSalary();
        float salary = employeeSalary * percent + employeeSalary;
        if (employee.getNrChildren() > 0){
            salary = (float) (salary * 0.02 * employee.getNrChildren() + salary);
        }
        if (employee.isMaritalStatus()){
            salary = (float) (salary * 0.03 + salary);
        }
        employee.setSalary(salary);
    }

    public void addEmployee (Employee employee){
        list = getEmployees();
        list.getList().add(employee);
        updateListFile();
    }

    public void removeEmployee () {
       list = getEmployees();
        Employee employeeToRemove = null;

        Scanner sc = new Scanner(System.in);
        do {
                System.out.println("Please choose the employee to remove. Enter the name :");
                String name = sc.nextLine();
                System.out.println("Enter the surname :");
                String surname = sc.nextLine();

                for (int i = 0; i < list.getList().size();i++){
                    if (list.getList().get(i).getName().equals(name) & list.getList().get(i).getSurname().equals(surname)){
                         employeeToRemove = list.getList().get(i);
                    }
                }
                if (employeeToRemove != null) {
                    list.getList().remove(employeeToRemove);
                    updateListFile();
                    break;
                } else {
                    System.out.println("You've entered wrong data. Please try again");
                }

        } while (true);
    }

    public void editData ( ) {
        list = getEmployees();
        Employee employeeToEdit = null;

        do {
                Scanner sc = new Scanner(System.in);
                System.out.println("Please choose the employee to edit. Enter the surname :");
                String surname = sc.next();

                for (int i = 0; i < list.getList().size(); i++) {
                    if (list.getList().get(i).getSurname().equals(surname)) {
                        employeeToEdit = list.getList().get(i);
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
                    System.out.println("You've entered wrong data. Please try again");
                }

            } while (true);
        }

    public int countNumberOfEmp(float givenSalary) {
        list = getEmployees();
        int counter = 0;
        for(int i = 0; i<list.getList().size(); i++){
            if (list.getList().get(i).getSalary() > givenSalary){
                counter++;
            }
        }
        return counter;
    }

    public float countAverageSalary(int branch) {
        list = getEmployees();
       int counter = 0;
       float allSalary = 0;

       for(int i = 0; i<list.getList().size(); i++){
           if(list.getList().get(i).getNrBranch() == branch){
               float salary = list.getList().get(i).getSalary();
               allSalary = allSalary + salary;
               counter++;
           }
       }
        float averageSalary = allSalary / counter;

        return averageSalary;
    }

    public float highestSalaryWomen() {
        list = getEmployees();
       float highSalaryWomen = 0;

       for(int i = 0; i<list.getList().size(); i++){
           float salary = list.getList().get(i).getSalary();
           if (list.getList().get(i).getSex() == 'k'){
               if(highSalaryWomen < salary) {
                   highSalaryWomen = salary;
                    }
               }
           }
        return highSalaryWomen;
    }

    public float highestSalaryMen (){
       list = getEmployees();
        float highSalaryMen = 0;

        for(int i = 0; i<list.getList().size(); i++) {
            float salary = list.getList().get(i).getSalary();
            if (list.getList().get(i).getSex() == 'm') {
                if (highSalaryMen < salary) {
                    highSalaryMen = salary;
                }
            }
        }
        return highSalaryMen;
    }

    public float averageOfWomenSalary() {
       list = getEmployees();
       float allWomenSalary = 0;
       int counterWomen = 0;
        float salary = 0;

       for (int i = 0; i < list.getList().size(); i++){
           salary = list.getList().get(i).getSalary();
           if (list.getList().get(i).getSex() == 'k'){
               allWomenSalary = allWomenSalary + salary;
               counterWomen++;
           }
       }

        float averageWomenSalary = allWomenSalary / counterWomen;
       return averageWomenSalary;
    }

    public float averageOfMenSalary (){
       list = getEmployees();
        float allMenSalary = 0;
        int counterMen = 0;
        float salary = 0;

        for (int i = 0; i < list.getList().size(); i++){
            salary = list.getList().get(i).getSalary();
            if (list.getList().get(i).getSex() == 'k'){
                allMenSalary = allMenSalary + salary;
                counterMen++;
            }
        }

        float averageMenSalary = allMenSalary / counterMen;
        return averageMenSalary;
    }

    public void increaseSalary10per() {
       list = getEmployees();

       for(Employee employee : list.getList()){
           countRise(0.10f, employee);
       }
       updateListFile();
    }

    public String increaseSalaryByAmount(float amount) {
       list = getEmployees();

       int counterWomen = 0;
       int counterMen = 0;
       float salaryAfterRise = 0;
       for (Employee employee : list.getList()){
           salaryAfterRise = employee.getSalary() + amount;
           employee.setSalary(salaryAfterRise);
           if(employee.getSex() == 'k') {
               counterWomen++;
           } else {
               counterMen++;
           }
       }
        int counter = counterWomen + counterMen;
        System.out.println("The sum of rises : "+counter);
        updateListFile();

        return "The ratio of women's rise to men's rise is "+counterWomen+ " : "+counterMen;
    }

    public void sortForSurname(boolean howSort) {
       list = getEmployees();
       if (howSort){
           Collections.sort(list.getList(), new EmplyeeSurnameComparator());
       } else {
           Collections.sort(list.getList(), new EmplyeeSurnameComparator());
           Collections.reverse(list.getList());
       }
       updateListFile();
    }

    public void sortForSalary(boolean howSort) {
        list = getEmployees();
        if (howSort){
            Collections.sort(list.getList(), new EmployeeSalaryComparator());
        } else {
            Collections.sort(list.getList(), new EmployeeSalaryComparator());
            Collections.reverse(list.getList());
        }
        updateListFile();
    }



    public String longestSurname() {
       list = getEmployees();
       String theLongestSurname = "";

       for (Employee employee : list.getList()){
           if(theLongestSurname.length() < employee.getSurname().length()){
               theLongestSurname = employee.getSurname();
           }
       }
        return theLongestSurname;
    }

    public int countAverageAge() {
       list = getEmployees();
       int counter = 0;
       int sumAge = 0;
       for(Employee employee : list.getList()){
           if (employee.getNrChildren() > 0){
               sumAge = sumAge + employee.getAge();
               counter++;
           }
       }
       int averageAge = sumAge / counter;
       return averageAge;
    }

    public void encodeData() {
       list = getEmployees();
       float allSalary = 0;
       int counter = 0;
       String encodeSurname = "";
       String specialSign = "";
       char tab [] = null;
       char sign = '*';

       for(Employee employee : list.getList()){
           allSalary = allSalary + employee.getSalary();
           counter++;
       }
       float averageSalary = allSalary / counter;

       for (Employee employee : list.getList()){
           if (employee.getSalary() < averageSalary){

               tab = new char[employee.getSurname().length()-1];
               Arrays.fill(tab, sign);
               specialSign = new String(tab);

              encodeSurname = employee.getSurname().substring(0,1) + specialSign;
               employee.setSurname(encodeSurname);
           }
       }
       updateListFile();
    }

}


