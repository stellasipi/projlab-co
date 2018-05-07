package shokoban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import javax.swing.*;




@SuppressWarnings("serial")
/* public class MyKeyListener extends JPanel {
	
	public MyKeyListener() {
		KeyListener listener = new My();
		addKeyListener(listener);
		setFocusable(true);
	}*/
	
	

	public class MyKeyListener implements KeyListener {
		
		private final HashSet<Integer> pressed = new HashSet<Integer>();
		
		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		public void keyPressed(KeyEvent e) {
			/*int key = e.getKeyCode();
			if(key==e.VK_SPACE) {
				pressed.add(e.getKeyCode());
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			}
			else if(key==e.VK_RIGHT) {
				pressed.add(e.getKeyCode());
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			}
			else if(key==e.VK_LEFT) {*/
				pressed.add(e.getKeyCode());
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			//}
			

		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
//}