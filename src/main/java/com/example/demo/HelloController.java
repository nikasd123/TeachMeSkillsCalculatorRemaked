package com.example.demo;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class HelloController {
    public TextField input;
    public StringBuilder formattedInput = new StringBuilder("0");
    public String operation;

    public void btnClicked(ActionEvent actionEvent) {
        getClickedButton((Button) actionEvent.getSource());
    }

    public void getClickedButton(Button btn)
    {
        if (input.getText().equals("0") && input.getText().length() == 1)
        {
            formattedInput.replace(0, 1, btn.getText());
        } else
        {
            formattedInput.append(btn.getText());
        }
        input.setText(formattedInput.toString());
    }

    public void backspace(ActionEvent actionEvent) {
        if (formattedInput.length() > 0) {
            formattedInput.deleteCharAt(formattedInput.length() - 1);
            input.setText(formattedInput.toString());
        }
    }
    public void reset(ActionEvent actionEvent) {
        formattedInput.delete(0, formattedInput.length());
        formattedInput.append("0");
        input.setText(formattedInput.toString());
    }

    public void arithmeticOperation(ActionEvent actionEvent) {
        Button btn = (Button) actionEvent.getSource();
        operation = btn.getText();

        formattedInput.append(operation);
        input.setText(formattedInput.toString());
    }

    public void equals(ActionEvent actionEvent) {
        String[] operands = input.getText().split("\\W");
        double operand1 = Double.parseDouble(operands[0]);
        double operand2 = Double.parseDouble(operands[1]);

        switch (operation)
        {
            case "/":
                input.setText(String.valueOf((Double.parseDouble(operands[0])) / (Double.parseDouble(operands[1]))));
                break;
            case "*":
                input.setText(String.valueOf((Double.parseDouble(operands[0])) * (Double.parseDouble(operands[1]))));
                break;
            case "+":
                input.setText(String.valueOf((Double.parseDouble(operands[0])) + (Double.parseDouble(operands[1]))));
                break;
            case "-":
                input.setText(String.valueOf((Double.parseDouble(operands[0])) - (Double.parseDouble(operands[1]))));
                break;
            default: break;
        }
    }
}