#include <stdio.h>
#include <pthread.h>
#include <stdint.h>

#define ARR_SIZE 10

float array1[ARR_SIZE] = { 1.1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
float array2[ARR_SIZE] = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
float resultArray[ARR_SIZE];


void* addArrays() {
    for (int i = 0; i < ARR_SIZE; i++) {
        resultArray[i] = array1[i] + array2[i];
    }
}

void main()
{


    pthread_t t;

    pthread_create(&t, NULL, addArrays, NULL);

    pthread_join(t, NULL);

    for (int i = 0; i < ARR_SIZE; i++)
    {
        printf("%.1f ", resultArray[i]);
    }
    printf("\n");
}
