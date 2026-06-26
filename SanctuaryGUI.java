import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * Swing GUI for searching and viewing animals in a sanctuary.
 *
 * Layout:
 *   NORTH:  Search field, type combo box, injured checkbox, search button
 *   CENTER: Scrollable text area showing results
 *   SOUTH:  Status label showing match count
 */
public class SanctuaryGUI extends JFrame {
    // M10: Declare private Sanctuary field
    private Sanctuary sanctuary;

    // M9: Declare GUI components:
    private JTextField nameField;
    private JComboBox<String> typeCombo;
    private JCheckBox injuredCheck;
    private JButton searchButton;
    private JTextArea resultArea;
    private JLabel statusLabel;

    public SanctuaryGUI() {
        super("Caribbean Wildlife Conservation Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 500);

        // M9: Set layout to BorderLayout
        setLayout(new BorderLayout());

        // M9: Build NORTH panel (FlowLayout)
        JPanel northPanel = new JPanel(new FlowLayout());

        // Add JLabel "Search:", JTextField (14 columns), JLabel "Type:",
        northPanel.add(new JLabel("Search:"));
        northPanel.add(nameField = new JTextField(14));
        northPanel.add(new JLabel("Type:"));

        // JComboBox with {"All","Bird","Reptile","Marine"},
        northPanel.add(typeCombo = new JComboBox<>(new String[]{"All", "Bird", "Reptile", "Marine"}));

        // JCheckBox "Injured/Critical only", JButton "Search"
        northPanel.add(injuredCheck = new JCheckBox("Injured/Critical only"));
        northPanel.add(searchButton = new JButton("Search"));

        // Add panel to NORTH
        add(northPanel, BorderLayout.NORTH);     
        

        // M9: Build CENTER
        resultArea = new JTextArea();
        
        // Create JTextArea, set monospaced font, make non-editable
        resultArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        resultArea.setEditable(false);
        
        // Wrap in JScrollPane, add to CENTER
        JScrollPane scrollPane = new JScrollPane(resultArea);
        
        add(scrollPane, BorderLayout.CENTER);
             

        // M9: Build SOUTH
        // Create JLabel "Ready", add to SOUTH
        statusLabel = new JLabel("Ready");
        add(statusLabel, BorderLayout.SOUTH);

        // M11: Add ActionListener to searchButton that calls runSearch()
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runSearch();
            }
        });

        // M11: Add KeyListener to nameField that calls runSearch() on keyReleased
        nameField.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    runSearch();
                }
        });


        setLocationRelativeTo(null);
    }

    // M10: Implement setModel - Stores the Sanctuary to search over.
    public void setModel(Sanctuary s) {
        // M10: Store the sanctuary reference and Optionally update the window title
        this.sanctuary = s;
        setTitle("Caribbean Wildlife Conservation Tracker - " + s.getName());
    }

    /**
     * Filters the sanctuary's animals based on the GUI controls and
     * displays matching results.
     *
     * M11: Implement runSearch
     *
     * Steps:
     * 1. Get text from nameField (trim, convert to lowercase)
     * 2. Get selected type from typeCombo
     * 3. Get checkbox state from injuredCheck
     * 4. Loop through sanctuary's animals:
     *    - If text is non-empty, keep only animals whose species or nickname
     *      contains the text (case-insensitive)
     *    - If type is not "All", keep only matching type
     *    - If checkbox is selected, keep only "Injured" or "Critical" animals
     * 5. Build result string and set in resultArea
     * 6. Set statusLabel: "No matches", "1 result", or "N results"
     */
    private void runSearch() {
        // M11: Implement filtering and display
        String name = nameField.getText().trim().toLowerCase();
        String selectedType = (String) typeCombo.getSelectedItem();
        boolean injured = injuredCheck.isSelected();

        ArrayList<Animal> results = new ArrayList<>();

        for (Animal a : sanctuary.getAnimals()) {
            boolean matches = true;

            if (!name.isEmpty() && !a.getSpecies().toLowerCase().contains(name) && !a.getNickname().toLowerCase().contains(name)) {
                matches = false;
            }
            if (!selectedType.equals("All") && !a.getType().equals(selectedType)) {
                matches = false;
            }
            if (injured && !a.getHealthStatus().equals("Injured") && !a.getHealthStatus().equals("Critical")) {
                matches = false;
            }

            if (matches) {
                results.add(a);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Animal a : results) {
            sb.append(a.toString()).append("\n");
        }

        resultArea.setText(sb.toString());

        int count = results.size();
        if (count == 0) {
            statusLabel.setText("No matches");
        } else if (count == 1) {
            statusLabel.setText("1 result");
        } else {
            statusLabel.setText(count + " results");
        }
    }

    /**
     * Creates a demo sanctuary, populates it, and launches the GUI.
     *
     * TODO M12: Implement main method
     */
    public static void main(String[] args) {
        // TODO M12: Create Sanctuary, add animals, create GUI, wire model, show
    }
}
