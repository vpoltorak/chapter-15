import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Iterator;
/**
   Class for simulating a runway.
*/
public class RunwaySimulator
{
   Queue<String> takeoff;
   Queue<String> landing;

   /**
      Constructor.
   */
   public RunwaySimulator()
   {
      takeoff = new LinkedList<String>();
      landing = new LinkedList<String>();
   }

   /**
      display the queues
   */
   public void display()
   {
      System.out.println("take-off queue:" + takeoff);
      System.out.println("landing queue:" + landing);
   }
   
   /**
      Add a flight symbol to the taking off queue.
      @param flightSymbol the flight symbol.
   */
   public void addTakeOff(String flightSymbol)
   {
      takeoff.add(flightSymbol);
      display();
   }

   /**
      Add a flight symbol to the landing queue.
      @param flightSymbol the flight symbol.
   */
   public void addLanding(String flightSymbol)
   {
      landing.add(flightSymbol);
      display();
   }

   /**
      Handle the next action.
   */
   public void handleNextAction()
   {
      if (landing.size() > 0)
           System.out.println(landing.poll() + " has landed");
      else if (landing.size() <= 0 && takeoff.size() > 0)
           System.out.println(takeoff.poll() + " has taken off");
      else if (landing.size() <= 0 && takeoff.size() <= 0)
           System.out.println("No planes in take-off or landing queue");
      display();
   }
}
