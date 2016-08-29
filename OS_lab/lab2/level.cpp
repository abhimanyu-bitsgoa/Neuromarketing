#include<bits/stdc++.h>
#include <sys/wait.h>
#include <unistd.h>
using namespace std;
int level=0;
bool pr=true;
int main(){
  int check;
  int cpid ;
  int n;
  cin>>n;
  //system("ps");
  for(int i=0;i<n;i++){

    cpid=fork();

    if(cpid==0){

      level++;
      if(i==n-1){
        cout<<"@ level = "<< level<<" PID =  "<<getpid()<<" PPID = "<<getppid()<<endl;
      }

    }
    else{
      wait(NULL);

      if(pr==true){

        cout<<"@ level = "<< level<<" PID =  "<<getpid()<<" PPID = "<<getppid()<<endl;
        //pr=false;
      }


    }

  }

  return 0;
}
