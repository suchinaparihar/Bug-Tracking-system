package chat.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;

import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 

public class bts extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bts frame = new bts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection connection = null;
	/**
	 * Create the frame.
	 */
	public bts() {
		connection = sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton btnBugTrackingSystem = new JButton("BUG TRACKING SYSTEM");
		btnBugTrackingSystem.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBugTrackingSystem.setBounds(67, 36, 312, 86);
		contentPane.add(btnBugTrackingSystem, BorderLayout.NORTH);
		
		JButton btnUser = new JButton(" REPORT BUG");
		btnUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userpage up = new userpage();
				up.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnUser.setBounds(142, 133, 163, 37);
		contentPane.add(btnUser);
		
		JButton btnPm = new JButton("Project Manager");
		btnPm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				pmpage pp = new pmpage();
				pp.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnPm.setBounds(32, 181, 152, 37);
		contentPane.add(btnPm);
		
		JButton btnDeveloper = new JButton("DEVELOPER");
		btnDeveloper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				developerpage dp = new developerpage();
				dp.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnDeveloper.setBounds(242, 181, 139, 37);
		contentPane.add(btnDeveloper);
	}
 
	
 


	}


