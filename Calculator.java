package MyPackage;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel;

    Font myFont = new Font("Arial", Font.BOLD, 30);

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        // Create Frame
        frame = new JFrame("Simple Calculator");
        frame.setSize(420, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.GRAY); // Set background color

        // Create TextField
        textfield = new JTextField("0");
        textfield.setBounds(50, 25, 300, 50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.WHITE); // Set textfield background color

        // Create Button
        addButton = new JButton("+");
        addButton.addActionListener(this);
        subButton = new JButton("-");
        subButton.addActionListener(this);
        divButton = new JButton("/");
        divButton.addActionListener(this);
        mulButton = new JButton("*");
        mulButton.addActionListener(this);
        decButton = new JButton(".");
        equButton = new JButton("=");
        equButton.addActionListener(this);
        delButton = new JButton("del");
        delButton.addActionListener(this);
        clrButton = new JButton("clr");
        negButton = new JButton("(-)");
        negButton.addActionListener(this);

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = divButton;
        functionButtons[3] = mulButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
            functionButtons[i].setBackground(Color.ORANGE); // Set function button background color
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
            numberButtons[i].setBackground(Color.LIGHT_GRAY); // Set number button background color
        }

        negButton.setBounds(50, 430, 100, 50);
        decButton.addActionListener(this);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
        clrButton.addActionListener(this);

        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBackground(Color.DARK_GRAY); // Set panel background color

        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);

        // Add on frame
        frame.add(textfield);
        frame.add(panel);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(negButton);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }

  

	
	public void actionPerformed(ActionEvent e) {
		for(int i =0;i<10;i++) {
			if(e.getSource() == numberButtons[i]) {
	            if (textfield.getText().equals("0")) {
	                textfield.setText(""); // Clear the default "0"
	            }
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource() == equButton) {
			num2 = Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+':
				result= num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case '*':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
				
		}
		if(e.getSource() == clrButton) {
			textfield.setText("0");
		}
		
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i =0 ; i<string.length()-1; i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	
	}

}
