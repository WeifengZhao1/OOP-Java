import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project2 {
    public static void main(String[] args) throws FileNotFoundException {

        UnsortedCarList unsortedCarList = new UnsortedCarList();
        SortedCarList sortedCarList = new SortedCarList();

        Scanner input = new Scanner(new File("cars.txt"));
        while (input.hasNext()) {
            String line = input.nextLine();
            StringTokenizer token = new StringTokenizer(line, ",");

            int length = token.countTokens();

            if (length != 4) {
                System.out.println(line);
            } else {
                String make = token.nextToken();
                String model = token.nextToken();
                int year = Integer.parseInt(token.nextToken());
                int mileage = Integer.parseInt(token.nextToken());
                Car car = new Car(make, model, year, mileage);

                sortedCarList.add(car);
                unsortedCarList.add(car);
            }
        }
        new CarGUI(unsortedCarList, sortedCarList);
    }
}