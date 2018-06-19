#ifndef RUMER_BUFFER_H
#define RUMER_BUFFER_H

/*
 * How does a circle buffer work? Its a buffer of a fixed size, and has a read and write position. We write and read values at the next
 * Read or Write position and increment that position. If either position reaches the end of the buffer we start from the beginning
 */

struct rumer_buffer {
    int* values;
    int size;
    int readPosition;
    int writePosition;
    int seec;
};
struct rumer_buffer* allocate_buffer(int size);
int get(struct rumer_buffer* buffer);
void put(struct rumer_buffer* buffer, int value);
void free_buffer(struct rumer_buffer* buffer);
int getSeec(struct rumer_buffer* buffer);

#endif //RUMER_BUFFER_H
