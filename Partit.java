package Dhondt_OOP;

public class Partit {
    private String nom;
    private int vots;
    private int escons;
    private boolean participa;

    public Partit(String nom, int vots) {
        this.nom = nom;
        this.vots = vots;
        this.escons = getEscons();
        this.participa = isParticipa();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getVots() {
        return vots;
    }

    public void setVots(int vots) {
        this.vots = vots;
    }

    public int getEscons() {
        return escons;
    }

    public void setEscons(int escons) {
        this.escons += escons;
    }

    public boolean isParticipa() {
        return participa;
    }

    public void setParticipa(boolean participa) {
        this.participa = participa;
    }
}


