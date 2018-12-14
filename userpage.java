package chat.client;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.sql.*;
import javax.swing.*;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class userpage extends JFrame {

 

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
 
	 
			public void run() {
				try {
					userpage frame = new userpage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	
 
	Connection connection = null;
	private JTextField textField_2;
	/**
	 * Create the frame.
	 */
	public userpage() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(86, 27, 311, 74);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnSubmitBug = new JButton("SUBMIT");
		btnSubmitBug.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "insert into error_data (Error,ErrorType,Email) values (?,?,?)";
					PreparedStatement pst = connection.prepareStatement(query);
					pst.setString(1, textField.getText() );
					pst.setString(2, textField.getText() );
					pst.setString(3, textField_1.getText() );
					
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Bug data submitted");
					
				    pst.close();
				    userpage up = new userpage();
				    up.setVisible(true);
				    setVisible(false);
					dispose();
					
				}catch(Exception e1) {
					e1.printStackTrace();
				}
			}
			
		});
		btnSubmitBug.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmitBug.setBounds(75, 176, 147, 54);
		contentPane.add(btnSubmitBug);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnCancel.setBounds(253, 176, 128, 54);
		contentPane.add(btnCancel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(10, 140, 46, 25);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 145, 311, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblBug = new JLabel("Bug");
		lblBug.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBug.setBounds(10, 38, 33, 34);
		contentPane.add(lblBug);
		
		JLabel lblErrortype = new JLabel("BugType");
		lblErrortype.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblErrortype.setBounds(10, 115, 62, 14);
		contentPane.add(lblErrortype);
		
		textField_2 = new JTextField();
		textField_2.setBounds(86, 112, 311, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bts b = new bts();
				b.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnBack.setBounds(0, 0, 78, 23);
		contentPane.add(btnBack);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
