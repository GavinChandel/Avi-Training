package FileHandling.fileCoparatorNew;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSVcomparator {
    public String fileName;

    // Constructor to initialize the file name
    public CSVcomparator(String fileName) {
        this.fileName = fileName;
    }

    // Method to compare two CSV files and identify differences
    public static void Check(CSVcomparator file1, CSVcomparator file2) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        // Define date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
        // Format the current date-time
        String formattedDateTime = now.format(formatter);
        // Flag to track if differences are found
        boolean differencesFound = false;

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1.fileName));
             BufferedReader br2 = new BufferedReader(new FileReader(file2.fileName))) {

            String currentLine1;
            String currentLine2;
            int row = 0;

            // Read the header line of the first file and skip the header line of the second file
            String[] header = br1.readLine().split(",");
            br2.readLine();

            // Read lines from both files simultaneously until one of them reaches the end
            while ((currentLine1 = br1.readLine()) != null && (currentLine2 = br2.readLine()) != null) {
                String[] details1 = currentLine1.split(",");
                String[] details2 = currentLine2.split(",");

                // Compare corresponding data elements
                for (int i = 0; i < details1.length; i++) {
                    if (!details1[i].equals(details2[i])) {
                        differencesFound = true; // Set flag to true if differences are found
                        break;
                    }
                }
                // If differences are found, exit the loop
                if (differencesFound) {
                    break;
                }
                // Move to the next row
                row++;
            }

            // Create result file only if differences are found
            if (differencesFound) {
                try (BufferedWriter fw = new BufferedWriter(new FileWriter(formattedDateTime + "result.csv"))) {
                    fw.write("Cell,Actual File,Expected File\n");

                    // Reset file pointers to read from the beginning again
                    BufferedReader br4 = new BufferedReader(new FileReader(file1.fileName));
                    BufferedReader br5 = new BufferedReader(new FileReader(file2.fileName));
                    br4.readLine();
                    br5.readLine();

                    // Skip header line and write differences into the result file
                    while ((currentLine1 = br4.readLine()) != null && (currentLine2 = br5.readLine()) != null) {
                        String[] details1 = currentLine1.split(",");
                        String[] details2 = currentLine2.split(",");
                        for (int i = 0; i < details1.length; i++) {
                            if (!details1[i].equals(details2[i])) {
                                fw.write("Row " + row + " Col " + i + " " + header[i] + ":," + details1[i] + "," + details2[i] + "\n");
                            }
                        }
                        row++;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
