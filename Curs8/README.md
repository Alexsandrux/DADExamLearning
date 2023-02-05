full course: https://www.codingame.com/playgrounds/349/introduction-to-mpi/introduction-to-distributed-computing   

**Introduction**

Message Passing Interface (MPI) is a standardized library for passing messages.

MPI is just a standard, which means that we have an abstract list of features and concepts that will be implemented.

MPI is used for passing messages between processes which can be a really good for paralelism and HPC.


But, the area where MPI truly shines is **Distributed Computing**, where  for a long time MPI is used for passing messages between the different nodes of a distributed arhitecture.

**MPI_COMM_WORLD**

When a program is runned with MPI all the processes are grouped in a **COMMUNICATOR**. We can consider the communicator as a box where we can group the process toghether, thus all the communications are atribuited to a communicator. In this we they can get to every process.


Types of communications:
- **Point-to-Point** : Two processes in the same communicator are going to communicate.
- **Collective** : All the processes in a communicator are going to communicate together.

The default communicator is ```MPI_COMM_WORLD``` which groups all the processes when the program begins.

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
    - char = ```MPI_CHAR```
    - int = ```MPI_INT```
    - float = ```MPI_FLOAT```
    - double = ```MPI_DOUBLE```
    - and many more types..
3. The number of elements
4. A tag (it defines the *type* of the communication, that is a completely informal value but by the user)
5. Destination id (the rank of the receiving process)
6. A communicator

Sending code looks like this:
```
int MPI_Send(void *buf, int count , MPI_Datatype datatype, int dest, int tag, MPI_Comm comm);
```

*Receiving Messages*

Work in the same way as sending messages but instead of dest id we need a source id, but we also need a status.

We can use ```MPI_ANY_SOURCE``` instead of the source name for accepting any process and we can later find the the sender in MPI_Status struct.

Receiving code looks like this:
```
int MPI_Recv(void *buf, int count, MPI_Datatype datatype, int source, int tag, MPI_Comm comm, MPI_Status *status);
```

We can use ```MPI_STATUS_IGNORE``` to omit using the status.

**MPI_Status**

Is a struct that you can acces if necessary to check information about the received message.

The MPI_Status struct looks like this:
```
struct MPI_Struct {
  int MPI_SOURCE;
  int MPI_TAG;
  int MPI_ERROR;
  int _cancelled;
  size_t _ucount;
};
```

It's declared like this:
```
MPI_Status variable_name;
``` 

After the basic information about blocking communications check: [blocking_comms.cpp](https://github.com/Alexsandrux/DADExamLearning/blob/main/Curs8/blocking_comms.cpp)

**NON-BLOCKING COMMUNICATION**

In MPI NON-BLOCKING COMMUNICATION is always needed to be implemented and completed. We are supposed to do our work instead of waiting to send like in the BLOCKING COMMUNICATION and check from time to time if the process we are sending to is ready to receive.

> kinda complicated and too much time to understand and implement... continuing after exam

**RACING CONDITIONS**

> kinda complicated and too much time to understand and implement... continuing after exam

**PROBING INCOMING COMMUNICATIONS**

> kinda complicated and too much time to understand and implement... continuing after exam

**COMMUNICATION MODES**

For blocking communication there are four types of communication modes to trigger the communication:
- standard ```MPI_Send```
- buffered ```MPI_Bsend``` => is similar to non-blocking communication because it stores all the data to be sent in a temporary buffer.
- ready ```MPI_Rsend``` => this makes sure the recv was been already called
- synchronous ```MPI_Ssend``` => for this the send will wait for the recv to complete ensuring that both processes are ready to transfer.


**COLLECTIVE COMMUNICATION**

Collective communication is used to exchange more easily information across all in processes of a communicator. 
Collective communication are useful for a lot of things. Depending of the objective there are different types of collective communications.

Some types of collective communications are:
- **Broadcast** - One process sends a message to every other process
- **Reduction** - One process gets data from all the other processes and applies an operation on it (sum, minimum, maximum, etc.
- **Scatter** - a single process partitions the data and sends pieces to every other process
- **Gather** - a single process assembles the data from different processes into a buffer

    _BROADCAST_

    Broadcast happens when one process wants to send information to all other processes. Broadcast is a non blocking operation, so processes continue running as soon as the information has been sent/received.

    After the operation, all process will have a copy of the data from the root process in their buffers.

    There are two types of Broadcast implementations:
    - one that is P2P: the root sends the information to all other processes one by one
    - one that relies on a tree structure: after the root sends the information to another process it reshares the information.

    Broadcast looks like this:
    ```
    int MPI_Bcast(void* buffer, int count, MPI_Datatype datatype, int root, MPI_Comm comm);
    ```

    _REDUCE_

    Reduce is a simple operation on all buffers on all processes.

    We can use predefined operations or we can create our own.

    This some of the posible flags we can use for predefined operations:
    - ```MPI_MAX```
    - ```MPI_MIN```
    - ```MPI_SUM```
    - ```MPI_MINLOC``` (gives the minimum and location)
    - ```MPI_PROD```
    - etc.

    What if we use operations on arrays?
    Well, the operations are element-wise and we will get as many result as the size of the array. So will we get the operation for the first element of the array, the second, the third, and so on..

    Reduce looks like this:
    ```
    int MPI_Reduce(void* send_data, void* recv_data, int count, MPI_Datatype type, MPI_Op op, int root, MPI_Comm communicator); 
    ```

    _SCATTER AND GATHER_

    This two are very useful operations for collective operations used distribute and regroup data from one to many and the oposite.

    Scatter looks like this:
    ```
    int MPI_Scatter(void *sendbuf, int sendcount, MPI_Datatype sendtype,
                void *recvbuf, int recvcount, MPI_Datatype recvtype, int root,
                MPI_Comm comm);
    ```

    Gather looks like this:
    ```
    int MPI_Gather(const void *sendbuf, int sendcount, MPI_Datatype sendtype,
               void *recvbuf, int recvcount, MPI_Datatype recvtype, int root,
               MPI_Comm comm);
    ```

