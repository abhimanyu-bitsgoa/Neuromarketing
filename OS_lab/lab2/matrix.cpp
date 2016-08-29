#include<bits/stdc++.h>
#include <unistd.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/shm.h>
#include <sys/wait.h>
//Matrix multiprocessor
using namespace std;

int matrix1[3][3] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
int matrix2[3][3] = {{10, 11, 12}, {13, 14, 15}, {16, 17, 18}};
int result[3][3];
int main(){
  key_t key = ftok("/home/aronzx/Desktop/OS_lab/OS1/q3.cpp", 0xff);
  int id = shmget(key, sizeof(int) * 3, 0644 | IPC_CREAT);
  int *shared_memory;
  int cpid;

  for(int k=0;k<3;k++){

  for(int i =0;i<3;i++){

    int j=-1;
    cpid=fork();

    if(cpid==0){
      // first child
      j++;
      cpid=fork();

      if(cpid==0){
        //Second child
        j++;
        cpid=fork();

        if(cpid==0){
          //Third child
          j++;
           shared_memory = (int *) shmat(id, NULL, 0);
			    *(shared_memory + j) = matrix1[k][j] * matrix2[j][i];
          wait(NULL);
          exit(0);
        }

        //Code for calc 2 child
        else{
         shared_memory = (int *) shmat(id, NULL, 0);
        *(shared_memory + j) = matrix1[k][j] * matrix2[j][i];
        wait(NULL);
        exit(0);
      }
      }
      //Code for calc 1 child
      else{
       shared_memory = (int *) shmat(id, NULL, 0);
      *(shared_memory + j) = matrix1[k][j] * matrix2[j][i];
      wait(NULL);
      exit(0);
    }
    }
    else{
      wait(NULL);
      //Code to add the 3 values;
       shared_memory = (int *) shmat(id, NULL, 0);
      result[k][i]=*(shared_memory+0)+*(shared_memory+1)+*(shared_memory+2);
      //cout<<k<<" "<<i<<" = "<<result[k][i]<<endl;
    }

  }

}

for(int i=0;i<3;i++){
  for(int j=0;j<3;j++){
    cout<<result[i][j]<<" ";
  }
  cout<<endl;
}
shmdt(shared_memory);
  return 0;
}
