import javax.swing.*;
import java.awt.*;
import java.io.*;

public class StudentMark extends JFrame 
{
	// UI Components
	private JTextField tfName, tfJava, tfDataStruct, tfSysProg, tfOOP;
	private JTextArea area;
	private JButton btnReceipt, btnReset, btnPrint;
	public StudentMark() 
	{
		setTitle("Student Marks System");
		setSize(800, 800);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.CYAN);
		setLayout(null);
		
		// Labels and Text Fields
		add(createLabel("Student Marks", 550, 100, 250, 20));
		tfName = createTextField(250, 150);
		tfJava = createTextField(250, 200);
		tfDataStruct = createTextField(250, 250);
		tfSysProg = createTextField(250, 300);
		tfOOP = createTextField(250, 350);
		add(createLabel("Name of the Student:", 50, 150, 200, 20));
		add(createLabel("Advanced Java:", 50, 200, 200, 20));
		add(createLabel("Data Structure:", 50, 250, 200, 20));
		add(createLabel("System Programming:", 50, 300, 200, 20));
		add(createLabel("Object-Oriented Programming:", 50, 350, 250, 20));
		
		// Buttons
		btnReceipt = createButton("Generate Receipt", 600, 490);
		btnReset = createButton("Reset", 750, 490);
		btnPrint = createButton("Print", 900, 490);
		add(btnReceipt);
		add(btnReset);
		add(btnPrint);
		
		// Text Area
		area = new JTextArea();
		area.setBounds(600, 540, 450, 240);
		add(area);
		
		// Action Listeners
		btnReset.addActionListener(e -> resetFields());
		btnPrint.addActionListener(e -> printReceipt());
		btnReceipt.addActionListener(e -> generateReceipt());
		setVisible(true);
	}
	
	private JLabel createLabel(String text, int x, int y, int w, int h)
	{
		JLabel label = new JLabel(text);
		label.setBounds(x, y, w, h);
		return label;
	}
	
	private JTextField createTextField(int x, int y)
	{
		JTextField tf = new JTextField();
		tf.setBounds(x, y, 250, 20);
		add(tf);
		return tf;
	}
	
	private JButton createButton(String text, int x, int y) 
	{
		JButton button = new JButton(text);
		button.setBounds(x, y, 150, 30);
		return button;
	}
	
	private void resetFields() 
	{
		tfName.setText("");
		tfJava.setText("");
		tfDataStruct.setText("");
		tfSysProg.setText("");
		tfOOP.setText("");
		area.setText("");
	}
	
	private void printReceipt()
	{
	try {
			area.print();
		} 
		catch (java.awt.print.PrinterException e) 
		{
			System.err.println("Printer error: " + e.getMessage());
		}
	}
	
	private void generateReceipt() 
	{
	    String receiptText = String.format
	    (
	        "-------------------------------------\n" +
	        "-----------Report--------------------\n" +
	        "-------------------------------------\n" +
	        "Student Name: %s\n" +
	        "Advanced Java: %s\n" +
	        "Data Structure: %s\n" +
	        "System Programming: %s\n" +
	        "Object-Oriented Programming: %s\n",
	        tfName.getText(), tfJava.getText(), tfDataStruct.getText(), tfSysProg.getText(), tfOOP.getText()
	    );
	    area.setText(receiptText);
	    saveReceiptToFile(receiptText);
	    JOptionPane.showMessageDialog(area, "Data saved successfully.");
	}
	
	private void saveReceiptToFile(String text) 
	{
		try (FileWriter writer = new FileWriter("java.txt", true)) 
		{
			writer.write(text);
		} 
		catch (IOException e)
		{
			System.err.println("Error saving file: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) 
	{
		new StudentMark();
	}

}

