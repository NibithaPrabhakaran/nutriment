import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.Action;

@SuppressWarnings("serial")
public class dna extends JFrame{

	private JPanel loginframe;
	private JButton login;
	private JButton singnin;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dna frame = new dna();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public dna() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1604, 1009);
		loginframe = new JPanel();
		loginframe.setForeground(new Color(255, 255, 0));
		loginframe.setBackground(new Color(35, 35, 35));
		loginframe.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(loginframe);
		loginframe.setLayout(null);
		
		login = new JButton("LOG IN");
		login.setBackground(new Color(255, 255, 255));
		login.setForeground(new Color(255, 0, 0));
		login.setFont(new Font("Bell MT", Font.BOLD, 25));
		login.setBounds(697, 468, 167, 48);
		loginframe.add(login);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//setVisible(false);
			lframe lf;
			try {
				lf = new lframe();
				lf.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}	
			
			
			}
		});
		
		singnin = new JButton("SIGN UP");
		singnin.setBackground(new Color(255, 255, 255));
		singnin.setFont(new Font("Bell MT", Font.BOLD, 25));
		singnin.setForeground(new Color(255, 0, 0));
		singnin.setBounds(697, 552, 167, 48);
		loginframe.add(singnin);
		singnin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				//setVisible(false);
				sframe sf = new sframe();	
				sf.setVisible(true);
				//setVisible(true);
			}
		});
		
		JLabel nutri = new JLabel("    NUTRIMENT");
		nutri.setForeground(new Color(255, 255, 255));
		nutri.setFont(new Font("Stencil", Font.BOLD, 70));
		nutri.setBounds(528, 228, 639, 147);
		loginframe.add(nutri);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nibit\\Downloads\\logofinal.jpg"));
		lblNewLabel.setBounds(484, 207, 150, 178);
		loginframe.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nibit\\Downloads\\juice-smoothie-ingredients-copy-space.jpg"));
		lblNewLabel_1.setBounds(0, -40, 1670, 899);
		loginframe.add(lblNewLabel_1);
	}
	@SuppressWarnings("serial")
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
