package ui;
import model.Comanda;
import model.MagazinOnline;
import model.Produs;
import statistics.Statistic;

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

                    meniuClient(scanner);

                    break;
                case 3:
                    System.out.println("La revedere!");
                    break;
                default:
                    System.out.println("Cerere invalida!");

            }
        } while (choice != 3);

        scanner.close();
    }

    private static void meniuClient(Scanner scanner) {
        System.out.println(" ");
        System.out.println("Clientul nostru stapanul nostru!");
        System.out.println("Doresti sa comanzi un produs?");
        System.out.println("0 - NU. Magazinul se va inchide.");
        System.out.println("1 - DA. Mergi catre comanda.");
        System.out.print("Introdu alegerea: ");

        int clientChoice = scanner.nextInt();
        switch (clientChoice) {
            case 0:
                break;
            case 1:
                System.out.println(" ");
                System.out.println("NOMENCLATOR COMANDA NOUA");

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
                                System.out.println("Am adaugat acest produs la comanda.");
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

                float sumaComanda = 0;

                for(Produs p : produseComandate){
                    sumaComanda += p.getPret();
                }

                System.out.println(" ");
                System.out.println("Checkout comanda:");
                System.out.println(comandaNoua.toString());
                System.out.println("Doriti sa efectuati comanda in valoare de " + sumaComanda + "lei ?");
                System.out.println("0. Nu");
                System.out.println("1. Da");
                
                int comandaChoice = scanner.nextInt();
                switch (comandaChoice){
                    case 0:
                        System.out.println("Comanda a fost resetata!");
                        break;
                    case 1:
                        efectueazaComanda(comandaNoua);
                        break;
                }
        }
    }

    private static void efectueazaComanda(Comanda comandaNoua) {
        Statistic.adaugaComanda(comandaNoua);
    }

    public static void meniuAdmin(Scanner scanner) {
        int adminChoice;
        System.out.println("Autentificare cu succes!");

        do {
            System.out.println(" ");
            System.out.println("Meniu Admin:");
            System.out.println("1. Adauga produs nou");
            System.out.println("2. Sterge un produs");
            System.out.println("3. Modifica un produs");
            System.out.println("4. Reinitializeaza selectia de produse");
            System.out.println("5. Statistici");
            System.out.println("6. Logout admin");
            System.out.print("Alege o optiune: ");
            adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    System.out.println("NOMENCLATOR PRODUS NOU.");

                    Produs produsNou = citestProdus(scanner);

                    System.out.print("Stoc produs: ");
                    int stocProdus = scanner.nextInt();

                    magazinOnline.adaugaProdus(produsNou, stocProdus);

                    System.out.println("Produsul a fost adaugat cu succes.");
                    break;
                case 2:
                    System.out.println(" ");
                    System.out.println("Ce produs doresti sa stergi?");
                    System.out.print("ID produs de sters: ");

                    magazinOnline.stergeProdus(scanner.nextInt());
                    break;
                case 3:
                    System.out.println(" ");
                    System.out.println("Ce produs doresti sa modifici?");
                    System.out.print("ID produs de modificat: ");

                    int idProdus = scanner.nextInt();
                    Produs produsModificat = magazinOnline.cautaProdus(idProdus);

                    if(produsModificat!=null){
                        scanner.nextLine();
                        String numeProdusModificat;
                        do {
                            System.out.print("Nume produs: ");
                            numeProdusModificat = scanner.nextLine();
                            if (numeProdusModificat.trim().isEmpty()) {
                                System.out.println("Numele produsului nu poate fi gol.");
                            }
                        } while (numeProdusModificat.trim().isEmpty());
                        float pretProdusModificat;
                        do {
                            System.out.print("Pret produs: ");
                            if (scanner.hasNextFloat()) {
                                pretProdusModificat = scanner.nextFloat();
                                if (pretProdusModificat <= 0) {
                                    System.out.println("Pretul trebuie sa fie un numar pozitiv.");
                                }
                            } else {
                                System.out.println("Introducere invalida. Te rugam sa introduci un numar valid pentru pret.");
                                scanner.next();
                                pretProdusModificat = -1;
                            }
                        } while (pretProdusModificat <= 0);

                        produsModificat.setNume(numeProdusModificat);
                        produsModificat.setPret(pretProdusModificat);
                        magazinOnline.modificaProdus(idProdus, produsModificat);
                    }

                    break;
                case 4:
                    magazinOnline.initialData();
                    break;
                case 5:
                    System.out.println("STATISTICI:");
                    System.out.println("Istoric comenzi: ");
                    System.out.println(Statistic.getIstoricComenzi().toString());
                    break;
                case 6:
                    System.out.println("Admin delogat!");
                    break;
                default:
                    System.out.println("Optiune invalida. Incearca din nou.");
            }
        } while (adminChoice!=6);

    }

    private static Produs citestProdus(Scanner scanner) {
        scanner.nextLine();
        String numeProdus;
        do {
            System.out.print("Nume produs: ");
            numeProdus = scanner.nextLine();
            if (numeProdus.trim().isEmpty()) {
                System.out.println("Numele produsului nu poate fi gol.");
            }
        } while (numeProdus.trim().isEmpty());
        float pretProdus;
        do {
            System.out.print("Pret produs: ");
            if (scanner.hasNextFloat()) {
                pretProdus = scanner.nextFloat();
                if (pretProdus <= 0) {
                    System.out.println("Pretul trebuie sa fie un numar pozitiv.");
                }
            } else {
                System.out.println("Introducere invalida. Te rugam sa introduci un numar valid pentru pret.");
                scanner.next();
                pretProdus = -1;
            }
        } while (pretProdus <= 0);

        return new Produs(numeProdus, pretProdus);
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
