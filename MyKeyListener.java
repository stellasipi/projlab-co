package shokoban;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
	

	public class MyKeyListener implements KeyListener {
		private GameView gv;
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
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				}
				break;
				
			case KeyEvent.VK_A:
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.LEFT);
				}
				break;
				
			case KeyEvent.VK_S:
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				}
				break;
				
			case KeyEvent.VK_D:
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				}
				break;
				
			case KeyEvent.VK_Q:
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				s.PlaceHoney();
				}
				
				break;	
				
			case KeyEvent.VK_E:
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				s.PlaceOil();
				}
				break;
				
			case KeyEvent.VK_I:
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				}
				break;
				
			case KeyEvent.VK_J:
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.LEFT);
				}
				break;
				
			case KeyEvent.VK_K:
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				}
				break;
				
			case KeyEvent.VK_L:
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				}
				break;
				
			case KeyEvent.VK_U:
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				s.PlaceHoney();
				}
				break;	
				
			case KeyEvent.VK_P:
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				s.PlaceOil();
				}
				break;
				
			case KeyEvent.VK_UP:
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				}
				break;
				
			case KeyEvent.VK_LEFT:
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.LEFT);
				}
				break;
				
			case KeyEvent.VK_DOWN:
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				}
				break;
				
			case KeyEvent.VK_RIGHT:
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				}
				break;
				
			case KeyEvent.VK_NUMPAD0:
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				s.PlaceHoney();
				}
				break;	
				
			case KeyEvent.VK_NUMPAD1:
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				s.PlaceOil();
				}
				break;
				
			case KeyEvent.VK_NUMPAD8:
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				}
				break;
				
			case KeyEvent.VK_NUMPAD4:
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.LEFT);
				}
				break;
				
			case KeyEvent.VK_NUMPAD5:
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				}
				break;
				
			case KeyEvent.VK_NUMPAD6:
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				}
				break;
				
			case KeyEvent.VK_NUMPAD7:
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				s.PlaceHoney();
				}
				break;	
				
			case KeyEvent.VK_NUMPAD9:
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				s.PlaceOil();
				}
				break;
				
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;	
			}
			
			gv.revalidate();
			gv.repaint();
			gv.DrawAll();
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
//}