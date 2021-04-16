import javax.swing.JFileChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 
import java.io.File;

public class FileMenuHandler implements ActionListener  {
		private CarGUI gui;
	
	public FileMenuHandler(CarGUI gui) {
		this.gui = gui;	
	}
	
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		
		if(menuName.equals("Open")) {
	        JFileChooser fc = new JFileChooser();
	        
	        int returnVal = fc.showOpenDialog(null);
	        if (returnVal == JFileChooser.APPROVE_OPTION)
	        {
	            File file = fc.getSelectedFile();
	            this.gui.readFile(file);
	        }
	      }
	        
	        else {
	        	System.exit(0);
	        }
	    }
}
	
		
	

