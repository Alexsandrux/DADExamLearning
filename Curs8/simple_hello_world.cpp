#include <iostream>
#include <mpi.h>

int main(int argc, char **argv)
{
    MPI_Init(&argc, &argv); // we always have to initialise and then finalize the mpi progam (here we initialize it)

    int size, rank;
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    // above we get the rank of each process and the the MPI program size

    if (rank == 0) // like this we can tell segment what a process can acces from the program
    {
        std::cout << "Hi I'm the process with rank 0 and the size of the program is " << size << std::endl;
    }

    std::cout << "Hello world, from process #" << rank << std::endl;

    MPI_Finalize(); // here is the finalize part that we always have to add

    return 0;
}
