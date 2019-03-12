package pl.com.ttpsc.kursjava.data;

import java.io.Serializable;

public class Employee implements Serializable {

    private static final long serialVersionUID = 258369158;

   private String name;
   private String surname;
   private char sex;
   private int nrBranch;
   private float salary;
   private int age;
   private int nrChildren;
   private boolean maritalStatus;

    public Employee(String name, String surname, char sex, int nrBranch, float salary, int age, int nrChildren, boolean maritalStatus) {

        String correctWrittenName = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
        String correctWrittenSurname = surname.substring(0,1).toUpperCase() + surname.substring(1).toLowerCase();
        this.name = correctWrittenName.replaceAll("\\s\\d", "");
        this.surname = correctWrittenSurname.replaceAll("\\s\\d", "");
        this.sex = sex;
        this.nrBranch = nrBranch;
        this.salary = salary;
        this.age = age;
        this.nrChildren = nrChildren;
        this.maritalStatus = maritalStatus;
    }

    public String getName() { return name; }

    public String getSurname() {
        return surname;
    }

    public void setSurname (String surname){ this.surname = surname; }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) { this.sex = sex; }

    public int getNrBranch() {
        return nrBranch;
    }

    public void setNrBranch(int nrBranch) {
        this.nrBranch = nrBranch;
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

    public int getNrChildren() {
        return nrChildren;
    }

    public void setNrChildren(int nrChildren) {
        this.nrChildren = nrChildren;
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
                ", nrBranch =" + getNrBranch() +
                ", salary =" + getSalary() +
                ", age =" + getAge() +
                ", nrChildren =" + getNrChildren() +
                ", maritalStatus =" + isMaritalStatus() +
                '}';
    }

    public String shortDisplay () {
        return "Employee{" + " name ="+getName()+", surname ="+getSurname()+", salary ="+getSalary();
    }

    public String specialDisplay (){
       return "Employee{" + " name ="+getName().toUpperCase()+", surname ="+getSurname().toUpperCase();
    }

    public String displayForWrite() {
       return getSurname()+" "+getName()+" "+ getSex()+" "+ getNrBranch()+" "+ getSalary()+" "+ getAge()+" "+ getNrChildren();
    }

    public boolean CheckingSalary (double salary){
        if (this.salary > salary){
            return true;
        } else {
            return false;
        }
    }

    public void countRise (float percent) {
        float salary = getSalary() * percent + getSalary();
        if (getNrChildren() > 0){
            salary = (float) (salary * 0.02 * getNrChildren() + salary);
        }
        if (isMaritalStatus()){
            salary = (float) (salary * 0.03 + salary);
        }
        setSalary(salary);
    }
}
