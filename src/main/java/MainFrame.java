import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JPanel panelMain = new JPanel();
    JPanel panelBottom = new JPanel();
    JTable table = new JTable();
    JScrollPane scroll = new JScrollPane(table);

    JButton butAdd = new JButton("+");
    JButton butRefresh = new JButton("Обновить");
    JButton butDelete = new JButton("-");
    JButton butDeleteAll = new JButton("Очистить");

    JLabel labelSpace1 = new JLabel("       ");
    JLabel labelSpace2 = new JLabel("       ");
    JLabel labelSpace3 = new JLabel("       ");
    JLabel labelSpace4 = new JLabel("       ");

    public void ourFrame(){

        setTitle("Список врагов");
        setSize(550,550);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        panelMain.setLayout(new GridBagLayout());
        panelBottom.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        panelBottom.add(butAdd, c);
        c.gridx = 1;
        c.gridy = 0;
        panelBottom.add(labelSpace1, c);
        c.gridx = 2;
        c.gridy = 0;
        panelBottom.add(butRefresh, c);
        c.gridx = 3;
        c.gridy = 0;
        panelBottom.add(labelSpace2, c);
        c.gridx = 4;
        c.gridy = 0;
        panelBottom.add(butDelete, c);
        c.gridx = 5;
        c.gridy = 0;
        panelBottom.add(labelSpace3, c);
        c.gridx = 6;
        c.gridy = 0;
        panelBottom.add(butDeleteAll, c);

        c.gridx = 0;
        c.gridy = 0;
        panelMain.add(scroll, c);
        c.gridx = 0;
        c.gridy = 1;
        panelMain.add(labelSpace4, c);
        c.gridx = 0;
        c.gridy = 2;
        panelMain.add(panelBottom, c);

        add(panelMain);



    }

}
