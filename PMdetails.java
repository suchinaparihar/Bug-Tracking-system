package chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

 
import jade.domain.persistence.SaveContainer;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.StaleProxyException;

public class PMdetails extends JFrame {

    private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			 public void run() {
				try {
					PMdetails pmd = new PMdetails();
					pmd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	private JTable table;
 
	
	public PMdetails() {
	
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 434);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnListOfDevelopers = new JButton("List of Developers");
		btnListOfDevelopers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				 
				 
				 
			}
		});
			
	
		btnListOfDevelopers.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnListOfDevelopers.setBounds(58, 42, 176, 47);
		contentPane.add(btnListOfDevelopers);
		
		JButton btnStartADiscussion = new JButton("Start a Discussion Thread");
		btnStartADiscussion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		
				 
				setVisible(false);
				dispose();
				
			}

			 

			 
		});
		btnStartADiscussion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnStartADiscussion.setBounds(44, 244, 227, 47);
		contentPane.add(btnStartADiscussion);
		
		JButton btnNewButton = new JButton("Bug Assignment Data");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "select * from assigned_bug";
					PreparedStatement pst = connection.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
				    table.setModel(DbUtils.resultSetToTableModel(rs));
					
				}catch(Exception e1) {

				 
				}	
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(58, 140, 176, 53);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(320, 42, 366, 269);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(JFrame.EXIT_ON_CLOSE);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(109, 348, 101, 36);
		contentPane.add(btnNewButton_1);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    
				pmpage pm = new pmpage();
				pm.setVisible(true);
				setVisible(false);
				dispose();
				
		
				}
			});
	
		btnBack.setBounds(0, 0, 89, 23);
		contentPane.add(btnBack);
}
	}
