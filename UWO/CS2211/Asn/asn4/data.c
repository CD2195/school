/* data.c */
#include <stdio.h>
#include "data.h"

/*
 * Input:   'node': is a node
 * Effect:  node.key is printed and the node.data is printed
 */
void print_node(Node node) {
    printf("%d\t%c\n",node.key,node.data);
}

