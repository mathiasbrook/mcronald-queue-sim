//name: Mathias Brook
//date: 6/2/2026

import java.util.*;
public class McRonald {
public static final int time = 1080;  
   
 private static int tl = 0;
 private static int tw = 0;
 private static int served = 0;
  
  private static int LQ = 0;
 private static int longestWait = 0;
   
  public static void main(String[] args)
  {
     Queue queue = new Queue();
     int cookTime = 0;
     for (int i = 0; i <= time; i++) {                 
        int chance = (int)(Math.random()*5)+1;
        if (chance == 1) {
           queue.add(new Customer(i));
           tl++;}
                
        if (cookTime == 0 && queue.isEmpty() == false) {
           cookTime = (int)(Math.random()*6)+2;
           int x = queue.peek().getWait();
           tw += x;
           if (x > longestWait)
              longestWait = x;
           queue.poll();
           served++;}
        
        if (cookTime > 0)
           cookTime--;
        for (Customer x: queue)
           x.increment();
        display(queue, i);}
     
     System.out.println("Total customers = " + tl);
     System.out.println("Total customers served = " + served);
     System.out.println("Average wait time = " + ((tw*1.0)/served));
     System.out.println("Longest wait time = " + longestWait);
     System.out.println("Longest queue = " + LQ);}
  
   
  public static void display(Queue q, int min){
     String ans = min + ": [ ";
     int num = 0;
     if (q.peek() != null)
        for (Customer x: q) {
           ans += x.getClock() + " ";
           num++;
        }
     if (num > LQ)
        LQ = num;
     ans += "]";
     System.out.println(ans);    
  }}
  

class Customer {
  private int clock = 0;
   private int wait = 0;
      
   public Customer(int t) {
      clock = t;
   }
      
   public int getClock() {
      return clock;
   }
      
   public int getWait(){
      return wait;
   }
      
   public void increment(){
      wait++;
   }
   
}

class Queue implements Iterable<Customer> {
    private Node head;
    private Node tail;

    private class Node {
        Customer data;
        Node next;
        Node(Customer data) {
            this.data = data;
            this.next = null;
        }
    }

    public void add(Customer c) {
        Node newNode = new Node(c);
        if (tail == null) {
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;}}
     

    public Customer poll() {
        if (head==null) return null;
        Customer data =head.data;
        head =head.next;
        if (head ==null) tail=null;
        return data;
    }

    public Customer peek() {
        if (head ==null) return null;
        return head.data;
    }

    public boolean isEmpty() {
        return head ==null;
    }

    public java.util.Iterator<Customer> iterator() {
        return new java.util.Iterator<Customer>() {
            Node current =head;
            public boolean hasNext() { return current !=null;}
            public Customer next(){
                Customer data =current.data;
                current =current.next;
                return data;
            }
        };
    }
}
