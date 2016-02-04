/* This program implements a simple converter, which converts between metric and imperial values. */
#include <stdio.h>

/*
 * Function takes units and scale factor diplays converted value
 */
int convert(char unit1[], char unit2[], float scale) {
    /* Declare variables */
    float value;
    /* Take value, convert and display */
    printf("Enter %s", unit1); 
    printf(" value > ");
    scanf("%f",&value);
    value = value*scale;
    printf("\n\t\tResult: %f", value);
    printf(" %s", unit2);
    return 1;
} // int convert(str,str,float)

/*
 * Function takes the selected option, converts an inputted value and diplays it.
 */
int parseOpt(int option) {

    /* Declare variables */
    char unit;
    int valid = 0;

    /* Parse options and convert values */
    while(valid != 1) {
        if(option == 1) {
            printf("Enter 'K' for kg => lb or 'P' for lb => kg > ");
            scanf(" %c",&unit);

            if(unit == 'K') {
                valid = convert("kg","lb",2.20462);
            }
            else if(unit == 'P') {
                valid = convert("lb","kg",0.453592);
            } 
        }
        else if(option == 2) {
            printf("Enter 'L' for L => gal or 'G' for gal => L > ");
            scanf(" %c",&unit);

            if(unit == 'L') {
                valid = convert("L","gal",0.219969);
            }
            else if(unit == 'G') {
                valid = convert("gal","L",4.54609);
            }
        }
        else if(option == 3) {
            printf("Enter 'C' for cm => in or 'I' for in => cm > ");
            scanf(" %c",&unit);

            if(unit == 'C') {
                valid = convert("cm","in",0.393701);
            }
            else if(unit == 'I') {
                valid = convert("in","cm",2.54);
            }
        }
        else if(option == 4) {
            float value;
            printf("Enter 'C' for ℃ => ℉ or 'F' for ℉ => ℃ > ");
            scanf(" %c",&unit);

            if(unit == 'C') {
                printf("Enter ℃ value > ");
                scanf("%f",&value);
                value = value*1.8 + 32;
                printf("\n\t\tResult: %f", value);
                printf(" ℉");
                valid = 1;
            }
            else if(unit == 'F') {
                printf("Enter ℉ value > ");
                scanf("%f",&value);
                value = (value-32)/1.8;
                printf("\n\t\tResult: %f", value);
                printf(" ℃");
                valid = 1;
            }
        }
    }

    return 0;
} // int parseOpt(int)

/*
 * Main method
 */
int main () {
    /* Declare variables */
    int opt;
    float value;

    printf("--- Metric <=> Imperial Converter ---\n");
    while(opt != 5) {
        /* Display and input option */
        printf("\n\nPress 1-5 for the following options:\n\n");
        printf("(1) - Kilogram (kg)     <=>     Pound (lb)\n");
        printf("(2) - Litre (L)         <=>     Imperial Gallon (gal)\n");
        printf("(3) - Centimetre (cm)   <=>     Inch (in)\n");
        printf("(4) - Celcius (℃)       <=>     Fahrenheit (℉)\n");
        printf("\n(5) - Exit\n");

        do {
            printf("\nEnter option > ");
            scanf("%d",&opt);
            printf("\n");

            /* Parse input */
            switch(opt) {
                case 1: parseOpt(1);break;
                case 2: parseOpt(2);break;
                case 3: parseOpt(3);break;
                case 4: parseOpt(4);break;
            }
        } while(opt < 1 || opt > 5);
    } // Exit program
    return 0;
} // int main(void)
