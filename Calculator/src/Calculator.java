import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class Calculator extends JFrame implements ActionListener{
	
	public Dimension textDimension = new Dimension(300, 35);
	
	public boolean plus, minus, multiply, divide = false;
	public boolean justEquals = false;
	public boolean justFirstNum = false;
	
	public int first = 0;
	public int second = 0;	
	public int answer = 0;
	
	public JTextField text = new JTextField(20);
	
	public JButton button0 = new JButton("0");
	public JButton button1 = new JButton("1");
	public JButton button2 = new JButton("2");
	public JButton button3 = new JButton("3");
	public JButton button4 = new JButton("4");
	public JButton button5 = new JButton("5");
	public JButton button6 = new JButton("6");
	public JButton button7 = new JButton("7");
	public JButton button8 = new JButton("8");
	public JButton button9 = new JButton("9");
	public JButton buttonPlus = new JButton("+");
	public JButton buttonMinus = new JButton("-");
	public JButton buttonMultiply = new JButton("*");
	public JButton buttonDivide = new JButton("/");
	public JButton buttonEquals = new JButton("=");
	public JButton buttonClear = new JButton("CLEAR");	
	
	Calculator() {
		this.setSize(300, 250);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		GridLayout grid = new GridLayout(5, 5);
		this.setLayout(grid);
		
		FlowLayout layoutCenter1 = new FlowLayout(FlowLayout.CENTER);
		FlowLayout layoutCenter2 = new FlowLayout(FlowLayout.CENTER, 1, 1);
		
		JPanel panelText = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		
		panelText.setLayout(layoutCenter1);
		panel1.setLayout(layoutCenter2);
		panel2.setLayout(layoutCenter2);
		panel3.setLayout(layoutCenter2);
		panel4.setLayout(layoutCenter2);
		
		text.setPreferredSize(textDimension);
		text.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		text.setEditable(false);
	
		button0.addActionListener(this);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		button5.addActionListener(this);
		button6.addActionListener(this);
		button7.addActionListener(this);
		button8.addActionListener(this);
		button9.addActionListener(this);
		buttonPlus.addActionListener(this);
		buttonMinus.addActionListener(this);
		buttonMultiply.addActionListener(this);
		buttonDivide.addActionListener(this);
		buttonEquals.addActionListener(this);
		buttonClear.addActionListener(this);
		
		panelText.add(text);
		this.add(panelText);
		
		panel1.add(button7);
		panel1.add(button8);
		panel1.add(button9);
		panel1.add(buttonPlus);
		this.add(panel1);
		
		panel2.add(button4);
		panel2.add(button5);
		panel2.add(button6);
		panel2.add(buttonMinus);
		this.add(panel2);
		
		panel3.add(button1);
		panel3.add(button2);
		panel3.add(button3);
		panel3.add(buttonMultiply);
		this.add(panel3);
		
		panel4.add(button0);
		panel4.add(buttonClear);
		panel4.add(buttonEquals);
		panel4.add(buttonDivide);
		add(panel4);

		
		
	
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == buttonEquals) {
			if(plus) {
				addSubtractWhatever("plus");
			}else if(minus) {
				addSubtractWhatever("minus");
			}else if(multiply) {
				addSubtractWhatever("multiply");
			}else if(divide) {
				addSubtractWhatever("divide");
			}else {
				answer = first;
			}
			text.setText(answer + ""); 
			justEquals = true;
			justFirstNum = false;
			plus = false;
			minus = false;
			multiply = false;
			divide = false;
		} else {
			if(justEquals) {
				text.setText("");
				justEquals = false;
			}
			String current = text.getText();
			if(justFirstNum) {
				if(ae.getSource() == button7) {
					text.setText(current + "7");
					second = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button8) {
					text.setText(current + "8");
					second = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button9) {
					text.setText(current + "9");
					second = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button4) {
					text.setText(current + "4");
					second = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button5) {
					text.setText(current + "5");
					second = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button6) {
					text.setText(current + "6");
					second = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button1) {
					text.setText(current + "1");
					second = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button2) {
					text.setText(current + "2");
					second = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button3) {
					text.setText(current + "3");
					second = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button0) {
					if(!text.getText().equals("")) {
						text.setText(current + "0");
						second = Integer.parseInt(text.getText());
					}
				}else if(ae.getSource() == buttonClear) {
					text.setText("");
					first = 0;
					second = 0;
				}
			} else {
				if(current.length() > 10) {
					if(ae.getSource() == buttonPlus) {
						text.setText("");
						plus = true;
						justFirstNum = true;
					}else if(ae.getSource() == buttonMinus) {
						text.setText("");
						minus = true;
						justFirstNum = true;
					}else if(ae.getSource() == buttonMultiply) {
						text.setText("");
						multiply = true;
						justFirstNum = true;
					}else if(ae.getSource() == buttonDivide) {
						text.setText("");
						divide = true;
						justFirstNum = true;
					}			
				} else if(ae.getSource() == button7) {
					text.setText(current + "7");
					first = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button8) {
					text.setText(current + "8");
					first = 8;
					first = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button9) {
					text.setText(current + "9");
					first = 9;
					first = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button4) {
					text.setText(current + "4");
					first = 4;
					first = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button5) {
					text.setText(current + "5");
					first = 5;
					first = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button6) {
					text.setText(current + "6");
					first = 6;
					first = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button1) {
					text.setText(current + "1");
					first = 1;
					first = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button2) {
					text.setText(current + "2");
					first = 2;
					first = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button3) {
					text.setText(current + "3");
					first = 3;
					first = Integer.parseInt(text.getText());
				}else if(ae.getSource() == button0) {
					if(!text.getText().equals("")) {
						text.setText(current + "0");
						first = Integer.parseInt(text.getText());
					}
				}
			}
			if(ae.getSource() == buttonClear) {
				text.setText("");
				first = 0;
				second = 0;
			}else if(ae.getSource() == buttonPlus) {
				text.setText("");
				plus = true;
				justFirstNum = true;
			}else if(ae.getSource() == buttonMinus) {
				text.setText("");
				minus = true;
				justFirstNum = true;
			}else if(ae.getSource() == buttonMultiply) {
				text.setText("");
				multiply = true;
				justFirstNum = true;
			}else if(ae.getSource() == buttonDivide) {
				text.setText("");
				divide = true;
				justFirstNum = true;
			}
		}
	}
	
	public void addSubtractWhatever(String opperator) {
		if(opperator.equals("plus")) {
			answer = first + second;
		} else if(opperator.equals("minus")) {
			answer = first - second;
		} else if(opperator.equals("multiply")) {
			answer = first * second;
		} else if(opperator.equals("divide")) {
			answer = first / second;
		}
		first = answer;
		second = 0;
	}
	
	public static void main(String[] args) {
		new Calculator().setVisible(true);
	}

}
