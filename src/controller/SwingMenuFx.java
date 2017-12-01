package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class SwingMenuFx {
	JFrame mainFrame;
	JComponent component;
	@FXML TextField Barcode;
	JFXPanel fxpanel;
	public static void main(String[] args) {
		SwingMenuFx app = new SwingMenuFx();
		showSwingGUI(app);
	}

	private static void showSwingGUI(SwingMenuFx app) {
		app.mainFrame = new JFrame("Java SWING Examples");
		app.mainFrame.setSize(757, 499);
		// Adding MenuBar
		JMenuBar menubar = new JMenuBar();
		JMenu menu;
		JMenuItem swing, javaFx;
		menu = new JMenu("Menu");
		swing = new JMenuItem("Swing");
		javaFx = new JMenuItem("javaFx");
		
		//Adding Action Listeners to menu Items
		swing.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				app.fxpanel=new JFXPanel();
				app.createJFXPanel(app);
				app.mainFrame.getContentPane().removeAll();
				app.component=new JLabel("Swing Button Clicked");
				app.mainFrame.add(app.component);
				app.mainFrame.revalidate();
			}
		});
		javaFx.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				app.mainFrame.getContentPane().removeAll();
				app.mainFrame.add(app.fxpanel);
				app.component.setBounds(0,0,200,200);
				app.mainFrame.revalidate();
			}
		});
		
		menu.add(swing);
		menu.add(javaFx);
		menubar.add(menu);// Menu Bar Complete
		
		
		
		
		
		app.mainFrame.setJMenuBar(menubar);
		app.component = new JLabel("Error Loading");
		app.component.setBounds(50, 50, 200, 200);
		app.mainFrame.add(app.component);
		app.mainFrame.setVisible(true);
		app.mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	protected void createJFXPanel(SwingMenuFx app) {
		Platform.runLater(new Runnable() {
			
			@Override
			public void run() {
				app.createJFXUI(app);
				
			}
		
		
	});
	}

	protected void createJFXUI(SwingMenuFx app) {
		Scene scene = null ;
		
		
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(SwingMenuFx.class.getResource("../view/Root.fxml"));
			loader.setController(SwingMenuFx.this);
			BorderPane rootLayout = (BorderPane) loader.load();

			scene = new Scene(rootLayout);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		app.fxpanel.setScene(scene);
		app.component=fxpanel;
		System.out.println("FXpanel Created");
		
	}
	
	@FXML public void done() {
		JOptionPane.showMessageDialog(null, "Bacode value is "+Barcode.getText());
	}
	
	public void initialize() {
		//something that neeeds to be done after FXML Initialization
		System.out.println("FXML got initialized");
	}
	
}
