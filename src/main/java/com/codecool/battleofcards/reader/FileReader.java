package com.codecool.battleofcards.reader;

import java.util.Scanner;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;


    /**
    * This class is used to upload Cards data from given csv file.
    **/

public class FileReader {

    /*
    * This method upload Cards data from given csv file
    * <p>This method throws a <tt>IOException</tt> if given path doesn't exist.
    *
    * @param filename name of file to open.
    * @return Card data as string
    * @throws IOException if given path doesn't exist.
    */

    public String readerFromFile(String filename) {
        StringBuilder fileContent = new StringBuilder();


        ClassLoader classLoader = getClass().getClassLoader();
        Path filePath = Paths.get(classLoader.getResource(filename).getFile());

        try (Scanner reader = new Scanner(filePath)) {
            while (reader.hasNextLine()) {
                fileContent.append(reader.nextLine());
                fileContent.append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileContent.toString();
    }
}
