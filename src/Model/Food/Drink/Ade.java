package Model.Food.Drink;

public class Ade extends Drink {
    private boolean isWhipped;
    public Ade(int price, int amount, String name, String temperature, boolean isWhipped) {
        super(price,amount,name,"ICE");
        this.isWhipped = isWhipped;
    }
    public boolean isWhipped() {
        return isWhipped;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Ade ade = (Ade) obj;
        return this.getAmount() == ade.getAmount() &&
                this.getName().equals(ade.getName()) &&
                this.getTemperature().equals(ade.getTemperature()) &&
                this.isWhipped() == ade.isWhipped();
    }
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("그리고 ")
                    .append(getName())
                    .append(" ")
                    .append(getAmount())
                    .append("잔 주세요. ");
            if(isWhipped()){
                sb.append("휘핑크림은 올려주세요!\n");
            }else{
                sb.append("휘핑크림은 빼고요! \n");
            }
        return sb.toString();
    }



}
