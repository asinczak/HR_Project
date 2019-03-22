package pl.com.ttpsc.kursjava.data;

import pl.com.ttpsc.kursjava.services.EmployeeService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement (name = "Employee")
@XmlAccessorType (XmlAccessType.FIELD)
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

   public Employee () {}

    public Employee(String name, String surname, char sex, int nrBranch, float salary, int age, int nrChildren, boolean maritalStatus) {
        this.name = EmployeeService.enterDataCorrectly(name);
        this.surname = EmployeeService.enterDataCorrectly(surname);
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

}
