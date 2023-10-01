import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame implements ActionListener {
    private JTextField numField1, numField2, resultField;
    private JButton addButton, subButton, mulButton, divButton;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        numField1 = new JTextField(10);
        numField2 = new JTextField(10);
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        resultField = new JTextField(10);
        resultField.setEditable(false);
        addButton.addActionListener(this);
        subButton.addActionListener(this);
        mulButton.addActionListener(this);
        divButton.addActionListener(this);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Number 1:"));
        inputPanel.add(numField1);
        inputPanel.add(new JLabel("Number 2:"));
        inputPanel.add(numField2);
        inputPanel.add(new JLabel("Result:"));
        inputPanel.add(resultField);
        JPanel containerPanel = new JPanel();
        containerPanel.setLayout(new BorderLayout());
        containerPanel.add(inputPanel, BorderLayout.CENTER);
        containerPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(containerPanel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subButton) {
                result = num1 - num2;
            } else if (e.getSource() == mulButton) {
                result = num1 * num2;
            } else if (e.getSource() == divButton) {
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    resultField.setText("Error: Division by zero");
                    return;
                }
            }

            resultField.setText(String.format("%.2f", result));
        } catch (NumberFormatException ex) {
            resultField.setText("Error: Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SimpleCalculator();
        });
    }
}
