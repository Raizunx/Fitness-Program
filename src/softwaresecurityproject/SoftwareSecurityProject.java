
package softwaresecurityproject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Razan
 */


// Main Class Original
public class SoftwareSecurityProject {

    final static int maxAge = 85;
    final static int minAge = 5;
        
    public static void main(String[] args) {
        
        //check if file exist or need to be created
        initializeFile();
        Scanner input = new Scanner(System.in);
        int choice;
        //access value set to true if user login or regester is correct
        boolean access = false;
        int attempts = 0;

        System.out.println("------------------------------------------");
        System.out.println("Welcome To Your Fitness Program ! :)");
        System.out.println("------------------------------------------");
        
        // Menu loop for Register, Login, and Exit options
        do {
            //call getUserInput method to check that input is valid input 
            choice = getUserInput("Please select:: \n1- Register\n2- Login\n3- Exit", "[1-3]", input);

            switch (choice) {
                case 1:
                    access = registerUser(input);
                    break;
                case 2:
                    access = loginUser(input);
                    break;
                case 3:
                    System.exit(0);    
                default:
                    System.out.println("\nInvalid choice. Try again\n");
            }
            
            //user attempts to login increase each time
            attempts++;
            
            //check user attempts to log in to system to terminate when needed
            if (attempts >= 3){
                System.out.println("Maximum login attempts reached. Exiting...");
                System.exit(0);  
            }
            
        } while (access == false);
    
        //ArrayList object will contain an object from the chosen Fitness Plan Category that include the user info entered 
        ArrayList<FitnessPlan> plans = new ArrayList<>();

        // Get user input for fitness level
        int level = getUserInput("Enter your fitness level: \n1- Beginner\n2- Intermediate\n3- Advanced", "[1-3]", input);

        // Get user input for age
        int age = getUserInput("Enter your age:", "\\d+", minAge, maxAge, input);

        // Get user input for surgery
        int surgery = getUserInput("Have you had any surgery recently? \n1- Yes\n2- No", "[1-2]", input);

        // Get user input for illness
        int illness = getUserInput("Do you suffer from any illnesses? \n1- Heart\n2- Joint\n3- Lung\n4- Other\n5- None", "[1-5]", input);

        do{
        // Ask for user fitness goals
        choice = getUserInput("Select your fitness goal:\n1- Cardio\n2- Strength Training\n3- Flexibility\n4- Yoga\n5- HIIT\n6- Exit(High-Intensity Interval Training)", "[1-6]", input);
        System.out.print("\n");

        // Create the appropriate fitness plan based on user input
        switch (choice) {
            case 1:
                //Cardio
                plans.add(new Cardio(level, illness, surgery, age) {});
                break;
            case 2:
                //Strength Training
                plans.add(new StrengthTraining(level, illness, surgery, age) {});
                break;
            case 3:
                //Flexibility
                plans.add(new Flexibility(level, illness, surgery, age) {});
                break;
            case 4:
                //Yoga
                plans.add(new Yoga(level, illness, surgery, age) {});
                break;
            case 5:
                //HIIT (High-Intensity Interval Training)
                plans.add(new HIIT(level, illness, surgery, age) {});
                break;
            case 6:
                //close the system
                System.exit(0);
                break;
            default:
                System.out.println("Invalid goal choice.");
                break;
        }

        // Execute the recommendPlan() method for last selected plan
        if (!plans.isEmpty()) {
                plans.get(plans.size() - 1).recommendPlan();
        }
        
        } while (choice != 6);

        //close reading more inputs
        input.close();
    }
    
    //overload method
    //get a valid user input
    public static int getUserInput(String message, String regex, Scanner input) {
        int userInput;
        do {
            //print message & get input from user
            System.out.println("\n"+ message);
            String inputStr = input.next();
            
            //check if input is only 1 character
            if (inputStr.length() == 1) {
                
                //check if input matches the regex 'specefied gevien pattern'
                if (inputStr.matches(regex)) {
                    //parse string to integer and break
                    userInput = Integer.parseInt(inputStr);
                    System.out.println("------------------------------------------");
                    break;
                } 
                else{
                    System.out.println("Please choose a number from the menue.\n");
                    System.out.println("------------------------------------------");
                }
            }
            //wrong input, repeat while loop
            else {
                System.out.println("Invalid input. Please try again to choose a number from the menue.\n");
                System.out.println("------------------------------------------");
            }
        } while (true);
        
        return userInput;
    }
    
