package pl.com.ttpsc.kursjava.services;

import java.io.*;

public class PropertiesService {

    private static final String FILE_NAME = "default.settings";
    static File file = new File(FILE_NAME);
    static String chosenLanguage = "";

    public static void setMenuDefaultLanguage () {
        String text = "DEFAULT LANGUAGE=en";

        if (file.exists()) {

            try(Writer writer = new FileWriter(file)){
                writer.write(text);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
           File file = new File(FILE_NAME);
            try(Writer writer = new FileWriter(file)){
                writer.write(text);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

        public static String readMenuLanguage() {

        if (file.exists()) {

            try (BufferedReader fileReader = new BufferedReader(new FileReader(file))) {
                String line = fileReader.readLine();
                String [] tab = line.split("=");
                chosenLanguage = tab[1];
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File -default.settings- doesn't exist");
        }
        return chosenLanguage;
    }

    public static void changeMenuLahguage(String str) {

        chosenLanguage = "DEFALULT LANGUAGE="+str;

        if (file.exists()){
            try(Writer writer = new FileWriter(file)) {
            writer.write(chosenLanguage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
