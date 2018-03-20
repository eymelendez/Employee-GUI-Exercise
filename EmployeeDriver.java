package edu.pupr.Employee;

import java.awt.EventQueue;

public class EmployeeDriver {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					JFrame_GUI frame = new JFrame_GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
