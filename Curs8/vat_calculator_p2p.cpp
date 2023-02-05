#include <iostream>
#include <mpi.h>

int main(int argc, char **argv)
{
    MPI_Init(&argc, &argv);

    int size, rank;
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    double value = 0.0;

    if (rank == 0)
    {
        value = 100.0;

        MPI_Send(&value, 1, MPI_DOUBLE, 1, 0, MPI_COMM_WORLD);
    }
    else
    {

        MPI_Recv(&value, 1, MPI_DOUBLE, 0, 0, MPI_COMM_WORLD, MPI_STATUS_IGNORE);

        value = value * 1.19;

        std::cout << "The process with the rank " << rank << " calculated the value " << value << std::endl;
    }

    MPI_Finalize();
    return 0;
}