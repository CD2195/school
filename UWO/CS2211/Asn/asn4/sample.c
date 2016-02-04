/* sample.c - sample main program */
#include <stdio.h>
#include "bst.h"

int main() {
    
    BStree bst;

    bst = bstree_ini(1000);

    bstree_insert(bst,6,'a',1);
    bstree_insert(bst,3,'b',1);
    bstree_insert(bst,9,'b',1);
    bstree_insert(bst,4,'c',1);
    bstree_insert(bst,6,'b',1);
    bstree_insert(bst,20,'d',1);
    bstree_insert(bst,1,'e',1);

    bstree_traversal(bst,1);

    bstree_free(bst);
}

