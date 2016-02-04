/* This program implements project 5 from chapter 2 of textbook */
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
    float x,y;

    /* Display prompt */
    printf("---Polynomial Calculator---\n");
    /* Ask for a */
    printf("Enter x > ");
    scanf(" %f",&x);

    /* Calculate polynomial */
    y = 3*recExp(x,5) + 2*recExp(x,4) - 5*recExp(x,3) - recExp(x,2) + 7*x - 6;

    /* Display result */
    printf("\t 3x⁵+2x⁴-5x³-x²+7x-6 = %f",y);
    printf("\n");

    return 0;
} // int main(void) 
