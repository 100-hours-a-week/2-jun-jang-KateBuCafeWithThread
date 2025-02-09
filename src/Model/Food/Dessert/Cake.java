package Model.Food.Dessert;

public class Cake extends Dessert{
    private String size;
    public Cake(int price, int amount,String name,int pork,String size){
        super(price,amount,name,pork);
        this.size = size;
    }
    public String getSize(){
        return size;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Cake cake = (Cake) obj;
        return this.getAmount() == cake.getAmount() &&
                this.getName().equals(cake.getName()) &&
                this.getSize().equals(cake.getSize()) &&
                this.getFork() == cake.getFork();
    }
    @Override
    public String getDescription() {
        StringBuilder sb = new StringBuilder();
        sb.append("그리고 케이크는 ")
                .append(getName())
                .append("로 ")
                .append("사이즈는 ")
                .append(getSize())
                .append("로 ")
                .append("포크는 ")
                .append(getFork())
                .append("개 주시고요. ")
                .append(getAmount())
                .append("개 주세요! \n");
        return sb.toString();
    }


}
