package statistics;

import model.Comanda;
import model.MagazinOnline;
import model.Produs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Statistic{
    static List<Comanda> istoricComenzi = new ArrayList<Comanda>();
    public static void readDataFromFile() {
        Object object = null;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("statistics.ser")) ) {
            object = inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
            System.out.println("eroare citire" + e.getMessage());
        }

        if(object == null){
            System.out.println("Istoric comenzi null!");
        }
        else{
            istoricComenzi = (ArrayList<Comanda>) object;
            System.out.println(" ");
            System.out.println("( Exista istoric de comenzi. )");
        }
    }

    public static void writeDataToFile() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("statistics.ser", false))) {
            outputStream.writeObject(istoricComenzi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void adaugaComanda(Comanda comandaNoua){
        istoricComenzi.add(comandaNoua);
    }

    public static List<Comanda> getIstoricComenzi() {
        return istoricComenzi;
    }
}
