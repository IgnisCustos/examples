#include "stdio.h"
#include <stdlib.h>
#include "rumer_buffer.h"

int doingRumerSearch(int amount, int bufferSize){
    struct rumer_buffer* buffer = allocate_buffer(bufferSize);
    for(int i = 0;i<amount;i++){
        get(buffer);
        put(buffer,0);
        get(buffer);
    }
    int seec = getSeec(buffer);
    free_buffer(buffer);
    return seec;
}

void doingSystemTest(){
    printf("-----------------------------------\n");
    printf(" !!!  SYSTEM TEST:        START !!!\n");
    printf("-----------------------------------\n");
    struct rumer_buffer* buffer = allocate_buffer(10);
    for(int i = 0;i<100;i++){
        get(buffer);
        put(buffer,0);
        get(buffer);
    }
    put(buffer,1);
    get(buffer);
    int seec = getSeec(buffer);
    free_buffer(buffer);

    printf("FAKE Single Event Effects: %d\n", seec);
    printf("-----------------------------------\n");
    printf(" !!!  SYSTEM TEST:          END !!!\n");
    printf("-----------------------------------\n\n\n");
}


int main(int argc, char** argv) {

    if(argc<4){
        printf("usage: ./rumer <runs> <storedZerosPerRun> <bufferSize>\n");
        exit(1);
    }

    int runs;
    sscanf (argv[1],"%d",&runs);

    int storedPerRun;
    sscanf (argv[2],"%d",&storedPerRun);

    int bufferSize;
    sscanf (argv[3],"%d",&bufferSize);

    int seecOverall=0;

    if(argv[4]!=NULL)
            doingSystemTest();


    printf("-----------------------------------\n");
    printf(" Settings:\n");
    printf("-----------------------------------\n");
    printf("Runs: %s\n",argv[1]);
    printf("Stored zeros per run: %s\n",argv[2]);
    printf("Buffer size: %s\n",argv[3]);
    printf("-----------------------------------\n");

    printf("Rumer started . . .\n");
    for (int i=0;i<runs;i++){
        int seec = doingRumerSearch(storedPerRun, bufferSize);
        if(seec!=0)
            printf("SEEC!: %d occured in run #%d\n", seec,i);
        seecOverall= seecOverall+seec;
        if((i%1000)==0)
            printf("Finished run number: %d\n", i);
    }
    printf("-----------------------------------\n");
    printf(" Results:\n");
    printf("-----------------------------------\n");
    printf("Total stored values: %d\n", runs*storedPerRun);
    printf("Single Event Effects: %d\n", seecOverall);
    printf("-----------------------------------\n");
}





