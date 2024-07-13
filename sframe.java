import java.awt.EventQueue;
import java.awt.Font;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
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


public class sframe extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass;
	private JTextField username;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					sframe frame = new sframe();
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
	public sframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1543, 881);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userlabel = new JLabel("USERNAME");
		userlabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		userlabel.setBounds(326, 312, 304, 70);
		contentPane.add(userlabel);
		
		JLabel passlabel = new JLabel("PASSWORD");
		passlabel.setFont(new Font("Times New Roman", Font.BOLD, 50));
		passlabel.setBounds(338, 458, 303, 63);
		contentPane.add(passlabel);
		
		pass = new JPasswordField();
		pass.setBounds(694, 480, 342, 44);
		contentPane.add(pass);
		
		JButton enter = new JButton("ENTER");
		enter.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
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
					
					String query1="insert into user values(?,?)";
					PreparedStatement ps1=con.prepareStatement(query1);
					ps1.setString(1,user);
					ps1.setString(2,password);
					int i=ps1.executeUpdate();
						JOptionPane.showMessageDialog(enter,"signed in  successful");
						mainpage m;
						try {
							m = new mainpage();
							m.setVisible(true);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"enter username and password");
					}
				}
				
				 catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		enter.setFont(new Font("Arial Black", Font.BOLD, 30));
		enter.setBounds(788, 605, 166, 56);
		contentPane.add(enter);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 30));
		username.setBounds(694, 330, 342, 44);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\nibit\\Downloads\\S.jpg"));
		lblNewLabel.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel);
		
	}

}
