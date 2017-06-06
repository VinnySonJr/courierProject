package courierui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("unused")
public class CourierMainFrame extends JFrame {

	/**
	 * Generated serialization unique identifier.
	 * This would be used if the object were streamed
	 * in bit form so that it would be reconstructed correctly.
	 */
	private static final long serialVersionUID = -2964820041018829006L;
	
	private JPanel contentPane; 

	/**
	 * 
	 * We'll probably want to create the login screen as a separate frame
	 * since there will be different menu items depending on which user
	 * logs in. We could also control the display of the menu based on
	 * whether the login panel was currently displayed and the employee role
	 * of the current authorized user.
	 */
	public static void startGUI(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourierMainFrame frame = new CourierMainFrame();
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
	public CourierMainFrame() {
		CourierMainFrame currentFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1017, 602);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem mntmDeliveryTickets = new JMenuItem("Delivery Tickets");
		mntmDeliveryTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				// In the add, place the constructor for your panel
				//getContentPane().add();
				getContentPane().add(new DeliveryTicketListPanel(currentFrame));
				getContentPane().revalidate();
			}
		});
		menuBar.add(mntmDeliveryTickets);
		
		JMenuItem mntmEmployees = new JMenuItem("Employees");
		mntmEmployees.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new EmployeeManagementPanel(currentFrame));
				getContentPane().revalidate();
			}
		});
		menuBar.add(mntmEmployees);
		
		JMenuItem mntmClients = new JMenuItem("Clients");
		mntmClients.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				getContentPane().add(new ClientManagementPanel(currentFrame));
				getContentPane().revalidate();
			}
		});
		menuBar.add(mntmClients);
		
		JMenuItem mntmBusinessParameters = new JMenuItem("Business Parameters");
		mntmBusinessParameters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				// In the add, place the constructor for your panel
				//getContentPane().add();
				getContentPane().revalidate();
			}
		});
		menuBar.add(mntmBusinessParameters);
		
		JMenuItem mntmMapConfiguration = new JMenuItem("Map Configuration");
		mntmMapConfiguration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				// In the add, place the constructor for your panel
				//getContentPane().add();
				getContentPane().add(new MapConfigPanel(currentFrame));
				getContentPane().revalidate();
			}
		});
		menuBar.add(mntmMapConfiguration);
		
		JMenuItem mntmReports = new JMenuItem("Reports");
		mntmReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				// In the add, place the constructor for your panel
				//getContentPane().add();
				getContentPane().revalidate();
			}
		});
		menuBar.add(mntmReports);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getContentPane().removeAll();
				// In the add, place the constructor for your panel
				//getContentPane().add();
				getContentPane().revalidate();
			}
		});
		menuBar.add(mntmLogout);
		
		// The default panel to display should be added here.
		// This will eventually be the login screen.
		currentFrame.getContentPane().removeAll();
		//currentFrame.getContentPane().add();
		currentFrame.getContentPane().add(new DeliveryTicketListPanel(currentFrame));
		currentFrame.getContentPane().revalidate();
		
	}

}
