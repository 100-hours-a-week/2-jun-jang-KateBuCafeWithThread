package Model.Food.Drink;

public class Coffee extends Drink{
    private String coffeeBean;

    public Coffee(int price, int amount , String name, String temperature, String coffeeBean) {
        super(price, amount, name, temperature);
        this.coffeeBean = coffeeBean;
    }
    public String getCoffeeBean() {
        return coffeeBean;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Coffee coffee = (Coffee) obj;
        return this.getAmount() == coffee.getAmount() &&
                this.getName().equals(coffee.getName()) &&
                this.getTemperature().equals(coffee.getTemperature()) &&
                this.getCoffeeBean().equals(coffee.getCoffeeBean());
    }

    @Override
    public String getDescription() {
        StringBuilder sb=new StringBuilder();
        sb.append("안녕하세요! 먼저 커피는 ")
                .append(getName())
                .append(" 로 주시고, ")
                .append(getTemperature())
                .append("로 해주세요. 아 원두는 ")
                .append(getCoffeeBean())
                .append("로 해주시고 ")
                .append(getAmount())
                .append("잔 주세요. \n");

        return sb.toString();
    }


}