    //overload method
    //get a valid user age input
    public static int getUserInput(String message, String regex, int minAge, int maxAge, Scanner input) {
    int userInput;
    do {
        //print message & get input from user
        System.out.println("\n"+message);
        String inputStr = input.next();
        
        //check if input is only 1 character
        if (inputStr.length() == 1 || inputStr.length() == 2) {

            //check if input matches the regex 'specefied gevien pattern'
            if (inputStr.matches(regex)) {
                
                //parse string to integer and compare if age in specefied range then break
                userInput = Integer.parseInt(inputStr);
                if (userInput >= minAge && userInput <= maxAge) {
                    System.out.println("------------------------------------------");
                    break;
                } 
                //age out of specefied range 
                else {
                    System.out.println("Please enter a valid age within the range " + minAge + " and " + maxAge + ".\n");
                    System.out.println("------------------------------------------");
                }
            } 
            //wrong input, repeat while loop
            else {
                System.out.println("Invalid age. Please enter a valid age number.\n");
                System.out.println("------------------------------------------");
            }
        }
        //age is not forming from 1 or 2 numbers
        else {
            System.out.println("Invalid age. Please enter a valid age number.\n");
            System.out.println("------------------------------------------");
        }
    } while (true);
    
    return userInput;
    }

    //check user entreis for username and password and write them to the file
    private static boolean registerUser(Scanner input) {
        String username = "";
        String password = "";

        while (true) {
            System.out.print("Enter username (4-20 characters): ");
            username = input.next();

            //username not correct
            if (username.isEmpty() || username.length() < 4 || username.length() > 20) {
                System.out.println("Invalid username. Please try again.");
            } else if (isUsernameTaken(username)) { //user name have been taken by another user
                System.out.println("Username already exists. Please choose a different username.");
            }else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter password (8-20 characters): ");
            password = input.next();

            //password not correct
            if (password.isEmpty() || password.length() < 8 || password.length() > 20) {
                System.out.println("Invalid password. Please try again.");
            }else {
                break;
            }
        }

        // Hash the user's password
        String hashedPassword = hashPassword(password);

        // Try to open a BufferedWriter for writing to "users.txt" file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            // Write username and hashed password to the file
            writer.write(username + ":" + hashedPassword + "\n");
            System.out.println("Registration successful!");
            return true;
        } catch (IOException e) {
            // Handle IO exception if occurred during file writing
            System.out.println("Error writing to file: " + e.getMessage());
        }
        
        //user entres is not good
        return false;
    }

    //check user entreis for username and password and compare them to the file
    private static boolean loginUser(Scanner input) {
        System.out.print("Enter username: ");
        String username = input.next();

        System.out.print("Enter password: ");
        String password = input.next();
        String hashedPassword = hashPassword(password);

        // Try to open a BufferedReader to read from the "users.txt" file
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            // Initialize variables for reading lines and tracking login success
            String line;
            boolean loginSuccessful = false;
            
            // Read lines from the file until the end of file is reached
            while ((line = reader.readLine()) != null) {
                // Split the line into parts based on the ":" delimiter
                String[] parts = line.split(":");
                // Check if the line contains username and hashed password matching the input
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(hashedPassword)) {
                    loginSuccessful = true;
                    break;
                }
            }

            if (loginSuccessful) {
                System.out.println("Login successful!");
                return true;
            }else {
                System.out.println("Invalid username or password.");
            }
            
        } catch (IOException e) {
            // Handle IO exception if occurred during file reading
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return false;
    }
    
    //check if user are trying to get a taken username and prevent that
    private static boolean isUsernameTaken(String username) {
        
        // Try to open a BufferedReader to read from the "users.txt" file
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            
            // Read lines from the file until the end of file is reached
            while ((line = reader.readLine()) != null) {
                // Split the line into parts based on the ":" delimiter
                String[] parts = line.split(":");
                // Check if the line contains the username in the first part
                if (parts.length > 0 && parts[0].equals(username)) {
                    // Return true if the username is found in the file
                    return true;
                }
            }
        } 
        catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return false;
    }
    
    //check the availability of the file to create it or it is exist
    private static void initializeFile() {
        File file = new File("users.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException e) {
                System.out.println("An error occurred while creating the file: " + e.getMessage());
            }
        }
    }
    
    // Method to hash a given password using the SHA-256 algorithm
    private static String hashPassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256 hashing
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Generate the hashed bytes from the password bytes
            byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Build a hexadecimal representation of the hashed bytes
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            // Return the hashed password as a string
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e) {
            // Handle NoSuchAlgorithmException by throwing a runtime exception
            throw new RuntimeException("Hashing algorithm not found.", e);
        }
    }
    
}


