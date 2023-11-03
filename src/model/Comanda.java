package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Comanda implements Serializable {
    static int ultimulId = 0;
    int id;
    LocalDate dataComenda;
    ArrayList<Produs> listaProduse;

    public Comanda( LocalDate dataComenda, ArrayList<Produs> listaProduse) {
        this.id = ultimulId++;
        this.dataComenda = dataComenda;
        this.listaProduse = listaProduse;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDataComenda() {
        return dataComenda;
    }

    public void setDataComenda(LocalDate dataComenda) {
        this.dataComenda = dataComenda;
    }

    public ArrayList<Produs> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(ArrayList<Produs> listaProduse) {
        this.listaProduse = listaProduse;
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", dataComenda=" + dataComenda +
                ", listaProduse=" + listaProduse +
                '}';
    }
}
