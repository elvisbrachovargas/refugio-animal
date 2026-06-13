package Util;

import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    public static int leerInt() {
        int numero = sc.nextInt();
        sc.nextLine(); // Limpia el enter
        return numero;
    }
}