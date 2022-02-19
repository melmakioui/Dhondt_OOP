package Dhondt_OOP;

import Dhondt_OOP_REFACTORED.Dhondt_OOP.Eleccions;

public class Main {

    public static void main(String[] args) {


        String[] partits = {"Partit A","Partit B", "Partit C", "Partit D"};
        int[] votacions = {120000, 100000, 40000, 4232};

        Dhondt_OOP_REFACTORED.Dhondt_OOP.Eleccions eleccions = new Eleccions(partits, votacions, 8, 3);
        eleccions.calcDhondt();
        eleccions.imprimirResultatsEscons();
        System.out.println("");
        eleccions.imprimirTaulaQuoficients();


    }
}
