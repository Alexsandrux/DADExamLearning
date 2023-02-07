**CORBA**

CORBA - **C**ommon **O**bject **R**equest **B**roker **A**rhitecture

The CORBA basic arhitecture consists of:
- a client
 - Client object
 - Stub
 - ORB

- a server host machine
 - a Remote object
 - Skeleton
 - ORB

**STUB**

- Lives on the client
- Pretends to be remote object

**SKELETON** (Lives in a dungeon, in another context anyway)

- Lives on the server
- Receives requests from the stub
- Talks to true remote object
- Delivers response to stub

**CORBA BASIC FLOW**

1. Server creates remote object
2. Server registers the remote object
3. Client requests object to name server
4. Name Server returns remote reference(and stub gets created)
5. Client invokes stub method
6. Stub talks with skeleton
7. Skeleton invokes remote object method

**ORB**

OMG does not specify exactly where the ORB
is in CORBA.
Depending on which CORBA implementation
(product) is used, the ORB may be:
– A set of run-time libraries
– A server machine/process
– Part of the operating system (Spring)
– Part of a web browser (Netscape)

ORB - **O**bject **R**equest **B**roker

__FEATURES:__

- Handles all communication among objects
- Each host (machine) has its own ORB
- ORBs know how to talk to each other
- ORB also provides basic services to client

__RESPONSABILITIES:__

- Find the object implementation for the request
- Prepare the object implementation to receive the request
- Communicate the data making up the request
- Retrieve the results of the request

ORB is good if the Stub and the Skeleton are written in different programming languages.

**What is ORB really?**

- Not a separate process
- Library code that executes in-process
- Listens to TCP ports for connections
    - One port per local object
- Opens TCP sockets to other objects
    - N ports per remote machine

**GIOP AND IIOP**

The OMG agreed protocol for ORB interoperability is called the General Inter-ORB Protocol (GIOP).
GIOP defines the logical data representation and message formats for communication.

The OMG defines a realization of GIOP that uses TCP/IP as the transport layer. This specialization is called the Internet Inter-ORB Protocol (IIOP).

**PSEUDO-OBJECTS**

The ORB is a pseudo-object
It works just like a remote object, only it’s local.

The Basic Object Adapter (BOA)
- Another pseudo-object
- Helps register objects with the ORB
- Functions
    - Maintain Implementation Repository
    - Generate and interpret object references
    - Activate and deactivate implementation objects
    - Invoke methods via 
    
**WHY WHOULD I NEED BOTH ORB AND BOA**

Allows vendors to optimize or enhance functionality
- register many objects en masse
- cache object state elsewhere
E.g. Object database

**USING BOA**

Slightly different procedure for initializing objects
Hides name service from you
- Ask the BOA to register the object
- Ask the Helper object to bind the object
Once the object is created, interface is identical
- Just call methods using normal Java syntax

**OBJECT ADAPTERS**

**POA**

POA - **P**ORTABLE **O**BJECT **A**DAPTER

**POA IS A BOA**

Provides many services:
- Dispatches client calls to server objects
- Handles incoming client calls
- Handles registration of servers
- Instantiatiates objects at runtime and creates and manages
object references

Characteristics of object adapters:
- An object adapter may be responsible for one or more objects
- The object adapter is not aware of the interfaces on the object it controls
- Object skeleton provides invoke() function for the adaptor to call and pass the message the adaptor it receives
- Skeleton does marshall and unmarshall.

**CORBA IMPLEMENTATIONS**

**SUN** - now deprecated, had 3 parts:
- ORB
- Naming service (COS - CORBA OBJECT SERVICE)
- idltojava & javatoidl compiler

**SUN STUB AND SKELETON**

Stub:
- java objects call stub methods
- stubs communicate with corba objects ( and vice versa)
- Transparent integration

Skeleton
- ORB passes request to a skeleton(like a stub)
- Skeleton calls local implementation




**WEB SERVICES**

**XML-RDC** 

- "a software system designed to support interoperable Machine to Machine interaction over a network.“ (W3C)
- Remote Procedure Call over HTTP

Characteristics:
- remote procedure calls using HTTP for transport and XML as encoding
- XML-RPC message is an HTTP-POST request
- very simple XML - doesn't use XML namespaces or attributes
- works only with HTTP


**WSDL**

- WSDL – **W**eb **S**ervice **D**efinition **L**anguage
- WSDL = XML document that describes a web service
- WSDL – Specifies the location of the service and the operations (or methods) it exposes

WSDL describes a web service using the following elements:
- <binding> contains communication protocols used by the web service
- <portType> defines the operations that can be performed by a web service, and the messages that are involved
- <message> defines the in/out messages that are used by the operations ó methods
- <types> defines data types used by the messages

A WSDL document can also contain extension elements and a <service> element that makes it possible to group together the definitions of several web services.

**SOAP**

SOAP – **S**imple **O**bject **A**ccess **P**rotocol
- simple XML based protocol to let applications exchange information over HTTP
- defines a format for sending messages
- allows you to get around firewalls (firewalls and proxy servers normally block RPC traffic)
- platform and language independent
- transport Protocols: TCP, HTTP, SMTP, and MQ – Message Queues

A SOAP message is an ordinary XML containing the following elements:
- <Envelope> which identifies that the XML document is a SOAP message
- <Header> which contains application specific information about the SOAP message (such as authentication, payment, etc) .
- <Body> contains the actual SOAP message
- <Fault> contains eventual error messages

The SOAP messaging protocol allows you to send MIME attachments via SOAP messages. WSDL provides a description of these attachments.

SOAP with Attachments API for Java (SAAJ) allows you to do XML messaging from the Java platform

The SAAJ API conforms to the Simple Object Access Protocol (SOAP) 1.1 and 1.2 specifications and the SOAP with Attachments specification.


A SOAP message may include one or more attachment parts in addition to the SOAP part.

The SAAJ API provides the AttachmentPart class to represent an attachment part of a SOAP message.

An attachment part can contain any kind of content.