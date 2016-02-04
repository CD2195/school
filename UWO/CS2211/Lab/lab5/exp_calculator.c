/* This program implements an exponential number calculator */
#include <stdio.h>

/*
 * Function takes a float 'a' and non-negative integer 'b', where a is the base and b is the exponent.
 * Returns float a^b
 */
float recExp(float a, int b) {
    /* Setup base cases n =0,1 */
    if(b == 0) return 1;
    else if(b == 1) return a;

    /* If n is even */
    else if(b % 2 == 0) {
        float c = recExp(a,b/2);
        return c*c;
    }
    /* If n is odd */
    else {
        float c = recExp(a,b/2);
        return c*c*a;
    }
} // float exp(float,int)

/**
 * Main program
 */
int main() {

    /* Declare variables */
    float a;
    int b;

    /* Display prompt */
    printf("---Exponent Calculator---\n");
    do {
        /* Ask for a */
        printf("Enter base > ");
        scanf(" %f",&a);
        /* Ask for b */
        printf("Enter exponent > ");
        scanf(" %d",&b);

        /* Display error message if b % 2 != 0 */
        if(b < 0) printf("\t\tExponent must be postive integer!\n");
    } while(b < 0);

    /* Display result */
    printf("\t\t%f", recExp(a,b));
    printf("\n");

    return 0;
} // int main(void) 
