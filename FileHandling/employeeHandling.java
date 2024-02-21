package FileHandling;

//importing the necessary packages
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

//main class
public class employeeHandling {
    public static void main(String[] args) {
        String filename = "C:\\Users\\chand\\OneDrive\\Desktop\\aviSoft\\src\\FileHandling\\employees.csv"; // file from which data is being read
        String newFile = "C:\\Users\\chand\\OneDrive\\Desktop\\aviSoft\\src\\FileHandling\\demo.csv"; //new file which will be created after sorting
        int totalSalary = 0; // total salary variable
        int count = 0; //count of the total number of employees
        List<String[]> aboveAverageSalaries = new ArrayList<>();//an arraylist to store the desired target entries

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) { //importing the buffered reader object
            String line;//a string variable to perform the reading function
            while ((line = br.readLine()) != null) {//while the string variable is not null,
                String[] fields = line.split(",");//create a new string array
                if(fields.length>8 && !fields[7].equals("-")){//salary is on the 7th column of the dataset
                    int salary = Integer.parseInt(fields[7]);//taking the salary input from every entry
                    totalSalary+=salary;//adding the current salary to the total salary variable
                    count++;//incrementing the count by one, everytime a new entry is read
                }
            }
        } catch (IOException e) {//handling the IOException
            e.printStackTrace();
        }



        double avgSalary = (double)totalSalary/count;//calculating the average salary for the dataset
        System.out.println("Average salary: "+avgSalary);//printing the average salary for the dataset


        //this is to further compare all the entries' salary with the average salary computed, so in order to sort them accordingly
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(newFile))) {//implementing a new buffered writer object
            bw.write("Employee Name,Employee Salary");//creating the headers for the new file namely, "employee name" and "employee salary"
            bw.newLine();//entering a new line

            try (BufferedReader br = new BufferedReader(new FileReader(filename))) {//creating a new buffered reader object to read the target variables from the list created earlier
                String line;//declaring a string variable
                while ((line = br.readLine()) != null) {//while the string variable is not null
                    String[] fields = line.split(",");//creating a new string array, with the delimiter set to a comma(',')
                    if (fields.length >= 8 && !fields[7].equals("-")) {//if salary variable for that entry is not null
                        int salary = Integer.parseInt(fields[7]);//create a salary variable for comparison with average salary computed earlier
                        if (salary > avgSalary) {
                            aboveAverageSalaries.add(new String[]{fields[1] + " " + fields[2], String.valueOf(salary)});//add the current entry into the targets arraylist
                        }
                    }
                }
                for (String[] entry : aboveAverageSalaries) {//for each loop utilised for every entry in the targets list
                    bw.write(entry[0]);//write the first name and last name
                    bw.write(',');//separate them using a comma for a CSV file format
                    bw.write(entry[1]);//write the salary respective to that particular entry in the CSV file
                    bw.newLine();//inserting a new line after every entry
                }
            }
        } catch (IOException e) {//catching the IOException
            System.out.println(e.getMessage());
        }
    }
}

