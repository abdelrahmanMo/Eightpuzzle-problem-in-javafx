
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uherbert;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author abdelrahmanOsman
 */
public class Node implements Comparable<Node> {

   public ArrayList<Node> neighbors=new ArrayList();
   public Node parent;
   public String steps;
   public  int[][] Gride=new int[25][25];
   public int x;
   public int y;
   public int cost;
   public Node(int[][]Grid)
   {
       for(int i=0 ;i<Gride.length;i++)
       {
           for(int j=0;j<Gride.length;j++)
           {
               Gride[i][j]= Grid[i][j];
           }
           
       }
   }
   public boolean GoalTest()
   {
    boolean Isgoal=true;
   for(int i=0 ;i<Gride.length;i++)
       {
           for(int j=0;j<Gride.length;j++)
           {
              if(Gride[i][j]==1)
              {
                  Isgoal=false;
                  return Isgoal;
              }
           }
           
       }
   return Isgoal;
    }
    public boolean subGoal()
   {
    boolean Subgoal=true;
   for(int i=0 ;i<Gride.length;i++)
       {
           for(int j=0;j<Gride.length;j++)
           {
              if(Gride[i][j]==3||Gride[i][j]==4||Gride[i][j]==5||Gride[i][j]==2)
              {
                  if(i==Heristic.choosex&&j==Heristic.choosey)
                  {
                      Subgoal=false;
                      return Subgoal;
                  }
              }
           }
           
       }
   return Subgoal;
    }
    
