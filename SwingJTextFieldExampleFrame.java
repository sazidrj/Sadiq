
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SwingJTextFieldExampleFrame extends JFrame  {

	private String Name;
	private String fullName;
	private String IdNumber;
	private String cellNo;

	public SwingJTextFieldExampleFrame(){
		
		setSize(400,500);
		setTitle("JTextField Demo");
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setDividerLocation(250);
		
		final JTextArea textArea = new JTextArea(60, 50);
		JScrollPane scrollText = new JScrollPane(textArea);
		textArea.setEditable(false);
		
		splitPane.setLeftComponent(scrollText);
		add(splitPane);
		
		JPanel panel = new JPanel(new GridLayout(0,1));
		
		splitPane.setRightComponent(panel);
		
		JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		addNameControls(namePanel);


		JButton submitButton = new JButton("Click ME");
		submitButton.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
		        if(SwingUtilities.isLeftMouseButton(evt)){
		        	String fullStr = "Name is:"+getFullName();
		        	fullStr += "\nIdNumber is:"+getIdNumber()+
		        	"\nMobile No is: "+getCellNo();
		        	textArea.setText(fullStr);
		        }
		    }
		});
		submitPanel.add(submitButton);
		
		panel.add(namePanel);
		panel.add(submitPanel);

	}
	
	private void addNameControls(JPanel namePanel){
		JLabel fName = new JLabel("Name: ");
		namePanel.add(fName);
		
		final JTextField Name = new JTextField(15);
		Name.setBackground(Color.YELLOW);
				
		Name.addKeyListener(new KeyAdapter() {
		    public void keyTyped(KeyEvent e) {
		    	char letter = e.getKeyChar();
		        if (Name.getText().length() >= 15 )
		            e.consume();
		        else if(!Character.isLetter(letter)){
		        	e.consume();
		        }
		    }  
		});
		
		Name.addFocusListener(new FocusListener(){
			public void focusGained(FocusEvent fe){
				
			}
			
			public void focusLost(FocusEvent fe){
				setName(Name.getText());
			}
		});
		
		namePanel.add(Name);

		JLabel addressLb3 = new JLabel("MY ID:");
		namePanel.add(addressLb3);

		final JTextField pin = new JTextField(10);
		pin.addFocusListener(new FocusListener(){

			public void focusLost(FocusEvent fe){
				setIdNumber(pin.getText());
			}

			public void focusGained(FocusEvent fe){

			}
		});

		pin.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char letter = e.getKeyChar();
				if (pin.getText().length() >= 15 ){
					e.consume();
				}
				else if(!Character.isDigit(letter)){
					e.consume();
				}
			}
		});
		namePanel.add(pin);

		JLabel phone = new JLabel("Cell No: ");

		namePanel.add(phone);

		final JTextField phoneNo = new JTextField(10);
		phoneNo.addFocusListener(new FocusListener(){

			public void focusLost(FocusEvent fe){
				setCellNo(phoneNo.getText());
			}

			public void focusGained(FocusEvent fe){

			}
		});

		phoneNo.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent e) {
				char letter = e.getKeyChar();
				if (phoneNo.getText().length() >= 10 )
					e.consume();
				else if(!Character.isDigit(letter)){
					e.consume();
				}
			}
		});
		namePanel.add(phoneNo);
	}
	
	private void addFullNameControls(JPanel fullNamePanel, final JTextField firstName,final JTextField middleName, final JTextField lastName){
		JLabel fullNameTxt = new JLabel("Full name: ");
		fullNamePanel.add(fullNameTxt);

		final JTextField fullName = new JTextField(60);
		fullName.setEditable(false);

		fullNamePanel.add(fullName);

		final Button button = new Button("Click ME");
		button.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent evt) {
		        if(SwingUtilities.isLeftMouseButton(evt)){
		        	String fName = firstName.getText();
		        	String mName = middleName.getText();
		        	String lName = lastName.getText();
		        	if(mName.length() > 0)
		        		fullName.setText(fName+" "+mName+" "+lName);
		        	else
		        		fullName.setText(fName+" "+lName);
		        	setFullName(fName+" "+mName+" "+lName);
		        }
		    }
		});

		fullNamePanel.add(button);
	}



	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}


	public String getIdNumber() {
		return IdNumber;
	}

	public void setIdNumber(String IdNumber) {
		this.IdNumber = IdNumber;
	}

	public String getCellNo() {
		return cellNo;
	}

	public void setCellNo(String cellNo) {
		this.cellNo = cellNo;
	}


	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
}
