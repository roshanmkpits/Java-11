import java.util.ArrayList;

class Bank{
    private String name;
    ArrayList<Branch> branches=new ArrayList<Branch>();

    public Bank(String name) {
        this.name = name;
    }

    public void addBranch(String branchName) {
        Branch branch=new Branch(branchName);
        branches.add(branch);
    }
    public void listOfBranch() {
        for (Branch ob:branches) {
            System.out.println(ob);
        }
    }

    public void addCustomer(String branchName, String customerName, double initialTrans) {
        Customer customer=new Customer(customerName,initialTrans);
        Branch branch=new Branch(branchName);
        branch.getCustomers().add(customer);
        System.out.println(customerName+""+" customer added to branch "+branchName);
    }
    void getCutomerFromBranch(){
        
    }
}

class Branch{

    private String name;
    ArrayList<Customer> customers=new ArrayList<Customer>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public Branch(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "name='" + name + '\'' +
                '}';
    }
}



class Customer {

    private String customerName;
    private double transaction;

    public Customer(String customerName, double transaction) {
        this.customerName = customerName;
        this.transaction = transaction;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTransaction() {
        return transaction;
    }

    public void setTransaction(double transaction) {
        this.transaction = transaction;
    }
}


public class Challange8Bank {
    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");
        bank.addBranch("Adelaide");
        bank.addBranch("ramnagar");
        bank.listOfBranch();
        bank.addCustomer("Adelaide", "Tim", 50.05);

    }
}
