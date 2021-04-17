package ch.zhaw.example.BoTests.keyStrocke;

import java.util.Scanner;

public class KeyStrocke {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Gib was ein: ");
        String eingabe = sc.next();
        System.out.println("Du hast " + eingabe + " eingegeben.");
    }
}
