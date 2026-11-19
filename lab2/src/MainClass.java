import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainClass 
{
    public static void main (String[] args)
    {
        SwingUtilities.invokeLater(new Runnable ()
        {
            @Override
            public void run () 
            {
                createAndShowGUI ();
            }
        });
    }

    private static void createAndShowGUI ()
    {
        JFrame frame = new JFrame ();

        frame.setLayout (new FlowLayout (FlowLayout.CENTER, 20, 20));

        Font bigFont = new Font ("SansSerif", Font.PLAIN, 20);

        final JTextField sumField  = new JTextField ("100000", 10);
        final JTextField termField = new JTextField ("12", 4);
        final JTextField rateField = new JTextField ("10", 4);
        final JComboBox<String> typeCombo = 
            new JComboBox <String> (new String[]{"Без капитализации", "С капитализацией"});

        JButton calculateButton = new JButton ("Рассчитать");
        final JTextField resultField = new JTextField (" ", 12);
        resultField.setEditable (false);

        JTextField[] textFields = {sumField, termField, rateField, resultField};
        for (JTextField tf : textFields)
        {
            tf.setFont (bigFont);
            tf.setPreferredSize (new Dimension(tf.getPreferredSize().width, 36));
            tf.setBorder(BorderFactory.createCompoundBorder(
                    tf.getBorder(), new EmptyBorder(4, 6, 4, 6)));
        }
        typeCombo.setFont (bigFont);
        typeCombo.setPreferredSize (new Dimension (260, 36));
        calculateButton.setFont (bigFont);
        calculateButton.setPreferredSize (new Dimension (180, 40));

        JLabel[] labels =
        {
                new JLabel ("Сумма:"),
                new JLabel ("Срок (мес.):"),
                new JLabel ("Ставка (%):"),
                new JLabel ("Доход:")
        };
        for (JLabel l : labels) l.setFont (bigFont);

        frame.add (labels[0]);
        frame.add (sumField);
        frame.add (labels[1]);
        frame.add (termField);
        frame.add (labels[2]);
        frame.add (rateField);
        frame.add (typeCombo);
        frame.add (calculateButton);
        frame.add (labels[3]);
        frame.add (resultField);

        calculateButton.addActionListener (new ActionListener ()
        {
            @Override
            public void actionPerformed (ActionEvent e)
            {
                try
                {
                    double sum    = Double.parseDouble(sumField.getText().trim());
                    int    months = Integer.parseInt(termField.getText().trim());
                    double rate   = Double.parseDouble(rateField.getText().trim());

                    if (sum <= 0 || months <= 0 || rate < 0) {
                        resultField.setText ("Ошибка ввода");
                        return;
                    }

                    double income;
                    boolean capitalized = typeCombo.getSelectedItem ()
                            .equals("С капитализацией");

                    if (capitalized)
                    {
                        double monthlyRate = rate / 100.0 / 12.0;
                        double total = sum * Math.pow(1 + monthlyRate, months);
                        income = total - sum;
                    }
                    else
                    {
                        income = sum * (rate / 100.0) * (months / 12.0);
                    }
                    resultField.setText(String.format("%.2f", income));
                }
                catch (NumberFormatException ex)
                {
                    resultField.setText("Ошибка ввода");
                }
            }
        });

        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);

        frame.pack ();
        if (frame.getWidth () < 1100) frame.setSize (1100, frame.getHeight ());
        frame.setMinimumSize (new Dimension (900, 200));

        frame.setLocationRelativeTo (null);
        frame.setTitle ("Калькулятор вклада");
        frame.setVisible (true);
    }
}
