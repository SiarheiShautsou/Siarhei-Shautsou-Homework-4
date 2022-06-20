package com.sheva.util;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputInfo {

    public static String getRandomStringFromFile(String fileName) {

        String s = null;
        try (FileReader fr = new FileReader(fileName)) {

            Scanner scan = new Scanner(fr);
            List<String> names = new ArrayList<>();
            while (scan.hasNext()) {
                names.add(scan.next());
            }
            int i = (int) (Math.random() * (names.size() - 1));
            s = names.get(i);

        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException o) {
            o.printStackTrace();
        }
        return s;
    }
}