/*
// Main Class For Test Cases Result
public class SoftwareSecurityProject {

    final static int maxAge = 85;
    final static int minAge = 5;
        
    public static void main(String[] args) {
        
        //check if file exist or need to be created
        initializeFile();
        Scanner input = new Scanner(System.in);
        int choice;
        //access value set to true if user login or regester is correct
        boolean access = false;
        int attempts = 0;

        System.out.println("------------------------------------------");
        System.out.println("Welcome To Your Fitness Program ! :)");
        System.out.println("------------------------------------------");
        
        // Menu loop for Register, Login, and Exit options
        do {
            //call getUserInput method to check that input is valid input 
            choice = getUserInput("Please select:: \n1- Register\n2- Login\n3- Exit", "[1-3]", input);

            switch (choice) {
                case 1:
                    access = registerUser(input);
                    break;
                case 2:
                    access = loginUser(input);
                    break;
                case 3:
                    System.exit(0);    
                default:
                    System.out.println("\nInvalid choice. Try again\n");
            }
            
            //user attempts to login increase each time
            attempts++;
            
            //check user attempts to log in to system to terminate when needed
            if (attempts >= 3){
                System.out.println("Maximum login attempts reached. Exiting...");
                System.exit(0);  
            }
            
        } while (access == false);
    
        //ArrayList object will contain an object from the chosen Fitness Plan Category that include the user info entered 
        ArrayList<FitnessPlan> plans = new ArrayList<>();

        // Get user input for fitness level
        int level = getUserInput("Enter your fitness level: \n1- Beginner\n2- Intermediate\n3- Advanced", "[1-3]", input);

        // Get user input for age
        int age = getUserInput("Enter your age:", "\\d+", minAge, maxAge, input);

        // Get user input for surgery
        int surgery = getUserInput("Have you had any surgery recently? \n1- Yes\n2- No", "[1-2]", input);

        // Get user input for illness
        int illness = getUserInput("Do you suffer from any illnesses? \n1- Heart\n2- Joint\n3- Lung\n4- Other\n5- None", "[1-5]", input);

        do{
        // Ask for user fitness goals
        choice = getUserInput("Select your fitness goal:\n1- Cardio\n2- Strength Training\n3- Flexibility\n4- Yoga\n5- HIIT\n6- Exit(High-Intensity Interval Training)", "[1-6]", input);
        System.out.print("\n");

        // Create the appropriate fitness plan based on user input
        switch (choice) {
            case 1:
                //Cardio
                plans.add(new Cardio(level, illness, surgery, age) {});
                break;
            case 2:
                //Strength Training
                plans.add(new StrengthTraining(level, illness, surgery, age) {});
                break;
            case 3:
                //Flexibility
                plans.add(new Flexibility(level, illness, surgery, age) {});
                break;
            case 4:
                //Yoga
                plans.add(new Yoga(level, illness, surgery, age) {});
                break;
            case 5:
                //HIIT (High-Intensity Interval Training)
                plans.add(new HIIT(level, illness, surgery, age) {});
                break;
            case 6:
                //close the system
                System.exit(0);
                break;
            default:
                System.out.println("Invalid goal choice.");
                break;
        }

        // Execute the recommendPlan() method for last selected plan
        if (!plans.isEmpty()) {
                plans.get(plans.size() - 1).recommendPlan();
        }
        
        } while (choice != 6);

        //close reading more inputs
        input.close();
    }
    
    //overload method
    //get a valid user input
    public static boolean getUserInput( String regex, String input) {
        int userInput;
            //print message & get input from user
            
            //check if input is only 1 character
            if (input.length() == 1) {
                
                //check if input matches the regex 'specefied gevien pattern'
                if (input.matches(regex)) {
                    //parse string to integer and break
                    userInput = Integer.parseInt(input);
                    System.out.println("------------------------------------------");
                    return true;
                } 
                else{
                    System.out.println("Please choose a number from the menue.\n");
                    System.out.println("------------------------------------------");
                }
            }
            //wrong input, repeat while loop
            else {
                System.out.println("Invalid input. Please try again to choose a number from the menue.\n");
                System.out.println("------------------------------------------");
            }
        
        return false;
    }
    
    //overload method
    //get a valid user age input
    public static boolean getUserInput( String regex, int minAge, int maxAge, String input) {
    int userInput;
        //print message & get input from user
        
        //check if input is only 1 character
        if (input.length() == 1 || input.length() == 2) {

            //check if input matches the regex 'specefied gevien pattern'
            if (input.matches(regex)) {
                
                //parse string to integer and compare if age in specefied range then break
                userInput = Integer.parseInt(input);
                if (userInput >= minAge && userInput <= maxAge) {
                    System.out.println("------------------------------------------");
                    return true;
                } 
                //age out of specefied range 
                else {
                    System.out.println("Please enter a valid age within the range " + minAge + " and " + maxAge + ".\n");
                    System.out.println("------------------------------------------");
                }
            } 
            //wrong input, repeat while loop
            else {
                System.out.println("Invalid age. Please enter a valid age number.\n");
                System.out.println("------------------------------------------");
            }
        }
        //age is not forming from 1 or 2 numbers
        else {
            System.out.println("Invalid age. Please enter a valid age number.\n");
            System.out.println("------------------------------------------");
        }
    
    return false;
    }

    //check user entreis for username and password and write them to the file
    public static boolean registerUser(String username, String password) {

        boolean name = false;
        boolean pass = false;
        
            System.out.print("Enter username (4-20 characters): ");

            //username not correct
            if (username.isEmpty() || username.length() < 4 || username.length() > 20) {
                System.out.println("Invalid username. Please try again.");
            } else if (isUsernameTaken(username)) { //user name have been taken by another user
                System.out.println("Username already exists. Please choose a different username.");
            }else{
                name =true;
            }

            System.out.print("Enter password (8-20 characters): ");

            //password not correct
            if (password.isEmpty() || password.length() < 8 || password.length() > 20) {
                System.out.println("Invalid password. Please try again.");
            }else {
                pass=true;
            }
        
                    
        if (name ==true && pass ==true){
            return true;
        }else{
        //user entres is not good
        return false;
        }

        // Hash the user's password
        String hashedPassword = hashPassword(password);

        // Try to open a BufferedWriter for writing to "users.txt" file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            // Write username and hashed password to the file
            writer.write(username + ":" + hashedPassword + "\n");
            System.out.println("Registration successful!");
            return true;
        } catch (IOException e) {
            // Handle IO exception if occurred during file writing
            System.out.println("Error writing to file: " + e.getMessage());
        }

    }

    //check user entreis for username and password and compare them to the file
    public static boolean loginUser(String username, String password) {

        String hashedPassword = hashPassword(password);

        // Try to open a BufferedReader to read from the "users.txt" file
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            // Initialize variables for reading lines and tracking login success
            String line;
            boolean loginSuccessful = false;
            
            // Read lines from the file until the end of file is reached
            while ((line = reader.readLine()) != null) {
                // Split the line into parts based on the ":" delimiter
                String[] parts = line.split(":");
                // Check if the line contains username and hashed password matching the input
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(hashedPassword)) {
                    loginSuccessful = true;
                    break;
                }
            }

            if (loginSuccessful) {
                System.out.println("Login successful!");
                return true;
            }else {
                System.out.println("Invalid username or password.");
            }
            
        } catch (IOException e) {
            // Handle IO exception if occurred during file reading
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return false;
    }
    
    //check if user are trying to get a taken username and prevent that
    private static boolean isUsernameTaken(String username) {
        
        // Try to open a BufferedReader to read from the "users.txt" file
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            
            // Read lines from the file until the end of file is reached
            while ((line = reader.readLine()) != null) {
                // Split the line into parts based on the ":" delimiter
                String[] parts = line.split(":");
                // Check if the line contains the username in the first part
                if (parts.length > 0 && parts[0].equals(username)) {
                    // Return true if the username is found in the file
                    return true;
                }
            }
        } 
        catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return false;
    }
    
    //check the availability of the file to create it or it is exist
    private static void initializeFile() {
        File file = new File("users.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            }catch (IOException e) {
                System.out.println("An error occurred while creating the file: " + e.getMessage());
            }
        } 
    }
    
    // Method to hash a given password using the SHA-256 algorithm
    private static String hashPassword(String password) {
        try {
            // Create a MessageDigest instance for SHA-256 hashing
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Generate the hashed bytes from the password bytes
            byte[] hashedBytes = digest.digest(password.getBytes(StandardCharsets.UTF_8));

            // Build a hexadecimal representation of the hashed bytes
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            // Return the hashed password as a string
            return sb.toString();
            
        } catch (NoSuchAlgorithmException e) {
            // Handle NoSuchAlgorithmException by throwing a runtime exception
            throw new RuntimeException("Hashing algorithm not found.", e);
        }
    }
    
}
*/