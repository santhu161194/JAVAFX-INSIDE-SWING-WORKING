package controller;

import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class Demo {
	@FXML TextField Barcode;
	TextField text;
	JTextField t1;
	JFXPanel p2;
	// 1
	public static void main(String[] args) {
		initAndShowGUI();// Initializes the Swing GUI
	}

	
	
	// 2.
	public static void initAndShowGUI() {
		Demo demo = new Demo();
		 JFrame f=new JFrame();  
		    JTextField ta=new JTextField("Swing Text Field");  
		    JPanel p1=new JPanel();  
		    p1.add(ta);  
		    JTable t1=new JTable(7, 15);
		    t1.setBounds(25, 25, 400, 600);
		    p1.add(t1);
		    JMenuBar mb=new JMenuBar();  
		    JMenu menu;
		    JMenuItem i1, i2 ;
		    menu=new JMenu("Menu");  
	          i1=new JMenuItem("Item 1");  
	          i2=new JMenuItem("Item 2");  
	          menu.add(i1); menu.add(i2);  
	          MenuItemListener menuItemListener = demo.new MenuItemListener();
	          i1.addActionListener(menuItemListener);
	          i2.addActionListener(menuItemListener);
	          mb.add(menu);  
	          f.setJMenuBar(mb);
		    
		    
		    
		    demo.p2=new JFXPanel();  
		    JComponent tp=new JTabbedPane();  
		    tp.setBounds(0,0,200,200);  
		    tp.add("main",p1);  
		    tp.add("visit",demo.p2);  
		    f.add(tp);  
		    f.setSize(757, 499);
		    f.setVisible(true);  
		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Starting the JFX User Thread
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				demo.initFX(demo.p2);

			
			}
			
		});

	}
	
	public void onAction1(final ActionEvent ac) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println("onAction: " +ac);
            }
        });
    }
	
	public void initialize() {
		
		System.out.println("FXML got initialized");
	}
	
	
	
	private void initFX(JFXPanel fxPanel) {
		// This method is invoked on the JavaFX thread
		Scene scene = null ;
		text = new TextField();
		
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Demo.class.getResource("../view/Root.fxml"));
			loader.setController(Demo.this);
			BorderPane rootLayout = (BorderPane) loader.load();

			scene = new Scene(rootLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		fxPanel.setScene(scene);
	}
	
	@FXML public void done() {
		System.out.println("Done Dona Done"+Barcode.getText());
	}
	
	class MenuItemListener implements ActionListener {
		@Override
		public void actionPerformed(java.awt.event.ActionEvent e) {
			//demo.tp=demo.p2
			
		}    
	   }
	

}