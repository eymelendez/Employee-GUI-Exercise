/**
 * 
 * Filename: EmployeeFrame.java
 * 
 * Author: Edwin Y. Melendez Lopez #89139
 * 
 * Description: GUI that takes the information inputed by the user and displays it in the console and after
 * 				putting the hour pay on the textfield of the GUI and "Losing Focus" it will calculate how much earnings 
 * 				the person has based on what type of employee is it.
 * 
 * 		History:
 * 		02/18/2018 - Program created. EML
 *  	02/18/2018 - Added Employee Java class. EML
 *  
 * 		02/18/2018 - Added HourlyEmployee class. EML
 * 		02/18/2018 - Added SalariedEmployee class. EML
 * 		02/18/2018 - Added the JPanels to organize the GUI's content . EML
 * 		02/18/2018 - Added the JLables. EML
 * 		02/20/2018 - Added the Focus Gained of ID. EML
 * 		02/20/2018 - Added the Focus Lost of ID. EML
 * 
 *  	02/20/2018 - Added the Focus Gained of SSN. EML
 * 		02/20/2018 - Added the Focus Lost of SSN. EML
 * 
 *  	02/20/2018 - Added the Focus Gained of First Name. EML
 * 		02/20/2018 - Added the Focus Lost of First Name. EML
 * 
 *  	02/20/2018 - Added the Focus Gained of Last Name. EML
 * 		02/20/2018 - Added the Focus Lost of Last Name. EML
 * 
 * 		02/20/2018 - Added the Focus Gained of Maiden's Name. EML
 * 		02/20/2018 - Added the Focus Lost of Maiden's Name. EML
 * 
 * 		02/20/2018 - Added the Focus Gained of Hour Pay. EML
 * 		02/20/2018 - Added the Focus Lost of Hour Pay. EML
 *
 * 		02/21/2018 - Modified the Focus Lost and Gained of some variables while adding exception handling . EML
 * 		02/21/2018 - Adjusted the components of the GUI for better detail and organization. EML
 * 		02/21/2018 - Started working on the salutation link with the Photo_Label component. EML
 * 		02/21/2018 - Added a string defining the names of the photo's used in the component of Salutation. EML
 * 		02/22/2018 - Took out the focus lost for the txtfield of ID, SSN, First Name, Last Name and Maiden's Name because if the user switches and leaves it in blank it pops
 * 					 double showMessageDialog. EML
 *		02/23/2018 - Added a setIcon() to the combo box Salutation to display the photo based on what salutation is choosing. EML
 *		02/25/2018 - 
 *
 *	TODO: You need to find a way to make the toStrings display on the console or terminal by basing it on th etype of employee selected in the GUI
 *
 */
 

package edu.pupr.Employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.LineBorder;


import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;

public class JFrame_GUI extends JFrame {

	private JPanel contentPane;
	private JTextField HourPay_txtfld;
	private JTextField ID_txtfld;
	private JTextField SSN_txtfld;
	private JTextField firstName_txtfld;
	private JTextField lastName_txtfld;
	private JTextField maidenName_txtfld;
	private JTextField WeekPay_txtfld;
	private JTextField YearPay_txtfld;
	
	 // HourlyEmployee hour_Employee = new HourlyEmployee();
	// SalariedEmployee salaried_Employee = new SalariedEmployee();

