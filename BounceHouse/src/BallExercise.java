import javax.swing.*;
import java.awt.*;
import static java.awt.Color.*;
import static java.lang.System.*;

public class BallExercise
{
    private static class BallFrame extends JFrame implements Runnable
    {
        boolean initial = true;
        int pos = 0;

        @Override
        /* write run() method that will switch stopflag and loop and keep 
        calling repaint() while the ball is not stopped and the ball is 
          on the frame (the ball width less than the right side). 
         When done, end the ball thread. */
        public void run()
        {
            setSize(600, 300);//width, height
            setLocation(500, 100);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
        	boolean bwidth = (pos <= 600);//bwidth exists while ball is on frame
            while (pos <= 600)//ball is on the frame
            {
                try
                {
                    repaint();
                    Thread.sleep(3);
                }
                catch (InterruptedException e)
                {
                    break;
                }
            }
            exit(0);
        }

        // write update method to not clear frame and call paint()
public void update() {
	//
}

       /* write end() method that will switch stopflag and 
          draw final ball */ 
        @Override
        public void paint(Graphics g)      /* write paint() method to cover old ball, move x across the
        screen, draw new ball, and go to sleep */
        {
            if (initial)
            {
                initial = false;
                g.setColor(white);
                g.fillOval(pos++, 100, 20,20);
                g.setColor(red);
                g.fillOval(pos, 200, 20,20);//red ball
            }
            else
            {
                g.setColor(white);
                g.fillOval(pos++, 100, 20,20);
                g.setColor(blue);
                g.fillOval(pos, 100, 20,20);
            }

        }
    }

    private static class FrameTwo extends JFrame implements Runnable
    {
        @Override
        public void run()
        {
            setSize(220, 180);
            setLocation(500, 500);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            JButton button = new JButton("Click to stop");
            button.addActionListener(e -> exit(0));
            getContentPane().add(new JPanel().add(button).getParent());
            setVisible(true);
        }
    }
    public static void main(String[] args)
    {
        new Thread(new BallFrame()).start();
        new Thread(new FrameTwo()).start();
    }
}



