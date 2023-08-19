package project_NotepadClone;

import java.util.* ;
 import java.io.* ;
 
 import javax.swing.* ;
 import java.awt.* ;
 import java.awt.event.* ;
 import javax.swing.filechooser.* ;
 
public class NotepadClone extends JFrame implements ActionListener {
	
	JTextArea textarea ;
	String text ;
	
	NotepadClone(){
		
		//MENU BAR : ICONS
		ImageIcon Icon=new ImageIcon(ClassLoader.getSystemResource("project_NotepadClone/Images/notepadicon.png"));
		Image icon=Icon.getImage() ;
	    setIconImage(icon) ;
	    
	    JMenuBar menuBar=new JMenuBar();
	    
	    //BACKGROUND COLOUR CHANGING
	    menuBar.setBackground(Color.GRAY) ;
	    
	    //FILE
	    
	    JMenu file=new JMenu("File") ;
	    file.setFont(new Font("SAN_SERIF",Font.ITALIC,14)) ;
	    
	    //MENUITEM
	    JMenuItem newfile=new JMenuItem("New") ;
	    newfile.addActionListener(this) ;
	    newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.CTRL_MASK)) ;
	    JMenuItem open=new JMenuItem("Open") ;
	    open.addActionListener(this) ;
	    open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK)) ;
	    JMenuItem save=new JMenuItem("Save") ;
	    save.addActionListener(this) ;
	    save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK)) ;
	    JMenuItem print=new JMenuItem("Print") ;
	    print.addActionListener(this) ;
	    print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK)) ;
	    JMenuItem exit=new JMenuItem("Exit") ;
	    exit.addActionListener(this) ;
	    exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,ActionEvent.CTRL_MASK)) ;
	    
	    file.add(newfile) ;
	    file.add(open) ;
	    file.add(save) ;
	    file.add(print) ;
	    file.add(exit) ;
	    
	    menuBar.add(file) ;
	    
	    //EDIT
	    
	    JMenu edit=new JMenu("Edit") ;
	    edit.setFont(new Font("SAN_SERIF",Font.ITALIC,14)) ;
	    
	    //MENUITEM
	    JMenuItem copy=new JMenuItem("Copy") ;
	    copy.addActionListener(this);
	    copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK)) ;
	    JMenuItem paste=new JMenuItem("Paste") ;
	    paste.addActionListener(this);
	    paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,ActionEvent.CTRL_MASK)) ;
	    JMenuItem cut=new JMenuItem("Cut") ;
	    cut.addActionListener(this);
	    cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,ActionEvent.CTRL_MASK)) ;
	    JMenuItem select=new JMenuItem("Select All") ;
	    select.addActionListener(this);
	    select.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK)) ;
	    
	    edit.add(copy) ;
	    edit.add(paste) ;
	    edit.add(cut) ;
	    
	    menuBar.add(edit) ;
	    
	    //VIEW
	    
	    JMenu view=new JMenu("View") ;
	    view.setFont(new Font("SAN_SERIF",Font.ITALIC,14)) ;
	    
	    //MENUITEM
	    JMenuItem zoom=new JMenuItem("Zoom") ;
	    zoom.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,ActionEvent.CTRL_MASK)) ;
	    view.add(zoom) ;
	    menuBar.add(view) ;
	    
	    //HELP
	    
	    JMenu helpMenu=new JMenu("Help") ;
	    helpMenu.setFont(new Font("SAN_SERIF",Font.ITALIC,14)) ;
	    
	    //MENUITEM
	    JMenuItem help=new JMenuItem("About") ;
	    help.addActionListener(this);
	    help.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK)) ;
	    
	    helpMenu.add(help) ;
	    menuBar.add(helpMenu) ;
	    
	    
	    setJMenuBar(menuBar) ;
	    
	    textarea=new JTextArea() ;
	    textarea.setFont(new Font("AERIAL",Font.PLAIN,18)) ;
	    textarea.setLineWrap(true) ;
	    textarea.setWrapStyleWord(true);
	    add(textarea) ;
	    JScrollPane scrollbar=new JScrollPane(textarea) ;
	    scrollbar.setBorder(BorderFactory.createEmptyBorder()) ;
	    add(scrollbar) ;
	    
	    
	    setExtendedState(JFrame.MAXIMIZED_BOTH);
	    setVisible(true) ;
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand().equals("New")) {
			textarea.setText("") ;
		}else if(ae.getActionCommand().equals("Open")) {
			JFileChooser choose=new JFileChooser() ;
			choose.setAcceptAllFileFilterUsed(false) ;
			FileNameExtensionFilter filter = FileNameExtensionFilter("text only","txt");
			choose.addChoosableFileFilter(filter) ;
			int action=choose.showOpenDialog(this) ;
			if(action != JFileChooser.APPROVE_OPTION) {
				return ;
			}
			File file=choose.getSelectedFile();
			try {
				BufferedReader reader=new BufferedReader(FileReader(file)) ;
				textarea.read(reader,null);
			}catch(Exception e) {
				System.out.println();
				//e.printStackTrace();
			}
		}else if(ae.getActionCommand().equals("Save")) {
			JFileChooser saveas = new JFileChooser();
			saveas.setApproveButtonText("Save") ;
			
			int action=saveas.showOpenDialog(this) ;
			if(action != JFileChooser.APPROVE_OPTION) {
				return ;
			}
			File filename= new File(saveas.getSelectedFile()+".txt") ;
			BufferedWriter outputFile=null ;
			try {
				outputFile=new BufferedWriter(new FileWriter(filename)) ;
			}catch(Exception e) {
				System.out.println();
				//e.printStackTrace();
			}
		}else if(ae.getActionCommand().equals("Print")) {
			try {
				textarea.print();
			}catch(Exception e) {
				System.out.println();
				//e.printStackTrace();
			}
		}else if(ae.getActionCommand().equals("Exit")) {
			System.exit(0);
		}else if(ae.getActionCommand().equals("Copy")) {
			text=textarea.getSelectedText();
		}else if(ae.getActionCommand().equals("Paste")) {
			textarea.insert(text,textarea.getCaretPosition());
		}else if(ae.getActionCommand().equals("Cut")) {
			text=textarea.getSelectedText();
			textarea.replaceRange("",textarea.getSelectionStart(),textarea.getSelectionEnd()) ;
		}else if(ae.getActionCommand().equals("Select All")) {
			textarea.selectAll() ;
		}else if(ae.getActionCommand().equals("About")) {
			new About().setVisible(true) ;
		}
	}

	private Reader FileReader(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	private FileNameExtensionFilter FileNameExtensionFilter(String string1, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotepadClone notepad=new NotepadClone() ;
	}

}
