import java.awt.*; 
import javax.swing.*; 
import java.io.*; 
import java.awt.event.*;
import javax.swing.text.*; 
import java.util.*;

class ADEDITOR extends JFrame implements ActionListener{
	JTextArea textArea_1;
	JFrame frame;
	
	ADEDITOR(){
		//give the heading of the frame
		frame = new JFrame("ADEDITOR - A Text Editor By Aditya P");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 1350, 650);
		frame.getContentPane().add(scrollPane);

		textArea_1 = new JTextArea();
		scrollPane.setViewportView(textArea_1);
		
		JMenuBar menubar = new JMenuBar();
		//create a file menu
		JMenu file = new JMenu("File");
		
		//creating elements of file
		JMenuItem newMenu = new JMenuItem("New Text File");
		JMenuItem openMenu = new JMenuItem("Open Existing file");
		JMenuItem saveMenu = new JMenuItem("Save this file");
		JMenuItem printMenu = new JMenuItem("Print my C++ code");
		JMenuItem exitMenu = new JMenuItem("Exit");
		
		newMenu.addActionListener(this);
		openMenu.addActionListener(this);
		saveMenu.addActionListener(this);
		printMenu.addActionListener(this);
		exitMenu.addActionListener(this);
		
		file.add(newMenu);
		file.add(openMenu);
		file.addSeparator();
		file.add(saveMenu);
		file.addSeparator();
		file.add(printMenu);
		file.addSeparator();
		file.add(exitMenu);
		
		
		//create a edit menu
		JMenu edit = new JMenu("Edit");
		
		//creating elements of edit
		JMenuItem cutMenu = new JMenuItem("Cut");
		JMenuItem copyMenu = new JMenuItem("Copy");
		JMenuItem pasteMenu = new JMenuItem("Paste");
		JMenuItem selectAll = new JMenuItem("Select All");
		
		cutMenu.addActionListener(this);
		copyMenu.addActionListener(this);
		pasteMenu.addActionListener(this);
		selectAll.addActionListener(this);
		
		edit.add(cutMenu);
		edit.add(copyMenu);
		edit.add(pasteMenu);
		edit.addSeparator();
		edit.add(selectAll);
		
		//create help
		JMenu help = new JMenu("Help");
		
		//creating elements of help
		JMenuItem helpMenu = new JMenuItem("Help");
		
		helpMenu.addActionListener(this);
		
		help.add(helpMenu);
		
		//assigning menus to menubar
		menubar.add(file);
		menubar.add(edit);
		menubar.add(help);
				
		frame.setJMenuBar(menubar);
		frame.setSize(700,700);
		frame.show();
	}
	
	public void actionPerformed(ActionEvent e){
		String command = e.getActionCommand();
		if(command.equals("New Text File")){
			//do save the code first
			int result = JOptionPane.showConfirmDialog(frame,"Please make sure you have saved your code.Are you sure to proceed?","C++ Code Editor By Adinovap20",
			JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			//code if clicked yes no
			if(result==JOptionPane.YES_OPTION){
				//editor.setText("");
				textArea_1.setText("");
				
			}else{
				//do nothing
			}
		}else if(command.equals("Open Existing file")){
			//create open dialog box
			JFileChooser openDialog = new JFileChooser("f:");
			
			//result
			int fileChosen = openDialog.showOpenDialog(null);
			
			//if user selects a file
			if(fileChosen==JFileChooser.APPROVE_OPTION){
				File chosen = new File(openDialog.getSelectedFile().getAbsolutePath());
				
				try{
					String s1 = "", sl = "";
					FileReader fileReader = new FileReader(chosen);
					BufferedReader bufferReader = new BufferedReader(fileReader);
					
					sl = bufferReader.readLine();
					
					while((s1 = bufferReader.readLine()) != null){
						sl = sl + "\n" + s1;
					}
					
					textArea_1.setText(sl);
				}catch(Exception evt){
					JOptionPane.showMessageDialog(frame,evt.getMessage());
				}
			}else{
				JOptionPane.showMessageDialog(frame,"Open file process is cancelled by you..");
			}
		}else if(command.equals("Save this file")){
			JOptionPane.showMessageDialog(frame,"While saving the file do mention the extension like HelloWorld.txt");
			JFileChooser saveDialog = new JFileChooser("f:");
				int fileChosen = saveDialog.showSaveDialog(null);
			
				if(fileChosen == JFileChooser.APPROVE_OPTION){
					File fi = new File(saveDialog.getSelectedFile().getAbsolutePath()); 
  
					try { 
						// Create a file writer 
						FileWriter wr = new FileWriter(fi, false); 
  
						// Create buffered writer to write 
						BufferedWriter w = new BufferedWriter(wr); 
  
						// Write 
						w.write(textArea_1.getText()); 
  
						w.flush(); 
						w.close(); 
					}catch (Exception evt) { 
						JOptionPane.showMessageDialog(frame, evt.getMessage()); 
					} 
				}else{
					JOptionPane.showMessageDialog(frame, "Save file process is cancelled by you..");  
				}
		}else if(command.equals("Print my C++ code")){
			try{ 
				textArea_1.print(); 
            }catch (Exception evt) { 
                JOptionPane.showMessageDialog(frame, evt.getMessage()); 
            } 
		}else if(command.equals("Exit")){
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}else if(command.equals("Cut")){
			textArea_1.cut();
		}else if(command.equals("Copy")){
			textArea_1.copy();
		}else if(command.equals("Paste")){
			textArea_1.paste();
		}else if(command.equals("Select All")){
			textArea_1.selectAll();
		}else if(command.equals("Help")){
			JOptionPane.showMessageDialog(frame, "This is the ADEDITOR - made by Aditya P.\n ADEDITOR is the simple text editor in which you can simply edit the text, open the text and save the text.\n\nFor more information visit https://www.github.com/adinovap20/ADEDITOR");
		}
	}
	
	public static void main(String args[]){
		ADEDITOR e = new ADEDITOR();
	}
}