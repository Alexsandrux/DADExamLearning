Cand este apelat "fork" system call pe un process, este creat un nou proces numit proces copil.
Procesul original poarta denumirea de proces parinte.
Procesul-copil este un o copie a parintelui.

In C fork() returneaza:   0 => copil; !0 => parinte; <0 => fork has failed.

Procesul-parinte foloseste wait() pentru a astepta pana ce procesul-copil termina executia si elibereaza resursele.
Daca procesul-parinte nu foloseste wait() procesul-copil nu va elibera resursele si va fi considerat un proces "zombie". 