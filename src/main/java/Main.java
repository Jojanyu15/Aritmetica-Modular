import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {

    private static int resta;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese el primer numero:");
            int a = scanner.nextInt();
            System.out.print("Ingrese el segundo numero:");
            int b = scanner.nextInt();
            System.out.print("Ingrese el mod N:");
            int n = scanner.nextInt();
            if (n <= 0) {
                throw new ModularArithmeticException("ERROR: el modulo N es menor o igual a 0");
            }
            System.out.println("\n\nSUMA MODULAR " + a + "+" + b + " = " + sumaModular(a, b, n));
            System.out.println("RESTA MODULAR " + a + "-" + b + " = " + restaModular(a, b, n));
            System.out.println("MULTIPLICACION MODULAR " + a + "X" + b + " = " + multiplicacionModular(a, b, n));
            System.out.println("DIVISIÓN MODULAR " + a + "/" + b + " = " + divisionModular(a, b, n));
        } catch (ModularArithmeticException e) {
            System.out.println(e.getMensaje());
        }

    }

    static int multiplicacionModular(int a, int b, int n) {
        return (a * b) % n;
    }

    static int sumaModular(int a, int b, int n) {
        return (a + b) % n;
    }

    static int restaModular(int a, int b, int n) {
        if ((a - b) <= 0) {
            int resta = a - b;
            System.out.println("REPRESENTACIÓN SIMETRICA RESTA MODULAR: " + resta);
            return resta + n;
        }
        return (a - b) % n;
    }

    static int divisionModular(int a, int b, int n) {
        return (a * obtenerInverso(b, n));
    }

    static int obtenerInverso(int numero, int n) {
        for (int i = 1; i < n; i++) {
            if ((numero * i) % n == 1) {
                return i;
            }
        }
        throw new ModularArithmeticException("ERROR en la división: El numero " + numero + " no es invertible");
    }
}
