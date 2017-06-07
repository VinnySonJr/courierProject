package courierui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import courierpd.core.User;

public class EmployeeManagementPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	public EmployeeManagementPanel(CourierMainFrame currentFrame) {
		setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new AddUpdateEmployeePanel(currentFrame, new User()));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(145, 468, 97, 25);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentFrame.getContentPane().removeAll();
				// when we update the user, it shouldn't be a new User, but one from the list
				currentFrame.getContentPane().add(new AddUpdateEmployeePanel(currentFrame, new User()));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnUpdate.setBounds(443, 468, 97, 25);
		add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new EmployeeDeletePanel(currentFrame));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnDelete.setBounds(725, 468, 97, 25);
		add(btnDelete);
		
		JList list = new JList();
		list.setBounds(84, 108, 791, 335);
		add(list);
		
		JLabel lblEmployeeList = new JLabel("Employee List");
		lblEmployeeList.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEmployeeList.setBounds(465, 41, 86, 16);
		add(lblEmployeeList);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setBounds(329, 79, 56, 16);
		add(lblIdNumber);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(105, 79, 118, 16);
		add(lblName);
		
		JLabel lblRole = new JLabel("Role");
		lblRole.setBounds(541, 79, 97, 16);
		add(lblRole);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(788, 79, 56, 16);
		add(lblEmail);

	}
}