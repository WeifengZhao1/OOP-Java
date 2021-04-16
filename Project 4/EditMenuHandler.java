import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class EditMenuHandler implements ActionListener {
    private CarGUI gui;
    String CarMake;

    public EditMenuHandler(CarGUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();

        if (menuName.equals("Search")) {
            CarMake = JOptionPane.showInputDialog(null, "Enter a car make");
            this.gui.search(CarMake);
        }
    }
}