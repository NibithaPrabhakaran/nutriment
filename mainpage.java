import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.Color;
import java.awt.geom.*;
import javax.swing.border.Border;

@SuppressWarnings({ "serial", "unused" })
public class mainpage extends JFrame {

	private JPanel contentPane;
	private JTextField grams1;
	private JTextField totcal;
	private JTextField totfat;
	private JTextField totcarbo;
	private JTextField totprotien;
	private JTextArea itemtable;
	float tcal=0;
	float tfat=0;
	float tcarbs=0;
	float tprotien=0;
	String foodlist=" ";
	String str;
	private JTextField grams3;
	private JTextField grams4;
	private JTextField grams2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainpage frame = new mainpage();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public mainpage() throws SQLException{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setBounds(100, 100, 1607, 1019);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(244, 10, 221, 154);
		contentPane.add(lblNewLabel);
		
		String[] str1= {"","chappathi","dosa","idiyappam","idly","kichadi","naan","paratha","pongal","poori","sweet pongal","uppma","vada","veg noodles"};
		JComboBox vegcb = new JComboBox(str1);
		vegcb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		vegcb.setBounds(518, 29, 237, 46);
		vegcb.setSelectedIndex(0);
		vegcb.setEditable(false);
		contentPane.add(vegcb);
		
		String[] str2= {"","aloo sabji","cabbage  poriyal","carrot beans poriyal","channa dal" ,"coconut chutney","coconut milk","mango pickle","panner butter masala","papad","potato fry","pulikuzhambu","rasam","sambhar"};
		JComboBox sidedishcb = new JComboBox(str2);
		sidedishcb.setSelectedIndex(0);
		sidedishcb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		sidedishcb.setEditable(false);
		sidedishcb.setBounds(518, 103, 237, 46);
		contentPane.add(sidedishcb);
		

		String[] str3= {"","boiled rice","curd rice","lemon rice","veg pulao","veg fried rice","tomato rice","tamarind rice","sambhar rice"};
		JComboBox ricecb = new JComboBox(str3);
		ricecb.setSelectedIndex(0);
		ricecb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ricecb.setEditable(false);
		ricecb.setBounds(518, 174, 237, 46);
		contentPane.add(ricecb);
		
		String[] str4= {"","chicken gravy","chicken 65","chicken briyani","fish curry","fish fry","mutton briyani","mutton gravy","prawn gravy"};
		JComboBox nonvegcb = new JComboBox(str4);
		nonvegcb.setSelectedIndex(0);
		nonvegcb.setFont(new Font("Tahoma", Font.PLAIN, 20));
		nonvegcb.setEditable(false);
		nonvegcb.setBounds(518, 244, 237, 46);
		contentPane.add(nonvegcb);
		
		
		
		JLabel foodlabel = new JLabel("SELECTED FOOD ITEM");
		foodlabel.setFont(new Font("Tw Cen MT", Font.BOLD, 30));
		foodlabel.setBounds(532, 391, 331, 46);
		contentPane.add(foodlabel);
		
		grams1 = new JTextField();
		grams1.setBounds(951, 39, 73, 35);
		contentPane.add(grams1);
		grams1.setColumns(10);
		
		JLabel gramslabel1 = new JLabel(" GRAMS");
		gramslabel1.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		gramslabel1.setBounds(866, 29, 83, 49);
		contentPane.add(gramslabel1);
		
		itemtable = new JTextArea();
		itemtable.setFont(new Font("Monospaced", Font.BOLD, 15));
		itemtable.setBounds(432, 447, 535, 307);
		contentPane.add(itemtable);
		
		totcal = new JTextField();
		totcal.setBounds(1317, 468, 89, 46);
		contentPane.add(totcal);
		
		totfat = new JTextField();
		totfat.setColumns(10);
		totfat.setBounds(1317, 524, 89, 46);
		contentPane.add(totfat);
		
		totcarbo = new JTextField();
		totcarbo.setColumns(10);
		totcarbo.setBounds(1317, 584, 89, 46);
		contentPane.add(totcarbo);
		
		totprotien = new JTextField();
		totprotien.setColumns(10);
		totprotien.setBounds(1317, 640, 89, 46);
		contentPane.add(totprotien);
		
		JLabel calorielabel = new JLabel("Total Calories");
		calorielabel.setFont(new Font("Yu Gothic", Font.BOLD, 28));
		calorielabel.setBounds(1038, 471, 213, 43);
		contentPane.add(calorielabel);
		
		JLabel carbolabel = new JLabel("Total Carbohydrate");
		carbolabel.setFont(new Font("Yu Gothic", Font.BOLD, 28));
		carbolabel.setBounds(1038, 587, 286, 43);
		contentPane.add(carbolabel);
		
		JLabel protienlabel = new JLabel("Total Protiens");
		protienlabel.setFont(new Font("Yu Gothic", Font.BOLD, 28));
		protienlabel.setBounds(1038, 643, 213, 43);
		contentPane.add(protienlabel);
		
		JLabel fatlabel = new JLabel("Total Fat");
		fatlabel.setFont(new Font("Yu Gothic", Font.BOLD, 28));
		fatlabel.setBounds(1038, 527, 213, 43);
		contentPane.add(fatlabel);
		
		JButton calculatebutton = new JButton("calculate");
		
		calculatebutton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		calculatebutton.setBounds(1128, 359, 178, 46);
		contentPane.add(calculatebutton);
		
		itemtable.setText("\n");
		JButton addbutton1 = new JButton("+");
		addbutton1.setBackground(new Color(128, 255, 128));
		addbutton1.setForeground(new Color(0, 128, 0));
		addbutton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodlist=itemtable.getText();
				String list=foodlist+" "+(String)vegcb.getSelectedItem()+"\n";
				itemtable.setText(" ");
				itemtable.append(list);
			}
			
		});
		addbutton1.setFont(new Font("Arial Black", Font.BOLD, 25));
		addbutton1.setBounds(778, 29, 53, 46);
		contentPane.add(addbutton1);
		
		
		JButton addbutton3 = new JButton("+");
		addbutton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodlist=itemtable.getText();
				String list=foodlist+" "+(String)ricecb.getSelectedItem()+"\n";
				itemtable.setText(" ");
				itemtable.append(list);	
			}
		});
		addbutton3.setForeground(new Color(0, 128, 0));
		addbutton3.setFont(new Font("Arial Black", Font.BOLD, 25));
		addbutton3.setBackground(new Color(128, 255, 128));
		addbutton3.setBounds(778, 170, 53, 46);
		contentPane.add(addbutton3);
		
		JButton addbutton4 = new JButton("+");
		addbutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodlist=itemtable.getText();
				String list=foodlist+" "+(String)nonvegcb.getSelectedItem()+"\n";
				itemtable.setText(" ");
				itemtable.append(list);	
			}
		});
		addbutton4.setForeground(new Color(0, 128, 0));
		addbutton4.setFont(new Font("Arial Black", Font.BOLD, 25));
		addbutton4.setBackground(new Color(128, 255, 128));
		addbutton4.setBounds(778, 240, 53, 46);
		contentPane.add(addbutton4);
		
		JButton addbutton2 = new JButton("+");
		addbutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foodlist=itemtable.getText();
				String list=foodlist+" "+(String)sidedishcb.getSelectedItem()+"\n";
				itemtable.setText(" ");
				itemtable.append(list);		
			}
		});
		addbutton2.setForeground(new Color(0, 128, 0));
		addbutton2.setFont(new Font("Arial Black", Font.BOLD, 25));
		addbutton2.setBackground(new Color(128, 255, 128));
		addbutton2.setBounds(778, 98, 53, 49);
		contentPane.add(addbutton2);
		
		JLabel gramslabel3 = new JLabel(" GRAMS");
		gramslabel3.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		gramslabel3.setBounds(866, 174, 83, 49);
		contentPane.add(gramslabel3);
		
		JLabel gramslabel4 = new JLabel(" GRAMS");
		gramslabel4.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		gramslabel4.setBounds(866, 244, 83, 49);
		contentPane.add(gramslabel4);
		
		grams3 = new JTextField();
		grams3.setColumns(10);
		grams3.setBounds(951, 179, 75, 35);
		contentPane.add(grams3);
		
		grams4 = new JTextField();
		grams4.setColumns(10);
		grams4.setBounds(949, 249, 75, 35);
		contentPane.add(grams4);
		
		
		JLabel gramslabel2 = new JLabel(" GRAMS");
		gramslabel2.setFont(new Font("Tw Cen MT", Font.BOLD, 20));
		gramslabel2.setBounds(866, 103, 83, 49);
		contentPane.add(gramslabel2);
		
		grams2 = new JTextField();
		grams2.setColumns(10);
		grams2.setBounds(949, 108, 75, 35);
		contentPane.add(grams2);
		
		JButton btnNewButton = new JButton("clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				itemtable.setText("");
				vegcb.setSelectedIndex(0);
				sidedishcb.setSelectedIndex(0);
				ricecb.setSelectedIndex(0);
				nonvegcb.setSelectedIndex(0);
				totcal.setText("");
				totfat.setText("");
				totcarbo.setText("");
				totprotien.setText("");
				grams1.setText("");
			    grams2.setText("");
			    grams3.setText("");
				grams4.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(1333, 359, 138, 46);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\nibit\\Downloads\\main.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1540, 845);
		contentPane.add(lblNewLabel_1);
		
		
		
		String url="jdbc:mysql://localhost:3306/calculator";
		String user="root";
		String ps="dharunibiabi";
		Connection con=DriverManager.getConnection(url, user , ps);
		Statement stm=con.createStatement();
		
		vegcb.addItemListener(new ItemListener() {
			
			public void itemStateChanged(ItemEvent ie)
			{
				
				if(ie.getSource()==vegcb)
				{
					str=(String)vegcb.getSelectedItem();
				}
			}
		});
		calculatebutton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					String url="jdbc:mysql://localhost:3306/calculator";
					String user="root";
					String ps="dharunibiabi";
					Connection con=DriverManager.getConnection(url, user , ps);
					Statement stm=con.createStatement();
					
					String query1="select * from fooditem where foodname=?";
					PreparedStatement ps1=con.prepareStatement(query1);
					ps1.setString(1,(String)vegcb.getSelectedItem());
					ResultSet res1=ps1.executeQuery();
					
					String query2="select * from fooditem where foodname=?";
					PreparedStatement ps2=con.prepareStatement(query2);
					ps2.setString(1,(String)sidedishcb.getSelectedItem());
					ResultSet res2=ps2.executeQuery();
					
					String query3="select * from fooditem where foodname=?";
					PreparedStatement ps3=con.prepareStatement(query3);
					ps3.setString(1,(String)ricecb.getSelectedItem());
					ResultSet res3=ps3.executeQuery();
					
					String query4="select * from fooditem where foodname=?";
					PreparedStatement ps4=con.prepareStatement(query4);
					ps4.setString(1,(String)nonvegcb.getSelectedItem());
					ResultSet res4=ps4.executeQuery();
					
					while(res1.next())
					{
						float cal=0;
						float fat=0;
						float carbs=0;
						float protien=0;
						
						int g1=Integer.parseInt(grams1.getText());
						
						cal=res1.getFloat("calorie");
						cal*=g1;
						cal/=100;
						tcal+=cal;
						fat=res1.getFloat("fat");
						fat*=g1;
						fat/=100;
						tfat+=fat;
						
						carbs=res1.getFloat("carbs");
						carbs*=g1;
						carbs/=100;
						tcarbs+=carbs;
						
						protien=res1.getFloat("protien");
						protien*=g1;
						protien/=100;
						tprotien+=protien;
					}	
					
					while(res2.next())
					{
						float cal=0;
						float fat=0;
						float carbs=0;
						float protien=0;
						
						int g2=Integer.parseInt(grams2.getText());
						
						cal=res2.getFloat("calorie");
						cal*=g2;
						cal/=100;
						tcal+=cal;
						fat=res2.getFloat("fat");
						fat*=g2;
						fat/=100;
						tfat+=fat;
						carbs=res2.getFloat("carbs");
						carbs*=g2;
						carbs/=100;
						tcarbs+=carbs;
						protien=res2.getFloat("protien");
						protien*=g2;
						protien/=100;
						tprotien+=protien;
					}	
					
					while(res3.next())
					{
						float cal=0;
						float fat=0;
						float carbs=0;
						float protien=0;
						
						int g3=Integer.parseInt(grams3.getText());
						
						cal=res3.getFloat("calorie");
						cal*=g3;
						cal/=100;
						tcal+=cal;
						fat=res3.getFloat("fat");
						fat*=g3;
						fat/=100;
						tfat+=fat;
						carbs=res3.getFloat("carbs");
						carbs*=g3;
						carbs/=100;
						tcarbs+=carbs;
						protien=res3.getFloat("protien");
						protien*=g3;
						protien/=100;
						tprotien+=protien;
					}	
					
					while(res4.next())
					{
						float cal=0;
						float fat=0;
						float carbs=0;
						float protien=0;
						
						int g4=Integer.parseInt(grams4.getText());
						
						cal=res4.getFloat("calorie");
						cal*=g4;
						cal/=100;
						tcal+=cal;
						fat=res4.getFloat("fat");
						fat*=g4;
						fat/=100;
						tfat+=fat;
						carbs=res4.getFloat("carbs");
						carbs*=g4;
						carbs/=100;
						tcarbs+=carbs;
						protien=res4.getFloat("protien");
						protien*=g4;
						protien/=100;
						tprotien+=protien;
					}	
					
					totcal.setText(String.valueOf(tcal));
					totfat.setText(String.valueOf(tfat));
					totcarbo.setText(String.valueOf(tcarbs));
					totprotien.setText(String.valueOf(tprotien));
				} catch (SQLException | ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
			}
		});
		
       
	}  
	public void dbcalculate(String str)throws SQLException
	{
		
		
			
	}
	}

