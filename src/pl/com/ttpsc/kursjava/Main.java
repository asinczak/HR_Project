package pl.com.ttpsc.kursjava;

import pl.com.ttpsc.kursjava.data.Employee;
import pl.com.ttpsc.kursjava.services.EmployeeService;
import pl.com.ttpsc.kursjava.services.FileService;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee("jan", "kowalski", 'm',2,2000,30,0,false);
        Employee employee2 = new Employee("kasia", "motyl",'k',3,3000,35,1,true);
        FileService fileService = new FileService();
        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);


        fileService.writeObject(employeeService.getList());
        fileService.readObject();


        employeeService.removeEmployee();
        employeeService.shortDisplayList();
        fileService.readObject();



    }
}