      public void copyArray(int[][]G,int[][]Grid)
   {
       for(int i=0;i<G.length;i++)
       {
           for(int j=0;j<G.length;j++)
           Grid[i][j]=G[i][j];
       }
   }
        public void moveright(int[][]p,int x,int y)
      {
         String step = null;
          int[][]pc= new int[25][25];
          copyArray(p, pc);
          if(p[x][y]==3)
          {
              if(y<24 && pc[x][y+1] != -1 && pc[x][y+1]!=8)
              {
                  if(p[x][y+1]==1)
                  {
                     pc[x][y+1]=0;
                  }
                  int temp=5;
                     pc[x][y]=pc[x][y+1];
                     pc[x][y+1]=temp;
              }
             
              step="rrs";
          }
          else if(p[x][y]==4)
          {
              if(y<24 && pc[x][y+1] != -1 && pc[x][y+1]!=8)
              {
                  if(p[x][y+1]==1)
                  {
                     pc[x][y+1]=0;
                  }
                  int temp=5;
                     pc[x][y]=pc[x][y+1];
                     pc[x][y+1]=temp;
              }
             
              step="rs";
          }
          else if(p[x][y]==5)
          {
              if(y<24 && pc[x][y+1] != -1 && pc[x][y+1]!=8)
              {
                  if(p[x][y+1]==1)
                  {
                     pc[x][y+1]=0;
                  }
                  int temp=pc[x][y];
                     pc[x][y]=pc[x][y+1];
                     pc[x][y+1]=temp;
              }
             
              step="s";
          }
          else if(p[x][y]==2)
          {
             if(y<24 && pc[x][y+1] != -1 && pc[x][y+1]!=8)
              {
                  if(p[x][y+1]==1)
                  {
                     pc[x][y+1]=0;
                  }
                  int temp=5;
                     pc[x][y]=pc[x][y+1];
                     pc[x][y+1]=temp;
              }
             
              step="ls";
          }
          Node newnode=new Node(pc);
           neighbors.add(newnode);
           newnode.parent=this;
           newnode.steps=step;
          
      }
        public void movedown(int[][]p,int x,int y)
      {
         String step = null;
          int[][]pc= new int[25][25];
          copyArray(p, pc);
          if(p[x][y]==3)
          {
              if(x<24 && pc[x+1][y]!=-1&&pc[x+1][y]!=8)
              {
                  if(p[x+1][y]==1)
                  {
                     pc[x+1][y]=0;
                    
                  }
                  int temp=2;
                     pc[x][y]=pc[x+1][y];
                     pc[x+1][y]=temp;
              }
              step="ls";
          }
          else if(p[x][y]==4)
          {
              if(x<24 && pc[x+1][y]!=-1&&pc[x+1][y]!=8)
              {
                  if(p[x+1][y]==1)
                  {
                     pc[x+1][y]=0;
                    
                  }
                  int temp=2;
                     pc[x][y]=pc[x+1][y];
                     pc[x+1][y]=temp;
              }
              step="rrs";
          }
          else if(p[x][y]==5)
          {
              if(x<24 && pc[x+1][y]!=-1&&pc[x+1][y]!=8)
              {
                  if(p[x+1][y]==1)
                  {
                     pc[x+1][y]=0;
                    
                  }
                  int temp=2;
                     pc[x][y]=pc[x+1][y];
                     pc[x+1][y]=temp;
              }
              step="rs";
          }
          else if(p[x][y]==2)
          {
            if(x<24 && pc[x+1][y]!=-1&&pc[x+1][y]!=8)
              {
                  if(p[x+1][y]==1)
                  {
                     pc[x+1][y]=0;
                    
                  }
                  int temp=pc[x][y];
                     pc[x][y]=pc[x+1][y];
                     pc[x+1][y]=temp;
              }
              step="s";
          }
          Node newnode=new Node(pc);
           neighbors.add(newnode);
           newnode.parent=this;
           newnode.steps=step;
          
      }
        public void moveup(int[][]p,int x,int y)
      {
         String step = null;
          int[][]pc= new int[25][25];
          copyArray(p, pc);
          if(p[x][y]==3)
          {
              //باصص لفوق
            if(x>0 && pc[x-1][y]!=-1 && pc[x-1][y]!=8)
              {
                  if(pc[x-1][y]==1)
                  {
                     pc[x-1][y]=0;
                  
                  }
                    int temp=4;
                     pc[x][y]=pc[x-1][y];
                     pc[x-1][y]=temp;
              }
             // pc[x][y]=4; 
              step="rs";
          }
          else if(p[x][y]==4)
          {
              if(x>0 && pc[x-1][y]!=-1 && pc[x-1][y]!=8)
              {
                  if(pc[x-1][y]==1)
                  {
                     pc[x-1][y]=0;
                  
                  }
                    int temp=pc[x][y];
                     pc[x][y]=pc[x-1][y];
                     pc[x-1][y]=temp;
              }
              step="s";
          }
          else if(p[x][y]==5)
          {
              if(x>0 && pc[x-1][y]!=-1 && pc[x-1][y]!=8)
              {
                  if(pc[x-1][y]==1)
                  {
                     pc[x-1][y]=0;
                  
                  }
                    int temp=4;
                     pc[x][y]=pc[x-1][y];
                     pc[x-1][y]=temp;
              }
              step="ls";
          }
          else if(p[x][y]==2)
          {
             if(x>0 && pc[x-1][y]!=-1 && pc[x-1][y]!=8)
              {
                  if(pc[x-1][y]==1)
                  {
                     pc[x-1][y]=0;
                  
                  }
                    int temp=4;
                     pc[x][y]=pc[x-1][y];
                     pc[x-1][y]=temp;
              }
              step="rrs";
          }
          Node newnode=new Node(pc);
           neighbors.add(newnode);
           newnode.parent=this;
           newnode.steps=step;
          
      }
      public void moveleft(int[][]p,int x,int y)
      {
         String step = null;
          int[][]pc= new int[25][25];
          copyArray(p, pc);
          if(p[x][y]==3)
          {
              //باصص لفوق
              if(y>0&& pc[x][y-1]!=-1&&pc[x][y-1]!=8)
              {
                  if(pc[x][y-1]==1)
                  {
                     pc[x][y-1]=0;
                    
                  }
                  int temp=pc[x][y];
                     pc[x][y]=pc[x][y-1];
                     pc[x][y-1]=temp;
              }
             
              step="s";
          }
          else if(p[x][y]==4)
          {
              //باصص لليمين
            if(y>0&& pc[x][y-1]!=-1&&pc[x][y-1]!=8)
              {
                  if(pc[x][y-1]==1)
                  {
                     pc[x][y-1]=0;
                    
                  }
                  int temp=3;
                     pc[x][y]=pc[x][y-1];
                     pc[x][y-1]=temp;
              }
             
              step="ls";
          }
          else if(p[x][y]==5)
          {
              if(y>0&& pc[x][y-1]!=-1&&pc[x][y-1]!=8)
              {
                  if(pc[x][y-1]==1)
                  {
                     pc[x][y-1]=0;
                    
                  }
                  int temp=3;
                     pc[x][y]=pc[x][y-1];
                     pc[x][y-1]=temp;
              }
             
              step="rrs";
          }
          else if(p[x][y]==2)
          {
              if(y>0&& pc[x][y-1]!=-1&&pc[x][y-1]!=8)
              {
                  if(pc[x][y-1]==1)
                  {
                     pc[x][y-1]=0;
                    
                  }
                  int temp=3;
                     pc[x][y]=pc[x][y-1];
                     pc[x][y-1]=temp;
              }
             
              step="rs";
          }
          Node newnode=new Node(pc);
           neighbors.add(newnode);
           newnode.parent=this;
           newnode.steps=step;
          
      }

