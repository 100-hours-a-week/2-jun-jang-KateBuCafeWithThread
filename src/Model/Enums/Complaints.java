package Model.Enums;

public enum Complaints {
    RefundRequire("이거 환불해!"),SlowComplain("왜이리 느려!"),TasteBadComplain("이 커피 맛 없어!");
    private String name;
    Complaints(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
}
