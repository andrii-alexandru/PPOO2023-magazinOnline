import model.MagazinOnline;
import model.Produs;
import statistics.Statistic;
import ui.Menu;

public class Main {
    public static void main(String[] args) {
//        magazinOnline.initialData();

//        System.out.println(magazinOnline.toString());
//        MagazinOnline magazinOnline = MagazinOnline.getInstance();
//        System.out.println(magazinOnline.toString());


        MagazinOnline.readDataFromFile();
        Statistic.readDataFromFile();

        Menu.displayMainMenu();

        MagazinOnline.writeDataToFile();
        Statistic.writeDataToFile();
    }


}