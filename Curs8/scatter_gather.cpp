#include <iostream>
#include <mpi.h>

int main(int argc, char **argv)
{
    MPI_Init(&argc, &argv);

    int size, rank;
    int big_array_size = 12;

    MPI_Comm_size(MPI_COMM_WORLD, &size);
    MPI_Comm_rank(MPI_COMM_WORLD, &rank);

    if (rank == 0)
    {
        if ((big_array_size % size) != 0)
        {
            std::cout << "The slot size is NOT divisible with the size of the array" << std::endl;
            MPI_Abort(MPI_COMM_WORLD, 0);
        }
    }

    int arr[big_array_size];
    for (int i = 0; i < big_array_size; i++)
    {
        arr[i] = i + 1;
    }

    if (rank == 0)
    {
        std::cout << "Before scatter and gather:" << std::endl;
        for (int i = 0; i < big_array_size; i++)
        {
            std::cout << arr[i] << std::endl;
        }
    }

    int small_array_size = 12 / size;
    int chunk[small_array_size];

    MPI_Scatter(arr, small_array_size, MPI_INT, chunk, small_array_size, MPI_INT, 0, MPI_COMM_WORLD);

    for (int i = 0; i < small_array_size; i++)
    {
        chunk[i] = rank;
    }

    MPI_Gather(chunk, small_array_size, MPI_INT, arr, small_array_size, MPI_INT, 0, MPI_COMM_WORLD);

    if (rank == 0)
    {
        std::cout << "After scatter and gather:" << std::endl;
        for (int i = 0; i < big_array_size; i++)
        {
            std::cout << arr[i] << std::endl;
        }
    }

    MPI_Finalize();

    return 0;
}