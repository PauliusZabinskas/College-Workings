

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "linkedList.h"



//Creates a new linked list element with given content of size
//Returns a pointer to the element
listElement* createEl((void*) data, size_t size){
    listElement* e = malloc(sizeof(listElement));
    if(e == NULL){
    //malloc has had an error
    return NULL; //return NULL to indicate an error.
    }
    char* dataPointer = malloc(sizeof(char)*size);
    if(dataPointer == NULL){
        //malloc has had an error
        free(e); //release the previously allocated memory
        return NULL; //return NULL to indicate an error.
    }
    strcpy(dataPointer, data);
    e->data = dataPointer;
    e->size = size;
    e->next = NULL;
    return e;
}
//Prints out each element in the list
void traverse(listElement* start){
    listElement* current = start;
    while(current != NULL){
    printf("%s\n", current->data);
    current = current->next;
    }
}
//Inserts a new element after the given el
//Returns the pointer to the new element
listElement* insertAfter(listElement* el, char* data, size_t size){
    listElement* newEl = createEl(data, size);
    listElement* next = el->next;
    newEl->next = next;
    el->next = newEl;
    return newEl;
}
//Delete the element after the given el
void deleteAfter(listElement* after){
    listElement* delete = after->next;
    listElement* newNext = delete->next;
    after->next = newNext;
    //need to free the memory because we used malloc
    free(delete->data);
    free(delete);
}

// Returns the number of elements in a linked list.
int length(listElement* list) {
    int count = 0;
    while (list != NULL) {
        count++;
        list = list->next;
    }
    return count;
}

// Push a new element onto the head of a list.
void push(listElement** list, char* data, size_t size) {
    listElement* newHead = createEl(data, size);
    newHead->next = *list;
    *list = newHead;
}

// Pop an element from the head of a list.
listElement* pop(listElement** list) {
    if (*list == NULL) return NULL;
    listElement* oldHead = *list;
    *list = (*list)->next;
    oldHead->next = NULL;  // Detach the old head from the list
    return oldHead;
}

// Enqueue a new element onto the head of the list.
void enqueue(listElement** list, char* data, size_t size) {
    push(list, data, size);  // Reusing push functionality as enqueue to head is same as push
}

// Dequeue an element from the tail of the list.
listElement* dequeue(listElement* list) {
    if (list == NULL || list->next == NULL) return NULL;  // Empty or single-element list
    listElement* prev = NULL;
    listElement* tail = list;
    while (tail->next != NULL) {
        prev = tail;
        tail = tail->next;
    }
    if (prev != NULL) {
        prev->next = NULL;  // Detach the last element
    }
    return tail;
}
