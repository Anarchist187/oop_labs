package classes;

import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerListener implements ChangeListener
{
    private final JSpinner spinner;
    private final JTextField binaryField;
    private final JTextField powersField;

    public SpinnerListener(JSpinner spinner, JTextField binaryField, JTextField powersField)
    {
        this.spinner = spinner;
        this.binaryField = binaryField;
        this.powersField = powersField;
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        int number = (Integer) spinner.getValue();

        if (number < 0)
            number = 0;
        binaryField.setText(BinaryConverter.toBinary(number));
        powersField.setText(BinaryConverter.toPowersOfTwo(number));
    }
}