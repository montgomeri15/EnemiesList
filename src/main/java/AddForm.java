import javax.swing.*;
import java.awt.*;

public class AddForm extends JFrame {

    JPanel panel = new JPanel();
    JLabel label = new JLabel("Введите имя врага:");
    JTextField textField = new JTextField(13);
    JButton button = new JButton("ОК");

    JLabel labelSpace1 = new JLabel("       ");
    JLabel labelSpace2 = new JLabel("       ");

    public void addFrame(){

        setTitle("Добавление");
        setSize(220,180);
        setLocationRelativeTo(null);
        setVisible(true);

        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        c.gridx = 0;
        c.gridy = 0;
        panel.add(label, c);
        c.gridx = 0;
        c.gridy = 1;
        panel.add(labelSpace1, c);
        c.gridx = 0;
        c.gridy = 2;
        panel.add(textField, c);
        c.gridx = 0;
        c.gridy = 3;
        panel.add(labelSpace2, c);
        c.gridx = 0;
        c.gridy = 4;
        panel.add(button, c);

        add(panel);
    }
}