     /*
      public void turnRight(int[][]p,int x,int y)
      {
         
          int[][]pc= new int[25][25];
          copyArray(p, pc);
          if(p[x][y]==3)
          {
              //باصص لفوق
              pc[x][y]=4;
          }
          else if(p[x][y]==4)
          {
              //باصص لليمين
              pc[x][y]=5;
          }
          else if(p[x][y]==5)
          {
              //باصص لتحت
              pc[x][y]=2;
          }
          else if(p[x][y]==2)
          {
             //باصص للشمال
              pc[x][y]=3;
          }
          Node newnode=new Node(pc);
           neighbors.add(newnode);
           newnode.parent=this;
           newnode.steps="r";
          
      }
      public void turnLeft(int[][]p,int x,int y)
      {
          int[][]pc= new int[25][25];
          copyArray(p, pc);
          if(p[x][y]==4)
          {
              pc[x][y]=3;
          }
          else if(p[x][y]==3)
          {
             
              pc[x][y]=2;
          }
          else if(p[x][y]==2)   
          {
             
              pc[x][y]=5;
          }
          else if(p[x][y]==5)
          {
             
              pc[x][y]=4;
          }
          Node newnode=new Node(pc);
           neighbors.add(newnode);
           newnode.parent=this;
           newnode.steps="l";
          
      }
      
       public void move(int[][]p,int x,int y)
      {
          int[][]pc= new int[25][25];
          copyArray(p, pc);
          if(pc[x][y]==4)
          {
              if(x>0 && pc[x-1][y]!=-1 && pc[x-1][y]!=8)
              {
                  if(pc[x-1][y]==1)
                  {
                     pc[x-1][y]=0;
                  
                  }
                    int temp=pc[x][y];
                     pc[x][y]=pc[x-1][y];
                     pc[x-1][y]=temp;
              }
          }
          else if(pc[x][y]==3)
          {
             if(y>0&& pc[x][y-1]!=-1&&pc[x][y-1]!=8)
              {
                  if(pc[x][y-1]==1)
                  {
                     pc[x][y-1]=0;
                    
                  }
                  int temp=pc[x][y];
                     pc[x][y]=pc[x][y-1];
                     pc[x][y-1]=temp;
              }
              
          }
          else if(pc[x][y]==2)   
          {
             if(x<24 && pc[x+1][y]!=-1&&pc[x+1][y]!=8)
              {
                  if(p[x+1][y]==1)
                  {
                     pc[x+1][y]=0;
                    
                  }
                  int temp=pc[x][y];
                     pc[x][y]=pc[x+1][y];
                     pc[x+1][y]=temp;
              }
          }
          else if(pc[x][y]==5)
          {
              if(y<24 && pc[x][y+1]!=-1 && pc[x][y+1]!=8)
              {
                  if(p[x][y+1]==1)
                  {
                     pc[x][y+1]=0;
                    
                  }
                  int temp=pc[x][y];
                     pc[x][y]=pc[x][y+1];
                     pc[x][y+1]=temp;
              }
             
              }
          Node newnode=new Node(pc);
           neighbors.add(newnode);
           newnode.parent=this;
           newnode.steps="s";
         //  newnode.calculateCost();
          
      }
   */
   public void expandMove()
   {
       for(int i=0;i<Gride.length;i++)
       {
           for(int j=0;j<Gride.length;j++)
           {
               if(Gride[i][j]==3||Gride[i][j]==4||Gride[i][j]==5||Gride[i][j]==2)
           {
                x=i;
                y=j;
           }
           }
       }
       
        
       moveright(Gride, x, y);
       moveleft(Gride, x, y);
       moveup(Gride, x, y);
         movedown(Gride, x, y);
        
        
     //  move(Gride, x, y);
       //turnLeft(Gride, x, y);
       //turnRight(Gride, x, y);
       
        
       
      
   }
   public boolean IsSame(int[][]p)
   {
        boolean issame=true;
       for(int i=0;i<Gride.length;i++)
       {
           for(int j=0;j<Gride.length;j++)
           {
          if(Gride[i][j]!=p[i][j])
          {
              issame=false;
              return issame;
          }
           }
       }
       return issame;
   }
   public boolean print()
   {
      // System.out.println(Gride.length);
       for(int i=0;i<Gride.length;i++)
       {
           for(int j=0;j<Gride.length;j++)
           {
               System.out.print(Gride[i][j]+" ");
              
           }
           System.out.println("");
       }
       System.out.println("");
       return true;
   }

    
   
   
  
