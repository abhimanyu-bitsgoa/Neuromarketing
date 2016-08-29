#include<bits/stdc++.h>
using namespace std;

int main(){
		int n;
		cin>>n;
int temp=n;
		int sum=0;
		while(n--){
			sum++;
		}
		cout<<"Parent runs "<<sum<<endl;
		cout<<"Child run "<<temp-sum<<endl;


  return 0;
}
