//name: Mathias Brook
//date: 2/22/24

import java.util.*;
public class McRonald3
{
   public static final int TIME = 1080;  //18 hrs * 60 min
   private static int total = 0;
   private static int waiting = 0;
   private static int longestQueue = 0;
   private static int longestWait = 0;
   
   public static void main(String[] args)
   {
      
      Queue<Customer> list = new LinkedList<Customer>();
      int cookTime1 = 0;
      int cookTime2 = 0;
      int cookTime3 = 0;
      
      for (int i = 0; i <= TIME; i++) {             
         int chance = (int)(Math.random()*2)+1;
         if (chance == 1) {
            list.add(new Customer(i));
            total++;
         }
                  
         if (cookTime1 == 0 && list.isEmpty() == false) {
            cookTime1 = (int)(Math.random()*6)+2;
            int x = list.peek().getWait();
            waiting += x;
            if (x > longestWait)
               longestWait = x;
            list.poll();
         }
                 
         if (cookTime2 == 0 && list.isEmpty() == false){
            cookTime2 = (int)(Math.random()*6)+2;
            int x = list.peek().getWait();
            waiting += x;
            if (x > longestWait) longestWait = x;
            list.poll();
         }
         
         if (cookTime3 == 0 && list.isEmpty() == false) {
            cookTime3 = (int)(Math.random()*6)+2;
            int x = list.peek().getWait();
            waiting += x;
            if (x > longestWait)
               longestWait = x;
            list.poll();
         }
               
         if (cookTime1 > 0)
            cookTime1--;
         if (cookTime2 > 0)
            cookTime2--;
         if (cookTime3 > 0)
            cookTime3--;
         
         for (Customer x: list)
            x.increment();
         display(list, i);
      }
      System.out.println("Total customers served = " + total);
      System.out.println("Average wait time = " + ((waiting*1.0)/total));
      System.out.println("Longest wait time = " + longestWait);
      System.out.println("Longest queue = " + longestQueue);
   }
   
   public static void display(Queue<Customer> q, int min){
      String ans = min + ": [ ";
      int num = 0;
      if (q.peek() != null)
         for (Customer x: q) {
            ans += x.getClock() + " ";
            num++;
         }
      if (num > longestQueue)
         longestQueue = num;
      ans += "]";
      System.out.println(ans);    
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