**RMI**

RMI stands for Remote Method Invocation, a Java-based API that allows objects to invoke methods on remote objects, typically in a different Java Virtual Machine (JVM). It is used to build distributed systems where objects can interact with each other regardless of their location.

**RMI ARHITECTURE**

The **RMI Client** is looking for the address and the name of the RMI server object in the RMI Registry program – **lookup**.


The **RMI Server** must register it's name and adress in the RMI registry program - **bind**.

**STUB**: The stub is a client-side proxy for the remote object. It acts as a representative of the remote object on the client side and communicates with the remote object by sending method invocation requests to the RMI runtime. The stub acts as an intermediary between the client and the remote object, hiding the complexity of the communication from the client.

**Skeleton**: The skeleton is a server-side component that receives method invocation requests from the RMI runtime and dispatches them to the remote object. The skeleton acts as an intermediary between the RMI runtime and the remote object, and it is responsible for executing the methods on behalf of the client.

RMI Stub serializes and transmits the parameters of the call in sequence – **“marshalling”** to the RMI Skeleton. RMI Skeleton de-serializes and extracts the parameters from the received call – **“unmarshalling”**. In the end, the RMI Skeleton calls the method inside the server object and send back the response to the RMI Stub through **“marshalling”** the return’s parameter.

**Marshalling** in RMI (Remote Method Invocation) refers to the process of serializing and transmitting method arguments and return values over the network.

In RMI, when a client invokes a method on a remote object, the method arguments and return values need to be transferred from the client to the remote object and back. To facilitate this, RMI uses the Java serialization mechanism to convert the arguments and return values into a stream of bytes, which can be transmitted over the network. This process is known as marshalling.

When the remote object receives the method invocation request, it deserializes the arguments, executes the method, and then serializes the return value. This process is known as **unmarshalling**. The return value is then transmitted back to the client, where it is deserialized and returned to the caller.

**RMI COMPONENTS**

The RMI (Remote Method Invocation) architecture consists of the following components:

1. **Remote Interface**: This defines the methods that can be remotely invoked and specifies the signature of the methods. The remote interface must extend the `java.rmi.Remote` interface and declare all its methods to throw `java.rmi.RemoteException`.

2. **Remote Object**: This is the implementation of the remote interface that contains the actual implementation of the methods. The remote object must extend `java.rmi.server.UnicastRemoteObject` and implement the methods defined in the remote interface.

3. **RMI Registry**: This is a naming service that maps the names of remote objects to their references. The registry allows clients to look up the remote objects by their names and obtain references to them.

4. **Client**: This is the component that invokes the methods on the remote object. The client can look up the remote object from the registry using the `java.rmi.Naming` class and then invoke its methods.

5. **Java RMI runtime**: This component is responsible for managing the communication between the client and the remote object. It provides support for object serialization, network communication, and remote method invocation.

In summary, the RMI architecture allows for the creation of distributed systems where objects can interact with each other regardless of their location by providing a framework for remote method invocation. The client can invoke methods on a remote object by looking up the remote object from the registry and sending method invocation requests to the remote object, which is then executed by the RMI runtime.


**DEVELOPING A RMI SYSTEM**

    **DEVELOPMENT of the RMI SERVER**:
1. Defining the remote interface. The remote interface must extend the `java.rmi.Remote` interface and declare all its methods to throw `java.rmi.RemoteException`.
2. Developing the Java class for instantiation of the JRMI server object –
implementing the interface from the step 1. The remote object must extend `java.rmi.server.UnicastRemoteObject` and implement the methods defined in the remote interface.
3. Developing the Java main server program. Bind the remote object to the RMI registry: The next step is to bind the remote object to the registry so that it can be located by clients. This can be done by calling the `rebind` method of the `java.rmi.Naming class`.
4. Compiling the Java server classes source code and generating the JRMI
Skeleton & JRMI Stub classes using rmic utility program

    **DEVELOPMENT of the RMI CLIENT**:

5. Developing the Java client program
6. Copying the Java compiled byte-code files for JRMI Stub and for the
remote interface – from the server side to the client side
7. Compiling the client Java source code file together with the files from
step 6.

    **RUNNING RMI SERVER**:

8. Start the JRMI registry program. 
9. Start the server program.

    **RUNNING RMI CLIENT**:
    
10. Start the client program
