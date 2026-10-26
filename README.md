# McRonald Queue Simulation

A Java simulation of one day at a fast food drive-thru, minute by minute, using a queue I built from scratch as a linked list.

## Features
- Simulates 1080 minutes (an 18 hour day)
- Each minute there's a 1 in 5 chance a new customer arrives
- One cook takes a random 2-7 minutes per order
- Prints the line every minute (each number is the minute that customer arrived)
- End of day stats: total customers, customers served, average wait time, longest wait and longest line

## How to run
```
javac McRonald.java && java McRonald
```
The results are different every run because arrivals and cook times are random.

## Sample output
From a real run (the full output is one line per minute, so this is cut down):
```
0: [ ]
1: [ ]
2: [ ]
...
908: [ 866 868 877 878 881 882 890 893 894 896 897 899 907 ]
909: [ 868 877 878 881 882 890 893 894 896 897 899 907 909 ]
910: [ 868 877 878 881 882 890 893 894 896 897 899 907 909 ]
911: [ 868 877 878 881 882 890 893 894 896 897 899 907 909 911 ]
...
1080: [ 1048 1053 1058 1059 1064 1069 1072 1079 ]
Total customers = 234
Total customers served = 226
Average wait time = 20.451327433628318
Longest wait time = 59
Longest queue = 14
```

## How it works
- `Customer` stores the minute it arrived and how long it has been waiting
- `Queue` is my own singly linked list with `head` and `tail` pointers: `add` puts a customer at the tail, `poll` removes from the head, `peek` looks at the front, and it implements `Iterable` so I can loop through the line with a for-each loop
- Every minute: maybe add a customer, if the cook is free take the next order and record that customer's wait, count down the cook timer, then add a minute to everyone still waiting

## Earlier versions
`variants/` has two earlier versions of the same assignment that use Java's built-in `LinkedList` as the queue:
- `three-cooks/McRonald3.java`: three cooks and a customer every other minute on average
- `1000-days/McRonald1000.java`: runs 1000 days in a row and only prints the stats, including average customers per day and the busiest day

Run them from their own folder, for example `cd variants/three-cooks && javac McRonald3.java && java McRonald3`. In these older versions "Total customers served" counts everyone who arrived.

Sample stats from the three cooks version:
```
Total customers served = 527
Average wait time = 0.7571157495256167
Longest wait time = 6
Longest queue = 4
```

From the 1000 day version:
```
Total customers served = 287671
Average wait time = 18.08649464144804
Longest wait time = 183
Longest queue = 39
Average served per day = 287.671
Largest day = 331
```

## Concepts used
- Linked lists (nodes, head and tail pointers)
- Queues (FIFO)
- Implementing `Iterable` with an inner class iterator
- Simulation with random events
- Tracking running totals and maximums

## What I'd add next
- Let you pass the arrival chance, cook times and number of cooks as arguments so you can compare setups without editing code
- Track average wait by hour to find the rush hours
- Graph the line length over the day
