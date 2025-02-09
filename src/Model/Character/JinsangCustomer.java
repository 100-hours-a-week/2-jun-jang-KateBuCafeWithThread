package Model.Character;

import Model.Enums.Complaints;

import java.util.Random;

public class JinsangCustomer extends Character{
    private final Complaints complaint;
    public JinsangCustomer(){
        super("진상손님",80,40);

        Complaints[] complaints= Complaints.values();
        this.complaint = complaints[new Random().nextInt(complaints.length)];
    }

    public Complaints getComplaint(){
        return complaint;
    }

}
