package io.happylrd.datagen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class DataGenerator {
    private static final String DATA_FILE_PATH = "./input/data.txt";
    private static final int RANDOM_UPPER_BOUND = 100000;

    private void generate(String filePath, int numberUpperBound) {
        File file = new File(filePath);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);
            for (int i = 0; i < numberUpperBound; i++) {
                int randomInt = (int) (1 + Math.random() * numberUpperBound);
                writer.println(randomInt);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.close();
                System.out.println("Generate data finished.");
            }
        }
    }

    public static void main(String[] args) {
        DataGenerator generator = new DataGenerator();
        generator
                .generate(DATA_FILE_PATH, RANDOM_UPPER_BOUND);
    }
}
