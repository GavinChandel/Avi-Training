package DistributedFileSystem;

import java.util.HashMap;
import java.util.Map;

// Class representing a file in the distributed file system
class File {
    private String fileName; // Name of the file
    private int fileSize;    // Size of the file in bytes
    private boolean isReplicated; // Flag indicating whether the file is replicated

    // Constructor to initialize file attributes
    File(String name, int size, boolean replicated) {
        this.fileName = name;
        this.fileSize = size;
        this.isReplicated = replicated;
    }

    // Getters and setters for file attributes
    public String getFileName() {
        return fileName;
    }

    public int getFileSize() {
        return fileSize;
    }

    public boolean getReplicated() {
        return isReplicated;
    }

    public void setReplicated(boolean replicated) {
        this.isReplicated = replicated;
    }
}

// Custom exception class for Distributed File System exceptions
class DFSException extends Exception {
    // Constructor to initialize exception message
    public DFSException(String message) {
        super(message);
    }
}

// Class representing a server in the distributed file system
class Server {
    private int serverId; // Unique identifier for the server
    Map<String, File> files; // Map to store files with their names as keys

    // Constructor to initialize server attributes
    Server(int id) {
        this.serverId = id;
        this.files = new HashMap<>(); // Initialize files map
    }

    // Method to check if a file exists on the server
    public boolean fileExists(String fileName) {
        // Check if the files map contains the given file name
        return files.containsKey(fileName);
    }

    // Method to upload a file to the server
    public void uploadFile(File file) {
        try {
            // Check if the file already exists on the server
            if (files.containsKey(file.getFileName())) {
                // Throw a DFSException if the file already exists
                throw new DFSException("File with the file Name : " + file.getFileName() + " already exists in the server..!!");
            }
            // Add the file to the files map
            files.put(file.getFileName(), file);
        } catch (DFSException e) {
            // Catch and handle the DFSException by printing the error message
            System.out.println(e.getMessage());
        }
    }

    // Method to download a file from the server
    public void downloadFile(String fileName) {
        try {
            // Check if the file exists on the server
            if (!files.containsKey(fileName)) {
                // Throw a DFSException if the file doesn't exist
                throw new DFSException("File with the file name : " + fileName + " doesn't exist in the server..!!");
            }
            // If the file exists, print a message indicating that the file is being downloaded
            System.out.println("Downloading the file..!!");
            // Print a message indicating that the file has been downloaded successfully
            System.out.println("File Downloaded..!!");
        } catch (DFSException e) {
            // Catch and handle the DFSException by printing the error message
            System.out.println(e.getMessage());
        }
    }

}

public class DistributedFileSystem {
    public static void main(String[] args) {
        // Create a server
        Server server = new Server(1);

        // Create files
        File file1 = new File("file1.txt", 1024, true);
        File file2 = new File("file2.txt", 2048, false);

        // Upload files to the server
        server.uploadFile(file1);
        server.uploadFile(file2);

        // Try to upload file1 again (it should fail)
        server.uploadFile(file1);

        // Download files from the server
        server.downloadFile("file1.txt");
        server.downloadFile("file3.txt"); // Try downloading a non-existent file

        // Set file2 as replicated
        file2.setReplicated(true);

        // Upload file2 again (it should succeed this time)
        server.uploadFile(file2);
    }
}
