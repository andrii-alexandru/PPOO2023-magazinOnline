package model;

import java.io.Serializable;

public class Produs implements Serializable {
    static int ultimulId = 0;
    int id;
    String nume;
    float pret;

    public Produs(String nume, float pret) {
        this.id = ultimulId++;
        this.nume = nume;
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", pret=" + pret +
                '}';
    }
}
