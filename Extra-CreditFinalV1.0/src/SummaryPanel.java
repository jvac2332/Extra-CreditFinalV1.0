import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.util.ArrayList;

public class SummaryPanel extends JPanel {
    private ArrayList<Car> storage;
    private JTextArea tarSummary;
    private JLabel lblSummary;
    public void setupGUI() {
        setLayout(new BorderLayout());
        lblSummary = new JLabel("Car Summary");
        add(lblSummary,BorderLayout.NORTH);
        tarSummary = new JTextArea(10,30);
        tarSummary.setEditable(false);
        add(tarSummary,BorderLayout.CENTER);
    }
    public void setSummaryLabel(String text) {
        lblSummary.setText(text);
    }
    public SummaryPanel(ArrayList<Car> storage) {
        this.storage = storage;
        setupGUI();
    }
    public void updateList() {
        tarSummary.setText("");
        String text = "";
        for (Car c : storage ){
            text = text + c + "\n";
        }
        tarSummary.setText(text);
    }
}

