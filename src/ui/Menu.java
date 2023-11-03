package ui;
import model.MagazinOnline;
import model.Produs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public static void displayMainMenu() {
        MagazinOnline magazinOnline = MagazinOnline.readDataFromFile("magazin_data.ser");

        System.out.println("Welcome to the Online Shop!");
        System.out.println("Please choose an option:");
        System.out.println("1. Give Statistics");
        System.out.println("2. Browse the Shop");
        System.out.println("3. Exit");

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You chose to give statistics.");
                    break;
                case 2:
                    System.out.println("You chose to browse the shop.");
                    assert magazinOnline != null;
                    afiseazaProdusele(magazinOnline.getListaProduse());
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void afiseazaProdusele(ArrayList<Produs> listaProduse) {
        System.out.println("Lista Produse:");

        for (Produs produs : listaProduse) {
            System.out.println("ID: " + produs.getId());
            System.out.println("Nume: " + produs.getNume());
            System.out.println("Pret: " + produs.getPret());
            System.out.println("------------------------------");
        }
    }

}
