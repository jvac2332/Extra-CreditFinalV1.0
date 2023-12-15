
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JButton;
// Helps run the codes that runs really and not cause problems 

public class MainFrame extends JFrame implements ActionListener{
    private CarDetailPanel cdp;
    private ArrayList<Car> storage;
    private JButton btnAddCar;
    // Helps the secure source of each private statement and not to cause errors
    public void setUpMenu(){
        JMenuBar mBar = new JMenuBar();
        JMenu mnuFile = new JMenu("File");
        mBar.add(mnuFile);
        JMenuItem mnuTxt = new JMenuItem("Save to Txt file"); // Saves it to the txt file
        mnuTxt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                CarPrinter.printToTextFile(storage);
            }
        });
   
        mnuFile.add(mnuTxt);
        JMenuItem mnuXMl = new JMenuItem("Save to XML file"); // The XMl file lets the user sotr and share the data
        mnuXMl.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                CarPrinter.printToXMLFile(storage);
            } 
        });

        JMenuItem mnuExit = new JMenuItem("Exit");
        mnuExit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        mnuFile.add(mnuExit);
        mnuFile.add(mnuTxt);
        mnuFile.add(mnuXMl);
        setJMenuBar(mBar);



    }

   
   
    public void setupGUI() {
        setBounds(100,100,500,400); // Setting the box up
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setTitle("Car");
        Container c = getContentPane(); // contains what in the box
        c.setLayout(new BorderLayout());// Lays the border for the program.
        this.cdp = new CarDetailPanel();
        SummaryPanel sumPan = new SummaryPanel(storage);
        c.add(cdp,BorderLayout.WEST);
        c.add(sumPan,BorderLayout.EAST);
        JPanel panSouth = new JPanel();
        this.btnAddCar = new JButton("Add Car");
        btnAddCar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { 
                String Make = "",Model = "";
                int Year = 0;
                ArrayList<String> errors = new ArrayList<String>(); // The try catch allows the user to see whats id the statement works or not
                try {
                    Make = cdp.getMakel();
                } catch (Exception ex) {
                    errors.add("Not Valid"); // tells the user that info is not valid
                }
                try {
                    Model = cdp.getModel();
                } catch (Exception ex) {
                    errors.add("Not Valid");
                }
                try {
                    Year = cdp.getYear();
                } catch (Exception ex) {
                    errors.add("Not Valid");
                }
                String errorMessage = "";
                if (errors.size() > 0) {
                    for (String error: errors) {
                        errorMessage = errorMessage + error + " ";
                    } 
                    JOptionPane.showMessageDialog(null,"These errors occurred: " + errorMessage);
                } else {
                    Car c = new Car(Make,Model,Year);
                    storage.add(c);
                    sumPan.updateList();
                    cdp.clearEntries();
                    sumPan.setSummaryLabel("Cars in Storage");
                    repaint();    // refreshes the frame's appearance and gives a person a right frame set
                }
            }
        });
        panSouth.setLayout(new FlowLayout());
        panSouth.add(btnAddCar);
        c.add(panSouth,BorderLayout.SOUTH);
        setUpMenu();
    }

    public MainFrame(ArrayList<Car> storage){
        this.storage = storage;
        setupGUI();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}

    