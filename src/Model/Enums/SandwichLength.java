package Model.Enums;

public enum SandwichLength {
    HALF(15),FULL(30);
    private int length;
    SandwichLength(int length){
        this.length=length;
    }
    public int getLength(){
        return length;
    }

}
