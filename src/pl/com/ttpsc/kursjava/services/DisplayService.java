package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.data.Employee;

public class DisplayService {

    EmployeeService employeeService = EmployeeService.getInstance();
    FileService fileService = FileService.getInstance();

    public void displayList () {
        for (Employee employee : fileService.readObject()){
            System.out.println(employee.shortDisplay());
        }
    }

    public void displayRemoveEmployee () {
        System.out.println("List of all employees :");
        employeeService.getList();
        employeeService.removeEmployee();
    }

    public void displayEditData() {
        System.out.println("List of all employees :");
        employeeService.getList();
        employeeService.editData();
    }

    public void displayHighestSalary() {
        System.out.println("The highest women's salary is : "+ employeeService.highestSalaryWomen());
        System.out.println("The higest men's salary is : "+ employeeService.highestSalaryMen());
    }

    public void displayRatioOfSalary() {
        System.out.println("The ratio of women's salary to men's salary is "+ employeeService.averageOfWomenSalary()+" : " +
                ""+employeeService.averageOfMenSalary());
    }

    public void displayIncreaseSalary10per() {
        employeeService.increaseSalary10per();
        System.out.println("Salaries after rise");
        System.out.println(employeeService.getList());
    }

    public void displayLongestSurname() {
        System.out.println("Employee with the longest surname is : "+ employeeService.longestSurname());
    }

    public void displayCountAverageAge() {
        System.out.println("The average age of employees who have children is : "+ employeeService.countAverageAge());
    }

    public void infoProgram (){
        System.out.println("Author : J. Kozak");
        System.out.println("Made by : Agata");
        System.out.println("Program to support organization in company");
    }
}
