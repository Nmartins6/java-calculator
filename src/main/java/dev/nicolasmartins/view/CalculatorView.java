package dev.nicolasmartins.view;

import javax.swing.*;
import java.awt.*;

// JFrame IS THE MAIN WINDOW OF A SWING APPLICATION
public class CalculatorView extends JFrame {

// JTextField IS AN INPUT FIELD
    private JTextField display;
    private JButton addBtn, subtractBtn, multiplyBtn, divideBtn, clearBtn;

    public CalculatorView() {

        // CONFIG WINDOW
        setSize(300,400);
        setTitle("CALCULADORA JAVA");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // CONFIG PRINCIPAL LAYOUT
        setLayout(new BorderLayout());

        // CONFIG DISPLAY
        display = new JTextField("0");
        display.setEditable(false);
        display.setHorizontalAlignment(SwingConstants.RIGHT);
        setFont(new Font(("Arial"), Font.BOLD, 24 ));
        add(display, BorderLayout.NORTH);

        // BUTTONS PANEL
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridLayout(5,1,5,5));

        // NUMBERS BUTTONS
        JPanel numbersPanel = new JPanel(new GridLayout(4,3,5,5));
        for(int i = 1 ; i < 9 ; i++) {
            numbersPanel.add(new JButton(String.valueOf(i)));
        }
        numbersPanel.add(new JButton("0"));
        numbersPanel.add(new JButton("."));

        buttonPanel.add(numbersPanel);

        // OPERATION BUTTONS
        JPanel operationPanel = new JPanel(new GridLayout(1, 4, 5, 5));
        addBtn = new JButton("+");
        subtractBtn = new JButton("-");
        multiplyBtn = new JButton("*");
        divideBtn = new JButton("/");

        operationPanel.add(addBtn);
        operationPanel.add(subtractBtn);
        operationPanel.add(multiplyBtn);
        operationPanel.add(divideBtn);

        buttonPanel.add(operationPanel);

        //CLEAR BUTTON
        clearBtn = new JButton("C");
        buttonPanel.add(clearBtn);

        add(buttonPanel, BorderLayout.CENTER);
    }

// METHODS TO ACCESS COMPONENTS

    public String getDisplayText() {
        return display.getText();
    }

    public void setDisplayText(String text) {
        display.setText(text);
    }

    public JButton getAddBtn(){
        return addBtn;
    }

    public JButton getSubtractBtn(){
        return subtractBtn;
    }

    public JButton getMultiplyBtn() {
        return multiplyBtn;
    }

    public JButton getDivideBtn() {
        return divideBtn;
    }

    public JButton getClearBtn() {
        return clearBtn;
    }

}
