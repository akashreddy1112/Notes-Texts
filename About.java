package project_NotepadClone;

import java.util.* ;

import javax.swing.* ;
import java.awt.* ;
import java.awt.event.* ;

public class About extends JFrame implements ActionListener {
	
	About(){
		
		setBounds(300,100,600,500) ;
		setLayout(null) ;
		
		ImageIcon Icon1=new ImageIcon(ClassLoader.getSystemResource("project_NotepadClone/Images/windows.png"));
		Image image1=Icon1.getImage().getScaledInstance(250,500,Image.SCALE_DEFAULT);
		ImageIcon icon1=new ImageIcon(image1) ;
		JLabel logo1=new JLabel(icon1) ;
		logo1.setBounds(85,30,400,50) ;
		
		add(logo1) ;
		
		ImageIcon Icon2=new ImageIcon(ClassLoader.getSystemResource("project_NotepadClone/Images/notepadicon.png"));
		Image image2=Icon2.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
		ImageIcon icon2=new ImageIcon(image2) ;
		JLabel logo2=new JLabel(icon2) ;
		logo2.setBounds(50,105,70,70) ;
		
		add(logo2) ;
		
		JLabel text=new JLabel("<html>Hello Dear Users....Welcome to NOTES & TEXTS<br> version : 1.7.18 (OS Build Java)<br> NOTES & TEXTS. All Rights Reserved.</html>") ;
		text.setBounds(150,-25,500,400) ;
		text.setFont(new Font("AERIAL",Font.ITALIC,16)) ;
		
		add(text) ;
		
		JButton button=new JButton("OK") ;
		button.setBounds(230,300,100,25) ;
		button.addActionListener(this) ;
		add(button) ;
		
		setVisible(true) ;
	}
	public void actionPerformed(ActionEvent ae) {
		this.setVisible(false) ;
	}
	
	public static void main(String[] args) {
		new About() ;
	}
	
}
