package shokoban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
	

	public class MyKeyListener implements KeyListener {
		private GameView gv;
		private final HashSet<Integer> pressed = new HashSet<Integer>();
		MyKeyListener(GameView gameview)
		{
			gv=gameview;
		}
		
		
		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			Worker s;
			switch(key)
			{
			case KeyEvent.VK_W:
				System.out.println(key);
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				}
				break;
				
			case KeyEvent.VK_A:
				System.out.println(key);
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.LEFT);
				}
				break;
				
			case KeyEvent.VK_S:
				System.out.println(key);
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				}
				break;
				
			case KeyEvent.VK_D:
				System.out.println(key);
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				}
				break;
				
			case KeyEvent.VK_Q:
				break;	
				
			case KeyEvent.VK_E:
				break;
				
			case KeyEvent.VK_I:
				System.out.println(key);
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				}
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
			//Invalidate
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
//}