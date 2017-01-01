package io.happylrd.topk;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class TopKImpl {
    private static final String TOP_FILE_PATH = "./finaloutput/all-result.txt";
    private static final int K_VALUE = 10;

    public static void main(String[] args) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(TOP_FILE_PATH)
                    )
            );

            System.out.println("Top" + K_VALUE + " Result:");
            int readNumber = 0;
            while (scanner.hasNextLine() && readNumber < K_VALUE) {
                readNumber++;
                System.out.println("Read Number: " + readNumber +
                        "\t\tContent: " + scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
