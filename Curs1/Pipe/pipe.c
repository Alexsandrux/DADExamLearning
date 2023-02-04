#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main() {
	int fds[2];
	char buffer[20];
	
	pipe(fds);
	
	if(fork() == 0){
		printf("I'm the CHILD process!\n");
		printf("CHILD: I will write to this pipe: %d\n", fds[1]);
		write(fds[1], "hi", 3);
		
		exit(0);
	}
	else {
		wait(NULL);
		printf("I'm the PARENT process!\n");
		printf("PARENT: I will read from this pipe: %d\n", fds[0]);
		read(fds[0], buffer, 3);
		printf("PARENT: The CHILD sent this: %s\n", buffer);
	}


return 0;
}