**SNMP**

SNMP (Simple Network Management Protocol) este un protocol folosit pentru colectarea si organizarea informatilor ale dispozitivelor dintr-o retea. Este facut peste UDP pe portul 161.
	Daca un dispozitiv este snmp-enabled acesta poarta numele de agent.
	Un agent are mai multe obiecte care pot fi interactionate, fiecare avand un object-identifier (OID) ;acestea sunt stocate intr-un fisier numit MIB(Management Information Base).
Un MIB are o structura ierarchica si fiecare element are un numar pentru a fi usor gasit OID in fisier. De aici si modul in care OID-ul este infatisat: ex: .1.3.6.1.2.1.1.5 ( pentru name).
Pentru a interactiona cu un MIB este nevoie de un NMS(Network Management System) care este o bucata de cod folosita pentru a comunica cu agentul.
Moduri de comunicare ale NMS-ului cu MIB:
-	Get requests ( get, getNext, getBulk)
-	Set Requests
-	Trap/Inform ( sunt folosite pentru a notifica NMS-ul)
Atat Trap, cat si Inform fac acelasi lucru, dar doar Inform este de incredere deoarece asteapta o confirmare de la NMS; daca nu o primeste va retrimite Inform-ul. Trap pe de alta parte este trimis si agent-ul nu mai il intereseaza ce s-a intamplat cu el.


**UDP**

**TCP**

**UDP vs. TCP**

![tcp_Vs_udp](https://github.com/Alexsandrux/DADExamLearning/blob/main/Images/tcp%20vs%20udp.png)

