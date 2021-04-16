import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Project1 {

    static Car[] unsortedCarList = new Car[100];
    static Car[] sortedCarList = new Car[100];

    public static void main(String[] args) throws FileNotFoundException {
        int i = 0;

        Scanner input = new Scanner(new File("cars.txt"));
        while (input.hasNextLine()) {
            String line = input.nextLine();
            StringTokenizer token = new StringTokenizer(line, ",");

            int length = token.countTokens();

            if (length != 4) {
                System.out.println(line);
                i--;
            } else {
                String make = token.nextToken();
                String model = token.nextToken();
                int year = Integer.parseInt(token.nextToken());
                int mileage = Integer.parseInt(token.nextToken());
                Car car = new Car(make, model, year, mileage);

                unsortedCarList[i] = car;
                sortedCarList[i] = car;
            }
            i++;
        }

        selectionSort(sortedCarList, i);
        CarGUI cargui = new CarGUI(unsortedCarList, sortedCarList, i);
    }

    private static void selectionSort(Car[] sortedCarList, int length) {
        for (int i = 0; i < length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < length; j++) {
                if ((sortedCarList[j].getMake()).compareTo(sortedCarList[index].getMake()) < 0)
                    index = j;
                if (sortedCarList[index] != sortedCarList[i]) {
                    Car temp = sortedCarList[index];
                    sortedCarList[index] = sortedCarList[i];
                    sortedCarList[i] = temp;
                }
            }
        }
    }
}