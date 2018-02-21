/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uherbert;

import java.util.ArrayList;

/**
 *
 * @author hagarmohamad75
 */
public class UHerbert {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        String path="";
        int count=0;
      ReadFile RF=new ReadFile();
      String FilePath="C:\\Users\\abdelrahmanOsman\\Desktop\\level_pack4\\level200.txt";
      RF.ConvertFile(FilePath);
      RF.MakeGrid2D();
       RF.PrintGrid();
      long startTime = System.currentTimeMillis();   
        //System.out.println(ReadFile.Gridcc.length);
        Node root =new Node(ReadFile.Gridcc);
      //   BreadthFirst ui=new BreadthFirst();
         Heristic ui=new Heristic();
      // DepthFirst ui=new DepthFirst();
     //  Heristic ui=new Heristic();
      //  ArrayList<Node> solution =ui.BDF(root);
       // ArrayList<Node> solution =ui.DFs(root);
       ArrayList<Node> solution =ui.AHeri(root);
        
        System.out.println(solution.size());
        long endTime   = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("total time " + totalTime);
        if(solution.size()> 0)
        {
            System.out.println();
            for(int i=solution.size()-1; i>=0 ;i--)
            {
                if(solution.get(i).steps!=null)
                {
                System.out.print(solution.get(i).steps);
                 path=path+solution.get(i).steps;
                }
               // solution.get(i).print();
              
                
            }
            System.out.println();
        }
        else
        {
            //System.err.println("NO solution");
            System.err.println("NO solution");
        }
        /*System.err.println(path);
            String newpath=path.replaceAll("ssss", "x");
              System.out.println(newpath.length());
        System.out.println(newpath);*/
    }
    
}
