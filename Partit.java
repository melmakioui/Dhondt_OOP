package Dhondt;

public class Partit {

    private String nom;
    private int vots;
    private int escons = 0;
    private boolean participa = false;

    public Partit(String nom, int vots) {
        this.nom = nom;
        this.vots = vots;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVots(){
        return vots;
    }

    public void setVots(int vots) {
        this.vots = vots;
    }

    public int getEscons(){
        return escons;
    }

    public void addEscons() {
        escons++;
    }

    public boolean isParticipa(){
        return participa;
    }

    public void potParticipar(){
        this.participa = true;
    }


}
