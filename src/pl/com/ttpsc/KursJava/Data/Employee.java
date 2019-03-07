package pl.com.ttpsc.KursJava.Data;

public class Employee {

   private String name;
   private String surname;
   private char sex;
   private int nr_branch;
   private float salary;
   private int age;
   private int nr_children;
   private boolean maritalStatus;

    public Employee(String name, String surname, char sex, int nr_branch, float salary, int age, int nr_children, boolean maritalStatus) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.nr_branch = nr_branch;
        this.salary = salary;
        this.age = age;
        this.nr_children = nr_children;
        this.maritalStatus = maritalStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getNr_branch() {
        return nr_branch;
    }

    public void setNr_branch(int nr_branch) {
        this.nr_branch = nr_branch;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNr_children() {
        return nr_children;
    }

    public void setNr_children(int nr_children) {
        this.nr_children = nr_children;
    }

    public boolean isMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name= " + getName() + '\'' +
                ", surname ='" + getSurname() + '\'' +
                ", sex =" + getSex() +
                ", nr_branch =" + getNr_branch() +
                ", salary =" + getSalary() +
                ", age =" + getAge() +
                ", nr_children =" + getNr_children() +
                ", maritalStatus =" + isMaritalStatus() +
                '}';
    }

    public void shortDisplay () {
        System.out.println("Employee{" + " name ="+getName()+", surname ="+getSurname()+", salary ="+getSalary());
    }

    public void specialDisplay (){
        System.out.println("Employee{" + " name ="+getName().toUpperCase()+", surname ="+getSurname().toUpperCase());
    }

    public static void main(String[] args) {
        Employee employee = new Employee("kasia", "nowak", 'k', 2,1000,20,0, false);
        employee.toString();
        employee.shortDisplay();
        employee.specialDisplay();
    }

    public boolean CheckingSalary (double salary){
        if (this.salary > salary){
            return true;
        } else {
            return false;
        }
    }

    public void countRise (float percent) {
        this.salary = this.salary * percent + this.salary;
        if (this.nr_children > 0){
            this.salary = (float) (this.salary * 0.02 * this.nr_children + this.salary);
        }
        if (this.maritalStatus){
            this.salary = (float) (this.salary * 0.03 + this.salary);
        }
    }
}
