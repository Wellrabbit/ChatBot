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
 
}
