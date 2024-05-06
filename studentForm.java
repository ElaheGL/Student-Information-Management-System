import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.HashMap;

public class studentForm extends JFrame implements ActionListener{
	private JTextField passNM,name,studentNM;
	private JButton search,add;
	private JPanel part1,part2,part3;
	private java.util.HashMap<Integer, Student> hm;
	public studentForm() {
		setSize(400,200);
		setTitle("ST FORM");
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		part1 = new JPanel();
		part1.add(new JLabel("name"));
		name = new JTextField(10);
		part1.add(name);
		part1.add(new JLabel("pass number"));
		passNM = new JTextField(10);
		part1.add(passNM);
		add(part1,BorderLayout.NORTH);
		part2 = new JPanel();
		studentNM = new JTextField(10);
		part2.add(new JLabel("st number"));
		part2.add(studentNM);
		add(part2,BorderLayout.CENTER);
		add = new JButton("ADD");
		add.addActionListener(this);
		search = new JButton("SEARCH");
		search.addActionListener(this);
		part3 = new JPanel();
		part3.add(add);
		part3.add(search);
		add(part3,BorderLayout.SOUTH);
		hm = new java.util.HashMap<Integer, Student>();
		
		
				
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		studentForm form = new studentForm();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			addItems();
			cleanFields();		
		}
		if(e.getSource()== search) {
			searchPart();
			passNM.setText("");
		}
		
	}
	private void cleanFields() {
		name.setText("");
		passNM.setText("");
		studentNM.setText("");
		
		
	}
	private void addItems() {
		try {
			String namE = name.getText();
			int stNum = Integer.parseInt(studentNM.getText());
			int passNo = Integer.parseInt(passNM.getText());
			Student newStudent = new Student(namE, stNum);
			hm.put(passNo, newStudent);
			System.out.println(hm);
			cleanFields();
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please enter valid number");
		}
		
	}
	private void searchPart() {
		try {
			int passNo = Integer.parseInt(passNM.getText());
		
			if (hm.containsKey(passNo)) {
				Student stFound = hm.get(passNo);
				name.setText(stFound.name);
				studentNM.setText(Integer.toString(stFound.stNum));
		}
			else {
				JOptionPane.showMessageDialog(null, "There is no student with this passport number!");
			}
	}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "please enter a valid number");
		}
	}
	
}

