package ui;
import model.MagazinOnline;
import model.Produs;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    static MagazinOnline magazinOnline = MagazinOnline.getInstance();

    public static void displayMainMenu() {
        System.out.println("Bine ai venit la Magazinul Online!");

        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            System.out.println(" ");
            System.out.println("Te rog alege o optiune:");
            System.out.println("1. Admin");
            System.out.println("2. Magazin online");
            System.out.println("3. Exit");
            System.out.print("Introdu alegerea: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(" ");
                    System.out.println("Ai ales admin.");
                    System.out.print("Introdu parola pentru admin: ");
                    int password = scanner.nextInt();
                    if (password == 1234) {
                        meniuAdmin(scanner);
                    } else {
                        System.out.println("Parola incorecta. Aplicatia se va inchide.");
                        choice = 3;
                    }
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Selectia curenta de produse: ");

                    assert magazinOnline != null;
                    afiseazaProdusele(magazinOnline.getListaProduse());
                    break;
                case 3:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Cerere invalida. Te rog mai incearca.");
            }
        } while (choice != 3);

        scanner.close();
    }

    public static void meniuAdmin(Scanner scanner) {
        int adminChoice;
        System.out.println("Autentificare cu succes!");

        do {
            System.out.println(" ");
            System.out.println("Meniu Admin:");
            System.out.println("1. Adauga produs nou");
            System.out.println("2. Reseteaza selectia de produse");
            System.out.println("3. Inapoi");
            System.out.print("Alege o optiune: ");
            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    System.out.println("NOMENCLATOR PRODUS NOU.");
                    scanner.nextLine();

                    System.out.print("Nume produs: ");
                    String numeProdus = scanner.nextLine();
                    System.out.print("Pret produs: ");
                    float pretProdus = scanner.nextFloat();
                    Produs produsNou = new Produs(numeProdus, pretProdus);

                    System.out.print("Stoc produs: ");
                    int stocProdus = scanner.nextInt();

                    magazinOnline.adaugaProdus(produsNou, stocProdus);

                    System.out.println("Produsul a fost adaugat cu succes.");
                    break;
                case 2:
                    magazinOnline.initialData();
                    adminChoice = 3;
                    break;
                case 3:
                    System.out.println("Revenire la meniul principal.");
                    break;
                default:
                    System.out.println("Optiune invalida. Incearca din nou.");
            }
        } while (adminChoice!=3);

    }

    public static void afiseazaProdusele(ArrayList<Produs> listaProduse) {
        System.out.println("Lista Produse:");

        for (Produs produs : listaProduse) {
            System.out.println("Id: "   + produs.getId());
            System.out.println("Nume: " + produs.getNume());
            System.out.println("Pret: " + produs.getPret());
            System.out.println("Stoc: " + magazinOnline.getStocProdus(produs.getId()-1));
            System.out.println("------------------------------");
        }
    }

}
