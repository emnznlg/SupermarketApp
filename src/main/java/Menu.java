import java.util.Scanner;

public class Menu {
    static Scanner input = new Scanner(System.in);

    public static void showMainMenu() {
        AdminMethods.addAdmins();
        System.out.println("=============== APP MAIN MENU PAGE ===============");
        System.out.println("1. Enter as Admin\n2. Enter as Customer\nQ. QUIT");
        System.out.println("Please select the action you want:");
        String userInp = input.next().toUpperCase();
        do {
            if (userInp.equals("1")) {
                showAdminMainMenu();
                break;
            } else if (userInp.equals("2")) {
                showCustomerMainMenu();
                break;
            } else if (userInp.equals("Q")) {
                System.out.println("Thank you for using EMIN's ONLINE SHOPPING APP!");
                break;
            } else {
                System.out.println("Invalid user input! Please try again...");
                userInp = input.next();
            }
        } while (true);
    }

    public static void showAdminMainMenu() {
        System.out.println("=============== ADMIN MAIN MENU PAGE ===============");
        System.out.println("1. Sign in as Admin\n2. Forget Password?\n3. Return Main Menu\nQ. QUIT");
        System.out.println("Please select the action you want:");
        String userInp = input.next().toUpperCase();
        do {
            if (userInp.equals("1")) {
                AdminMethods.checkAdminDatabases();
                break;
            } else if (userInp.equals("2")) {
                AdminMethods.findForgottenPassword();
                break;
            } else if (userInp.equals("3")) {
                showMainMenu();
                break;
            } else if (userInp.equals("Q")) {
                System.out.println("Thank you for using EMIN's ONLINE SHOPPING APP!");
                break;
            } else {
                System.out.println("Invalid user input! Please try again...");
                userInp = input.next();
            }
        } while (true);
    }

    public static void showAdminSubMenu() {
        System.out.println("=============== ADMIN SUB-MENU PAGE ===============");
        System.out.println("1. Add Product\n2. List Product\n3. Remove Product\n4. Update Product\n" +
                "5. Show Total Revenue\n6. Return Admin-Main Menu\n7. Show Registered Customers\nQ. QUIT");
        System.out.println("Please select the action you want:");
        String userInp = input.next().toUpperCase();
        do {
            if (userInp.equals("1")) {
                AdminMethods.addProduct();
                break;
            } else if (userInp.equals("2")) {
                AdminMethods.listProducts();
                break;
            } else if (userInp.equals("3")) {
                AdminMethods.removeProduct("Remove");
                break;
            } else if (userInp.equals("4")) {
                AdminMethods.updateProduct("Update");
                break;
            } else if (userInp.equals("5")) {
                AdminMethods.showRevenue(); //Sonra yapilacak...
                break;
            } else if (userInp.equals("6")) {
                showAdminMainMenu();
                break;
            } else if (userInp.equals("7")) {
                AdminMethods.showRegisteredCustomers();
                break;
            } else if (userInp.equals("Q")) {
                System.out.println("Thank you for using EMIN's ONLINE SHOPPING APP!");
                break;
            } else {
                System.out.println("Invalid user input! Please try again...");
                userInp = input.next();
            }
        } while (true);
    }

    public static void adminMiniMenu(String type) {
        System.out.println("1. " + type + " More Product\n" +
                "2. Return to Sub Menu");
        String userInp = input.next();
        do {
            if (userInp.equals("1")) {
                if (type.equals("Add")) {
                    AdminMethods.addProduct();
                    break;
                } else if (type.equals("Remove")) {
                    AdminMethods.removeProduct(type);
                    break;
                }
            } else if (userInp.equals("2")) {
                showAdminSubMenu();
                break;
            } else {
                System.out.println("Invalid user input... Please try again.");
            }
        } while (true);

    }

    public static void showAdminUpdateProductMenu(int productID) {
        System.out.println("1. Update Product Name\n" +
                "2. Update Product Price\n" +
                "3. Update Product Category\n" +
                "4. Update Product Stock\n" +
                "5. Return to Sub Menu");
        String userInp = input.next();
        if (userInp.equals("1")) {
            AdminMethods.updateProductInfo(AdminMethods.productsDatabase.get(productID), "name");
        } else if (userInp.equals("2")) {
            AdminMethods.updateProductInfo(AdminMethods.productsDatabase.get(productID), "price");
        } else if (userInp.equals("3")) {
            AdminMethods.updateProductInfo(AdminMethods.productsDatabase.get(productID), "category");
        } else if (userInp.equals("4")) {
            AdminMethods.updateProductInfo(AdminMethods.productsDatabase.get(productID), "stock count");
        } else if (userInp.equals("5")) {
            showAdminSubMenu();
        } else {
            System.out.println("Invalid user input... Please try again.");
            showAdminUpdateProductMenu(productID);
        }

    }

    public static void showCustomerMainMenu() {
        System.out.println("=============== CUSTOMER MAIN MENU PAGE ===============");
        System.out.println("1. Sign In\n2. Forget Password?\n3. Sign Up\n4. Return Main Menu\nQ. QUIT");
        System.out.println("Please select the action you want:");
        String userInp = input.next().toUpperCase();
        do {
            if (userInp.equals("1")) {
                CustomerMethods.checkCustomerIDAndPasswordDatabases();
                break;
            } else if (userInp.equals("2")) {
                CustomerMethods.findForgottenCustomerPassword();
                break;
            } else if (userInp.equals("3")) {
                CustomerMethods.signUp();
                break;
            } else if (userInp.equals("4")) {
                showMainMenu();
                break;
            } else if (userInp.equals("Q")) {
                System.out.println("Thank you for using EMIN's ONLINE SHOPPING APP!");
                break;
            } else {
                System.out.println("Invalid user input! Please try again...");
                userInp = input.next();
            }
        } while (true);
    }

    public static void showCustomerSubMenu(CustomerPojo customer) {
        System.out.println("=============== CUSTOMER SUB-MENU PAGE ===============");
        System.out.println("Hello " + customer.name);
        System.out.println("1. Shop\n2. Cart\n3. Return Customer-Main Menu\nQ. QUIT");
        System.out.println("Please select the action you want:");
        String userInp = input.next().toUpperCase();
        do {
            if (userInp.equals("1")) {
                CustomerMethods.shop(customer);
                break;
            } else if (userInp.equals("2")) {
                CustomerMethods.showCart(customer);
                break;
            } else if (userInp.equals("3")) {
                Menu.showCustomerMainMenu();
                break;
            } else if (userInp.equals("Q")) {
                System.out.println("Thank you for using EMIN's ONLINE SHOPPING APP!");
                break;
            } else {
                System.out.println("Invalid user input! Please try again...");
                userInp = input.next();
            }
        } while (true);
    }

}
