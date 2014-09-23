import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculate extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	public static JTextField nonEditableText = new JTextField(10);
	public static JTextField text = new JTextField(10);
	public static String notEditableText = "";

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
	public JButton buttonClear = new JButton("CLEAR");

	public Calculate() {

		this.getContentPane().setLayout(new FlowLayout());

		nonEditableText.setEditable(false);

		text.addActionListener(this);
		text.addActionListener(this);
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
		buttonClear.addActionListener(this);
		add(nonEditableText);
		add(text);
		add(button0);
		add(button1);
		add(button2);
		add(button3);
		add(button4);
		add(button5);
		add(button6);
		add(button7);
		add(button8);
		add(button9);
		add(buttonPlus);
		add(buttonMinus);
		add(buttonClear);

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if (action.equals("0")) {
			assignText("0");
		} else if (action.equals("1")) {
			assignText("1");
		} else if (action.equals("2")) {
			assignText("2");
		} else if (action.equals("3")) {
			assignText("3");
		} else if (action.equals("4")) {
			assignText("4");
		} else if (action.equals("5")) {
			assignText("5");
		} else if (action.equals("6")) {
			assignText("6");
		} else if (action.equals("7")) {
			assignText("7");
		} else if (action.equals("8")) {
			assignText("8");
		} else if (action.equals("9")) {
			assignText("9");
		} else if (action.equals("+")) {
			assignText(" + ");
		} else if (action.equals("-")) {
			assignText(" - ");
		} else if (action.equals("CLEAR")) {
			assignText("CLEAR");
		} else {
			assignText(text.getText());
		}
		System.out.println(notEditableText + " " + text.getText());
	}

	public static void assignText(String pressed) {
		System.out.println("Pressed: " + pressed);
		if (pressed.equals("CLEAR")) {
			text.setText("");
			nonEditableText.setText("");
			notEditableText = "";
		} else if (pressed.equals(" + ") || pressed.equals(" - ")) {
			text.setText("");
			notEditableText += pressed;
			nonEditableText.setText(notEditableText);
		} else {
			notEditableText += pressed;
			nonEditableText.setText(notEditableText);
			text.setText(text.getText() + pressed);
		}
	}

	private static void createAndShowGUI() {
		JFrame frame = new Calculate();
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createAndShowGUI();
			}
		});

	}

}
