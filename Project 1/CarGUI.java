import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CarGUI extends JFrame {
    public CarGUI(Car[] unsortedCarList, Car[] sortedCarList, int length) {

        JFrame myFrame = new JFrame("Cars information");
        myFrame.setSize(1000, 600);
        myFrame.setLocation(300, 300);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea left = new JTextArea();
        JTextArea right = new JTextArea();

        //UnsortedCarList 
        left.setText("Unsorted Car List :> \n");
        for (int i = 0; i < length; i++) {
            left.append(unsortedCarList[i] + "\n");
        }
        JScrollPane UnsortedCarList = new JScrollPane(left);
        myFrame.getContentPane().add(UnsortedCarList);

        //SortedCarList
        right.setText("Sorted Car List :> \n");
        for (int i = 0; i < length; i++) {
            right.append(sortedCarList[i] + "\n");
        }
        JScrollPane SortedCarList = new JScrollPane(right);
        myFrame.getContentPane().add(SortedCarList);

        myFrame.setLayout(new GridLayout(1, 2));
        myFrame.setVisible(true);
    }
}