package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.data.Employee;
import pl.com.ttpsc.kursjava.data.Employees;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;
import java.util.List;

public final class FileService {

    private final static FileService fileService = new FileService();

    private FileService () {}

    public static FileService getInstance(){
        return fileService;
    }

    File f;
    private static final String BASE_FILE = "base.dat";
    private static final String TABLE_FILE = "employees.html";

    public void writeObject (List <Employee> list) {

        String fileName = BASE_FILE;
         f = new File(fileName);

        try (FileOutputStream file =new FileOutputStream(new File(fileName))){
            if(f.isFile());
                try (ObjectOutputStream obj = new ObjectOutputStream(file)) {
                    obj.writeObject(list);

                } catch(FileNotFoundException e){
                e.printStackTrace();
            }

            } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List <Employee> readObject () {

        List <Employee> listFromFile = null;
        File fileCheck = new File(BASE_FILE);

        try (FileInputStream file = new FileInputStream(fileCheck)){
            if (fileCheck.exists()) {
                try (ObjectInputStream input = new ObjectInputStream(file)) {

                    listFromFile = (List<Employee>) input.readObject();

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            } else {
                try (FileOutputStream NewFile =new FileOutputStream(new File(BASE_FILE))){


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFromFile;
    }

    public void createTable()  {

        try(PrintWriter pw = new PrintWriter(new FileWriter(TABLE_FILE))) {

            pw.println("<TABLE>\n<TR><TH>Surname\t<TH>Name\t<TH>Sex\t<TH>NrBranch\t<TH>Salary\t<TH>Age\t</TR>");

            for (Employee employee : readObject()){
                pw.println("\t<tr><TD>"+employee.getSurname()+"\t<TD>"+employee.getName()+"\t<TD>"+employee.getSex()+"\t<TD>"+
                        employee.getNrBranch()+"\t<TD>"+employee.getSalary()+"\t<TD>"+employee.getAge()+"<TD>");
            }
            pw.println("</TABLE>");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeFileName (String nameFile) {
        f = new File("base.dat");
        if(f.exists()){
            f.renameTo(new File(nameFile));
        }
    }

    public void writeToXMLfile () {

        File file = new File("EmployeesList.xml");

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Employees.class);
            Marshaller marshaller = jaxbContext.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            Employees employees = new Employees();
            marshaller.marshal(employees, file);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
