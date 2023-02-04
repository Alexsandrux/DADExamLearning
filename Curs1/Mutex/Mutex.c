#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

pthread_mutex_t mutex1 = PTHREAD_MUTEX_INITIALIZER;
int counter = 0;

void *add(void *arg)
{
    for (int i = 0; i < 100000; i++)
    {
        pthread_mutex_lock(&mutex1);
        counter++;
        pthread_mutex_unlock(&mutex1);
    }
    return NULL;
}

int main()
{
    pthread_t thread1, thread2;

    pthread_create(&thread1, NULL, &add, NULL);
    pthread_create(&thread2, NULL, &add, NULL);

    pthread_join(thread1, NULL);
    pthread_join(thread2, NULL);

    printf("SUM= %d\n", counter);

    return 0;
}
