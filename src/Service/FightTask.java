package Service;

import Model.Character.Character;

public class FightTask implements Runnable {

    private final Character attacker;
    private final Character defender;
    private final Object lock;
    public FightTask(Character attacker, Character defender,Object lock) {
        this.attacker = attacker;
        this.defender = defender;
        this.lock = lock;
    }
    @Override
    public void run() {
        while (attacker.isAlive() && defender.isAlive()) {
            //동시에 두개의 스레드가 한 캐릭터를 동시에 공격하는걸 방지
            synchronized (lock) {
                attacker.attack(defender);
                if(!defender.isAlive()) {
                    //상대가 쓰려졌으면 전투 종료
                    lock.notifyAll();
                    break;
                }
                try{
                    //한번 때렸으니, 공격 기회를 넘김
                    lock.notify();;
                    lock.wait();

                }catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                Thread.sleep(1000); // 공격 딜레이
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
