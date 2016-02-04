/* bst.c */
#include <stdio.h>
#include <stdlib.h>
#include "bst.h"

/*
 * Input:   'size': size of an array
 * Output:  a pointer of type BStree,
 *          i.e. a pointer to an allocated memory of BStree_struct type
 * Effect:  dynamically allocate memory of type BStree_struct
 *          allocate memory for an int array of size+1 for member tree_nodes
 *          allocate memoery for an unsigned char array of size+1 for member is_free
 *          set all entries of is_free to 1
 *          set member size to 'size'
 */
BStree bstree_ini(int size) {
    BStree bst = (BStree) malloc(sizeof(BStree_struct));
    (*bst).tree_nodes = (Node *) malloc((size+1)*sizeof(int));
    (*bst).is_free = (unsigned char *) malloc((size+1)*sizeof(char));
    int i;
    for(i=0;i<size+1;i++) (*bst).is_free[i] = '1'; 
    (*bst).size = size;
    return bst;
}

/*
 * Input:   'bst': a binary search tree
 *          'key': an integer
 *          'data': a character
 *          'index': an integer that starts at 1 when first called
 * Effect:  'data' with 'key' is inserted into 'bst'
 *          if 'key' is in 'bst', do nothing
 */
void bstree_insert(BStree bst, int key, char data, int index) {
    if(index >= (*bst).size) printf("New node is out of bounds of BST!\n");
    else if(bst->is_free[1] == '1') {
        bst->tree_nodes[index].key = key;
        bst->tree_nodes[index].data = data;
        bst->is_free[index] = '0';
    }
    else if((*bst).is_free[index] == '1') {
        (*bst).tree_nodes[index].key = key;
        (*bst).tree_nodes[index].data = data;
        (*bst).is_free[index] = '0';
    }
    else if(key < (*bst).tree_nodes[index].key) bstree_insert(bst,key,data,2*index);
    else if(key > (*bst).tree_nodes[index].key) bstree_insert(bst,key,data,2*index+1);
}

/*
 * Input:   'bst': a binary search tree
 *          'index': an integer that starts at 1 when first called
 * Effect:  print all the nodes in bst using in order traversal
 */
void bstree_traversal(BStree bst, int index) {
    if(index < (*bst).size) {
        bstree_traversal(bst,2*index); 
        if((*bst).is_free[index] == '0') printf("%d\t%c\n",(*bst).tree_nodes[index].key,(*bst).tree_nodes[index].data); /* Tried to call function from data.h but there was conflict with the Node parameter and the Node function */
        bstree_traversal(bst,2*index+1);
    }
}

/*
 * Input:   'bst': a binary search tree
 * Effect:  all memory used by bst are freed
 */
void bstree_free(BStree bst) {
    free((*bst).tree_nodes);
    free((*bst).is_free);
    free(bst);
} 
