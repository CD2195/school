#include<stdio.h>

main()
{
char b;
b = getchar();
while(b=='\n')
	{b=getchar();}
printf("%c\n",b);
}
