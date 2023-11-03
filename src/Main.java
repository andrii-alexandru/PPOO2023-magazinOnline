import model.MagazinOnline;
import model.Produs;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello and welcome!");

//        magazinOnline.initialData();

//        System.out.println(magazinOnline.toString());
//        MagazinOnline magazinOnline = MagazinOnline.getInstance();
//        System.out.println(magazinOnline.toString());


        MagazinOnline.readDataFromFile("magazin_data.ser");

        Menu.displayMainMenu();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            MagazinOnline.writeDataToFile("magazin_data.ser");
        }));
    }


}