package Dhondt_OOP;

public class Main {

    public static void main(String[] args) {


        Partit A;
        Partit B;
        Partit C;
        Partit D;

        Partit[] PARTITS =
                {A = new Partit("A", 120000),
                        B = new Partit("B", 100000),
                        C = new Partit("C", 40000),
                        D = new Partit("D", 6000),
                };

        Eleccions eleccions = new Eleccions(PARTITS, 3, 8);
        eleccions.calcDhondt();
        eleccions.imprimirTaulaQuoficients();
        eleccions.imprimirResultatsEscons();




    }
}
