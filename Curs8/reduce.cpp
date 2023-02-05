#include <iostream>
#include <cstdlib>
#include <mpi.h>

int main(int argc, char **argv)
{
    MPI_Init(&argc, &argv);

    int size, rank;
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    int array_size = 10;

    double buffer[array_size];

    for (int i = 0; i < array_size; i++)
    {
        buffer[i] = (i + 1) * (rank + 1);
    }

    double response[array_size];

    MPI_Reduce(buffer, response, array_size, MPI_DOUBLE, MPI_SUM, 0, MPI_COMM_WORLD); // we can use MPI_MAX to get the max and so on

    if (rank == 0)
    {
        for (int i = 0; i < array_size; i++)
        {
            std::cout << response[i] << std::endl;
        }
    }

    MPI_Finalize();

    return 0;
}