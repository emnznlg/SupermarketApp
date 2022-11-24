import java.util.*;

public class AdminMethods {
    static Scanner input = new Scanner(System.in);

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
        System.out.println("---------------------------# PRODUCT LIST #--------------------------------------------------------");
        System.out.println("ID           Name                  Price                 Category            Stock Count" +
                "\n-----------------------------------------------------------------------------------------------------------------");
        for (ProductPojo w : allProducts) {
            System.out.printf("%-12s %-21s %-21s %-21s %-21s\n", w.getProductID(), w.getName(), w.getPrice(), w.getCategory(), w.getStockCount());
        }
        Menu.showAdminSubMenu();
    }

    public static void searchProduct() {
    }

    public static void removeProduct() {
    }

    public static void updateProduct() {
    }

    public static void showRegisteredCustomers() {
    }

    public static void showRevenue() {
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

}