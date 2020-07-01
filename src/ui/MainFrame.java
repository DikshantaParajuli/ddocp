package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class MainFrame extends JFrame{
	JLabel lbluser,lblpass,lblwelcome;
	JTextField userfld;
	JPasswordField passfld;
	JButton btnlogin,btnregister;
	
	public MainFrame(){
		setSize(300, 300);
		setLayout(null);


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblwelcome=new JLabel("Welcome to Photo Editor");
		lblwelcome.setBounds(50, 45, 175, 25);
		
		lbluser=new JLabel("Username:");
		lbluser.setBounds(25, 95, 75, 25);
		
		userfld=new JTextField();
		userfld.setBounds(100, 95, 125, 25);
		
		lblpass=new JLabel("Password:");
		lblpass.setBounds(25, 145, 75, 25);
		
		passfld=new JPasswordField();
		passfld.setBounds(100, 145, 125, 25);
		
		
		btnlogin=new JButton("Login");
		btnlogin.setBounds(75, 195, 125, 25);
		
		
		btnregister=new JButton("Register");
		btnregister.setBounds(200, 10, 100, 25);
		
		btnregister.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent sandis) {
				new RegistrationFrame();
			}
			
		});
		btnlogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = userfld.getText();
				String pwd = new String(passfld.getPassword());

				UserService us = new UserService();
				int userId = us.loginUser(name, pwd);

				if (userId > 0) {
					dispose();
					
					new MainDashboard(userId);

				} else
					JOptionPane.showMessageDialog(null, "Username and password didn't matched");

			}
		});
		

		

		
	
		add(lblwelcome);
		add(lbluser);
		add(userfld);
		add(lblpass);
		add(btnlogin);
		add(btnregister);
		add(passfld);
		setResizable(false);
		setVisible(true);
		
	}
	
}
