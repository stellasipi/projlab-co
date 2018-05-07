package shokoban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
	

	public class MyKeyListener implements KeyListener {
		private GameView gv;
		private final HashSet<Integer> pressed = new HashSet<Integer>();
		private MyKeyListener(GameView gameview)
		{
			gv=gameview;
		}
		
		
		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			/*if(key==e.VK_SPACE) {
				pressed.add(e.getKeyCode());
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			}
			else if(key==e.VK_RIGHT) {
				pressed.add(e.getKeyCode());
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			}
			else if(key==e.VK_LEFT) {*/
			switch(key)
			{
			case KeyEvent.VK_W:
				break;
				
			case KeyEvent.VK_A:
				break;
				
			case KeyEvent.VK_S:
				break;
				
			case KeyEvent.VK_D:
				break;
				
			case KeyEvent.VK_Q:
				break;	
				
			case KeyEvent.VK_E:
				break;
				
			case KeyEvent.VK_I:
				break;
				
			case KeyEvent.VK_J:
				break;
				
			case KeyEvent.VK_K:
				break;
				
			case KeyEvent.VK_L:
				break;
				
			case KeyEvent.VK_U:
				break;	
				
			case KeyEvent.VK_P:
				break;
				
			case KeyEvent.VK_UP:
				break;
				
			case KeyEvent.VK_LEFT:
				break;
				
			case KeyEvent.VK_RIGHT:
				break;
				
			case KeyEvent.VK_DOWN:
				break;
				
			case KeyEvent.VK_0:
				break;	
				
			case KeyEvent.VK_1:
				break;
				
			case KeyEvent.VK_8:
				break;
				
			case KeyEvent.VK_4:
				break;
				
			case KeyEvent.VK_5:
				break;
				
			case KeyEvent.VK_6:
				break;
				
			case KeyEvent.VK_7:
				break;	
				
			case KeyEvent.VK_9:
				break;
			}
			
				pressed.add(e.getKeyCode());
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			//}
			

		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
//}