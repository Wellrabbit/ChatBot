package chat.view;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private JButton newButton;
	private JTextField userResponceField;
	private JTextArea ChatbotTextArea;
	private SpringLayout baseLayout;
	
	public ChatPanel(ChatController baseController)
	{
		this.baseController = baseController;
		newButton = new JButton("Does Something");
		userResponceField = new JTextField ("This is where you type to the chatbot");
		ChatbotTextArea = new JTextArea ("Chatbot responds here");
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(newButton);
		this.add(userResponceField);
		this.add(ChatbotTextArea);
	}
	private void setupLayout()
	{
		
	}
	private void setupListeners()
	{
		newButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
			
			}
		});
	}
}
