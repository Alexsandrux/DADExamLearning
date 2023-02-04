full course: https://www.codingame.com/playgrounds/349/introduction-to-mpi/introduction-to-distributed-computing

**Introduction**

Message Passing Interface (MPI) este o librarie standardizata pentru pasarea mesajelor.

MPI este doar un standard, ceea ce inseamna ca avem o lista abstracta de features si concepte care vor fi implementate.

MPI se ocupa cu pasarea mesajelor intre procese ce poate fi un lucru foarte bun pentru paralelism si HPC.

Dar, zona unde MPI straluceste este Distributed Computing, unde de mult timp MPI este folosit pentru pasarea mesajelor intre diferitele noduri ale unei arhitecturi distribuite.

**MPI_COMM_WORLD**

Cand un program este rulat cu MPI toate procesele sunt grupate intr-un "communicator". Putem considera communicator-ul ca o cutie care grupeaza procesele impreuna, astfel fiecare comunicare este atribuita unui communicator, astfel reusing sa ajunga la fiecare proces.

Communicator-ul default este MPI_COMM_WORLD care grupeaza toate procesele cand programul incepe.

Numarul(dimensiunea) communicatorul nu se schimba dupa ce este creata. Iar fiecare proces are un numar numit "rank" cu ajutorul caruia este identificat.
