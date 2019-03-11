package pl.com.ttpsc.kursjava;

import pl.com.ttpsc.kursjava.data.Employee;
import pl.com.ttpsc.kursjava.services.EmployeeService;

public class Main {

    public static void main(String[] args) {


        EmployeeService employeeService = new EmployeeService();

        employeeService.mainMenu();

//        System.out.println(employeeService.getList());

    }
    }
