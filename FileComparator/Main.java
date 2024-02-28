package FileHandling.fileCoparatorNew;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter the path of the first file
        System.out.println("Enter The File1 path: ");
        String file1 = scanner.nextLine();

        // Prompt user to enter the path of the second file
        System.out.println("Enter The File2 path: ");
        String file2 = scanner.nextLine();

        // Check if both files have ".txt" extension
        if(file1.contains(".txt") && file2.contains(".txt")){
            // Create instances of TXTComparator for both files
            TXTComparator file_1 = new TXTComparator(file1);
            TXTComparator file_2 = new TXTComparator(file2);

            // Call the static check method of TXTComparator to compare the files
            TXTComparator.check(file_1, file_2);
        }
        // Check if both files have ".csv" extension
        else if(file1.contains(".csv") && file2.contains(".csv")){
            // Create instances of CSVcomparator for both files
            CSVcomparator file_1 = new CSVcomparator(file1);
            CSVcomparator file_2 = new CSVcomparator(file2);

            // Call the static Check method of CSVcomparator to compare the files
            CSVcomparator.Check(file_1, file_2);
        }
    }
}
