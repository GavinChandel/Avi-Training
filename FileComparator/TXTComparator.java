package FileHandling.fileCoparatorNew;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TXTComparator {
    public String fileName;

    // Constructor to initialize the file name
    public TXTComparator(String name){
        this.fileName = name;
    }

    // Method to compare two text files and identify differences
    public static void check(TXTComparator file1, TXTComparator file2){
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();
        // Define date-time format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm");
        // Format the current date-time
        String formattedDateTime = now.format(formatter);
        // Flag to track if differences are found
        boolean differencesFound = false;

        try(BufferedReader br1 = new BufferedReader(new FileReader(file1.fileName));
            BufferedReader br2 = new BufferedReader(new FileReader(file2.fileName))) {

            String currentLine1;
            String currentLine2;
            int row = 0;

            // Read lines from both files simultaneously until one of them reaches the end
            while ((currentLine1 = br1.readLine()) != null && (currentLine2 = br2.readLine()) != null) {
                // Split each line into individual data elements
                String[] data1 = currentLine1.split("\s");
                String[] data2 = currentLine2.split("\s");

                // Compare corresponding data elements
                for (int i = 0; i < data1.length; i++) {
                    if (!data1[i].equals(data2[i])) {
                        differencesFound = true;
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

            // If differences are found, create a result file to store them
            if (differencesFound) {
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(formattedDateTime + "result.txt"))) {
                    bw.write("Index" + "\t"+"\t" + "ActualFile" + "\t"+"\t" + "Expected File"+"\n");
                    BufferedReader br3 = new BufferedReader(new FileReader(file1.fileName));
                    BufferedReader br4 = new BufferedReader(new FileReader(file2.fileName));

                    // Read lines from both files again to write differences into the result file
                    while ((currentLine1=br3.readLine())!=null && (currentLine2= br4.readLine())!=null){
                        String[] data1 = currentLine1.split(" ");
                        String[] data2 = currentLine2.split(" ");
                        for(int i=0; i< data1.length; i++){
                            if(!data1[i].equals(data2[i])){
                                // Write row and column numbers along with differing data elements
                                bw.write("Row"+(row-1)+" Col "+i+"\t "+data1[i]+"\t"+"\t"+"\t"+data2[i]+"\n");
                            }
                        }
                        row++;
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }
}
