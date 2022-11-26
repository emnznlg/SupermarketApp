import java.util.*;

public class CustomerMethods {

    static Scanner input = new Scanner(System.in);

    static Map<String, String> customerIDAndPasswordDatabase = new HashMap<>();
    static Map<String, CustomerPojo> customerInfoDatabase = new HashMap<>();
    static Collection<CustomerPojo> registeredCustomerInfo = customerInfoDatabase.values();
    static Map<String, ArrayList<CartPojo>> customerCartInfo = new HashMap<>();
    static Collection<ArrayList<CartPojo>> customerCartInfoList = customerCartInfo.values();
    static ArrayList<CartPojo> cartList = new ArrayList<>();

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

    public static void shop(CustomerPojo customer) {
        System.out.println("=============== CUSTOMER SHOPPING PAGE ===============");
        System.out.println();
        System.out.println("---------------------------# PRODUCT LIST #--------------------------------------------------------");
        System.out.println("ID           Name                  Price                 Category            Stock Count" +
                "\n-----------------------------------------------------------------------------------------------------------------");
        for (ProductPojo w : AdminMethods.allProducts) {
            System.out.printf("%-12s %-21s %-21s %-21s %-21s\n", w.getProductID(), w.getName(), w.getPrice(), w.getCategory(), w.getStockCount());
        }

        System.out.println("Please enter the ID of the product you want to purchase");
        int productID = input.nextInt();

        if (AdminMethods.productsDatabase.containsKey(productID)) {
            String chosenProductName = AdminMethods.productsDatabase.get(productID).name;
            System.out.println("Please enter the quantity");
            int quantity = input.nextInt();
            System.out.println("Please press 1 for add the product to the cart, or please press any key to cancel and go to sub menu.");
            String userInp = input.next();
            if (userInp.equals("1")) {
                double totalCost = calculateTotalCost(quantity, productID);
                CartPojo productsInTheCart = new CartPojo(chosenProductName, totalCost, quantity);
                cartList.add(productsInTheCart);
                customerCartInfo.put(customer.email, cartList);
                System.out.println("Total cost: " + totalCost + "\n" +
                        "1. Go to cart\n" +
                        "2. Add more product to cart");
                String userInpCart = input.next();
                if (userInpCart.equals("1")) {
                    showCart(customer);
                } else if (userInpCart.equals("2")) {
                    shop(customer);
                } else {
                    System.out.println("Invalid user input!");
                    Menu.showCustomerSubMenu(customer);
                }
            } else {
                Menu.showCustomerSubMenu(customer);
            }
        } else {
            System.out.println("Product not found!");
            Menu.showCustomerSubMenu(customer);
        }
    }

    public static double calculateTotalCost(int qty, int id) {
        return AdminMethods.productsDatabase.get(id).getPrice() * qty;
    }

    public static void showCart(CustomerPojo customer) { // Her karta eklemede yeni bir cart objesi olusmali ve bunlari Map'a kaydetmeli...
        System.out.println("=============== CUSTOMER CART PAGE ===============");
        System.out.println();
        System.out.println("---------------------------# CART PAGE #--------------------------------------------------------");
        System.out.println("Product Name           Quantity                  Total Cost" +
                "\n-----------------------------------------------------------------------------------------------------------------");
        for (ArrayList<CartPojo> w : customerCartInfoList) {
            for (CartPojo s : w) {
                System.out.printf("%-12s %-21s %-21s\n", s.productName, s.quantity, s.totalCost);
            }
        }
        System.out.println("Please press '1' to complete the purchase, or please any button to return the sub menu");
        String userInp = input.next();
        if (userInp.equals("1")) {
            System.out.println("Thank you for you purchase! You packages will be sent soon!");
            cartList.clear();
            customerCartInfo.clear();
            customerCartInfoList.clear();//Burada cart temizlenmedi...
        }
        Menu.showCustomerSubMenu(customer);
    }

    public static void showReturnablePurchases() {

    }

    public static void showPastPurchases() {

    }

    public static void showMyInformationMenu() {

    }


}

/*


        if (AdminMethods.productsDatabase.containsKey(productID)) {
            System.out.println("Please enter the quantity");
            int quantity = input.nextInt();
            double productCost = AdminMethods.productsDatabase.get(productID).getPrice();
            double totalCost = productCost * quantity;
            System.out.println("Total Cost is: " + totalCost);
            System.out.println("Please press '1' if you want to add product to your cart, or please press '2' to shop a new product");
            String userInp = input.next();
            CartPojo cart = new CartPojo(AdminMethods.productsDatabase.get(productID).name, totalCost, quantity);
            do {
                if (userInp.equals("1")) {
                    customerCartInfo.put(customer.email, cart);
                    System.out.println("Product added successfully to cart!");
                    System.out.println("Please press '1' to shop more products, or press '2' to go to cart page");
                    String userInpCart = input.next();
                    do {
                        if (userInpCart.equals("1")) {
                            shop(customer);
                            break;
                        } else if (userInpCart.equals("2")) {
                            showCart(customer);
                            break;
                        } else {
                            System.out.println("Invalid user input. Please try again...");
                            userInpCart = input.next();
                        }
                    } while (true);
                } else if (userInp.equals("2")) {
                    shop(customer);
                    break;
                } else {
                    System.out.println("Invalid user input. Please try again...");
                    userInp = input.next();
                }
            } while (true);

        } else {
            System.out.println("Invalid product ID. Please enter the ID of the product you want to purchase");
            shop(customer);
        }
 */