import javax.swing.JOptionPane;

public class Project0 {
    public static void main(String[] args) {
        char letter = 'e';
        char letterr = 'E';
        int ecount = 0;
        int Ecount = 0;
        String input;

        while (true) {
            input = JOptionPane.showInputDialog(args, "write a sentence");

            if (input.equalsIgnoreCase("stop")) {
                System.exit(0);
            }

            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == letter) {
                    ecount++;
                } else if (input.charAt(i) == letterr) {
                    Ecount++;
                }
            }

            JOptionPane.showMessageDialog(null, "Number of lower case e's:" + ecount + "\n" + "Number of upper case e's:" + Ecount);
            ecount = 0;
            Ecount = 0;
        }
    }
}
