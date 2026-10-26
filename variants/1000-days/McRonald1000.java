//name: Mathias Brook
//date: 2/23/2024

import java.util.*;
public class McRonald1000
{
   public static final int TIME = 1440000;  //1000 days * 24 hrs * 60 min
   private static int total = 0;
   private static int waiting = 0;
   private static int longestQueue = 0;
   private static int longestWait = 0;
   private static int dayMax = 0;
   
   
   public static void main(String[] args)
   {
      
      Queue<Customer> list = new LinkedList<Customer>();
      int cookTime = 0;
      int day = 0;
      
      for (int i = 0; i <= TIME; i++){
                           
         int chance = (int)(Math.random()*5)+1;
         if (chance == 1) {
            list.add(new Customer(i));
            total++;
            day++;
         }
         
         if (cookTime == 0 && list.isEmpty() == false){
            cookTime = (int)(Math.random()*6)+2;
            int x = list.peek().getWait();
            waiting += x;
            if (x > longestWait)
               longestWait = x;
            list.poll();
         }
               
         if (cookTime > 0)
            cookTime--;
         
         for (Customer x: list)
            x.increment();
         
         if (day > dayMax)
            dayMax = day;
         if (i%1440 == 0)
            day = 0;
         
         count(list, i);
      
      }  
      
      System.out.println("Total customers served = " + total); 
      System.out.println("Average wait time = " + ((waiting*1.0)/total));
      System.out.println("Longest wait time = " + longestWait);
      System.out.println("Longest queue = " + longestQueue);
      System.out.println("Average served per day = " + ((total*1.0)/1000));
      System.out.println("Largest day = " + dayMax);
      
   }
   
   public static void count(Queue<Customer> q, int min){
      
      int num = 0;
      
      if (q.peek() != null)
         for (Customer x: q)
            num++;
      
      if (num > longestQueue)
         longestQueue = num;
            
   }
   
}

class Customer {
   private int clock = 0;
   private int wait = 0;
      
   public Customer(int t){
      clock = t;
   }
      
   public int getClock(){
      return clock;
   }
      
   public int getWait(){
      return wait;
   }
      
   public void increment(){
      wait++;
   }
   
}