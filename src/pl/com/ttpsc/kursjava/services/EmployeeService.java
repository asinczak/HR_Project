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

    List<Employee> list = new ArrayList<>();
    FileService fileService = FileService.getInstance();
    MenuService menuService = MenuService.getInstance();

   public List <Employee> getList () {
      return fileService.readObject();
   }

     void updateListFile() {
        fileService.writeObject(list);
    }

    public void addEmployee (Employee employee){
       list = getList();
        list.add(employee);
        updateListFile();
    }

    public void removeEmployee () {
       list = getList();
        Employee employeeToRemove = null;

        Scanner sc = new Scanner(System.in);
        do {
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
                    System.out.println("You've entered wrong data. Please try again");
                }

        } while (true);
    }

    public void editData ( ) {

        Employee employeeToEdit = null;

        do {
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
                    System.out.println("You've entered wrong data. Please try again");
                }

            } while (true);
        }

    public int countNumberOfEmp(float givenSalary) {
        list = getList();
        int counter = 0;
        for(int i = 0; i<list.size(); i++){
            if (list.get(i).getSalary() > givenSalary){
                counter++;
            }
        }
        return counter;
    }

    public float countAverageSalary(int branch) {
        list = getList();
       int counter = 0;
       float allSalary = 0;

       for(int i = 0; i<list.size(); i++){
           if(list.get(i).getNrBranch() == branch){
               float salary = list.get(i).getSalary();
               allSalary = allSalary + salary;
               counter++;
           }
       }
        float averageSalary = allSalary / counter;

        return averageSalary;
    }

    public float highestSalaryWomen() {
        list = getList();
       float highSalaryWomen = 0;

       for(int i = 0; i<list.size(); i++){
           float salary = list.get(i).getSalary();
           if (list.get(i).getSex() == 'k'){
               if(highSalaryWomen < salary) {
                   highSalaryWomen = salary;
                    }
               }
           }
        return highSalaryWomen;
    }

    public float highestSalaryMen (){
       list = getList();
        float highSalaryMen = 0;

        for(int i = 0; i<list.size(); i++) {
            float salary = list.get(i).getSalary();
            if (list.get(i).getSex() == 'm') {
                if (highSalaryMen < salary) {
                    highSalaryMen = salary;
                }
            }
        }
        return highSalaryMen;
    }

    public float averageOfWomenSalary() {
       list = getList();
       float allWomenSalary = 0;
       int counterWomen = 0;
        float salary = 0;

       for (int i = 0; i < list.size(); i++){
           salary = list.get(i).getSalary();
           if (list.get(i).getSex() == 'k'){
               allWomenSalary = allWomenSalary + salary;
               counterWomen++;
           }
       }

        float averageWomenSalary = allWomenSalary / counterWomen;
       return averageWomenSalary;
    }

    public float averageOfMenSalary (){
       list = getList();
        float allMenSalary = 0;
        int counterMen = 0;
        float salary = 0;

        for (int i = 0; i < list.size(); i++){
            salary = list.get(i).getSalary();
            if (list.get(i).getSex() == 'k'){
                allMenSalary = allMenSalary + salary;
                counterMen++;
            }
        }

        float averageMenSalary = allMenSalary / counterMen;
        return averageMenSalary;
    }

    public void increaseSalary10per() {
       list = getList();

       for(Employee employee : list){
           employee.countRise(0.10f);
       }
       updateListFile();
    }

    public String increaseSalaryByAmount(float amount) {
       list = getList();

       int counterWomen = 0;
       int counterMen = 0;
       float salaryAfterRise = 0;
       for (Employee employee : list){
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
       list = getList();
       if (howSort){
           Collections.sort(list, new EmplyeeSurnameComparator());
       } else {
           Collections.sort(list, new EmplyeeSurnameComparator());
           Collections.reverse(list);
       }
       updateListFile();
    }

    public void sortForSalary(boolean howSort) {
        list = getList();
        if (howSort){
            Collections.sort(list, new EmployeeSalaryComparator());
        } else {
            Collections.sort(list, new EmployeeSalaryComparator());
            Collections.reverse(list);
        }
        updateListFile();
    }



    public String longestSurname() {
       list = getList();
       String theLongestSurname = "";

       for (Employee employee : list){
           if(theLongestSurname.length() < employee.getSurname().length()){
               theLongestSurname = employee.getSurname();
           }
       }
        return theLongestSurname;
    }

    public int countAverageAge() {
       list = getList();
       int counter = 0;
       int sumAge = 0;
       for(Employee employee : list){
           if (employee.getNrChildren() > 0){
               sumAge = sumAge + employee.getAge();
               counter++;
           }
       }
       int averageAge = sumAge / counter;
       return averageAge;
    }

    public void encodeData() {
       list = getList();
       float allSalary = 0;
       int counter = 0;
       String encodeSurname = "";
       String specialSign = "";
       char tab [] = null;
       char sign = '*';

       for(Employee employee : list){
           allSalary = allSalary + employee.getSalary();
           counter++;
       }
       float averageSalary = allSalary / counter;

       for (Employee employee : list){
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


