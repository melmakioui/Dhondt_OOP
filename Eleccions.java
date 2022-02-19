package Dhondt_OOP;

public class Eleccions {

    private final Partit[] partits;
    private final int esconsPerAssignar;
    private final int numPartits;
    private final float[][] taulaResultats;

    public Eleccions(Partit[] partits, float percentatgeMinim, int esconsPerAssignar) {
        this.partits = partits;
        this.esconsPerAssignar = esconsPerAssignar;
        this.numPartits = partits.length;
        this.taulaResultats = new float[this.numPartits][esconsPerAssignar];

        initPartitsAmbPercentatgeMinim(partits, percentatgeMinim);
        initTaulaDhondt(partits,esconsPerAssignar);
    }

    private int votsTotals() {
        int total = 0;

        for (int i = 0; i < this.numPartits; i++) {
            total += partits[i].getVots();
        }
        return total;

    }

    private void initPartitsAmbPercentatgeMinim(Partit[] partits, float percentatgeMinim) {
        float minimVotacions = ((float) votsTotals() * (percentatgeMinim /100));

        for (int i = 0; i < this.numPartits; i++) {
            this.partits[i].setParticipa((this.partits[i].getVots() >= minimVotacions));
        }
    }

    private void initTaulaDhondt(Partit[] partits, int esconsPerAssignar) {
        for (int i = 0; i < numPartits; i++) {
            for (int j = 0; j < esconsPerAssignar; j++) {
                this.taulaResultats[i][j] = (partits[i].getVots() / ((float) j + 1));
            }
        }
    }


    public void calcDhondt(){

        float max = Float.MIN_VALUE;
        int maxIndex = 0;
        int contador = 0;

        while (contador < esconsPerAssignar) {

            for (int i = 0; i < this.numPartits; i++) {
                if (max < this.taulaResultats[ i ] [ partits[ i ].getEscons() ] && partits[ i ].isParticipa()) {
                    max = this.taulaResultats[ i ] [ partits[ i ].getEscons() ];
                    maxIndex = i;
                }
            }
            partits[maxIndex].setEscons(1);
            max = Float.MIN_VALUE;
            contador++;
        }
    }



    public void imprimirTaulaQuoficients() {

        System.out.println("TAULA QUOFICIENTS");

        for (int i = 0; i < this.numPartits; i++) {
            if (partits[i].isParticipa()) {
                System.out.print(partits[i].getNom() + " | ");
            }
            for (int j = 0; j < esconsPerAssignar; j++) {
                if (partits[i].isParticipa()) {
                    System.out.print(" " + this.taulaResultats[i][j] + " | ");
                }
            }
            System.out.println("");
        }
    }



    public void imprimirResultatsEscons() {

        System.out.println("RESULTATS ESCONS PER PARTITS");

        for (int i = 0; i < this.numPartits; i++) {
            if (partits[i].isParticipa()) {
                System.out.println(partits[i].getNom() + " obté en total: " + partits[i].getEscons());
            } else System.out.println(partits[i].getNom() + " no participa, no arriba als vots minims...");
        }
    }

}
