import java.util.*;

public class AdminMethods {
    static Scanner input = new Scanner(System.in);

    static double totalRev = 0;
    static Map<String, String> adminsDatabase = new HashMap<>();
    static Map<Integer, ProductPojo> productsDatabase = new HashMap<>();
    static Collection<ProductPojo> allProducts = productsDatabase.values();

    public static void addProduct() {
        System.out.println("=============== ADMIN ADD PRODUCT PAGE ===============");
        System.out.println("Please enter the product name:");
        String productName = input.next();
        System.out.println("Please enter the product price:");
        double productPrice = input.nextDouble();
        System.out.println("Please enter the product category:");
        String productCategory = input.next();
        System.out.println("Please enter the product stock count:");
        int productStockCount = input.nextInt();

        ProductPojo product = new ProductPojo(productName, productPrice, productCategory, productStockCount);
        productsDatabase.put(product.getProductID(), product);
        System.out.println("Product has been added successfully");
        Menu.adminMiniMenu("Add");
    }

    public static void listProducts() {
        System.out.println("=============== ADMIN PRODUCT LIST PAGE ===============");
        if (productsDatabase.isEmpty()) {
            System.out.println("There are no products in stocks now!");
        } else {
            System.out.println("---------------------------# PRODUCT LIST #--------------------------------------------------------");
            System.out.println("ID           Name                  Price                 Category            Stock Count" +
                    "\n-----------------------------------------------------------------------------------------------------------------");
            for (ProductPojo w : allProducts) {
                System.out.printf("%-12s %-21s %-21s %-21s %-21s\n", w.getProductID(), w.getName(), w.getPrice(), w.getCategory(), w.getStockCount());
            }
        }
        Menu.showAdminSubMenu();
    }

    public static void removeProduct(String type) {
        showHeader(type);
        int userInput = input.nextInt();
        if (productsDatabase.containsKey(userInput)) {
            productsDatabase.remove(userInput);
            System.out.println("Product has been removed successfully");
            allProducts.remove(productsDatabase.get(userInput));//Once collection'dan sildim, yer kaplamasin diye...
            productsDatabase.remove(userInput);//Sonra komple urun veritabanindan sildim...
            Menu.adminMiniMenu("Remove");
        } else {
            System.out.println("Product not found!");
            Menu.adminMiniMenu("Remove");
        }
    }

    public static void updateProduct(String type) {
        showHeader(type);
        int userInput = input.nextInt();
        if (productsDatabase.containsKey(userInput)) {
            Menu.showAdminUpdateProductMenu(userInput);
        } else {
            System.out.println("Product not found!");
            Menu.adminMiniMenu("Remove");
        }
    }

    public static void updateProductInfo(ProductPojo product, String type) {
        if (type.equals("name")) {
            System.out.println("The current " + type + " is " + product.getName());
            System.out.println("Please enter a new " + type + " for this product ");
            String userInp = input.next();
            product.setName(userInp);
        } else if (type.equals("price")) {
            System.out.println("The current " + type + " is " + product.getPrice());
            System.out.println("Please enter a new " + type + " for this product ");
            double userInp = input.nextDouble();
            product.setPrice(userInp);
        } else if (type.equals("category")) {
            System.out.println("The current " + type + " is " + product.getCategory());
            System.out.println("Please enter a new " + type + " for this product ");
            String userInp = input.next();
            product.setCategory(userInp);
        } else if (type.equals("stock count")) {
            System.out.println("The current " + type + " is " + product.getStockCount());
            System.out.println("Please enter a new " + type + " for this product ");
            int userInp = input.nextInt();
            product.setStockCount(userInp);
        }
        System.out.println("The product " + type + " has been changed successfully!");
        Menu.showAdminUpdateProductMenu(product.getProductID());
    }

    public static void showRegisteredCustomers() {
        System.out.println("=============== ADMIN SHOW REGISTERED CUSTOMERS PAGE ===============");
        if (CustomerMethods.customerInfoDatabase.isEmpty()) {
            System.out.println("There are no registered customers!");
        } else {
            System.out.println("---------------------------# REGISTERED CUSTOMERS LIST #--------------------------------------------------------");
            System.out.println("Name                  Phone Number                  Email" +
                    "\n-----------------------------------------------------------------------------------------------------------------");
            for (CustomerPojo w : CustomerMethods.registeredCustomerInfo) {
                System.out.printf("%-20s %-18s %-20s\n", w.name, w.getPhoneNumber(), w.email);
            }
        }
        Menu.showAdminSubMenu();
    }

    public static void showRevenue() {
        System.out.println("Your total revenue is: " + totalRev);
        Menu.showAdminSubMenu();
    }

    public static void addAdmins() {
        adminsDatabase.put("admin1@gmail.com", "12345");
        adminsDatabase.put("admin2@gmail.com", "987654");
        adminsDatabase.put("admin3@gmail.com", "111111");
    }

    public static void checkAdminDatabases() {
        System.out.println("Please enter your admin email:");
        String email = input.next();
        do {
            if (adminsDatabase.containsKey(email)) {
                System.out.println("Please enter your admin password:");
                String password = input.next();
                if (adminsDatabase.get(email).equals(password)) {
                    Menu.showAdminSubMenu();
                    break;
                } else {
                    System.out.println("Incorrect password");
                }
            } else {
                System.out.println("Invalid email...Please enter your admin email again:");
                email = input.next();
            }
        } while (true);
    }

    public static void findForgottenPassword() {
        System.out.println("=============== ADMIN FORGOTTEN PASSWORD PAGE ===============");
        System.out.println("Please enter your admin email:");
        String email = input.next();
        do {
            if (adminsDatabase.containsKey(email)) {
//                System.out.println("Please enter your security answer:");
//                String securityAnswer = input.next();
                System.out.println("Your password has been sent to your registered email...");
                System.out.println("Password: " + adminsDatabase.get(email));
                break;
            } else {
                System.out.println("The email couldn't be found! Please enter the correct email:");
                email = input.next();
            }
        } while (true);
        Menu.showAdminMainMenu();
    }

    public static void showHeader(String type) {
        System.out.println("=============== ADMIN " + type.toUpperCase() + " PRODUCT PAGE ===============");
        System.out.println("Please enter the ID of the product to " + type);
    }

}
