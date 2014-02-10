#include <vector>
#include <list>
#include <map>
#include <set>
#include <deque>
#include <stack>
#include <bitset>
#include <algorithm>
#include <functional>
#include <numeric>
#include <utility>
#include <sstream>
#include <iostream>
#include <iomanip>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <ctime>

using namespace std;

class AlienAndSetDiv2 {
public:
	
	int getNumber(int, int);
};

const int MOD = 1000000007;
int K;
 
 
map< set<int, greater<int> >, long > dp[101];
 
long rec(int n, set<int, greater<int> >  unmatched)
{
    map<set<int, greater<int> >, long> :: iterator q = dp[n].find(unmatched);
    long res = 0;
    if (q == dp[n].end()) {
        if (n == 0) {
            if (unmatched.size() == 0) {
                res = 1;
            }
        } else {
            if (unmatched.size() == 0) {
                // we can put n in any of the two sets.
                set<int, greater<int> > se;
                se.insert(n);
                res += ( 2 * rec(n - 1,  se) ) % MOD;
            } else {
                int mx = *unmatched.begin(); //get the largest number in set
                // match n with mx:
               set<int, greater<int> > newset = unmatched;
                newset.erase( newset.begin() );
                res += rec(n - 1, newset);
                 
                // add to the other set.
                if ( mx != n + K) {
                    newset = unmatched;
                    newset.insert(n);
                    res += rec(n - 1, newset);
                }
            }
            res %= MOD;
        }
        dp[n][unmatched] = res;
    } else {
        res = q->second;
    }
    return res;
}

int AlienAndSetDiv2::getNumber(int N, int K1) {
	K = K1;
	set<int, greater<int> > se;
    return rec(2*N, se);
}


double test0() {
	int p0 = 2;
	int p1 = 1;
	AlienAndSetDiv2 * obj = new AlienAndSetDiv2();
	clock_t start = clock();
	int my_answer = obj->getNumber(p0, p1);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p2 = 4;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p2 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p2 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test1() {
	int p0 = 3;
	int p1 = 1;
	AlienAndSetDiv2 * obj = new AlienAndSetDiv2();
	clock_t start = clock();
	int my_answer = obj->getNumber(p0, p1);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p2 = 8;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p2 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p2 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test2() {
	int p0 = 4;
	int p1 = 2;
	AlienAndSetDiv2 * obj = new AlienAndSetDiv2();
	clock_t start = clock();
	int my_answer = obj->getNumber(p0, p1);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p2 = 44;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p2 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p2 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test3() {
	int p0 = 10;
	int p1 = 10;
	AlienAndSetDiv2 * obj = new AlienAndSetDiv2();
	clock_t start = clock();
	int my_answer = obj->getNumber(p0, p1);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p2 = 184756;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p2 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p2 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}

int main() {
	int time;
	bool errors = false;
	
	time = test0();
	if (time < 0)
		errors = true;
	
	time = test1();
	if (time < 0)
		errors = true;
	
	time = test2();
	if (time < 0)
		errors = true;
	
	time = test3();
	if (time < 0)
		errors = true;
	
	if (!errors)
		cout <<"You're a stud (at least on the example cases)!" <<endl;
	else
		cout <<"Some of the test cases had errors." <<endl;
}

//Powered by [KawigiEdit] 2.0!
