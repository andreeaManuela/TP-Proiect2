# TP-Proiect2
Queues using threads in Java

Simulation Application aiming to analyse queuing based systems for determining and minimizing clients’ waiting time, developed for the Fundamental Programming Techniques course 2nd year, 2nd semester.

The application implemented in Java simulates a series of N clients (generated randomly) arriving for service, entering Q queues, waiting, being served and finally leaving the queues, with the help of multithreading and ensuring thread safety.
All clients are generated when the simulation is started. The application tracks the total time spent by every client  Each client is added to the queue with minimum waiting time when its 𝑡𝑎𝑟𝑟𝑖𝑣𝑎𝑙 time is greater than or equal to the simulation time.
A number of Q threads are launched to process in parallel the clients. Another thread is launched to hold the simulation time 𝑡𝑠𝑖𝑚𝑢𝑙𝑎𝑡𝑖𝑜𝑛 and distribute each client i to the queue with the smallest waiting time.
The result of the simulation is saved in a .txt file corresponding to the log of events.
