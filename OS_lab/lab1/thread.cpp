#include<bits/stdc++.h>
#include <sys/wait.h>
#include <unistd.h>
// To print when child came first or vice versa
using namespace std;
int parent=0;
int child=0;
int output=0;
int main(){
	
//std::cout.setf(std::ios::unitbuf);

  //for(int i=0;i<200;i++){
    parent=0;
    child=0;
    int cpid =vfork();
  if(cpid==0){
    //cout<<"The child of dad "<<getpid()<<endl;
    if(parent!=1)
      child++;

    exit(0);
  }
  else{
    //cout<<"My child is "<<cpid<<endl;

    if(child!=1)
      parent++;
	wait(NULL);
  //  exit(0);
  }
  if(parent==1)
    output++;
//}
  cout<<output<<endl;
  return 0;
}
