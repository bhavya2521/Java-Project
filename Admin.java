import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Admin {
	JButton logout;
	JFrame admin;
	public Admin() {
	admin = new JFrame("Admin Window");

	 logout = new JButton(new ImageIcon("logout.png"));
	 logout.setBounds(1200,10,75,70);
	 logout.setBackground(new Color(253, 253, 253 ));
	 logout.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
	 logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
	 admin.add(logout);

	 admin.getContentPane().setBackground(Color.WHITE);
	 admin.setSize(1500, 1000);
	 admin.setLayout(null);
	 admin.setVisible(true);

	logout.addActionListener(new ActionListener()
	  {
	   public void actionPerformed(ActionEvent e)
	   {
		int a = JOptionPane.showConfirmDialog(admin, "Are you sure?"); 
		if(a==JOptionPane.YES_OPTION){ 
			admin.dispose();
			@SuppressWarnings("unused")
			page p = new page();
		} 
		}
		});
	}
	}

	

