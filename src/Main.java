import java.util.Scanner;

public class Main {

    static void displayGreeting() {
        System.out.println();
        System.out.println("\n---------------------------------\n");
        System.out.println("Welcome to my Java quiz game! The quiz tests your general knowlegde in Computer Science.\n");
        System.out.println("---------------------------------\n");
    }

    static void displayDifficulty() {
        System.out.println("\nNote on hard mode: ");
        System.out.println("The quiz stops on your first incorrect answer. Choose wisely.");
        System.out.print("\nSelect difficulty (easy, medium, hard): ");
    }

    static void easy(Scanner scanner, int guess, int score, Questions[] questions) {

        // Looping through each question in the questions array
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n---------------------------------\n");
            System.out.println(questions[i].getPrompt());
        
            for (String option : questions[i].getOpts()) {
                System.out.println(option);
            }
        
            System.out.print("Your answer: ");
            guess = scanner.nextInt();
        
            // checking if user guessed right and incrementing score if that's the case
            if (guess == questions[i].getAns()) {
                System.out.println("Correct Answer!");
                score++;
            } else {
                System.out.println("Incorrect Answer");
            }
        }
        scanner.nextLine();
        System.out.println("\nYou scored: "+ score);
    }

    static void medium(Scanner scanner, int guess, int score, Questions[] questions) {

        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n---------------------------------\n");
            System.out.println(questions[i].getPrompt());
        
            for (String option : questions[i].getOpts()) {
                System.out.println(option);
            }
        
            System.out.print("Your answer: ");
            guess = scanner.nextInt();
        
            if (guess == questions[i].getAns()) {
                System.out.println("Correct Answer!");
                score++;
            } else {
                System.out.println("Incorrect Answer");
            }
        }
        scanner.nextLine();
        System.out.println("\nYou scored: " + score);
    }

    static void hard(Scanner scanner, int guess, int score, Questions[] questions) {
        
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n---------------------------------\n");
            System.out.println(questions[i].getPrompt());
        
            for (String option : questions[i].getOpts()) {
                System.out.println(option);
            }
        
            System.out.print("Your answer: ");
            guess = scanner.nextInt();
        
            if (guess == questions[i].getAns()) {
                System.out.println("Correct Answer!");
                score++;
            } else { 
                System.out.println("Incorrect Answer");

                // Quiz for hard mode ends completely on the player's first incorrect answer. The score stops getting incremented
                break;
            }
        }
        scanner.nextLine();
        System.out.println("\nYou scored: "+ score);
    }

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);

        // players guess for each question and score
        int guess = 0;
        int score = 0;
        
        // Constructor which groups together the questions, options and correct answer for each round
        // more practical than three arrays for each dificulty
        Questions[] easyQuestions = {
            new Questions("Which of these is a permanent storage device that has no moving parts?",
            new String[]{"1. Hard Disk Drive (HDD)", "2. Solid State Drive (SSD)", "3. RAM", "4. Optical Drive"}, 2),

            new Questions("What does \"Open Source\" software mean?",
            new String[]{"1. The software is free to buy", "2. The software has no security features",
                         "3. The software only works on Linux", "4. The source code is available for anyone to inspect/modify"}, 4),

            new Questions("What is the primary purpose of a \"Compiler\"?",
            new String[]{"1. To browse the internet", "2. To convert high-level code into machine code",
                         "3. To act as a firewall", "4. To backup your hard drive"}, 2),

            new Questions("In a URL, what does \"HTTPS\" stand for?",
            new String[]{"1. Hypertext Transfer Protocol Secure", "2. Hyperlink Total Transfer System",
                         "3. High Tech Privacy Standard", "4. Home Text Process Server"}, 1),

            new Questions("What does \"GUI\" stand for in computing?",
            new String[]{"1. General User Integration", "2. Global Unit Identifier",
                         "3. Graphical User Interface", "4. Gaming Utility Instrument"}, 3)
        };

        Questions[] mediumQuestions = {
            new Questions("Which data structure follows the \"First-In, First-Out\" (FIFO) principle?", 
            new String[]{"1. Stack", "2. Tree", "3. Queue", "4. List"}, 3),

            new Questions("In Object-Oriented Programming (OOP), what is \"Encapsulation\"?", 
            new String[]{"1. The process of inheriting traits from a parent class", "2. Bundling data and methods that work on that data within a single unit", 
                         "3. The ability of a function to take multiple forms", "4. Running multiple programs at the exact same time"}, 2),

            new Questions("Which of the following is a \"Lossless\" file compression format?", 
            new String[]{"1. JPEG", "2. MP3", "3. MPEG", "4. PNG"}, 4),

            new Questions("What is the main purpose of a \"DNS\" (Domain Name System) server?", 
            new String[]{"1. To encrypt user passwords", "2. To translate human-readable domain names into IP addresses", 
                         "3. To host the physical files of a website", "4. To prevent viruses from entering a network"}, 2),

            new Questions("What is the role of a \"Router\" in a network?", 
            new String[]{"1. To forward data packets between different computer networks", "2. To store large files", 
                         "3. To convert analog signals to digital", "4. To compile source code"}, 1)
        };

        Questions[] hardQuestions = {
            new Questions("What is the time complexity of searching for an element in a sorted array using Binary Search?", 
            new String[]{"1. O(n)", "2. O(log(n))", "3. O(n log(n))", "4. O(n^2)"}, 2),

            new Questions("Which of the following is an example of a \"Functional\" programming language?", 
            new String[]{"1. Haskell", "2. Java", "3. C++", "4. Python"}, 1),

            new Questions("Which of the following is a \"Turing Complete\" system?", 
            new String[]{"1. A basic calculator", "2. Regular Expressions (Regex)", 
                         "3. Conway’s Game of Life", "4. HTML5 (without CSS/JS)"}, 3),

            new Questions("Which protocol is used to securely log into a remote server via the command line?", 
            new String[]{"1. FTP", "2. SSH", "3. Telnet", "4. HTTP"}, 2),

            new Questions("Which of these is a \"Bottom-Up\" parsing technique?", 
            new String[]{"1. LL Parsing", "2. Recursive Descent Parsing", "3. LR Parsing", "4. Predictive Parsing"}, 3)
        };
        
        // A greeting and the menu displaying the different difficulties
        // Player can choose to replay again
        displayGreeting();
        while (true) {
            displayDifficulty();
            String tier = scanner.nextLine();
            switch (tier) {
                case "easy":
                    easy(scanner, guess, score, easyQuestions);
                    break;
                
                case "medium":
                    medium(scanner, guess, score, mediumQuestions);
                    break;
                
                case "hard":
                    hard(scanner, guess, score, hardQuestions);
                    break;

                default:
                    System.out.print("\nInvalid choice. Must be (easy/medium/hard).\n"); 
                    continue;   
            }
            System.out.print("\nPlay again? (yes/no) ");
            String ans = scanner.nextLine();
            if (ans.equals("yes")) {
                continue;
            } else if (ans.equals("no")) {
                System.out.println("Exiting...");
                break;
            }
        }
        scanner.close();
    }
}