package dev.nicolasmartins.controller;

import dev.nicolasmartins.model.CalculatorModel;
import dev.nicolasmartins.view.CalculatorView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CaclculatorController {
    private CalculatorModel model;
    private CalculatorView view;
    private String currentInput;
    private String lastOperation;

    public CaclculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.currentInput = "";
        this.lastOperation = "";

        initController();
    }

    private void initController() {
        // ADD ACTION LISTENERS TO THE BUTTONS

        // NUMBERS AND DOTS
        for (Component comp : ((JPanel) ((JPanel) view.getContentPane().getComponent(1)).getComponent(0)).getComponents()) {
            if (comp instanceof JButton) {
                JButton btn = (JButton) comp;
                btn.addActionListener(new NumberButtonListener());
            }
        }

        // OPERATIONS
        view.getAddBtn().addActionListener(e -> performOperation("+"));
        view.getSubtractBtn().addActionListener(e -> performOperation("-"));
        view.getMultiplyBtn().addActionListener(e -> performOperation("*"));
        view.getDivideBtn().addActionListener(e -> performOperation("/"));

        // CLEAR
        view.getClearBtn().addActionListener(e -> clear());
    }

    private void performOperation(String operation) {
        try {
            double inputNumber = currentInput.isEmpty() ? model.getResult() : Double.parseDouble(currentInput);
            switch (lastOperation) {
                case "+":
                    model.add(inputNumber);
                    break;
                case "-":
                    model.subtract(inputNumber);
                    break;
                case "*":
                    model.multiply(inputNumber);
                    break;
                case "/":
                    model.divide(inputNumber);
                    break;
                default:
                    model.add(inputNumber);
                    break;
            }
            lastOperation = operation;
            view.setDisplayText(String.valueOf(model.getResult()));
            currentInput = "";
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Entrada inválida", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(view, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            clear();
        }
    }

    private void clear() {
        model.reset();
        currentInput = "";
        lastOperation = "";
        view.setDisplayText("0");
    }

    // LISTENET FOR NUMERIC BUTTONS AND DOT BUTTONS
    private class NumberButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if(command.equals(".")) {
                if(!currentInput.contains(".")) {
                    currentInput += ".";
                }
            } else {
                currentInput += command;
            }
            view.setDisplayText(currentInput);
        }
    }
}
