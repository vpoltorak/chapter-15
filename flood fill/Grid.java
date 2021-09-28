import java.util.*;
public class Grid
{
    private int[][] grid;
    private Stack<ArrayList> stack;
    private ArrayList<Integer> pair, temp_pair;
    private ArrayList< ArrayList<Integer> > donepairs;
    
    /**
     * Constructor for objects of class Grid
     */
    public Grid()
    {
        grid = new int[10][10];
        stack = new Stack<ArrayList>();
        pair = new ArrayList<Integer>();
    }
    
    public void floodfill(int x, int y)
    {
        //initial
        pair.add(x);
        pair.add(y);
        stack.push(pair);
        int count = 1;
        donepairs = new ArrayList< ArrayList<Integer> >();
        while (stack.size() > 0) 
        {
            pair = stack.pop();
            grid[pair.get(0)][pair.get(1)] = count; //fills the point on the 2d array
            if (donepairs.contains(pair) == false)
                    donepairs.add(pair);
                 
            if (pair.get(0) - 1 >= 0) //moving up
            {
                temp_pair = new ArrayList<Integer>(); temp_pair.add(0); temp_pair.add(0);
                temp_pair.set(0, pair.get(0) - 1);
                temp_pair.set(1, pair.get(1));
                 if (donepairs.contains(temp_pair) == false)
                    {
                        grid[temp_pair.get(0)][temp_pair.get(1)] = (count + 1);
                        donepairs.add(temp_pair);
                        stack.add(temp_pair);
                    }
            }
            if (pair.get(0) + 1 <= 9) //moving down
            {
                temp_pair = new ArrayList<Integer>(); temp_pair.add(0); temp_pair.add(0);
                temp_pair.set(0, pair.get(0) + 1);
                temp_pair.set(1, pair.get(1));
                if (donepairs.contains(temp_pair) == false)
                    {
                        grid[temp_pair.get(0)][temp_pair.get(1)] = count+1;
                        donepairs.add(temp_pair);
                        stack.add(temp_pair);
                    }
            }
            if (pair.get(1) - 1 >= 0) //moving left
            {
                temp_pair = new ArrayList<Integer>(); temp_pair.add(0); temp_pair.add(0);
                temp_pair.set(0, pair.get(0));
                temp_pair.set(1, pair.get(1) - 1);
                if (donepairs.contains(temp_pair) == false)
                    {
                        grid[temp_pair.get(0)][temp_pair.get(1)] = count+1;
                        donepairs.add(temp_pair);
                        stack.add(temp_pair);
                    }
            }
            if (pair.get(1) + 1 <= 9) //moving right
            {
                temp_pair = new ArrayList<Integer>(); temp_pair.add(0); temp_pair.add(0);
                temp_pair.set(0, pair.get(0));
                temp_pair.set(1, pair.get(1) + 1);
                if (donepairs.contains(temp_pair) == false)
                    {
                        grid[temp_pair.get(0)][temp_pair.get(1)] = count+1;
                        donepairs.add(temp_pair);
                        stack.add(temp_pair);
                    }
            }
            count += 1;
        }
    }

    public String toString()
    {
        String printgrid = "";
        for (int[] x : grid)
        {
            for (int y : x)
                printgrid += (y + " ");
            printgrid += "\n";
        }
        return printgrid;
    }
}
