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
#include <cstring>
#include <string>

using namespace std;

class PilingRectsDiv2 {
public:
	int getmax(vector <int>, vector <int>, int);
};

int PilingRectsDiv2::getmax(vector <int> X, vector <int> Y, int limit) {

		int n = X.size();
		int dp[201][201];
		memset(dp, 0, sizeof(dp));
		
		for (int i = 0; i < n; i++) {
			int x = max(X[i], Y[i]);
			int y = min(X[i], Y[i]);
			for (int k = 1; k < x+1; k++) {
				for (int j = 1; j < y+1; j++)
					dp[k][j]++;
			}
		}
		
		int res = 0;
		for (int i = 1; i < 201; i++) {
			for (int j = 1; j < 201; j++) {
				if (i*j >= limit)
					res = max(res, dp[i][j]);
			}
		}
		return (res == 0) ? -1 : res;
}
	
	

//Powered by [KawigiEdit] 2.0!



double test0() {
	int t0[] = {1,2,3,1};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {3,2,4,4};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	int p2 = 3;
	PilingRectsDiv2 * obj = new PilingRectsDiv2();
	clock_t start = clock();
	int my_answer = obj->getmax(p0, p1, p2);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p3 = 3;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p3 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p3 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test1() {
	int t0[] = {4,7};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {7,4};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	int p2 = 25;
	PilingRectsDiv2 * obj = new PilingRectsDiv2();
	clock_t start = clock();
	int my_answer = obj->getmax(p0, p1, p2);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p3 = 2;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p3 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p3 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test2() {
	int t0[] = {10};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {10};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	int p2 = 9999;
	PilingRectsDiv2 * obj = new PilingRectsDiv2();
	clock_t start = clock();
	int my_answer = obj->getmax(p0, p1, p2);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p3 = -1;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p3 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p3 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test3() {
	int t0[] = {10};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {3};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	int p2 = 30;
	PilingRectsDiv2 * obj = new PilingRectsDiv2();
	clock_t start = clock();
	int my_answer = obj->getmax(p0, p1, p2);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p3 = 1;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p3 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p3 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test4() {
	int t0[] = {3,6,5,8,2,9,14};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {14,6,13,8,15,6,3};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	int p2 = 27;
	PilingRectsDiv2 * obj = new PilingRectsDiv2();
	clock_t start = clock();
	int my_answer = obj->getmax(p0, p1, p2);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p3 = 4;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p3 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p3 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test5() {
	int t0[] = {121,168,86,106,36,10,125,97,53,26,148,129,41,18,173,55,13,73,91,174,177,190,28,164,122,92,5,26,58,188,14,67,48,196,41,94,24,89,54,117,12,6,155,103,200,128,184,29,92,149};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {199,182,43,191,2,145,15,53,38,37,61,45,157,129,119,123,177,178,183,188,132,108,112,137,92,59,75,196,102,152,114,121,181,93,32,3,24,116,4,163,96,159,196,43,59,150,79,113,20,146};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	int p2 = 5345;
	PilingRectsDiv2 * obj = new PilingRectsDiv2();
	clock_t start = clock();
	int my_answer = obj->getmax(p0, p1, p2);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p3 = 24;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p3 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p3 != my_answer) {
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
	
	time = test4();
	if (time < 0)
		errors = true;
	
	time = test5();
	if (time < 0)
		errors = true;
	
	if (!errors)
		cout <<"You're a stud (at least on the example cases)!" <<endl;
	else
		cout <<"Some of the test cases had errors." <<endl;
}
