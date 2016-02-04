/* exp.c */
#include <stdio.h>

long factorial(int n) {
    long fact = 1;
    int i;
    for(i = 1; i <= n; i++)
        fact *= i;
    return fact;
}

void euler_E(double E) {
    double term = 1, e = 1;
    int i,n = 1;
    while(term > E) {
        e = 1;
        for(i = 1; i<=n; i++)
            e += 1.0/factorial(i);
        term = 1.0/factorial(n);
        n++;
    }
    printf("\te = %.32lf\n\tε =%.32lf\n",e,term);
}

int main() {
    /* Declare variables */
    double E; 

    /* Ask for float value epsilon (E) */
    printf("Enter ε > ");
    scanf(" %lf",&E);

    /* Calculate and print value */
    euler_E(E);
    return 0;
}



