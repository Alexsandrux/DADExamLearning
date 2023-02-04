full course: https://www.codingame.com/playgrounds/349/introduction-to-mpi/introduction-to-distributed-computing   

**Introduction**

Message Passing Interface (MPI) is a standardized library for passing messages.

MPI is just a standard, which means that we have an abstract list of features and concepts that will be implemented.

MPI is used for passing messages between processes which can be a really good for paralelism and HPC.


But, the area where MPI truly shines is **Distributed Computing**, where  for a long time MPI is used for passing messages between the different nodes of a distributed arhitecture.

**MPI_COMM_WORLD**

When a program is runned with MPI all the processes are grouped in a **COMMUNICATOR**. We can consider the communicator as a box where we can group the process toghether, thus all the communications are atribuited to a communicator. In this we they can get to every process.


Types of communications:
- Point-to-Point : Two processes in the same communicator are going to communicate.
- Collective : All the processes in a communicator are going to communicate together.

The default communicator is MPI_COMM_WORLD which groups all the processes when the program begins.

The number(or **size**) of the communicator doesn't change after the it's creations. And every process has a number called **rank**, with the help of the program is identified.

For the information until now check: [simple_hello_world.cpp](https://github.com/Alexsandrux/DADExamLearning/blob/main/Curs8/simple_hello_world.cpp)

**Point-to-Point COMMUNICATION**

P2P communications are divided in two operations:
- **Send**
- **Receive**

P2P are called **BLOCKING COMMUNICATIONS** because the sending process will wait until the receiving process has finished receiving all the information.

*Sending Messages*

It sends a buffer of data of a certain type to another process.
P2P messages has the following properties:

1. The refference to a buffer
2. A datatype
    - char = MPI_CHAR
    - int = MPI_INT
    - float = MPI_FLOAT
    - double = MPI_DOUBLE
    - and many more types..
3. The number of elements
4. A tag (it defines the *type* of the communication, that is a completely informal value but by the user)
5. Destination id (the rank of the receiving process)
6. A communicator

*Receiving Messages*

Work in the same way as sending messages but instead of dest id we need a source id.

After the basic information about blocking communications check: [blocking_comms.cpp](https://github.com/Alexsandrux/DADExamLearning/blob/main/Curs8/blocking_comms.cpp)


