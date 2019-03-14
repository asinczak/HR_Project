package pl.com.ttpsc.kursjava.services;

import java.io.*;

public class PropertiesService {



    public static void setMenuLanguage() {
        FileService fileService = FileService.getInstance();
        File file = new File("default.settings");

        if (file.exists()) {

            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                String line = fileReader.readLine();
                String [] tab = line.split("=");
                if (tab [1] == "en") {
                    fileService.readInEng();
                }
                if (tab [1] == "pl") {
                    fileService.readInPl();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("File doesn't exist");

        }
    }
}
