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


}
