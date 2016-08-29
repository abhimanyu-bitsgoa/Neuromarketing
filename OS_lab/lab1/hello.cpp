#include<bits/stdc++.h>
#include <sys/wait.h>
#include <unistd.h>
using namespace std;

int main(){

  int cpid =fork();
  if(cpid==0){
		cout<<"I am the child "<<getpid()<<endl;
 	  //execlp("bin/ls","ls",NULL);
		//execl("/bin/ls", "ls", NULL);
		//exit(0);
	//execl("/bin/sh","sh","test.sh",NULL)

  }
  else{
		wait(NULL);
		cout<<"I am parent "<<getpid()<<endl;
		///cout<<"I am cpid "<<cpid<<endl;
		///cout<<wait(NULL);
		///cout<<"Child Over"<<endl;


  }

  return 0;
}
