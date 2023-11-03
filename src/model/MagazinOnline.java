package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MagazinOnline implements Serializable{
    static MagazinOnline instance;
    int[] stocProduse;
    int numarProduse;
    ArrayList<Produs> listaProduse;

    private MagazinOnline() {
        this.numarProduse = 50;
        this.stocProduse = new int[50];
        this.listaProduse = new ArrayList<Produs>();
    }

    public static MagazinOnline getInstance() {
        if (instance == null) {
            instance = new MagazinOnline();
        }
        return instance;
    }

    public int[] getstocProduse() {
        return stocProduse;
    }

    public void setstocProduse(int[] stocProduse) {
        this.stocProduse = stocProduse;
    }

    public int getNumarProduse() {
        return numarProduse;
    }

    public void setNumarProduse(int numarProduse) {
        this.numarProduse = numarProduse;
    }

    public ArrayList<Produs> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(ArrayList<Produs> listaProduse) {
        this.listaProduse = listaProduse;
    }

    public void adaugaProdus(Produs produs, int cantitate) {
//        stocProduse[produs.getId()][produs.getCategorie()] += cantitate;
    }

    public void stergeProdus(Produs produs, int cantitate) {
//        stocProduse[produs.getId()][produs.getCategorie()] -= cantitate;
    }

    public int getCantitateProdus(Produs produs) {
//        return stocProduse[produs.getId()][produs.getCategorie()];
        return 0;
    }

    public void writeDataToFile(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(instance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MagazinOnline readDataFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName)) ) {
            return (MagazinOnline) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void initialData(){
        this.numarProduse = 10;
        this.listaProduse.add(new Produs("Laptop", 800.0f));
        this.listaProduse.add(new Produs("Smartphone", 500.0f));
        this.listaProduse.add(new Produs("Tablet", 300.0f));
        this.listaProduse.add(new Produs("Headphones", 50.0f));
        this.listaProduse.add(new Produs("Keyboard", 30.0f));
        this.listaProduse.add(new Produs("Mouse", 20.0f));
        this.listaProduse.add(new Produs("Monitor", 250.0f));
        this.listaProduse.add(new Produs("Printer", 150.0f));
        this.listaProduse.add(new Produs("External Hard Drive", 100.0f));
        this.listaProduse.add(new Produs("Webcam", 40.0f));

        stocProduse = new int[this.listaProduse.size()];

        for (int i = 0; i < this.listaProduse.size(); i++) {
            Produs produs = this.listaProduse.get(i);
            stocProduse[i] = new Random().nextInt(101);
        }
    }

    @Override
    public String toString() {
        return "MagazinOnline{" +
                "stocProduse=" + Arrays.toString(stocProduse) +
                ", numarProduse=" + numarProduse +
                ", listaProduse=" + listaProduse +
                '}';
    }
}
