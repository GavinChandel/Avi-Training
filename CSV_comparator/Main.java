package FileHandling.fileCoparatorNew;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter The File1 path: ");
        String file1 = scanner.nextLine();
        System.out.println("Enter The File2 path: ");
        String file2 = scanner.nextLine();
        CSVcomparator file_1 = new CSVcomparator(file1);
        CSVcomparator file_2 = new CSVcomparator(file2);


        CSVcomparator.Check(file_1,file_2);

    }
}