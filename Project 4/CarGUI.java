import java.awt.GridLayout;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class CarGUI extends JFrame {

    JTextArea left = new JTextArea();
    JTextArea right = new JTextArea();

    UnsortedCarList unsortedCarList = new UnsortedCarList();
    SortedCarList sortedCarList = new SortedCarList();
    SortedCarList newSorted = new SortedCarList();
    CarNode interator;

    String make, model;
    int year, mileage;
    Car car = new Car(make, model, year, mileage);

    public CarGUI(UnsortedCarList unsortedCarList, SortedCarList sortedCarList) {

        this.setTitle("Cars information");
        this.setSize(1000, 600);
        this.setLocation(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuItem open = new JMenuItem("Open");
        JMenuItem quit = new JMenuItem("Quit");
        JMenuItem Search = new JMenuItem("Search");

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu FileMenu = new JMenu("Edit");
        FileMenuHandler fmh = new FileMenuHandler(this);
        EditMenuHandler emh = new EditMenuHandler(this);

        open.addActionListener(fmh);
        quit.addActionListener(fmh);
        Search.addActionListener(emh);

        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(quit);

        FileMenu.add(Search);

        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
        menuBar.add(FileMenu);
        this.setJMenuBar(menuBar);

        GridLayout layout = new GridLayout(1, 2);
        layout.setHgap(10);
        this.setLayout(layout);
        this.setVisible(true);
    }

    public void readFile(File file) {
        Scanner input = null;
        try {
            input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                StringTokenizer token = new StringTokenizer(line, ",");

                int length = token.countTokens();

                if (length != 4) {
                    System.out.println(line);
                } else {
                    make = token.nextToken();
                    model = token.nextToken();
                    year = Integer.parseInt(token.nextToken());
                    mileage = Integer.parseInt(token.nextToken());
                    car = new Car(make, model, year, mileage);

                    unsortedCarList.add(car);
                    sortedCarList.add(car);
                }
                left.setText(unsortedCarList.toString());
                right.setText(sortedCarList.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        add(left);
        add(right);
        setVisible(true);
    }

    public void search(String CarMake) {
        interator = unsortedCarList.head.next;

        while (interator != null) {
            if (interator.data.getMake().toLowerCase().trim().equals(CarMake.toLowerCase().trim())) {
                newSorted.add(interator.data);
            
            }
            interator = interator.next;

            left.setText(newSorted.toString());
            right.setText(newSorted.toString());
        }
        setVisible(true);
    }
}