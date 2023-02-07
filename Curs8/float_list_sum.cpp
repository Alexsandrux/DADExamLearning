#include <iostream>
#include <mpi.h>

int main(int argc, char **argv)
{
    MPI_Init(&argc, &argv);

    int rank, size;
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);
    MPI_Comm_size(MPI_COMM_WORLD, &size);

    if (size != 4)
    {
        MPI_Abort(MPI_COMM_WORLD, 0);
    }

    int float_size = 12;
    float vector[float_size] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

    int chunk_size = float_size / size;
    float chunk[chunk_size];

    MPI_Scatter(vector, chunk_size, MPI_FLOAT, chunk, chunk_size, MPI_FLOAT, 0, MPI_COMM_WORLD);

    float sum = 0;

    for (int i = 0; i < chunk_size; i++)
    {
        sum += chunk[i];
    }

    std::cout << "Rank " << rank << " has sum: " << sum << std::endl;
    float result = 0;

    MPI_Reduce(&sum, &result, 1, MPI_FLOAT, MPI_SUM, 0, MPI_COMM_WORLD);

    if (rank == 0)
        std::cout << "Suma este: " << result << std::endl;

    MPI_Finalize();

    return 0;
}