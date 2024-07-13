import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class lframe extends JFrame {

	private JPanel contentPane;
	private final JLabel passlabel = new JLabel("PASSWORD");
	private JPasswordField pass;
	private JTextField username;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					lframe frame = new lframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public lframe() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1606, 1016);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userlabel = new JLabel("USERNAME");
		userlabel.setForeground(new Color(0, 0, 0));
		userlabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		userlabel.setBounds(280, 578, 308, 70);
		contentPane.add(userlabel);
		passlabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 40));
		passlabel.setBounds(1111, 578, 272, 70);
		contentPane.add(passlabel);
		
		pass = new JPasswordField();
		pass.setBounds(1111, 538, 272, 48);
		contentPane.add(pass);
		
		JButton enter = new JButton("ENTER");
		enter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String user=username.getText();
				String password=pass.getText();
				
				try {
					if(user!=null&&password!=null)
					{
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/calculator";
					String user1="root";
					String ps="dharunibiabi";
					Connection con=DriverManager.getConnection(url, user1 , ps);
					Statement stm=con.createStatement();
					
					String query1="select * from user where username=? and password=?";
					PreparedStatement ps1=con.prepareStatement(query1);
					ps1.setString(1,user);
					ps1.setString(2,password);
					ResultSet res1=ps1.executeQuery();
					if(res1.next())
					{
						JOptionPane.showMessageDialog(null, "login successful");
						mainpage m;
						try {
							m = new mainpage();
							m.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}}
					else
					{
						JOptionPane.showMessageDialog(null, "incorrect username and password");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		enter.setFont(new Font("Times New Roman", Font.BOLD, 30));
		enter.setBounds(734, 527, 143, 56);
		contentPane.add(enter);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 30));
		username.setBounds(236, 538, 272, 48);
		contentPane.add(username);
		username.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nibit\\Downloads\\earphones.jpg"));
		lblNewLabel.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel);
	}
}
