import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }

    public static void pressEnterToContinue() { 
        System.out.println("Press Enter key to continue...");
        input.nextLine();
        input.nextLine(); 
       
    }

    public static void productManagerMenu() {
        ProductManager productManager = new ProductManager(1, "Product Manager");
        int choice;
        clearScreen();
        String answer;
        int custId;
        int choice2;
        do {
            System.out.println("Convenience Corner\n");
            System.out.println("Product\t\t\tPurchase");
            System.out.println("1. Add Product\t\t8. Add Purchase");
            System.out.println("2. Delete Product\t9. Show All Purchases");
            System.out.println("3. Modify Product\t");
            System.out.println("4. Show All Products");
            System.out.println("\nCustomer\t\tLoyalty Program");
            System.out.println("5. Add Customer\t\t10. Most Valuable Customer");
            System.out.println("6. Show All Customers\t11. Add Loyalty Points (Discount)");
            System.out.println("7. Delete Customer\t");
            System.out.println("\n12. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                do {
                    clearScreen();
                    System.out.print("Enter product id: ");
                    int id = input.nextInt();
                    if (productManager.isProductExist(id)) {
                        System.out.println("Product already exists.");
                        System.out.print("Do you want to add more products? (y/n): ");
                        answer = input.next();
                        continue; 
                    }
                    input.nextLine();
                    System.out.print("Enter product name: ");
                    String name = input.next();
                    System.out.print("Enter product price: ");
                    double price = input.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = input.nextInt();
            
                    Product product = new Product(id, name, price, quantity);
                    productManager.addProduct(product);
                    System.out.println("Product added successfully.");
                    System.out.print("Do you want to add more products? (y/n): ");
                    answer = input.next();
                } while (answer.equals("y"));
                break;
                case 2:
                    System.out.print("Enter product id: ");
                    int id2 = input.nextInt();
                    productManager.deleteProduct(id2);
                    break;
                case 3:
                    System.out.print("Enter product id: ");
                    int id3 = input.nextInt();
                    boolean productFound = false;
                    for (Product product : productManager.getProducts()) {
                        if (product.getId() == id3) {
                            productFound = true;
                            System.out.print("Enter product name: ");
                            String name = input.next();
                            System.out.print("Enter product price: ");
                            double price = input.nextDouble();
                            System.out.print("Enter product quantity: ");
                            int quantity = input.nextInt();
                            productManager.modifyProduct(id3, name, price, quantity);
                            break;
                        }
                    }
                    if (!productFound) {
                        System.out.println("Product not found.");
                    }
                    break;
                case 4:
                    clearScreen();
                    productManager.showAllProducts();
                    break;
                case 5:
                    clearScreen();
                    System.out.print("Enter customer id: ");
                    custId = input.nextInt();
                    if (productManager.isCustomerExist(custId)) {
                        System.out.println("Customer Already Exists.");
                        System.out.print("Do you want to add more customer? (y/n): ");
                        String answer2 = input.next();
                        continue; 
                    }
                    input.nextLine();
                    System.out.print("Enter customer name: ");
                    String name = input.nextLine();
                    System.out.print("Enter customer address: ");
                    String address = input.nextLine();
                    System.out.print("Enter customer balance: ");
                    double balance = Double.parseDouble(input.nextLine());
                    Customer customer = new Customer(custId, balance, name, address);
                    productManager.addCustomer(customer);
                    System.out.println("Customer added successfully.");
                case 6:
                    clearScreen();
                    productManager.showAllCustomers();
                    break;
                case 7:
                    System.out.print("Enter customer id: ");
                    int id4 = input.nextInt();
                    productManager.deleteCustomer(id4);
                    break;
                case 8:
                clearScreen();
                System.out.print("Enter customer id: ");
                int custId2 = input.nextInt();
                System.out.println("Enter product id: ");
                int prodId = input.nextInt();
                if (productManager.isCustomerExist(custId2) && productManager.isProductExist(prodId)) {
                    System.out.println("Customer\n");
                    productManager.showAllProducts();
                    System.out.println("\nProduct\n");
                    productManager.showAllCustomers();
                    System.out.print("\nEnter quantity: ");
                    int quantity = input.nextInt();
                    productManager.addPurchase(custId2, prodId, quantity);
                } else {
                    System.out.println("Customer or Product not found.");
                    continue;
                }                
                    break;
                case 9:
                clearScreen();
                    productManager.showAllPurchases();
                    break;
                case 10:
                    productManager.mostValuableCustomer();
                    break;
                case 11:
                   productManager.addLoyaltyPoints();
                    break;
            }

            pressEnterToContinue();
            clearScreen();
        } while (choice != 12);
    }

    public static void main(String[] args) {
            productManagerMenu();

    }
   
}