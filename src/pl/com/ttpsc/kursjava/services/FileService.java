package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.data.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    public void writeObject (List <Employee> list) {
        String fileName = "base.dat";
        File f = new File(fileName);

            FileOutputStream file = null;
            try {
                    if(f.isFile()) {
                        file = new FileOutputStream(new File(fileName));
                    }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        try {
            ObjectOutputStream obj = new ObjectOutputStream(file);
            obj.writeObject(list);



            obj.close();
            file.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void readObject () {

        try {
            FileInputStream file = new FileInputStream(new File("base.dat"));
            ObjectInputStream input = new ObjectInputStream(file);

            try {
                List <Employee> listFromFile = new ArrayList<>();

                   listFromFile = (List<Employee>) input.readObject();
                   for (Employee employee : listFromFile){
                       System.out.println(employee.displayForWrite());
                   }

                input.close();
                file.close();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
