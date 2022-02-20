package Dhondt;

public class Main {

    public static void main(String[] args) {

        String[] partits = {"Partit A","Partit B", "Partit C", "Partit D"};
        int[] votacions = {120000, 100000, 40000, 4232};

        Eleccions eleccions = new Eleccions(partits,votacions,8,3);
        eleccions.calcDhondt();
        eleccions.imprimirResultatsEscons();
        System.out.println();
        eleccions.imprimirTaulaQuoficients();


    }

}
