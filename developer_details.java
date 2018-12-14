package chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class developer_details extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					developer_details frame = new developer_details();
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
	public developer_details() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 193, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnDeveloper = new JButton("DEVELOPER 1");
		btnDeveloper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			}
		});
		btnDeveloper.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeveloper.setBounds(10, 11, 154, 66);
		contentPane.add(btnDeveloper);
		
		JButton btnDeveloper_1 = new JButton("DEVELOPER 2");
		btnDeveloper_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			}
		});
		btnDeveloper_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeveloper_1.setBounds(10, 77, 154, 74);
		contentPane.add(btnDeveloper_1);
		
		JButton btnDeveloper_2 = new JButton("DEVELOPER 3");
		btnDeveloper_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
			}
		});
		btnDeveloper_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDeveloper_2.setBounds(10, 152, 154, 74);
		contentPane.add(btnDeveloper_2);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bts b = new bts();
				b.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnCancel.setBounds(40, 253, 89, 23);
		contentPane.add(btnCancel);
	}

}
