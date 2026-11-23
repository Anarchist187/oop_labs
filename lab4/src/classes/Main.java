package classes;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;

public class Main
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Перевод числа в двоичную систему");
        frame.setLocation(400, 400);
        frame.setSize(700, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        Font bigFont = new Font("SansSerif", Font.PLAIN, 20);

        JPanel panel = new JPanel(new GridLayout(3, 2, 8, 8));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JSpinner spinner = new JSpinner(new SpinnerNumberModel(75, 0, 10000, 1));
        spinner.setFont(bigFont);

        JSpinner.NumberEditor editor =
                new JSpinner.NumberEditor(spinner, "#");
        spinner.setEditor(editor);
        JFormattedTextField spinnerField = editor.getTextField();
        spinnerField.setFont(bigFont);
        spinnerField.setHorizontalAlignment(JTextField.LEFT);

        JTextField binaryField = new JTextField();
        binaryField.setEditable(false);
        binaryField.setFont(bigFont);
        binaryField.setHorizontalAlignment(JTextField.LEFT);

        JTextField powersField = new JTextField();
        powersField.setEditable(false);
        powersField.setFont(bigFont);
        powersField.setHorizontalAlignment(JTextField.LEFT);

        JLabel label1 = new JLabel("Введите число сюда:");
        JLabel label2 = new JLabel("Перевод в двоичную систему:");
        JLabel label3 = new JLabel("Разложение по степеням двойки:");

        label1.setHorizontalAlignment(SwingConstants.LEFT);
        label2.setHorizontalAlignment(SwingConstants.LEFT);
        label3.setHorizontalAlignment(SwingConstants.LEFT);

        label1.setFont(bigFont);
        label2.setFont(bigFont);
        label3.setFont(bigFont);

        panel.add(label1);
        panel.add(spinner);
        panel.add(label2);
        panel.add(binaryField);
        panel.add(label3);
        panel.add(powersField);

        SpinnerListener listener = new SpinnerListener(spinner, binaryField, powersField);
        spinner.addChangeListener(listener);

        int initial = (Integer) spinner.getValue();
        binaryField.setText(BinaryConverter.toBinary(initial));
        powersField.setText(BinaryConverter.toPowersOfTwo(initial));

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}
