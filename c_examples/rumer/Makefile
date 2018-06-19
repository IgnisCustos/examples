
OBJECTS = 
CFLAGS = -std=c99 -g -Wall  
LDLIBS = 
CC=gcc


all: main

rumer_buffer.o: rumer_buffer.c
	$(CC) $(CFLAGS) $(LDLIBS) -c rumer_buffer.c

main.o: main.c
	$(CC) $(CFLAGS) $(LDLIBS) -c main.c

main: rumer_buffer.o main.o
	$(CC) $(CFLAGS) $(LDLIBS) rumer_buffer.o main.o -o rumer


clean:
	rm -f *.o rumer

