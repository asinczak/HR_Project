package pl.com.ttpsc.kursjava.services;

import pl.com.ttpsc.kursjava.data.Employee;

import java.io.*;
import java.util.List;

public class FileService {

    private static final String BASE_FILE = "base.dat";

    public void writeObject (List <Employee> list) {

        String fileName = BASE_FILE;
        File f = new File(fileName);

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

        try (FileInputStream file = new FileInputStream(new File("base.dat"));){
            try (ObjectInputStream input = new ObjectInputStream(file);){

                listFromFile = (List<Employee>) input.readObject();

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listFromFile;
    }

}
