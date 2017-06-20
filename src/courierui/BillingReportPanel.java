package courierui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import courierdm.DeliveryTicketDBAO;
import courierpd.core.Client;
import courierpd.core.DeliveryTicket;
import courierpd.core.User;
import courierpd.other.DateParser;

public class BillingReportPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public BillingReportPanel(CourierMainFrame currentFrame, User activeUser, List<Client> clientList, boolean allClients) {
		List<DeliveryTicket> persistedDeliveryTickets = DeliveryTicketDBAO.listDeliveryTickets();
		setLayout(null);
		
		JLabel lblClient = new JLabel("Client: ");
		lblClient.setBounds(69, 35, 46, 14);
		add(lblClient);
		
		String name = "";
		if(allClients)
		{
			name = "All Clients";
		}
		else
		{
			for(Client client: clientList)
			{
				name = client.getName();
			}
		}
		
		JLabel lblInsertName = new JLabel(name);
		lblInsertName.setBounds(125, 35, 189, 14);
		add(lblInsertName);
		
		DefaultListModel listModel = new DefaultListModel();
		for(Client client: clientList)
		{ 
			for(DeliveryTicket deliveryTicket: persistedDeliveryTickets)
			{
				if((deliveryTicket.getPickUpClient() == client && deliveryTicket.getIsBillPickUp()) || (deliveryTicket.getDeliveryClient() == client && !deliveryTicket.getIsBillPickUp()))
				{
					listModel.addElement(DateParser.printDate(deliveryTicket.getOrderDate()) + "    " + deliveryTicket.getPackageID() + "    " + DateParser.printTime(deliveryTicket.getActualPickUpTime()) + "    " + DateParser.printTime(deliveryTicket.getActualDeliveryTime()) + "    " + deliveryTicket.getEstPrice());
				}
			}
		}
		
		JList list = new JList(listModel);
		list.setFont(new Font("Courier New", Font.PLAIN, 12));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.setBounds(39, 92, 528, 269);
		add(list);
		
		JButton btnSaveAsPdf = new JButton("Save as PDF");
		btnSaveAsPdf.setBounds(125, 372, 123, 23);
		add(btnSaveAsPdf);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new BillingReportOptionsPanel(currentFrame, activeUser));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnCancel.setBounds(358, 372, 114, 23);
		add(btnCancel);
		
		
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(57, 67, 46, 14);
		add(lblDate);
		
		JLabel lblPackageId = new JLabel("Package ID");
		lblPackageId.setBounds(135, 67, 78, 14);
		add(lblPackageId);
		
		JLabel lblPickupTime = new JLabel("Pick-up Time");
		lblPickupTime.setBounds(235, 67, 100, 14);
		add(lblPickupTime);
		
		JLabel lblDeliveryTime = new JLabel("Delivery Time");
		lblDeliveryTime.setBounds(358, 67, 100, 14);
		add(lblDeliveryTime);
		
		JLabel lblBillingRate = new JLabel("Billing Rate");
		lblBillingRate.setBounds(468, 67, 87, 14);
		add(lblBillingRate);

	}
}
