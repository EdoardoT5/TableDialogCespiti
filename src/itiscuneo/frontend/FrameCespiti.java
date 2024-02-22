package itiscuneo.frontend;

import itiscuneo.backend.CespitiFile;
import itiscuneo.backend.ElencoCespiti;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrameCespiti extends JFrame implements ActionListener {
    private final ElencoCespiti elencoCespiti;
    private JButton btnNuovo;
    private DefaultTableModel dtmCespiti;
    private JTable tableCespiti;
    private JMenuItem menuItemCsv, menuItemJson;

    public  FrameCespiti() throws HeadlessException{
        super("Gestione Cespiti");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        elencoCespiti = new ElencoCespiti();
        initComponents();
    }

    private void initComponents() {
        this.setLayout(new BorderLayout());

        JPanel panelTable = new JPanel();
        String[] aHeaderTableCespiti = {"Codice", "Quantità", "Data Acquisto"};
        dtmCespiti = new DefaultTableModel(aHeaderTableCespiti,0);
        tableCespiti = new JTable(dtmCespiti);
        panelTable.add(new JScrollPane(tableCespiti));

        JPanel panelCmd = new JPanel();
        panelCmd.setLayout(new BorderLayout(4,1));
        btnNuovo = new JButton("Nuovo");
        panelCmd.add(btnNuovo);
        btnNuovo.addActionListener(this);

        this.add(panelTable, BorderLayout.CENTER);
        this.add(panelCmd, BorderLayout.EAST);

        JMenuBar menuBar = initMenu();
        this.setJMenuBar(menuBar);
    }

    private JMenuBar initMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuItemJson = new JMenuItem("Esporta json");
        menuFile.add(menuItemJson);
        menuItemJson.addActionListener(this);

        menuItemCsv = new JMenuItem("Esporta csv");
        menuFile.add(menuItemCsv);
        menuItemCsv.addActionListener(this);

        return menuBar;
    }

    public ElencoCespiti getElencoCespiti() {
        return elencoCespiti;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNuovo){
            new DialogCespiti(this).setVisible(true);
        }
        if(e.getSource()==menuItemCsv){
            CespitiFile cespitiFile = new CespitiFile();
            cespitiFile.scriviCsv(elencoCespiti);
        }
        if(e.getSource()==menuItemJson){

        }
    }

    public static void main(String[] args) {
        FrameCespiti frameCespiti = new FrameCespiti();
        frameCespiti.setVisible(true);
    }
}
