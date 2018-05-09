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
				System.out.println(key);
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				System.out.println("w1"+"UP");
				}
				gv.getGame();
				break;
				
			case KeyEvent.VK_A:
				System.out.println(key);
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.LEFT);
				System.out.println("w1"+"LEFT");
				}
				break;
				
			case KeyEvent.VK_S:
				System.out.println(key);
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				System.out.println("w1"+"DOWN");
				}
				break;
				
			case KeyEvent.VK_D:
				System.out.println(key);
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				System.out.println("w1"+"RIGHT");
				}
				break;
				
			case KeyEvent.VK_Q:
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				s.PlaceHoney();
				System.out.println("Honey w1");
				}
				
				break;	
				
			case KeyEvent.VK_E:
				s=gv.getGame().getWorker("w1");
				if(s!=null) 
				{
				s.PlaceOil();
				System.out.println("Oil w1");
				}
				break;
				
			case KeyEvent.VK_I:
				System.out.println(key);
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				System.out.println("w2"+"UP");
				}
				break;
				
			case KeyEvent.VK_J:
				System.out.println(key);
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.LEFT);
				System.out.println("w2"+"LEFT");
				}
				break;
				
			case KeyEvent.VK_K:
				System.out.println(key);
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				System.out.println("w2"+"DOWN");
				}
				break;
				
			case KeyEvent.VK_L:
				System.out.println(key);
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				System.out.println("w2"+"RIGHT");
				}
				break;
				
			case KeyEvent.VK_U:
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				s.PlaceHoney();
				System.out.println("Honey w2");
				}
				break;	
				
			case KeyEvent.VK_P:
				s=gv.getGame().getWorker("w2");
				if(s!=null) 
				{
				s.PlaceOil();
				System.out.println("Oil w2");
				}
				break;
				
			case KeyEvent.VK_UP:
				System.out.println(key);
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				System.out.println("w4"+"UP");
				}
				break;
				
			case KeyEvent.VK_LEFT:
				System.out.println(key);
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.LEFT);
				System.out.println("w4"+"LEFT");
				}
				break;
				
			case KeyEvent.VK_DOWN:
				System.out.println(key);
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				System.out.println("w4"+"DOWN");
				}
				break;
				
			case KeyEvent.VK_RIGHT:
				System.out.println(key);
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				System.out.println("w4"+"RIGHT");
				}
				break;
				
			case KeyEvent.VK_NUMPAD0:
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				s.PlaceHoney();
				System.out.println("Honey w4");
				}
				break;	
				
			case KeyEvent.VK_NUMPAD1:
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				s.PlaceOil();
				System.out.println("Oil w4");
				}
				break;
				
			case KeyEvent.VK_NUMPAD8:
				System.out.println(key);
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				System.out.println(s+"UP");
				}
				break;
				
			case KeyEvent.VK_NUMPAD4:
				System.out.println(key);
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.LEFT);
				System.out.println("w3"+"LEFT");
				}
				break;
				
			case KeyEvent.VK_NUMPAD5:
				System.out.println(key);
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				System.out.println("w3"+"DOWN");
				}
				break;
				
			case KeyEvent.VK_NUMPAD6:
				System.out.println(key);
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				System.out.println("w3"+"RIGHT");
				}
				break;
				
			case KeyEvent.VK_NUMPAD7:
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				s.PlaceHoney();
				System.out.println("Honey w3");
				}
				break;	
				
			case KeyEvent.VK_NUMPAD9:
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				s.PlaceOil();
				System.out.println("Oil w3");
				}
				break;
				
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;	
			}
			gv.revalidate();
			gv.repaint();
			gv.DrawAll2();
			//Invalidate
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
//}