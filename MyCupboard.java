import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MyCupboard {

    String inputFile = "input.txt";
    String outputFile = "output.txt";

    // Inserting clothes into the file according to alphabetical order
    public void insert() {
        File input = new File(inputFile);
        File output = new File(outputFile);

        try (Scanner inputScanner = new Scanner(input); Scanner outputScanner = new Scanner(output)) {
            // Read color and type from input file
            String color = inputScanner.next().trim().toLowerCase();
            String type = inputScanner.next().trim().toLowerCase();
            int asciiCode = color.charAt(0); // ASCII code of the first character of color
            int numLines = 26; // Number of lines to read from the output file
            ArrayList<String> lines = new ArrayList<>(); // List to store lines from output file

            System.out.println("ASCII code of the first character of color: " + asciiCode);

            try {
                // Read lines from the output file
                while (numLines > 0) {
                    String line = outputScanner.nextLine();
                    lines.add(line);
                    numLines--;
                }

                // Modify the appropriate line based on asciiCode
                String existingLine = lines.get(asciiCode - 97);
                String contentWithoutBrackets = existingLine.substring(1, existingLine.length() - 1);
                String newClothEntry = "[" + color + "," + type + "]";
                lines.set(asciiCode - 97, "[" + contentWithoutBrackets + newClothEntry + " ]");

                // Write modified lines back to the output file
                try (PrintWriter writer = new PrintWriter(output)) {
                    for (int i = 0; i < lines.size(); i++) {
                        if (i != lines.size() - 1) {
                            writer.println(lines.get(i));
                        } else {
                            writer.print(lines.get(i));
                        }
                    }
                }

            } catch (NoSuchElementException e) {
                System.out.println("Error: NoSuchElementException occurred while reading the output file.");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: Input or output file not found.");
            e.printStackTrace();
        }
    }

    // Searching for clothes in the file
    public void search(String color, String type) {
        File file = new File(outputFile);
        try (Scanner reader = new Scanner(file)) {

            // Remove trailing spaces and convert to lower case
            String searchColor = color.trim().toLowerCase();
            String searchType = type.trim().toLowerCase();
            int linesToSkip = searchColor.charAt(0) - 97;

            while (linesToSkip > 0) {
                reader.nextLine();
                linesToSkip--;
            }

            String colorLine = reader.nextLine();
            String lineContent = colorLine.substring(1, colorLine.length() - 1);

            // Check if the line is empty after removing brackets
            if (lineContent.equals("")) {
                System.out.println("No clothes exist with this color. Search for others.");
                return;
            }

            String[] clothesArray = lineContent.split(" ");
            int count = 0;

            for (String cloth : clothesArray) {
                // Remove first and last bracket
                String clothDetails = cloth.substring(1, cloth.length() - 1);
                // Split the color and type
                String[] details = clothDetails.split(",");

                if (details[0].equals(searchColor) && details[1].equals(searchType)) {
                    System.out.println(Arrays.toString(details));
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Sorry! You don't have " + color + " " + type);
            } else {
                System.out.println("You have " + count + " " + color + " " + type);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Output file doesn't exist.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyCupboard cupboard = new MyCupboard();
        cupboard.insert();
        Scanner scanner = new Scanner(System.in);

        try {
            // Taking input color and type from the user to be searched
            System.out.println("Enter the color:");
            String color = scanner.next();
            System.out.println("Enter the type: shirt or pant:");
            String type = scanner.next();

            // Searching for cloth with the specified color and type
            cupboard.search(color, type);

        } catch (NoSuchElementException e) {
            System.out.println("Error occurred while taking input:");
            e.printStackTrace();

        } finally {
            scanner.close();
        }
    }
}
