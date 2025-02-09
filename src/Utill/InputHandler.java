package Utill;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHandler {
    private static final Scanner sc=new Scanner(System.in);

    public static int getIntInput(String prompt, int min, int max) {
        int choice;
        while(true) {
            try{
                System.out.println(prompt);
                choice=sc.nextInt();
                sc.nextLine();
                if(choice >= min && choice <= max) {
                    return choice;
                } else{
                    System.out.println("잘못된 입력입니다. " + min + "부터 " + max + " 사이의 값을 입력해주세요.");
                }
            }catch(InputMismatchException e) {
                System.out.println("숫자를 입력해주세요!");
                sc.nextLine();
            }
        }
    }
    public static boolean getBooleanInput(String prompt) {
        while (true) {
            System.out.println(prompt + " (1: 예, 2: 아니오)");
            try {
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1){
                    return true;
                }
                if (choice == 2){
                    return false;
                }
                System.out.println("잘못된 입력입니다. 1 또는 2를 입력해주세요.");
            } catch (InputMismatchException e) {
                System.out.println("숫자를 입력해주세요!");
                sc.nextLine();
            }
        }
    }
    public static String getStringInput() {
        return sc.nextLine();
    }
}
