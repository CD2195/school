/* Program accepts a three digit number and displays them in reverse order */
#include <stdio.h>

int main () {
    /* Declare variables */
    int num,one,ten,hun;

    /* Ask user for three digit number */
    printf("Enter a three-digit number > ");
    scanf("%d", &num);

    hun = num/100;
    ten = (num - hun*100)/10;
    one = (num - hun*100 - ten*10);

    printf("The reversal is: %d%d%d\n",one,ten,hun);

    return 0;
}
