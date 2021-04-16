import java.io.FileNotFoundException;

public class Project4 {
    public static void main(String[] args) throws FileNotFoundException {

        UnsortedCarList unsortedCarList = new UnsortedCarList();
        SortedCarList sortedCarList = new SortedCarList();

        new CarGUI(unsortedCarList, sortedCarList);
    }
}