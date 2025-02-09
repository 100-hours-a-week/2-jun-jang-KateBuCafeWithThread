package Model.Enums;

public enum Menu {
    AMERICANO("아메리카노", 3000),
    LATTE("카페라테", 3500),
    LEMONADE("레몬에이드", 4000),
    GRAPEFRUIT_ADE("자몽에이드", 4000),
    CHICKEN_SANDWICH("치킨 샌드위치", 5000),
    EGG_SANDWICH("계란 샌드위치", 5000),
    STRAWBERRY_CAKE("딸기 케이크", 7000),
    CHOCOLATE_CAKE("초콜릿 케이크", 7000);

    private final String name;
    private final int price;
    Menu(String name,int price){
        this.name=name;
        this.price=price;
    }

    public String getName(){
        return this.name;
    }

    public int getPrice(){
        return this.price;
    }


}
