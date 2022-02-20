package Dhondt;

public class Eleccions {

    private final int numPartits;
    private final int esconsPerAssignar;
    private final Partit[] partits;
    private final float[][] taulaQuoficients;

    public Eleccions(String[] partits, int[] votacions, int esconsPerAssignar, int percentatgeMinim) {
        this.numPartits = partits.length;
        this.partits = new Partit[this.numPartits];
        this.esconsPerAssignar = esconsPerAssignar;
        this.taulaQuoficients = new float[numPartits][this.esconsPerAssignar];

        initPartits(partits, votacions);
        initDeterminarParticipants(percentatgeMinim);
        initTaulaDhondt();

    }

    private void initPartits(String[] partits, int[] votacions) {

        for (int i = 0; i < this.numPartits; i++) {
            this.partits[i] = new Partit(partits[i], votacions[i]);
            //System.out.println(this.partits[i].getVots());
        }
    }


    private int votsTotals() {
        int total = 0;

        for (int i = 0; i < this.numPartits; i++) {
            total += partits[i].getVots();
        }
        return total;
    }


    private void initDeterminarParticipants(float percentatgeMinim) {
        float minimVotacions = ((float) votsTotals() * (percentatgeMinim / 100));
        for (int i = 0; i < numPartits; i++) {
            if ((partits[i].getVots() >= minimVotacions))
                partits[i].potParticipar();
        }
    }


    private void initTaulaDhondt() {
        for (int i = 0; i < numPartits; i++) {
            for (int j = 0; j < esconsPerAssignar; j++) {
                taulaQuoficients[i][j] = (this.partits[i].getVots() / ((float) j + 1));
            }
        }
    }

    public void calcDhondt() {

        float maxQuoficient = 0;
        int maxIndex = 0;
        float votsQuoficient;
        boolean esCandidat;

        for (int e = 0; e < esconsPerAssignar; e++) {
            for (int i = 0; i < numPartits; i++) {

                votsQuoficient = taulaQuoficients[ i ][ partits[i].getEscons() ];
                esCandidat = partits[i].esParticipant();

                if ( maxQuoficient < votsQuoficient && esCandidat) {
                    maxQuoficient = votsQuoficient;
                    maxIndex = i;
                }
            }
            partits[maxIndex].addEscons();
            maxQuoficient = 0;

        }
    }


    public void imprimirTaulaQuoficients() {

        System.out.println("TAULA QUOFICIENTS");

        for (int i = 0; i < this.numPartits; i++) {
            if (partits[i].esParticipant()) {
                System.out.print(partits[i].getNom() + " | ");
            }
            for (int j = 0; j < esconsPerAssignar; j++) {
                if (partits[i].esParticipant()) {
                    System.out.print(" " + taulaQuoficients[i][j] + " | ");
                }
            }
            System.out.println();
        }
    }


    public void imprimirResultatsEscons() {

        System.out.println("RESULTATS ESCONS PER PARTITS");

        for (int i = 0; i < this.numPartits; i++) {
            if (partits[i].esParticipant()) {
                System.out.println(partits[i].getNom() + " obté en total: " + partits[i].getEscons());
            } else System.out.println(partits[i].getNom() + " no participa, no arriba als vots minims...");
        }
    }


}
