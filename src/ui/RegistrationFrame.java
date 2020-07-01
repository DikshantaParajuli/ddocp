package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrationFrame extends JFrame {
	JLabel lblregister,lblname,lblemail,lblusername,lblpassword;
	JTextField namefld,emailfld,usernamefld;
	JButton buttonregister;
	JPasswordField passwordfld;
	
		public RegistrationFrame() {
			setSize(350, 450);
			setLayout(null);
			lblregister=new JLabel("FREE REGISTERATION !!!!!!!! ");
			lblregister.setBounds(150, 25, 200, 25);
			
			lblname=new JLabel("Full Name:");
			lblname.setBounds(50, 100, 100, 25);
			
			namefld=new JTextField();
			namefld.setBounds(125, 100, 150, 25);
			
			lblemail=new JLabel("Email");
			lblemail.setBounds(50, 150, 100, 25);
			
			emailfld=new JTextField();
			emailfld.setBounds(125, 150, 150, 25);
			
			lblusername=new JLabel("Username:");
			lblusername.setBounds(50, 200, 100, 25);
			
			usernamefld=new JTextField();
			usernamefld.setBounds(125, 200, 150, 25);
			
			lblpassword=new JLabel("Password:");
			lblpassword.setBounds(50, 250, 125, 25);
			
			passwordfld=new JPasswordField();
			passwordfld.setBounds(125, 250,150,25);
			
			buttonregister=new JButton("REGISTER");
			buttonregister.setBounds(175, 300, 100, 25);
			
			buttonregister.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					String name = usernamefld.getText();
					String pwd = new String(passwordfld.getPassword());
					String email=emailfld.getText();
					String fname=namefld.getText();
					UserService us = new UserService();
					int userId = us.registerUser(name, pwd,email,fname);

					if (userId > 0) {
						JOptionPane.showMessageDialog(null, "User registered  sucessfully");
						
						
					} else
						JOptionPane.showMessageDialog(null, "Failed to register user");

				}
			});
			add(emailfld);
			add(buttonregister);
			add(passwordfld);
			add(lblpassword);
			
			add(lblusername);
			add(usernamefld);
			add(lblname);
			add(lblemail);
			add(namefld);
			add(lblregister);
			setVisible(true);
		}
		
}
