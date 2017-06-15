package courierui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import courierpd.core.Client;
import courierpd.map.Intersection;
import courierdm.ClientDBAO;
import courierdm.IntersectionDBAO;

public class ClientManagementPanel extends JPanel {

	/**
	 * Generated serialization unique identifier.
	 * This would be used if the object were streamed
	 * in bit form so that it would be reconstructed correctly.
	 */
	private static final long serialVersionUID = -6553392431507855432L;
	
	JList<Client> list;
	JButton btnAdd;
	JButton btnUpdate;
	JButton btnDelete;
	
	/**
	 * Create the panel.
	 */
	public ClientManagementPanel(CourierMainFrame currentFrame) {
		DefaultListModel listModel;
		List<Client> persistedClients = ClientDBAO.listClients();
		
		listModel = new DefaultListModel();
		for(Client client: persistedClients)
			listModel.addElement(client);
				
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) 
			{
				btnDelete.setEnabled(true);
					 		
				btnUpdate.setEnabled(true);
			}
		});
		list.setBounds(263, 106, 466, 335);
		add(list);
		
		setLayout(null);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new AddUpdateClientPanel(currentFrame, new Client(), true));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnAdd.setBounds(263, 468, 97, 25);
		add(btnAdd);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setEnabled(false);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new AddUpdateClientPanel(currentFrame, list.getSelectedValue(), false));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnUpdate.setBounds(443, 468, 97, 25);
		add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new ClientDeletePanel(currentFrame, list.getSelectedValue()));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnDelete.setBounds(630, 468, 97, 25);
		add(btnDelete);
		
		JLabel lblClientList = new JLabel("Client List");
		lblClientList.setBounds(465, 41, 56, 16);
		add(lblClientList);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(294, 79, 56, 16);
		add(lblName);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(571, 81, 46, 14);
		add(lblStatus);
	}
}
