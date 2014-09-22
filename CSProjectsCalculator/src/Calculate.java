import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Calculate extends JFrame implements ActionListener {
	public JTextField text = new JTextField(10);

	public Calculate() {

		this.getContentPane().setLayout(new FlowLayout());
		JButton button1 = new JButton("Yes");
		JButton button2 = new JButton("No");

		button1.addActionListener(this);
		button2.addActionListener(this);
		text.addActionListener(this);
		add(button1);
		add(button2);
		add(text);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String action = ae.getActionCommand();
		if (action.equals("Yes")) {
			System.out.println("Yes Button pressed!");
		} else if (action.equals("No")) {
			System.out.println(text.getText());
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
