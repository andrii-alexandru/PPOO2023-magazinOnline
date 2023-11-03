package ui;
import model.Comanda;
import model.MagazinOnline;
import model.Produs;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
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
                    assert magazinOnline != null;
                    afiseazaProdusele(magazinOnline.getListaProduse());

                    if(magazinOnline.getListaProduse() == null){
                        choice = 3;
                        break;
                    }

                    System.out.println(" ");
                    System.out.println("Selectia curenta de produse: ");

                    System.out.println(" ");
                    System.out.println("Clientul nostru stapanul nostru!");
                    System.out.println("Doresti sa comanzi un produs?");
                    System.out.println("0 - NU. Magazinul se va inchide.");
                    System.out.println("1 - DA. Mergi catre comanda.");
                    System.out.print("Introdu alegerea: ");

                    int clientChoice = scanner.nextInt();
                    switch (clientChoice) {
                        case 0:
                            choice = 3;
                            break;
                        case 1:
                            System.out.println(" ");
                            System.out.println("NOMENCLATOR COMANDA NOUA");
                            System.out.println("Introduceti id-ul produselor pe care doriti sa le comandati:");

                            ArrayList<Produs> produseComandate = new ArrayList<Produs>();
                            while (true) {
                                try {
                                    System.out.print("Introduceti id-ul produsului pentru comanda: ");
                                    if (scanner.hasNextInt()) {
                                        int idProdus = scanner.nextInt();
                                        Produs produsGasit = magazinOnline.cautaProdus(idProdus);

                                        if(produsGasit != null){
                                            produseComandate.add(produsGasit);
                                            System.out.println(" ");
                                            System.out.println("Am adaugat acest produs la comanda: ");
                                            System.out.println(produsGasit.toString());
                                        }
                                    } else {
                                        String input = scanner.next();
                                        if (input.equalsIgnoreCase("stop")) {
                                            break;
                                        } else {
                                            System.out.println("Introducere invalida. Va rugam sa introduceti numere intregi sau 'stop' pentru a incheia.");
                                        }
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println("Introducere invalidă. Vă rugăm să introduceți numere întregi valide sau 'stop' pentru a încheia.");
                                    scanner.next();
                                }
                            }

                            Comanda comandaNoua = new Comanda(LocalDate.now(), produseComandate);
                            System.out.println(" ");
                            System.out.println("Checkout comanda:");
                            System.out.println(comandaNoua.toString());
                            System.out.println("Doriti sa efectuati comanda in valoare de " + 3000 + "lei ?");
                            System.out.println("0. Nu");
                            System.out.println("1. Da");
                    }

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
            System.out.println("2. Sterge un produs");
            System.out.println("3. Reinitializeaza selectia de produse");
            System.out.println("4. Logout admin");
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
                    System.out.println("Ce produs doresti sa stergi?");
                    System.out.print("ID produs de sters: ");

                    magazinOnline.stergeProdus(scanner.nextInt());
                    break;
                case 3:
                    magazinOnline.initialData();
                    break;
                default:
                    System.out.println("Optiune invalida. Incearca din nou.");
            }
        } while (adminChoice!=4);

    }

    public static void afiseazaProdusele(ArrayList<Produs> listaProduse) {
        if(listaProduse == null){
            System.out.println("Lista de produse este nula!");
            return;
        }

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
