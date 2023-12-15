import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.BorderLayout;
// These imports set up the latyout of the box when run the program


public class CarDetailPanel extends JPanel { // Allows the user to type more jframe and panel codes to develop 
    private JTextField make;
    private JTextField model;
    private JTextField year; 
    // The privates help secure the area of the box and radius also to prevent the comments from leaking out
    public void setupGUI() {
        setLayout(new BorderLayout());
        JPanel panNorth = new JPanel();
        panNorth.setLayout(new GridLayout(3,2));
        panNorth.add(new JLabel("Make"));
        make = new JTextField(5);
        panNorth.add(make);
        panNorth.add(new JLabel("Model"));
        model = new JTextField(5);
        panNorth.add(model);
        panNorth.add(new JLabel("Year"));
        year = new JTextField(5);
        panNorth.add(year);
        // This statment allows the user to finish the make the textfield.
        add(panNorth,BorderLayout.NORTH);
 
    
    }
    public CarDetailPanel() {
        setupGUI();
    }
    public String getMakel() {
        return make.getText();
    }
    public String getModel() {
        return model.getText();
    }
    
    public int getYear() {
        return Integer.parseInt(year.getText());
    }
    public void clearEntries() {
        make.setText("");
        model.setText("");
        year.setText("");
        // This allows use to write whats in the boxes
    }
}

