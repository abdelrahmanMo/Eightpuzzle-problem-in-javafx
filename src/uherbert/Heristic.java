/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uherbert;

import static java.lang.Math.E;
import static java.lang.StrictMath.E;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.PriorityQueue;
import static jdk.nashorn.internal.objects.NativeMath.E;

/**
 *
 * @author abdelrahmanOsman
 */
public class Heristic {
       public static int  choosex=-1;
         public static int choosey=-1;
         public int cou=1;
     public ArrayList<Node> AHeri(Node root)
   {
       //ArrayList<Node> frontier=new ArrayList();
       ArrayList<Node> explored=new ArrayList();
       ArrayList<Node> pathFounder=new ArrayList();
      PriorityQueue<Node> frontier =
                          new PriorityQueue<Node>();
       frontier.add(root);
       
       boolean Goalfound = false;
       System.err.println("searching.....");
       while (frontier.size()>0 && Goalfound==false) {
          
           Node state=frontier.remove();
           explored.add(state);
           if(cou==1)
           {
               state.farray();
               cou++;
           }
           state.expandMove();
           //state.print();
           
           //state.print();
           for(int i=0;i<state.neighbors.size();i++)
           {
               Node currentneighbours= state.neighbors.get(i);
              
               if(currentneighbours.GoalTest())
               {
                   System.out.println("Goal found...");
                   Goalfound=true;
                   findpath(pathFounder,currentneighbours);
               }
                if(!currentneighbours.subGoal())
               {
                   System.out.println("xxxxxxxxxxxxxx");
                   currentneighbours.farray();
                   frontier.clear();
               }
               if(!contain(explored, currentneighbours) && !contain2(frontier, currentneighbours))
               {
                   currentneighbours.calculateCost();
                   frontier.add(currentneighbours);
                   //System.out.println("cost is:  "+frontier.element().cost);
               }
           }
           
           
       }
       return pathFounder;
   }
   public void findpath( ArrayList<Node> path,Node c)
   {
       System.out.println("trace the path...");
       Node current =c;
       path.add(current);
       while(current.parent!=null)
       {
           current=current.parent;
           path.add(current);
           
           
       }
   }
   
   public boolean contain(ArrayList<Node> list,Node c)
   {
       boolean contains=false;
       for(int i=0;i<list.size();i++)
       {
           if(list.get(i).IsSame(c.Gride))
           {
               contains=true;
               
           }
           
       }
       return contains;
   }
    public boolean contain2(PriorityQueue<Node> list,Node c)
   {
         boolean contains=false;
       Iterator<Node> iter = list.iterator();
        while (iter.hasNext()) {
           Node current = iter.next();
 
            if(current.IsSame(c.Gride))
           {
               contains=true;
               
           }
        }
   
       return contains;
   }
    
}
