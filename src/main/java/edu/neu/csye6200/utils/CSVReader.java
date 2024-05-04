package edu.neu.csye6200.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVReader {
    public static Map<String,String> loginAuth() {
        Map<String,String> UserPass = new HashMap<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("src/main/java/edu/neu/csye6200/res/PassengerList.csv"));
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] fields = input.split(",");
                UserPass.put(fields[2], fields[3]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return UserPass;
    }

    public static void addToCSV(StringRes file, String data) {
        String filePath = getFilePath(file);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
            // Append data to the file
            writer.write("\n" + data);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editPassengerCSV (List<Passengers> data) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Passengers passengers: data) {
                stringBuilder.append(passengers.toString()+"\n");
            }
            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("src/main/java/edu/neu/csye6200/res/PassengerList.csv", false));
            // Append data to the file
            writer.write(stringBuilder.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void editFlightCSV(StringRes file, List<Flight> data) {
        String filePath = getFilePath(file);
        try {
            StringBuilder stringBuilder = new StringBuilder();
            for (Flight passengers: data) {
                stringBuilder.append(passengers.toString()+"\n");
            }
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false));
            // Append data to the file
            writer.write(stringBuilder.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readCSV (StringRes file) {
        String filePath = getFilePath(file);
        List<String> csvList = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader(filePath));
            String input;
            while ((input = bufferedReader.readLine()) != null) {
                csvList.add(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvList;
    }

    private static String getFilePath(StringRes file) {
        String filePath;
        if (file == StringRes.PASSENGERS) {
            filePath = "src/main/java/edu/neu/csye6200/res/PassengerList.csv";
        } else if (file == StringRes.INTERNATIONAL) {
            filePath = "src/main/java/edu/neu/csye6200/res/InternationalList.csv";
        } else if (file == StringRes.DOMESTIC) {
            filePath = "src/main/java/edu/neu/csye6200/res/DomesticList.csv";
        } else {
            filePath = "src/main/java/edu/neu/csye6200/res/BookingList.csv";
        }
        return filePath;
    }
}
