package model;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MagazinOnline implements Serializable{
    static MagazinOnline instance;
    int[] stocProduse;
    ArrayList<Produs> listaProduse;

    public static MagazinOnline getInstance() {
        if (instance == null) {
            instance = new MagazinOnline();
        }
        return instance;
    }

    public int getStocProdus(int position) {
        if (position >= 0 && position < stocProduse.length) {
            return stocProduse[position];
        } else {
            throw new IndexOutOfBoundsException("Invalid position");
        }
    }

    public void setstocProduse(int[] stocProduse) {
        this.stocProduse = stocProduse;
    }

    public ArrayList<Produs> getListaProduse() {
        return listaProduse;
    }

    public void setListaProduse(ArrayList<Produs> listaProduse) {
        this.listaProduse = listaProduse;
    }

    public void adaugaProdus(Produs produs, int cantitate) {
        System.out.println("Dimensiune lista produse inainte: " +listaProduse.size());
        listaProduse.add(produs);
        System.out.println("Dimensiune lista produse dupa: " +listaProduse.size());

        int[] newStocProduse = new int[listaProduse.size()];

        for (int i = 0; i < listaProduse.size() - 1; i++) {
            newStocProduse[i] = stocProduse[i];
        }

        newStocProduse[listaProduse.size()-1] = cantitate;

        stocProduse = newStocProduse;

        System.out.println("stoc produse: " + stocProduse.toString());
    }

    public Produs cautaProdus(int idProdus){
        for (Produs produs : listaProduse) {
            if (produs.getId() == idProdus) {
                return produs;
            }
        }
        System.out.println("Nu am gasit nici un produs cu id = " + idProdus);
        return null;
    }

    public void stergeProdus(int idProdus) {
        for (Produs produs : listaProduse) {
            if (produs.getId() == idProdus) {
                Produs produsSters = produs;
                listaProduse.remove(produs);
                stocProduse[idProdus] = -1;
                System.out.println("Produsul " + produs.getNume() + "a fost sters cu succes!");
                return;
            }
        }
        System.out.println("Nu s-a gasit nici un produs cu id = " + idProdus);
    }


    public int getCantitateProdus(Produs produs) {
//        return stocProduse[produs.getId()][produs.getCategorie()];
        return 0;
    }

    public static void writeDataToFile(String fileName) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName, false))) {
            outputStream.writeObject(instance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readDataFromFile(String fileName) {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName)) ) {
            Object object = inputStream.readObject();
            if (object instanceof MagazinOnline) {
                instance = (MagazinOnline) object;
            }
            else{
                System.out.println("Citirea nu a rezultat intr-o instanta MagazinOnline!");
            }

            if (instance.getListaProduse()!= null && !instance.getListaProduse().isEmpty()) {
                Produs lastItem = instance.getListaProduse().get(instance.getListaProduse().size() - 1);

                Produs.setUltimulId(lastItem.getId());
                System.out.println("Ultimul id : " + Produs.getUltimulId());
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void initialData(){
        this.listaProduse = new ArrayList<Produs>();
        Produs.setUltimulId(0);

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

        System.out.println(" ");
        System.out.println(" s-a resetat lista!");
        System.out.println(instance.toString());
    }

    @Override
    public String toString() {
        return "MagazinOnline{" +
                "stocProduse=" + Arrays.toString(stocProduse) +
                ", listaProduse=" + listaProduse +
                '}';
    }
}
