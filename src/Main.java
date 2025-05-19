import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {

            while (true) {
                System.out.println("\n--- Bug Bounty Tracker ---");
                System.out.println("1. Add Program");
                System.out.println("2. Add Report");
                System.out.println("3. Exit");
                System.out.print("Choose: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline character

                // Enhanced switch statement (Java 12+)
                switch (choice) {
                    case 1 -> {
                        System.out.print("Program Name: ");
                        String name = sc.nextLine();
                        System.out.print("Platform: ");
                        String platform = sc.nextLine();
                        System.out.print("Scope: ");
                        String scope = sc.nextLine();
                        ProgramManager.addProgram(name, platform, scope);
                    }
                    case 2 -> {
                        System.out.print("Program ID: ");
                        int pid = sc.nextInt(); sc.nextLine();
                        System.out.print("Title: ");
                        String title = sc.nextLine();
                        System.out.print("Severity: ");
                        String severity = sc.nextLine();
                        System.out.print("Status: ");
                        String status = sc.nextLine();
                        System.out.print("Reward: ");
                        double reward = sc.nextDouble(); sc.nextLine();
                        ReportManager.addReport(pid, title, severity, status, reward);
                    }
                    case 3 -> {
                        System.out.println("Exiting...");
                        return; // Exit the program
                    }
                    default -> System.out.println("Invalid choice! Please try again.");
                }
            }

        }  catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace(); // Log the stack trace for better debugging
        }
        
    }
}
