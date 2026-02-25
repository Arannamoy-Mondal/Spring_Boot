#include<bits/stdc++.h>
using namespace std;

int binaryExp(long long a,long long b,long long m){
    long long res=1;
    a=a%m;
    while(b>0){
        if(b%2!=0){
            res=(res*a)%m;
        }
        a=(a*a)%m;
        b/=2;
    }
    return res;
}

int main(){
    long long a,b,m;
    cin>>a>>b>>m;
    cout<<binaryExp(a,b,m);
}