    @Override
    public int compareTo(Node o) {
       if(this.cost > o.cost){
			return 1;
		}else if(this.cost < o.cost){
			return -1;
		}
		return 0;
    }
   
   public void calculateCost()
   {
       int su=0;
       for(int i=0;i<Gride.length;i++)
           for(int j=0;j<Gride.length;j++)
           {
               if(Gride[i][j]==3||Gride[i][j]==4||Gride[i][j]==5||Gride[i][j]==2)
               {
  
                   int ddx=Heristic.choosex-i;
                   int ddy=Heristic.choosey-j;
                    su=Math.abs(ddx)+Math.abs(ddy);
                  break;
               }
           }
       this.cost=su+this.steps.length();
   }
   
   public void farray()
   {
       int sum=0;
     int min=5000;
       int[] w=new int[2];
       int [] position=new int[2];
     List<int[]> myList = new ArrayList<int[]>();
     // myList.clear();
          for(int i=0 ;i<Gride.length;i++)
       {
           for(int j=0;j<Gride.length;j++)
           {
              if(Gride[i][j]==1)
              {
                  System.out.println("x: "+i+" , y: "+j);
                  w[0]=i;
                  w[1]=j;
                 myList.add(w);
              }
              if(Gride[i][j]==3||Gride[i][j]==4||Gride[i][j]==5||Gride[i][j]==2)
              {
                   position[0]=i;
                   position[1]=j;
              }
           }
           
       }
          //System.err.println(myList.size());
          for(int i=0;i<myList.size();i++)
          {
              
              
             int xdis= myList.get(i)[0]-position[0];
              int ydis= myList.get(i)[1]-position[1];
               sum=Math.abs(xdis)+Math.abs(ydis);
              //System.out.println(sum);
              System.out.println("robot pos x: "+position[0]);
              System.out.println("robot pos y: "+position[1]);
              System.out.println(myList.get(i)[0]);
              System.out.println(myList.get(i)[1]);
              if(sum < min)
              {
                  min=sum;
                 Heristic.choosex=myList.get(i)[0];
                  Heristic.choosey=myList.get(i)[1];
              }
          }
   }
   
   
  
}
