package chat.view;
import javax.swing.JFrame;
import chat.controller.ChatController;
import javax.swing.JPanel;

public class ChatFrame extends JFrame
{
 private ChatController baseController;
 private ChatPanel basePanel;
 public ChatFrame(ChatController baseController)
 {
	 this.baseController = baseController;
	 basePanel = new ChatPanel(baseController);
	 setFrame();
 }

/**
 * Sets the frame to visble and sets size also makes it able resize.
 */
private void setFrame()
{
	 this.setContentPane(basePanel);
	 this.setTitle("Chat Bot");
	 this.setResizable(false);
	 this.setSize(600,600);
	 this.setVisible(true);
	
}
 public ChatController getBaseController()
 {
	 return baseController;
 }
 
}
