#include<bits/stdc++.h>
#include <sys/wait.h>
#include <unistd.h>

using namespace std;

int main(){
  int n;
  cin>>n;
  int cpid ;
cout<<"@ i = "<< 0<<" PID =  "<<getpid()<<" PPID = "<<getppid()<<endl;
  for(int i=0;i<n;i++){

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
