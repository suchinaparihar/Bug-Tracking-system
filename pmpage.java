package chat.client;

import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 

public class pmpage extends JFrame {
	 

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textField;

	public static void main(String [] args) {
	java.awt.EventQueue.invokeLater(new Runnable() {	
		 public void run() {
				
				new pmpage().setVisible(true);
				
	}
	});
	}
	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public pmpage() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPmLogin = new JLabel("PM LOGIN");
		lblPmLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPmLogin.setBounds(162, 11, 170, 51);
		contentPane.add(lblPmLogin);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(55, 90, 90, 24);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(55, 141, 90, 24);
		contentPane.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 145, 148, 20);
		contentPane.add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(184, 94, 148, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from login_table where Username=? and Password =?";
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
				    	
				    	PMdetails ps = new PMdetails();
				    	ps.setVisible(true);
				    	setVisible(false);
				    	dispose();
						
				          
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

			private void dispose() {
				// TODO Auto-generated method stub
				
			}
			
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(78, 205, 106, 45);
		contentPane.add(btnLogin);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(248, 205, 99, 45);
		contentPane.add(btnCancel);
		
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
