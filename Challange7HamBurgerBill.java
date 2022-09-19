
class Hamburger{
    public Hamburger() {
    }

    private String name;
    private String meat;
    private double price;
    private String breadRollType;

    private String addition1Name;
    private double addition1Price;
    private String addition2Name;
    private double addition2Price;
    private String addition3Name;
    private double addition3Price;
    private String addition4Name;
    private double addition4Price;

    public Hamburger(String name, String meat, double price, String breadRollType) {
        this.name = name;
        this.meat = meat;
        this.price = price;
        this.breadRollType = breadRollType;
    }

    public void addHamburgerAddition1(String name,double price){
        this.addition1Name=name;
        this.addition1Price=price;
    }
    public void addHamburgerAddition2(String name,double price){
        this.addition2Name=name;
        this.addition2Price=price;
    }

    public void addHamburgerAddition3(String name,double price){
        this.addition3Name=name;
        this.addition3Price=price;
    }
    public void addHamburgerAddition4(String name,double price){
        this.addition4Name=name;
        this.addition4Price=price;
    }
    public double itemizeHamburger()
    {
        return addition1Price+addition2Price+addition3Price+addition4Price+price ;
    }


}
class DeluxeBurger{

}
class HealthyBurger extends Hamburger{
    
    private String meat;
    private double price;
    private String healthyExtra1Name;
    private double healthyExtra1Price;
    private String healthyExtra2Name;
    private double healthyExtra2Price;

    public HealthyBurger(String meat, double price) {
        this.meat = meat;
        this.price = price;
    }

    @Override
    public double itemizeHamburger() {
        return super.itemizeHamburger();
    }

    public void addHealthyAddition1(String lentils, double v) {
    }
}


public class Challange7HamBurgerBill {
    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("Basic", "Sausage", 3.56, "White");
        hamburger.addHamburgerAddition1("Tomato", 0.27);
        hamburger.addHamburgerAddition2("Lettuce", 0.75);
        hamburger.addHamburgerAddition3("Cheese", 1.13);
        System.out.println("Total Burger price is " + hamburger.itemizeHamburger());

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 5.67);
        healthyBurger.addHamburgerAddition1("Egg", 5.43);
        healthyBurger.addHealthyAddition1("Lentils", 3.41);
        System.out.println("Total Healthy Burger price is  " + healthyBurger.itemizeHamburger());

    }
}
