package Model.Character;

import java.util.Random;

public class Character  {
    private String name;
    private int health;
    private int attackPower;

    public Character(String name,int health, int attackPower){
        this.name = name;
        this.health = health;
        this.attackPower=attackPower;
    }

    public boolean isAlive(){
        return health>0;
    }

    public synchronized void attack(Character character){


        if(character.isAlive()){

            if(new Random().nextInt(10)<7){
                System.out.println(name + "이(가) " + character.name + "을(를) 공격합니다! (공격력: " + attackPower + ")");
                character.takeDamage(attackPower);
            }else{
                System.out.println(name + "이(가) " + character.name + "을(를) 빚맞췄습니다! ");
            }

        }
    }
    public void takeDamage(int damage){
        if(new Random().nextInt(10)<7){
            health-=damage;
            System.out.println(name +"이(가) "+ damage+"의 피해를 입었습니다. 남은 체력: "+Math.max(health,0));
        }else{
            health-=damage/2;
            System.out.println(name + "이(가) 방어에 성공했습니다! 데미지를 절반만 맞습니다. 남은 체력: "+Math.max(health,0));
        }

    }

}
