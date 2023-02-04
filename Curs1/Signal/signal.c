#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>

void handler(int signum) {
   printf("Caught signal %d, coming home...\n", signum);
   exit(1);
}

int main () {
   signal(SIGINT, handler);

   while(1) {
      printf("Zzz...\n");
      sleep(1); 
   }
   return(0);
}
