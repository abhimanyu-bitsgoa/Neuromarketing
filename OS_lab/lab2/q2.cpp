#include<bits/stdc++.h>
#include <sys/wait.h>
#include <unistd.h>
using namespace std;
int level=0;
int parentid=getpid();
int pr=1;
int main(){
  int check;
  int cpid ;

  for(int i=0;i<3;i++){

    cpid=fork();
    if(cpid==0){

      level++;
        if(i==2)
        cout<<"@ level = "<< level<<" PID =  "<<getpid()<<" PPID = "<<getppid()<<" i= "<< i<<endl;

    }

    else{

      wait(NULL);


    if(getpid()==parentid){
      if(pr){
        cout<<"Condolences: 2 Grandchildren died "<<endl;

      }
      pr=0;
        cout<<"@ level = "<< level<<" PID =  "<<getpid()<<" PPID = "<<getppid()<<" i= "<< i<<endl;
        //exit(1);

      }
      else{
        cout<<"@ level = "<< level<<" PID =  "<<getpid()<<" PPID = "<<getppid()<<" i= "<< i<<endl;
      }

    }


  }

  return 0;
}
