package chat.client;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class developerpage extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	 
			public void run() {
				try {
					developerpage frame = new developerpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		 
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public developerpage() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from developer_login where Username=? and Password =?";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1,textField.getText());
					pst.setString(2,passwordField.getText());
				    ResultSet rs = pst.executeQuery();
				    int count=0;
				    while(rs.next()) {
				    	count = count+1;
				    	
				    }
				    if(count==1)
				    {
				    	 
				    	
				    	JOptionPane.showMessageDialog(null, "Username and Password is correct");
				    	dispose();
				    	developer_details dd = new developer_details();
				    	dd.setVisible(true);
						
				    	 
				    }
				    else if (count>1)
				    {
				    	JOptionPane.showMessageDialog(null, "Duplicate Username and Password");
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null, "Username and Password is not correct");
				    }
				    rs.close();
				    pst.close();
				}catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1);
				}
				 
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(90, 193, 104, 39);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(237, 193, 104, 39);
		contentPane.add(btnCancel);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(65, 81, 78, 32);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(65, 124, 104, 27);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(195, 127, 161, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(195, 78, 161, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblDeveloperLogin = new JLabel("DEVELOPER LOGIN");
		lblDeveloperLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDeveloperLogin.setBounds(113, 11, 217, 39);
		contentPane.add(lblDeveloperLogin);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bts b = new bts();
				b.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnBack.setBounds(0, 0, 89, 23);
		contentPane.add(btnBack);
	}

}
