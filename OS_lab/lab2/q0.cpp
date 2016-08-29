#include<bits/stdc++.h>
#include <sys/wait.h>
#include <unistd.h>

using namespace std;

int main(){

  int cpid ;
cout<<"@ i = "<< 0<<" PID =  "<<getpid()<<" PPID = "<<getppid()<<endl;
  for(int i=0;i<3;i++){

    cpid=fork();

    if(cpid==0){

        cout<<"@ i = "<< i<<" PID =  "<<getpid()<<" PPID = "<<getppid()<<endl;

    }
    else{
      wait(NULL);

        //cout<<"@ i = "<< i<<" PID =  "<<getpid()<<" PPID = "<<getppid()<<endl;

    }

  }

  return 0;
}
