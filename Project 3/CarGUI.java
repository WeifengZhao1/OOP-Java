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
    public CarGUI(UnsortedCarList unsortedCarList, SortedCarList sortedCarList) {
    	
        this.setTitle("Cars information");
        this.setSize(1000, 600);
        this.setLocation(300, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuItem open = new JMenuItem("Open");
        JMenuItem quit = new JMenuItem("Quit");
        
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        FileMenuHandler fmh = new FileMenuHandler(this);
        
        open.addActionListener(fmh);
        quit.addActionListener(fmh);
        
        fileMenu.add(open);
        fileMenu.addSeparator();
        fileMenu.add(quit);
        
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);

        GridLayout layout = new GridLayout(1, 2);   
        layout.setHgap(10);
        this.setLayout(layout);
        this.setVisible(true);
    }

	public void readFile(File file) {
        JTextArea left = new JTextArea();
        JTextArea right = new JTextArea();
        
		UnsortedCarList unsortedCarList = new UnsortedCarList();
		SortedCarList sortedCarList = new SortedCarList();
		      
		Scanner input = null;
        try
        {
            input = new Scanner(file);
            while (input.hasNext()) {
                String line = input.nextLine();
                StringTokenizer token = new StringTokenizer(line, ",");

                int length = token.countTokens();

                if (length != 4) {
                    System.out.println(line);
                } 
                else {
                	String make = token.nextToken();
                    String model = token.nextToken();
                    int year = Integer.parseInt(token.nextToken());
                    int mileage = Integer.parseInt(token.nextToken());
                    Car car = new Car(make, model, year, mileage);           
                   
                   unsortedCarList.add(car); 
                   sortedCarList.add(car);  
                   
        }                    
                left.setText(unsortedCarList.toString());
                right.setText(sortedCarList.toString());           
            }      
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
             
        add(left);
    	add(right);
    	setVisible(true);
    	 
	}
}




