import java.util.ArrayList;

public class Customer extends User {

   private  String address;
   private double balance;
   private int loyaltyPoints;
   private ArrayList<Product> products;
  
      public Customer(int id, double balance, String name, String address) {
          super(id, name);
          this.address = address;
          this.balance = balance;
          products = new ArrayList<>();
  
      }
  
      public String getAddress() {
          return address;
      }
  
      public void setAddress(String address) {
          this.address = address;
      }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public int getLoyaltyPoints() {
            return loyaltyPoints;
        }

        public void setLoyaltyPoints(int loyaltyPoints) {
            this.loyaltyPoints = loyaltyPoints;
        }

        //get products
        public ArrayList<Product> getProducts() {
            return products;
        }
  

  }
  