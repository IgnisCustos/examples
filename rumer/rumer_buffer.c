#include "rumer_buffer.h"
#include "stdio.h"
#include "stdlib.h"
#include "string.h"

struct rumer_buffer* allocate_buffer(int size) {
    struct rumer_buffer* buffer = (struct rumer_buffer*)malloc(sizeof(struct rumer_buffer));
    int* innerBuffer = (int*)malloc(sizeof(int)*size);
    memset(innerBuffer,0, sizeof(int)*size);
    buffer->values=innerBuffer;
    buffer->size=size;
    buffer->readPosition=0;
    buffer->writePosition=0;
    buffer->seec=0;
    return buffer;
}
void singleEventEffect(struct rumer_buffer* buffer, int value)
{
    buffer->seec=buffer->seec+1;
    printf("Single Event Effect: %d\n",value);
}

int getSeec(struct rumer_buffer* buffer)
{
    return buffer->seec;
}

int get(struct rumer_buffer* buffer) {
    int value = buffer->values[buffer->readPosition];
    buffer->readPosition=buffer->readPosition+1;
    if(buffer->readPosition>=buffer->size)
        buffer->readPosition=0;
    if (value!=0)
	    singleEventEffect(buffer,value);
    return value;
}
void put(struct rumer_buffer* buffer, int value) {
    buffer->values[buffer->writePosition]=value;
    buffer->writePosition=buffer->writePosition+1;
    if(buffer->writePosition>=buffer->size)
        buffer->writePosition=0;
}
void free_buffer(struct rumer_buffer* buffer) {
    free(buffer->values);
    free(buffer);
}

