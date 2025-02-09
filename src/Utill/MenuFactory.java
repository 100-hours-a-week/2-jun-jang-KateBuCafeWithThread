package Utill;

import Model.Enums.*;
import Model.Enums.*;
import Model.Food.Dessert.Cake;
import Model.Food.Dessert.Sandwich;
import Model.Food.Drink.Ade;
import Model.Food.Drink.Coffee;

public class MenuFactory {
    //중복되는 선택지
    private static int selectAmount(){
        int amountCount = InputHandler.getIntInput("마지막으로 몇 개 혹은 몇 잔 시키셨나요?", 1, 100);
        return amountCount;
    }
    private static int selectTemperature(){
        int temperatureChoice = InputHandler.getIntInput("ICE 인가요? HOT 인가요?\n1. ICE\n2. HOT", 1, 2);
        return temperatureChoice;
    }
    private static int selectForkAmount(){
        int ForkCount= InputHandler.getIntInput("포크 개수를 입력해주세요.", 1, 100);
        return ForkCount;
    }
    //메뉴 관련
    public static Menu[] getCoffeeMenu(){
        Menu[] coffees={Menu.AMERICANO,Menu.LATTE};
        return coffees;
    }
    public static Menu[] getCakeMenu(){
        Menu[] cakes = {Menu.STRAWBERRY_CAKE,Menu.CHOCOLATE_CAKE};
        return cakes;
    }
    public static Menu[] getAdeMenu(){
        Menu[] ades = {Menu.LEMONADE,Menu.GRAPEFRUIT_ADE};
        return ades;
    }
    public static Menu[] getSandwichMenu(){
        Menu[] sandwiches = {Menu.CHICKEN_SANDWICH,Menu.EGG_SANDWICH};
        return sandwiches;
    }
    // 메뉴 리스트 출력
    public static void showMenu(Menu[] menuList) {
        for (int i = 0; i < menuList.length; i++) {
            System.out.println((i + 1) + ". " + menuList[i].getName() + " - " + menuList[i].getPrice() + "원");
        }
        System.out.println((menuList.length + 1) + ". 주문하지 않음");
    }
    //커피 원두 종류 출력
    public static void showCoffeeBeans() {
        System.out.println("커피 원두의 종류");
        CoffeeBeans[] coffeeBeans=CoffeeBeans.values();
        for(int i=0;i<coffeeBeans.length;i++){
            System.out.println((i + 1) + ". " + coffeeBeans[i].getName());
        }
    }
    //케이크 사이즈 출력
    public static void showSize(){
        System.out.println("케이크의 사이즈: ");
        CakeSizes[] cakeSizes=CakeSizes.values();
        for(int i=0;i<cakeSizes.length;i++){
            System.out.println((i + 1) + ". " + cakeSizes[i]);
        }
    }
    //샌드위치 길이 출력
    public static void showLength(){
        System.out.println("샌드위치의 길이");
        SandwichLength[] sandwichLengths=SandwichLength.values();
        for(int i=0;i<sandwichLengths.length;i++){
            System.out.println((i + 1) + ". " + sandwichLengths[i]+ " "+ sandwichLengths[i].getLength()+"Cm");
        }

    }
    public static Coffee createCoffee(){
        //커피선택
        System.out.println("커피 종류: ");
        Menu[] coffees=getCoffeeMenu();
        DrinkTemperature[] coffeeTemperatures=DrinkTemperature.values();
        CoffeeBeans[] coffeeBeans=CoffeeBeans.values();
        showMenu(coffees);
        int coffeeChoice = InputHandler.getIntInput("손님이 원하는 커피는 무엇인가요? :", 1, coffees.length+1);
        if(coffeeChoice ==coffees.length+1) {
            return null;
        }
        Menu coffee = coffees[coffeeChoice -1];
        //온도 선택
        int temperatureChoice = selectTemperature();
        String temperature=coffeeTemperatures[temperatureChoice-1].toString();
        //커피원두 선택
        showCoffeeBeans();
        int beanChoice = InputHandler.getIntInput("원두 종류는 무엇인가요? : ", 1, coffeeBeans.length);
        String coffeeBean=coffeeBeans[beanChoice-1].getName();
        // 수량 선택
        int amountChoice = selectAmount();

        return new Coffee(coffee.getPrice(),amountChoice,coffee.getName(),temperature,coffeeBean);
    }

    public static Ade createAde(){
        //에이드 선택
        System.out.println("에이드 종류: ");
        Menu[] ades=getAdeMenu();
        showMenu(ades);
        int drinkChoice = InputHandler.getIntInput("손님이 원하는 에이드는 무엇인가요?", 1, ades.length+1);
        if(drinkChoice==ades.length+1){
            return null;
        }
        Menu ade = ades[drinkChoice-1];
        //에이드 온도 선택
        DrinkTemperature[] adeTemperatures=DrinkTemperature.values();
        int temperatureChoice = selectTemperature();
        String temperature=adeTemperatures[temperatureChoice-1].toString();
        //휘핑크림 여부
        boolean isWhipped = InputHandler.getBooleanInput("휘핑크림을 추가할까요?");
        //수량 선택
        int amountChoice = selectAmount();
        return new Ade(ade.getPrice(),amountChoice,ade.getName(),temperature,isWhipped);
    }
    public static Cake createCake(){
        //케이크 선택
        System.out.println("케이크 종류: ");
        Menu[] cakes=getCakeMenu();
        showMenu(cakes);
        int cakeChoice = InputHandler.getIntInput("손님이 원하는 케이크는 무엇인가요?", 1, cakes.length+1);
        if (cakeChoice == cakes.length+1) {
            return null;
        }
        Menu cake =  cakes[cakeChoice-1];
        //케이크 사이즈 선택
        CakeSizes[] cakeSizes= CakeSizes.values();
        showSize();
        int sizeChoice = InputHandler.getIntInput("사이즈를 선택해주세요.", 1, cakeSizes.length);
        String cakeSize = cakeSizes[sizeChoice - 1].toString();
        //포크 개수 선택
        int forkCount = selectForkAmount();
        //수량 선택
        int amountChoice = selectAmount();
        return new Cake(cake.getPrice(), amountChoice, cake.getName(), forkCount, cakeSize);
    }
    public static Sandwich createSandwich(){
        //샌드위치 종류
        System.out.println("샌드위치 종류: ");
        Menu[] sandwiches=getSandwichMenu();
        showMenu(sandwiches);
        int sandwichChoice=InputHandler.getIntInput("손님이 원하는 샌드위치는 무엇인가요?", 1, sandwiches.length+1);
        if(sandwichChoice==sandwiches.length+1) {
            return null;
        }
        Menu sandwich =  sandwiches[sandwichChoice-1];
        //샌드위치 길이
        SandwichLength[] sandwichLengths=SandwichLength.values();
        showLength();
        int lengthChoice = InputHandler.getIntInput("샌드위치 길이를 선택해주세요", 1, sandwichLengths.length);
        int sandwichLength=sandwichLengths[lengthChoice - 1].getLength();
        //포크 개수
        int forkCount = selectForkAmount();
        //수량 선택
        int amountChoice = selectAmount();
        return new Sandwich(sandwich.getPrice(), amountChoice, sandwich.getName(),forkCount,sandwichLength);
    }
}
