package a;

import java.io.*;
import java.util.Scanner;

public class FileOperations {

    static final String FILE_NAME = "internship_certificate.txt";

    // Function to write initial content to the file
    public static void writeToFile(String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            writer.write(content);
            System.out.println("✅ Content written to file successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Function to read content from the file
    public static void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            System.out.println("\n📂 File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Function to append new content to the file
    public static void appendToFile(String newContent) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.newLine(); // Go to new line before appending
            writer.write(newContent);
            System.out.println("✅ Content appended to file successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error appending to file: " + e.getMessage());
        }
    }

    // Main function to demonstrate file operations
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initial content
        String initialContent = """
                CREATE A JAVA PROGRAM TO READ,
                WRITE, AND MODIFY TEXT FILES.

                COMPLETION CERTIFICATE WILL BE
                ISSUED ON YOUR INTERNSHIP

                END DATE .

                CODTECH

                INSTRUCTIONS :
                FILE HANDLING

                UTILITY

                DELIVERABLE: A SCRIPT
                DEMONSTRATING FILE OPERATIONS
                WITH CLEAR DOCUMENTATION.
                """;

        // 1. Write initial content to file
        writeToFile(initialContent);

        // 2. Read the file
        readFromFile();

        // 3. Ask user for modification
        System.out.println("\n📝 Enter additional line to append:");
        String newLine = sc.nextLine();

        // 4. Append content
        appendToFile(newLine);

        // 5. Read updated content
        readFromFile();

        sc.close();
    }
}

