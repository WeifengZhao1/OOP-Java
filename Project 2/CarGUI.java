import java.awt.GridLayout;

import javax.swing.JFrame;

import javax.swing.JTextArea;

public class CarGUI extends JFrame {
    public CarGUI(UnsortedCarList unsortedCarList, SortedCarList sortedCarList) {

        this.setTitle("Cars information");
        this.setSize(1000, 600);
        this.setLocation(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JTextArea left = new JTextArea();
        JTextArea right = new JTextArea();

        String data = "Unsorted Car List :> \n";
        data += unsortedCarList.toString();

        left.setText(data);
        add(left);

        data = "Sorted Car List :> \n";
        data += sortedCarList.toString();
        right.setText(data);
        add(right);

        GridLayout layout = new GridLayout(1, 2);
        layout.setHgap(10);
        this.setLayout(layout);
        this.setVisible(true);


    }
}