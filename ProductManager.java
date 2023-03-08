import java.util.ArrayList;

public class ProductManager extends User {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    int max = 5;

    public ProductManager(int id, String name) {
        super(id, name);
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void deleteProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                System.out.println("Product deleted.");
                return;
            }
        }
        System.out.println("Product not found.");
    }
   
    public void modifyProduct(int id, String name, double price, int quantity) {
            for (Product product : products) {
                if (product.getId() == id) {
                    product.setName(name);
                    product.setPrice(price);
                    product.setQuantity(quantity);
                    System.out.println("Product modified.");
                    return;
                }
            }
    }

    public void showAllProducts() {
        if (products.size() == 0) {
            System.out.println("No product found.");
            return;
        }
        else {
          
            System.out.println("ID\tName\t\tPrice\t\tQuantity");
            for (Product product : products) {
                System.out.println(product.getId() + "\t" + product.getName() + "\t\t" + product.getPrice() + "\t\t" + product.getQuantity());
            }
        }
       
    }

    public boolean isProductExist(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public void addCustomer(Customer customer) {

        for (Customer customer1 : customers) {
            if (customer1.getId() == customer.getId()) {
                System.out.println("Customer already exist.");
                return;
            }
        }
        customers.add(customer);
    }

  
    public void showAllCustomers() {
        if (customers.size() == 0) {
            System.out.println("No customer found.");
            return;
        }

        else {
            System.out.println("ID\tName\t\t\tBalance\t\tLoyalty Points");
            for (Customer customer : customers) {
                System.out.println(customer.getId() + "\t" + customer.getName() + "\t\t" + customer.getBalance() + "\t\t" + customer.getLoyaltyPoints());
            }
        }
       
    }

    public void deleteCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                customers.remove(customer);
                System.out.println("Customer deleted.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }


    public boolean isCustomerExist(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return true;
            }
        }
        return false;
    }

   
    public void buyProduct(int customerId, int productId) {
        if (!isCustomerExist(customerId)) {
            System.out.println("Customer not found.");
            return;
        }
        if (!isProductExist(productId)) {
            System.out.println("Product not found.");
            return;
        }
        if (!isProductAvailable(productId)) {
            System.out.println("Product out of stock.");
            return;
        }
        if (!isCustomerBalanceEnough(customerId, productId)) {
            System.out.println("Customer balance is not enough.");
            return;
        }
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                for (Product product : products) {
                    if (product.getId() == productId) {
                        if (customer.getProducts().contains(product)) {
                            System.out.println("Customer has already bought the product.");
                            return;
                        }
                        customer.getProducts().add(product);
                        customer.setBalance(customer.getBalance() - product.getPrice());
                        product.setQuantity(product.getQuantity() - 1);
                        System.out.println("Product bought successfully.");
                        return;
                    }
                }
            }
        }
    }

    public boolean isProductAvailable(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                if (product.getQuantity() > 0) {
                    return true;
                }
            }
        }
        return false;
    }

    
    public boolean isCustomerBalanceEnough(int customerId, int productId) {
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                for (Product product : products) {
                    if (product.getId() == productId) {
                        if (customer.getBalance() >= product.getPrice()) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

   
    public void addPurchase(int customerId, int productId, int quantity) {
        if (!isProductAvailable(productId)) {
            System.out.println("Product out of stock.");
            return;
        }
        if (!isCustomerBalanceEnough(customerId, productId)) {
            System.out.println("Customer balance is not enough.");
            return;
        }
        for (Customer customer : customers) {
            if (customer.getId() == customerId) {
                for (Product product : products) {
                    if (product.getId() == productId) {
            
                        customer.getProducts().add(product);
                        customer.setBalance(customer.getBalance() - product.getPrice());
                        product.setQuantity(product.getQuantity() - quantity);
                        System.out.println("Product bought successfully.");
                        return;
                    }
                }
            }
        }
    }

    public void showAllPurchases() {
        if (customers.size() == 0) {
            System.out.println("No customer found.");
            return;
        }
        for (Customer customer : customers) {
            System.out.println("Customer ID: " + customer.getId() + ", Customer Name: " + customer.getName());
            System.out.println("Purchased Products:");
            System.out.println("ID\tName\tPrice");
            for (Product product : customer.getProducts()) {
                System.out.println(product.getId() + "\t" + product.getName() + "\t" + product.getPrice() );
            }
        }
    }

    public void mostValuableCustomer() {
  
        if (customers.size() == 0) {
            System.out.println("No customer found.");
            return;
        }
        else {
            for (Customer customer : customers) {
                if (customer.getProducts().size() == 0) {
                    System.out.println("No purchase found.");
                    return;
                }
            }
        }
        
        for (Customer customer : customers) {
            if (customer.getProducts().size() > max) {
                max = customer.getProducts().size();
            }
        }
        
        for (Customer customer : customers) {
            if (customer.getProducts().size() == max) {
                System.out.println("Customer ID: " + customer.getId() + ", Customer Name: " + customer.getName());
            }
        }
    }

    
    public void addLoyaltyPoints() {
        if (customers.size() == 0) {
            System.out.println("No customer found.");
            return;
        }
        else {
            for (Customer customer : customers) {
                if (customer.getProducts().size() == 0) {
                    System.out.println("No purchase found.");
                    return;
                }
            }
        }
        
        for (Customer customer : customers) {
            if (customer.getProducts().size() > max) {
                max = customer.getProducts().size();
            }
            else if (customer.getProducts().size() == max) {
                System.out.println("There is more than one customer with most purchased products.");
            }

            else {
                System.out.println("There is no customer with most purchased products.");
            }
        }
        
        for (Customer customer : customers) {
            if (customer.getProducts().size() == max) {
                customer.setLoyaltyPoints(customer.getLoyaltyPoints() + 10);
                System.out.println("Loyalty points added.");
            }
        }
    }

}

