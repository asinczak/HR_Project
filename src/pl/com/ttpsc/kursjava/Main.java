package pl.com.ttpsc.kursjava;

import pl.com.ttpsc.kursjava.data.Employee;
import pl.com.ttpsc.kursjava.services.EmployeeService;

public class Main {

    public static void main(String[] args) {

        Employee employee1 = new Employee("jan", "kowalski", 'm',2,2000,30,0,false);
        Employee employee2 = new Employee("kasia", "motyl",'k',3,3000,35,1,true);

        EmployeeService employeeService = new EmployeeService();
        employeeService.addEmployee(employee1);
        employeeService.addEmployee(employee2);

        employeeService.getList();

        Employee employee3 = new Employee("tomasz", "góra",'m',3,5000,40,3,true);
        employeeService.addEmployee(employee3);

        employeeService.getList();



        employeeService.removeEmployee();
        employeeService.getList();





    }
}
