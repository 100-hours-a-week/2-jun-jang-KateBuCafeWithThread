package Model.Customer;

import Model.Enums.*;
import Model.Enums.*;
import Model.Food.Dessert.Cake;
import Model.Food.Dessert.Sandwich;
import Model.Food.Drink.Ade;
import Model.Food.Drink.Coffee;
import Utill.MenuFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Customer {
    private final List<String> orders=  new ArrayList<>();
    private Coffee coffee=null;
    private Ade ade=null;
    private Cake cake=null;
    private Sandwich sandwich=null;

    public Customer(){
        Random rand = new Random();

        // 커피 생성
        coffee = createCoffee(rand);
        orders.add(coffee.getDescription());

        // 에이드 생성 여부
        if (rand.nextBoolean()) {
            ade = createAde(rand);
            orders.add(ade.getDescription());
        }

        // 케이크 생성 여부
        if (rand.nextBoolean()) {
            cake = createCake(rand);
            orders.add(cake.getDescription());
        }

        // 샌드위치 생성 여부
        if (rand.nextBoolean()) {
            sandwich = createSandwich(rand);
            orders.add(sandwich.getDescription());
        }

    }

    public Coffee getCoffee() {

        return coffee;
    }

    public Ade getAde() {

        return ade;
    }
    public Cake getCake() {

        return cake;
    }
    public Sandwich getSandwich() {

        return sandwich;
    }
    public List<String> getOrders() {
        return orders;
    }

    private Coffee createCoffee(Random rand) {
        Menu[] coffees = MenuFactory.getCoffeeMenu();
        DrinkTemperature[] coffeeTemperatures=DrinkTemperature.values();
        CoffeeBeans[] coffeeBeans=CoffeeBeans.values();
        Menu coffee= coffees[rand.nextInt(coffees.length)];
        String name = coffee.getName();
        String temperature = coffeeTemperatures[rand.nextInt(coffeeTemperatures.length)].toString();
        String bean = coffeeBeans[rand.nextInt(coffeeBeans.length)].getName();
        int price = coffee.getPrice();
        int amount = rand.nextInt(5) + 1;
        return new Coffee(price, amount, name, temperature, bean);
    }

    private Ade createAde(Random rand) {
        Menu[] ades = MenuFactory.getAdeMenu();
        boolean isWhipped = rand.nextBoolean();
        Menu ade= ades[rand.nextInt(ades.length)];
        String name = ade.getName();
        int price = ade.getPrice();
        int amount = rand.nextInt(5) + 1;
        return new Ade(price, amount, name, "ICE",isWhipped);
    }

    private Cake createCake(Random rand) {
        Menu[] cakes = MenuFactory.getCakeMenu();
        CakeSizes[] sizes = CakeSizes.values();
        Menu cake= cakes[rand.nextInt(cakes.length)];
        String name = cake.getName();
        String size = sizes[rand.nextInt(sizes.length)].toString();
        int forkCount = rand.nextInt(3) + 1;
        int price = cake.getPrice();
        int amount = rand.nextInt(5) + 1;
        return new Cake(price, amount, name, forkCount, size);
    }

    private Sandwich createSandwich(Random rand) {
        Menu[] sandwiches = MenuFactory.getSandwichMenu();
        SandwichLength[] lengths = SandwichLength.values();
        Menu sandwich= sandwiches[rand.nextInt(sandwiches.length)];
        String name = sandwich.getName();
        int length = lengths[rand.nextInt(lengths.length)].getLength();
        int forkCount = rand.nextInt(3) + 1;
        int price = sandwich.getPrice();
        int amount = rand.nextInt(5) + 1;
        return new Sandwich(price, amount, name, forkCount, length);
    }
}
