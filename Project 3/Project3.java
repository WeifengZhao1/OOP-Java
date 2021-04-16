import java.io.FileNotFoundException;

public class Project3 {
    public static void main(String[] args) throws FileNotFoundException {

       UnsortedCarList unsortedCarList = new UnsortedCarList();
       SortedCarList sortedCarList = new SortedCarList();
        	
        new CarGUI(unsortedCarList, sortedCarList);
	      
}	
}
