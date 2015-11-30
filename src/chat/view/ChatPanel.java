package chat.view;

import javax.swing.JLabel;
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
	private JLabel promptLable;

	public ChatPanel(ChatController baseController)
	{
		baseLayout = new SpringLayout();
		this.baseController = baseController;
		newButton = new JButton("Does Something");
		userResponceField = new JTextField(30);
		ChatbotTextArea = new JTextArea(10, 30);
		promptLable = new JLabel("Chat with my Chatbot");

		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void changeColor()
	{
		int red, blue, green;
		red = (int) (Math.random() * 256 );
		blue = (int) (Math.random() * 256);
		green = (int) (Math.random() * 256);
		
		this.setBackground(new Color(red, blue, green));
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.add(promptLable);
		this.add(newButton);
		this.add(userResponceField);
		this.add(ChatbotTextArea);
		userResponceField.setToolTipText("Type to talk to chatbot");
		ChatbotTextArea.setEnabled(false);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, newButton, 0,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, newButton, -10,
				SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, userResponceField, 29,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, userResponceField, -46,
				SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, ChatbotTextArea, 0,
				SpringLayout.WEST, promptLable);
		baseLayout.putConstraint(SpringLayout.SOUTH, ChatbotTextArea, -21,
				SpringLayout.NORTH, promptLable);
		baseLayout.putConstraint(SpringLayout.WEST, promptLable, 45,
				SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, promptLable, -5,
				SpringLayout.NORTH, userResponceField);

	}

	private void setupListeners()
	{
		newButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				changeColor();
			}
		});
	}

	public JTextArea getTextField()
	{
		return ChatbotTextArea;
	}

	public void setChatbotTextArea(JTextArea chatbotTextArea)
	{
		ChatbotTextArea = chatbotTextArea;
	}
}
