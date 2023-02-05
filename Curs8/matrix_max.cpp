#include <iostream>
#include <mpi.h>

int main(int argc, char **argv)
{
    MPI_Init(&argc, &argv);

    int size, rank;
    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    if (size != 3)
    {
        MPI_Abort(MPI_COMM_WORLD, 0);
    }

    int matrix_size = 3;
    int matrix[matrix_size][matrix_size] = {{1, 6, 5}, {4, 11, 7}, {8, 10, 1}};

    int chunk[matrix_size];

    MPI_Scatter(matrix, matrix_size, MPI_INT, chunk, matrix_size, MPI_INT, 0, MPI_COMM_WORLD);

    int max = 0;
    std::cout << "The process with rank " << rank << " :" << std::endl;
    for (int i = 0; i < matrix_size; i++)
    {
        std::cout << chunk[i] << " ";
        if (max < chunk[i])
        {
            max = chunk[i];
        }
    }
    std::cout << std::endl;

    int max_result = 0;
    MPI_Reduce(&max, &max_result, 1, MPI_INT, MPI_MAX, 0, MPI_COMM_WORLD);

    if (rank == 0)
        std::cout << "Process with rank: " << rank << " says: The max of the matrix is equal to " << max_result << std::endl;

    MPI_Finalize();
    return 0;
}