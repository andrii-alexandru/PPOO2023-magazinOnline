package model;

import java.util.Arrays;

public class Client {
    static int ultimulId = 0;
    int id;
    String nume;
    String prenume;
    String email;
    String adresa;
    int[] istoricComenzi;

    public Client(String nume, String prenume, String email, String adresa, int[] istoricComenzi) {
        this.id = ultimulId++;
        this.nume = nume;
        this.prenume = prenume;
        this.email = email;
        this.adresa = adresa;
        this.istoricComenzi = istoricComenzi;
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

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public int[] getIstoricComenzi() {
        return istoricComenzi;
    }

    public void setIstoricComenzi(int[] istoricComenzi) {
        this.istoricComenzi = istoricComenzi;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", email='" + email + '\'' +
                ", adresa='" + adresa + '\'' +
                ", istoricComenzi=" + Arrays.toString(istoricComenzi) +
                '}';
    }
}
