A pipe is a form of UNIX IPC.

The pipe takes at least 2 file descriptors(fd) as parameters.

---------------------break-----------------------
What is a file descriptor you might say?
Well, a fd is file where the process writes.
The default fd are stdin(0), stdout(1), stderr(2).

What if you want your own fd, to read from a file or write directly to a file?
You can use the dup() and dup2() system calls.

With dup you can change an default fd to a new fd. And it returns a copy of the original fd.
With dup2 you can restore the fd with the copy you got from dup and it's place as params.

---------------------end_of_break-----------------------

With the write and read system calls you can communicate within a pipe with the help of the saved fds positions that pipe replace its parameters with.