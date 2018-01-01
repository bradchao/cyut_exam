package tw.brad.cyut.exam;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CyutExam2 extends JFrame implements ActionListener{
	private JLabel phoneNumber;
	private JButton[] pads;
	
	public CyutExam2() {
		super("撥號程式");
		setLayout(new BorderLayout());
		phoneNumber = new JLabel("0");
		phoneNumber.setFont(new Font(null, 0, 48));
		phoneNumber.setHorizontalAlignment(JLabel.RIGHT);
		add(phoneNumber, BorderLayout.NORTH);
		
		JPanel padLayout = new JPanel(new GridLayout(4,3));
		pads = new JButton[12];
		for (int i=0; i<pads.length; i++) {
			if (i<10) {
				pads[i] = new JButton("" + i);
			}else if (i==10) {
				pads[i] = new JButton("Clear");
			}else if (i==11) {
				pads[i] = new JButton("Call");
			}
			pads[i].addActionListener(this);
		}
		padLayout.add(pads[7]); padLayout.add(pads[8]);padLayout.add(pads[9]);
		padLayout.add(pads[4]); padLayout.add(pads[5]);padLayout.add(pads[6]);
		padLayout.add(pads[1]); padLayout.add(pads[2]);padLayout.add(pads[3]);
		padLayout.add(pads[10]); padLayout.add(pads[0]);padLayout.add(pads[11]);
		add(padLayout, BorderLayout.CENTER);
		
		setSize(480, 800);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new CyutExam2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Clear") || 
				e.getActionCommand().equals("Call")) {
			phoneNumber.setText(" ");
		}else {
			phoneNumber.setText(phoneNumber.getText() + e.getActionCommand());
		}
	}

}
