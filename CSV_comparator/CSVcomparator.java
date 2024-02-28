package FileHandling.fileCoparatorNew;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CSVcomparator {
    public String fileName;

    public CSVcomparator(String fileName) {
        this.fileName = fileName;
    }

    public static void Check(CSVcomparator file1, CSVcomparator file2) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss-SSS");
        String formattedDateTime = now.format(formatter);
        boolean differencesFound = false; // Flag to track if differences are found

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1.fileName));
             BufferedReader br2 = new BufferedReader(new FileReader(file2.fileName))) {

            String currentLine1;
            String currentLine2;
            int row = 0;

            String[] header = br1.readLine().split(",");
            br2.readLine();

            while ((currentLine1 = br1.readLine()) != null && (currentLine2 = br2.readLine()) != null) {
                String[] details1 = currentLine1.split(",");
                String[] details2 = currentLine2.split(",");

                for (int i = 0; i < details1.length; i++) {
                    if (!details1[i].equals(details2[i])) {
                        differencesFound = true; // Set flag to true if differences are found
                        break;
                    }
                }
                if (differencesFound) {
                    break; // Exit loop if differences are found
                }
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

                    // Skip header line
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
