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
				break;	
				
			case KeyEvent.VK_E:
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
				break;	
				
			case KeyEvent.VK_P:
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
				
			case KeyEvent.VK_RIGHT:
				System.out.println(key);
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				System.out.println("w4"+"DOWN");
				}
				break;
				
			case KeyEvent.VK_DOWN:
				System.out.println(key);
				s=gv.getGame().getWorker("w4");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				System.out.println("w4"+"RIGHT");
				}
				break;
				
			case KeyEvent.VK_0:
				break;	
				
			case KeyEvent.VK_1:
				break;
				
			case KeyEvent.VK_8:
				System.out.println(key);
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.UP);
				System.out.println(s+"UP");
				}
				break;
				
			case KeyEvent.VK_4:
				System.out.println(key);
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.LEFT);
				System.out.println("w3"+"LEFT");
				}
				break;
				
			case KeyEvent.VK_5:
				System.out.println(key);
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.DOWN);
				System.out.println("w3"+"DOWN");
				}
				break;
				
			case KeyEvent.VK_6:
				System.out.println(key);
				s=gv.getGame().getWorker("w3");
				if(s!=null) 
				{
				gv.getGame().Move(s, Direction.RIGHT);
				System.out.println("w3"+"RIGHT");
				}
				break;
				
			case KeyEvent.VK_7:
				break;	
				
			case KeyEvent.VK_9:
				break;
				
			case KeyEvent.VK_ESCAPE:
				System.exit(0);
				break;	
			}
			//Invalidate
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}
//}