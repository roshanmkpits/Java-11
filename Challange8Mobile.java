//Implement the master class MobilePhone, that holds the ArrayList of Contacts, with the following attributes:
//
//        -  Two fields, a String called myNumber and an ArrayList of type Contact called myContacts.
//
//        -  A constructor that takes a String (the phone number) and initialises myNumber and instantiates myContacts.
//
//        -  And seven methods, they are (their functions are in their names):
//
//        -  addNewContact(), has one parameter of type Contact and returns a boolean. Returns true if the contact doesn't exists, or false if the contact already exists.
//
//        -  updateContact(), has two parameters of type Contact (the old contact that will be updated with the new contact) and returns a boolean. Returns true if the contact exists and was updated successfully, or false if the contact doesn't exists.
//
//        -  removeContact(), has one parameter of type Contact and returns a boolean. Returns true if the contact exists and was removed successfully, or false if the contact doesn't exists.
//
//        -  findContact(), has one parameter of type Contact and returns an int. The returned value is it's position in the ArrayList, it will either be -1 (doesn't exists) or a value greater than or equal to 0 (does exists).
//
//        -  findContact(), same as above, only it has one parameter of type String.
//
//        -  queryContact(), has one parameter of type String and returns a Contact. Use the String to search for the name and then return the Contact. Return null otherwise.



import java.util.ArrayList;
import java.util.Scanner;

class MobilePhone {
    private String myNumber; // Acts as identifier of each mobile phone
    private ArrayList<Contacts> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contacts>();
    }

    public void printOptions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print choice options.");
        System.out.println("\t 1 - To print the list of contacts.");
        System.out.println("\t 2 - To add a new contact.");
        System.out.println("\t 3 - To update an existing contact.");
        System.out.println("\t 4 - To remove a contact.");
        System.out.println("\t 5 - To search / find a contact.");
        System.out.println("\t 6 - To quit the application.");
    }

    public void printContacts() {
        System.out.println("Contact list (" + this.myContacts.size() + "):");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.print((i + 1) + ". ");
            printContact(i);
        }
    }

    public void addContact(String name, String phone) {
        if (inContacts(name)){
            System.out.println("Contact already on file");
        } else {
            Contacts newContact = new Contacts(name, phone);
            this.myContacts.add(newContact);
        }

    }

    private void updateContact(int position, Contacts newContact) {
        myContacts.set(position, newContact);
        System.out.println("Contact " + this.myContacts.get(position).getName() + " has been modified.");
    }

    public void updateContact(String name, String newName, String newPhone) {
        int position = findPosition(name);
        Contacts contact = this.getContact(name);
        contact.setName(newName);
        contact.setPhone(newPhone);
        System.out.println("Contact " + this.myContacts.get(position).getName() + " has been modified.");
        printContact(newName);
    }

    public void removeContact (String name) {
        int position = findPosition(name);
        if (inContacts(name)) {
            this.myContacts.remove(position);
            System.out.println("Contact " + name + " has been removed.");
        } else {
            System.out.println("Contact not found.");
        }
    }
    // Tim Buchalka builds this as a method in Contacts, which makes it somewhat easier
    public Contacts getContact(String name) {
        for (int i = 0; i < this.myContacts.size(); i++) {

            if (this.myContacts.get(i).getName().equals(name)) {
                return this.myContacts.get(i);
            }
        }
        return null;
    }

    private int findPosition(String name) {
        return this.myContacts.indexOf(getContact(name));
    }

    public boolean inContacts(String name) {
        if (this.findPosition(name)>=0){
            return true;
        }
        return false;
    }

    private void printContact (int position) {
        System.out.println(this.myContacts.get(position).getName() + ": " + this.myContacts.get(position).getPhone());
    }

    public void printContact (String name) {
        printContact(this.findPosition(name));
    }


}
class Contacts {
    private String name;
    private String phone;

    public Contacts(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Contacts createContact (String name, String phone) {

        return new Contacts(name,phone);
    }
}



public class Challange8Mobile {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobile = new MobilePhone("4123043993");
    public static void main(String[] args) {

        boolean quit = false;
        int choice;

        mobile.printOptions();

        while (!quit) {
            System.out.println("Please enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    mobile.printOptions();
                    break;
                case 1:
                    mobile.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 6:
                    quit = true;
                    break;
            }
        }

    }

    private static void addContact() {
        System.out.println("Enter name of contact to add:");
        String name = scanner.nextLine();
        System.out.println("Enter " + name + "'s phone number:");
        String phone = scanner.nextLine();
        mobile.addContact(name, phone);

    }
    private static void updateContact() {
        int option;
        System.out.println("Enter name of contact to update:");
        String name = scanner.nextLine();
        String newName = mobile.getContact(name).getName();
        String newPhone = mobile.getContact(name).getPhone();

        if (mobile.inContacts(name)) {
            System.out.println("Update (1) name, (2) phone, or (3) both?");
            option = scanner.nextInt();
            scanner.nextLine();  // nextInt() doesn't finish the line,so this one "flushes" it

            switch (option) {
                case 1:
                    System.out.println("Enter new name:");
                    newName = scanner.nextLine();
                    break;
                case 2:
                    System.out.println("Enter new phone:");
                    newPhone = scanner.nextLine();
                    break;
                case 3:
                    System.out.println("Enter new name:");
                    newName = scanner.nextLine();
                    System.out.println("Enter new phone:");
                    newPhone = scanner.nextLine();
                    break;
                default:
                    System.out.println("Option entered not valid.");
                    break;
            }
            mobile.updateContact(name, newName, newPhone);
        } else{
            System.out.println("Name provided not in contacts.");
        }
    }

    private static void removeContact(){
        System.out.println("Enter name of contact to remove:");
        String name = scanner.nextLine();
        if (mobile.inContacts(name)){
            mobile.removeContact(name);
        } else {
            System.out.println("Name provided not in contacts.");
        }
    }

    private static void findContact (){
        System.out.println("Enter name of contact to be found:");
        String name = scanner.nextLine();
        if (mobile.inContacts(name)){
            System.out.println("Contact found.");
            mobile.printContact(name);
        } else {
            System.out.println("Name provided not in contacts.");
        }
    }
}