	/**
	 * Create the frame.
	 */
	public JFrame_GUI() 
	{
		setTitle("Add_Employee_GUI");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		// Name of the photos to call in the photo_Label
		final String names[] = {"Mr-Icon.jpg", "Mrs-Icon.jpg", "Ms-Icon.jpg", "Darth-Vader.jpg"};
		
		// Items to be called.
		final Icon[] icons = {new ImageIcon(getClass().getResource(names[0])), new ImageIcon(getClass().getResource(names[1])), 
				  new ImageIcon(getClass().getResource(names[2])), new ImageIcon(getClass().getResource(names[3]))};
		
		// Instances of the Labels and Panels are here.
		
		JLabel HourPay_Label = new JLabel("Hour Pay: ");
		
		JLabel photo_Label = new JLabel("Image Appears Here");
		
		JLabel WeekPay_Label = new JLabel("Week Payment: ");
		
		JLabel YearPay_Label = new JLabel("Year Payment: ");
		
		JPanel Photo_Panel = new JPanel();
		
		JPanel Information_Panel = new JPanel();
		
		// Instances of the radio are here.
		
		JRadioButton rdbtn_Salaried = new JRadioButton("Salaried Employee");
		
		JRadioButton rdbtn_Hourly = new JRadioButton("Hourly Employee");
		
		// ActionListener for the radio button Hourly Employee
		rdbtn_Hourly.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rdbtn_Hourly.isSelected()) 
				{
					rdbtn_Salaried.setSelected(false); // Unchecks one button if the other is in use. if the other button is already selected.
					
					HourPay_Label.setText("Hour Pay: "); // This will change the Label when the butto Salary is selected.
	
					// Will make the labels and txtfld s visible again.
					WeekPay_Label.setVisible(true);
					YearPay_Label.setVisible(true);
					
					WeekPay_txtfld.setVisible(true);
					YearPay_txtfld.setVisible(true);
					
				}
			}
		});
		
		Photo_Panel.setToolTipText("Photo of the Employee");
		Photo_Panel.setBorder(new LineBorder(Color.BLUE, 2));
		Photo_Panel.setBackground(Color.WHITE);
		Photo_Panel.setForeground(Color.WHITE);
		
	
		Information_Panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		// Action listener of the radio button for salary 
		rdbtn_Salaried.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rdbtn_Salaried.isSelected()) 
				{
					rdbtn_Hourly.setSelected(false); // Unchecks one button if the other is in use. if the other button is already selected.
					
					HourPay_Label.setText("Salary: "); // This will change the Label when the butto Salary is selected.
					
					// Will make the labels and txtfld disappear if the salaried button is pressed.
					WeekPay_Label.setVisible(false);
					YearPay_Label.setVisible(false);
					
					WeekPay_txtfld.setVisible(false);
					YearPay_txtfld.setVisible(false);
					
				}
				
			}
		});
		
		rdbtn_Salaried.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtn_Salaried.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		
		rdbtn_Hourly.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtn_Hourly.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel Type_Employee_Panel = new JPanel();
		Type_Employee_Panel.setToolTipText("Panel which contains two types of Employees");
		Type_Employee_Panel.setBorder(new LineBorder(Color.GRAY));
		
		JPanel Results_Panel = new JPanel();
		Results_Panel.setBorder(new LineBorder(Color.GRAY));
		
		// Add button instance and the actionListener for the Add Button
		JButton Add_Button = new JButton("ADD");
		Add_Button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				if(rdbtn_Hourly.isSelected()) 
				{
					// System.out.println(hour_Employee);
					// in here it should call the toString but it's not working
				}
				
				if(rdbtn_Salaried.isSelected())
				{
					//System.out.println(salaried_Employee);
					// Same in the above
				}
				
			}
		});
		
		// Close button instance and the actionListener for the close button. 
		JButton Cancel_Button = new JButton("CANCEL");
		Cancel_Button.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) // Close frame with a close button include the action performed
			{
				System.exit(0);
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Type_Employee_Panel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
							.addComponent(Results_Panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(Photo_Panel, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Information_Panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(317, Short.MAX_VALUE)
					.addComponent(Add_Button, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Cancel_Button, GroupLayout.PREFERRED_SIZE, 106, GroupLayout.PREFERRED_SIZE)
					.addGap(35))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Photo_Panel, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE)
						.addComponent(Information_Panel, GroupLayout.PREFERRED_SIZE, 236, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(Results_Panel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
						.addComponent(Type_Employee_Panel, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(Add_Button)
						.addComponent(Cancel_Button)))
		);
		
		
		GroupLayout gl_Photo_Panel = new GroupLayout(Photo_Panel);
		gl_Photo_Panel.setHorizontalGroup(
			gl_Photo_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Photo_Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(photo_Label, GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_Photo_Panel.setVerticalGroup(
			gl_Photo_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Photo_Panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(photo_Label, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
					.addContainerGap())
		);
		Photo_Panel.setLayout(gl_Photo_Panel);
		
		
		HourPay_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		HourPay_txtfld = new JTextField();
		HourPay_txtfld.setHorizontalAlignment(SwingConstants.RIGHT);
		HourPay_txtfld.addFocusListener(new FocusAdapter() 
		{
			@Override
			public void focusLost(FocusEvent arg0) 
			{
				if(rdbtn_Hourly.isSelected()) 
				{
					double weeklyEarning = (Double.parseDouble(HourPay_txtfld.getText())) * 40; // Conversion from string to double and then to string again.
					double yearlyEarning = weeklyEarning * 52;
					
					WeekPay_txtfld.setText(Double.toString(weeklyEarning)); 
					YearPay_txtfld.setText(Double.toString(yearlyEarning));
				}
				
				
			}
		});
		HourPay_txtfld.setColumns(10);
		
		WeekPay_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		YearPay_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		WeekPay_txtfld = new JTextField();
		WeekPay_txtfld.setEditable(false);
		WeekPay_txtfld.setColumns(10);
		
		YearPay_txtfld = new JTextField();
		YearPay_txtfld.setEditable(false);
		YearPay_txtfld.setColumns(10);
		
		GroupLayout gl_Results_Panel = new GroupLayout(Results_Panel);
		gl_Results_Panel.setHorizontalGroup(
			gl_Results_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Results_Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Results_Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Results_Panel.createSequentialGroup()
							.addComponent(YearPay_Label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(YearPay_txtfld, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Results_Panel.createSequentialGroup()
							.addGroup(gl_Results_Panel.createParallelGroup(Alignment.LEADING)
								.addComponent(WeekPay_Label)
								.addComponent(HourPay_Label))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_Results_Panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(HourPay_txtfld)
								.addComponent(WeekPay_txtfld, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))))
					.addContainerGap(63, Short.MAX_VALUE))
		);
		gl_Results_Panel.setVerticalGroup(
			gl_Results_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Results_Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Results_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(HourPay_Label)
						.addComponent(HourPay_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_Results_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(WeekPay_Label)
						.addComponent(WeekPay_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
					.addGroup(gl_Results_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(YearPay_Label)
						.addComponent(YearPay_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		Results_Panel.setLayout(gl_Results_Panel);
		
		JLabel ID_Label = new JLabel("ID:");
		ID_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		ID_Label.setHorizontalAlignment(SwingConstants.LEFT);
		
		ID_txtfld = new JTextField();
		ID_txtfld.setHorizontalAlignment(SwingConstants.RIGHT);
		ID_txtfld.addFocusListener(new FocusAdapter() 
		{

			@Override
			public void focusGained(FocusEvent event)  // Invoked when a component gains the keyboard focus.  In other words, when click again, all blue to overwrite
			{
				ID_txtfld.selectAll();
			}
			
		});
		ID_txtfld.setColumns(20);
		
		JLabel Salutation_Label = new JLabel("Salutation:");
		Salutation_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		Salutation_Label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel SSN_Label = new JLabel("SSN:");
		SSN_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel firstName_Label = new JLabel("First Name:");
		firstName_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lastName_Label = new JLabel("Last Name:");
		lastName_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel maindenName_Label = new JLabel("Mother's Last Name: ");
		maindenName_Label.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		SSN_txtfld = new JTextField();
		SSN_txtfld.setHorizontalAlignment(SwingConstants.RIGHT);
		SSN_txtfld.addFocusListener(new FocusAdapter() 
		{

			@Override
			public void focusGained(FocusEvent event)  // Invoked when a component gains the keyboard focus.  In other words, when click again, all blue to overwrite
			{
				SSN_txtfld.selectAll();
			}
		});
		SSN_txtfld.setColumns(10);
		
		// TODO: Add the verifyInputString to firstName, lastName, maidenName
		firstName_txtfld = new JTextField();
		firstName_txtfld.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent event) 
			{
				firstName_txtfld.selectAll();
			}
			
		});
		firstName_txtfld.setHorizontalAlignment(SwingConstants.RIGHT);
		firstName_txtfld.setColumns(10);
		
		lastName_txtfld = new JTextField();
		lastName_txtfld.addFocusListener(new FocusAdapter() {
		
			@Override
			public void focusGained(FocusEvent event)
			{
				lastName_txtfld.selectAll();
			}
		});
		lastName_txtfld.setHorizontalAlignment(SwingConstants.RIGHT);
		lastName_txtfld.setColumns(10);
		
		maidenName_txtfld = new JTextField();
		maidenName_txtfld.addFocusListener(new FocusAdapter() {
			
			@Override
			public void focusGained(FocusEvent event) 
			{
				maidenName_txtfld.selectAll();
			}
		});
		maidenName_txtfld.setHorizontalAlignment(SwingConstants.RIGHT);
		maidenName_txtfld.setColumns(10);
		
		JComboBox Salutation_cmbbox = new JComboBox();
		Salutation_cmbbox.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent event) 
			{
				photo_Label.setText(null); //set the label to null ready for the image to be displayed

				photo_Label.setIcon(icons[Salutation_cmbbox.getSelectedIndex()]); // sets the photo or icon according to the index of the array of icons or photos.
			}
		});
		Salutation_cmbbox.setModel(new DefaultComboBoxModel(new String[] {"Mr.", "Mrs.", "Ms.", "Darth"}));
		
		GroupLayout gl_Information_Panel = new GroupLayout(Information_Panel);
		gl_Information_Panel.setHorizontalGroup(
			gl_Information_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Information_Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Information_Panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_Information_Panel.createSequentialGroup()
							.addComponent(Salutation_Label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Salutation_cmbbox, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Information_Panel.createSequentialGroup()
							.addComponent(maindenName_Label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(maidenName_txtfld, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_Information_Panel.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_Information_Panel.createSequentialGroup()
								.addComponent(lastName_Label)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lastName_txtfld))
							.addGroup(Alignment.LEADING, gl_Information_Panel.createSequentialGroup()
								.addGroup(gl_Information_Panel.createParallelGroup(Alignment.LEADING)
									.addComponent(firstName_Label)
									.addComponent(SSN_Label)
									.addComponent(ID_Label))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_Information_Panel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(ID_txtfld)
									.addComponent(SSN_txtfld, 166, 166, Short.MAX_VALUE)
									.addComponent(firstName_txtfld)))))
					.addContainerGap(36, GroupLayout.PREFERRED_SIZE))
		);
		gl_Information_Panel.setVerticalGroup(
			gl_Information_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Information_Panel.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_Information_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(ID_Label)
						.addComponent(ID_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_Information_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Salutation_Label)
						.addComponent(Salutation_cmbbox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Information_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(SSN_Label)
						.addComponent(SSN_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Information_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstName_Label)
						.addComponent(firstName_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(17)
					.addGroup(gl_Information_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lastName_Label)
						.addComponent(lastName_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_Information_Panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(maindenName_Label)
						.addComponent(maidenName_txtfld, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		Information_Panel.setLayout(gl_Information_Panel);
		
		
		GroupLayout gl_Type_Employee_Panel = new GroupLayout(Type_Employee_Panel);
		gl_Type_Employee_Panel.setHorizontalGroup(
			gl_Type_Employee_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Type_Employee_Panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_Type_Employee_Panel.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtn_Salaried)
						.addComponent(rdbtn_Hourly))
					.addContainerGap(85, Short.MAX_VALUE))
		);
		gl_Type_Employee_Panel.setVerticalGroup(
			gl_Type_Employee_Panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_Type_Employee_Panel.createSequentialGroup()
					.addGap(28)
					.addComponent(rdbtn_Salaried)
					.addGap(27)
					.addComponent(rdbtn_Hourly)
					.addGap(42))
		);
		Type_Employee_Panel.setLayout(gl_Type_Employee_Panel);
		contentPane.setLayout(gl_contentPane);
	} // end JFrame_GUI class
	
	// TextField Verification for Strings
		private String verifyInputString(JTextField textField) 
		{
			String str = textField.getText();			
			
			if (!str.matches("^[a-zA-Z]+$"))
			{
				JOptionPane.showMessageDialog(this, "It only accepts strings NOT numbers!");
				textField.requestFocus();
				textField.selectAll();
			} // end of if.
			
			return str;
		} // end verifyInput
		
	// TextField Verification for Numbers only entry.
		private String verifyInputNumber(JTextField textField) 
		{
			String strNum = textField.getText();			
			
			// Verify's of the txtfld is filled with numbers and NOT characters.
			if (strNum.equals(""))
			{
				JOptionPane.showMessageDialog(this, "It only accepts NUMBERS");
				textField.requestFocus();
				textField.selectAll();
			} // end of if.
			
			return strNum;
		} // end verifyInput
		
} // end JFrame_GUI public class as a whole.
