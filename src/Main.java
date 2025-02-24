import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyIn = new Scanner(System.in);

        Admin admin = new Admin("admin@gmail.com", "admin");
        Expert expert = new Expert("expert@gmail.com", "expert");
        Clients client = new Clients("client@gmail.com", "client");

        System.out.println("Welcome to the system! Please select your role to continue.");
        System.out.println("1. Admin");
        System.out.println("2. Expert");
        System.out.println("3. Client");
        int selectedRole = keyIn.nextInt();

        System.out.println("Enter your username: ");
        String enteredUsername = keyIn.next();

        System.out.println("Enter your password: ");
        String enteredPassword = keyIn.next();

        switch(selectedRole) {
            case(1): {
                if (!(admin.checkUsername(enteredUsername) &&
                admin.checkPassword(enteredPassword))) {
                    System.out.println("Invalid username or password entered," +
                            "exiting system.");
                    System.exit(0);
                }
                //rest of the code
                break;
            }
            case(2): {
                if (!(expert.checkUsername(enteredUsername) &&
                        expert.checkPassword(enteredPassword))) {
                    System.out.println("Invalid username or password entered," +
                            "exiting system.");
                    System.exit(0);
                }
                //rest of the code
                break;
            }
            case(3): {
                if (!(client.checkUsername(enteredUsername) &&
                        client.checkPassword(enteredPassword))) {
                    System.out.println("Invalid username or password entered," +
                            "exiting system.");
                    System.exit(0);
                }
                //rest of the code
                break;
            }
        }
    }
}