#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>
#include <signal.h>

#define ARR_SIZE 10

float array1[ARR_SIZE] = { 1.1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
float array2[ARR_SIZE] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
float resultArray[ARR_SIZE];

void addArrays() {
    for (int i = 0; i < ARR_SIZE; i++) {
        resultArray[i] = array1[i] + array2[i];
    }
}

void forkexample()
{
    int cpid = 0;

    cpid = fork();

    if (cpid == 0)
    {
        addArrays();
        printf("Child added the arrays\n");


        for (int i = 0; i < ARR_SIZE; i++)
        {
            printf("%.1f ", resultArray[i]);
        }
        printf("\n");
    }
    else
    {
        sleep(2);
        kill(cpid, SIGKILL);
        printf("Parent process!\n");
    }
        
}

void main()
{
    forkexample();

}
