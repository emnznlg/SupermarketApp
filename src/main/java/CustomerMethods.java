import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerMethods {

    static Scanner input = new Scanner(System.in);

    static Map<String, String> customerIDAndPasswordDatabase = new HashMap<>();
    static Map<String, CustomerPojo> customerInfoDatabase = new HashMap<>();

    public static void checkCustomerIDAndPasswordDatabases() {
        System.out.println("Please enter your customer email:");
        String email = input.next();
        do {
            if (customerIDAndPasswordDatabase.containsKey(email)) {
                System.out.println("Please enter your password:");
                String password = input.next();
                if (customerIDAndPasswordDatabase.get(email).equals(password)) {
                    Menu.showCustomerSubMenu(customerInfoDatabase.get(email));
                    break;
                } else {
                    System.out.println("Incorrect password");
                }
            } else {
                System.out.println("Invalid email...Please enter your email again:");
                email = input.next();
            }
        } while (true);
    }
    public static void findForgottenCustomerPassword() {
        System.out.println("=============== CUSTOMER FORGOTTEN PASSWORD PAGE ===============");
        System.out.println("Please enter your customer email:");
        String email = input.next();
        do {
            if (customerIDAndPasswordDatabase.containsKey(email)) {
//                System.out.println("Please enter your security answer:");
//                String securityAnswer = input.next();
                System.out.println("Your password has been sent to your registered email...");
                System.out.println("Password: " + customerIDAndPasswordDatabase.get(email));
                break;
            } else {
                System.out.println("The email couldn't be found! Please enter the correct email:");
                email = input.next();
            }
        } while (true);
        Menu.showCustomerMainMenu();
    }
    public static void passwordCheck(String password, String email) {
        do {
            if (password.length() > 4) {
                boolean regex = password.matches(".*[A-Z].*") && password.matches(".*[a-z].*") && password.matches(".*[0-9].*");
                if (regex) {
                    System.out.println("Please enter your name:");
                    String name = input.next();
                    System.out.println("Please enter your phone number:");
                    String phoneNumber = input.next();

                    CustomerPojo customer = new CustomerPojo(email, name, phoneNumber, password);
                    customerIDAndPasswordDatabase.put(email, password);
                    customerInfoDatabase.put(email, customer);

                    System.out.println("You have successfully registered...");
                    Menu.showCustomerSubMenu(customer);
                    break;
                } else {
                    System.out.println("Weak password... Please enter a new password.");
                    password = input.next();
                }
            } else {
                System.out.println("Weak password... Please enter a new password.");
                password = input.next();
            }
        } while (true);
    }
    public static void signUp() {
        System.out.println("=============== CUSTOMER SIGN UP PAGE ===============");
        System.out.println("Please enter your email");
        String email = input.next();
        do {
            if (customerIDAndPasswordDatabase.containsKey(email)) {
                System.out.println("We already have a customer with this email! Please enter another email:");
                email = input.next();
            } else {
                System.out.println("Please enter your password. ( Password should contain 5 character, at least 1 number and 1 uppercase)");
                String password = input.next();
                passwordCheck(password, email);
            }
        } while (true);

    }
    public static void shop() {

    }
    public static void showCart() {

    }
    public static void showReturnablePurchases() {

    }
    public static void showPastPurchases() {

    }

    public static void showMyInformationMenu() {

    }


}
