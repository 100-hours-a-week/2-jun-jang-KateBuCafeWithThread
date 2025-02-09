package Utill;

import Model.Character.JinsangCustomer;
import Model.Character.Manager;
import Service.FightTask;

public class FightManager {

    private Manager manager;
    private JinsangCustomer jinsangCustomer;
    private final Object lock = new Object();
    public FightManager(String managerName) {
        manager = new Manager(managerName);
        jinsangCustomer = new JinsangCustomer();

    }



    public boolean startFight() throws InterruptedException {
        System.out.println("진상손님 : "+jinsangCustomer.getComplaint().getName());
        System.out.println("전투 시작!");
        System.out.println("--------------------------------------------------------------");
        Thread.sleep(1000);
        FightTask managerAttack=new FightTask(manager,jinsangCustomer,lock);
        FightTask jinsangCustomerAttack=new FightTask(jinsangCustomer,manager,lock);

        Thread managerThread = new Thread(managerAttack);
        Thread jinsangThread = new Thread(jinsangCustomerAttack);

        managerThread.start();
        jinsangThread.start();

        managerThread.join();
        jinsangThread.join();

        return endFight();
    }
    private boolean endFight(){
        System.out.println("--------------------------------------------------------------");
        if(manager.isAlive()){
            System.out.println("매니저 승리! 진상을 해치웠습니다!");
            System.out.println("진상 손님의 주머니를 뒤져 10,000원을 획득했습니다!");
            return true;
        }else{
            System.out.println("진상 손님이 승리.. 매니저가 패배했습니다.");
            System.out.println("진상 손님에게 피해 보상금으로 5,000원을 지불했습니다..");
            return false;
        }
    }

}
