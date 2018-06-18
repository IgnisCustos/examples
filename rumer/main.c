#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>
#include "rumer_buffer.h"

int doingRumerSearch(int amount, int bufferSize, int milliseconds){
    struct rumer_buffer* buffer = allocate_buffer(bufferSize);
    for(int i = 0;i<amount;i++){
        usleep(milliseconds*1000); //200 ms
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


const char* addTime()
{
  time_t rawtime;
  struct tm * timeinfo;

  time ( &rawtime );
  timeinfo = localtime ( &rawtime );
  return asctime(timeinfo);
}

int main(int argc, char** argv) {

    if(argc<6){
        printf("usage: ./rumer <runs> <storedZerosPerRun> <bufferSize> <output after n runs> <milliseconds sleep> <systemtest> \n");
        exit(1);
    }

    int runs;
    sscanf (argv[1],"%d",&runs);

    int storedPerRun;
    sscanf (argv[2],"%d",&storedPerRun);

    int bufferSize;
    sscanf (argv[3],"%d",&bufferSize);

    int outPutter;
    sscanf (argv[4],"%d",&outPutter);

    int milliseconds;
    sscanf (argv[5],"%d",&milliseconds);

    if(argv[6]!=NULL)
            doingSystemTest();
    int seecOverall=0;

    printf("-----------------------------------\n");
    printf(" Settings:\n");
    printf("-----------------------------------\n");
    printf("Runs: %d\n",runs);
    printf("Stored zeros per run: %d\n",storedPerRun);
    printf("Buffer size: %d\n",bufferSize);
    printf("Output after: %d runs\n",outPutter);
    printf("Sleep between 1 read/write: %d ms \n",milliseconds);
    printf("-----------------------------------\n");

    printf("Rumer started . . .\n");
    for (int i=0;i<runs;i++){
        int seec = doingRumerSearch(storedPerRun, bufferSize, milliseconds);
        if(seec!=0)
            printf("SEEC!: %d occured in run #%d\n", seec,i);
        seecOverall= seecOverall+seec;
        if((i%outPutter)==0){
            printf("\n\n%s Finished run number: %d\n",addTime(), i);
        }
    }
    printf("-----------------------------------\n");
    printf(" Results:\n");
    printf("-----------------------------------\n");
    printf("Total stored values: %d\n", runs*storedPerRun);
    printf("Single Event Effects: %d\n", seecOverall);
    printf("-----------------------------------\n");
}





