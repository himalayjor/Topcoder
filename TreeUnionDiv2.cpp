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

class TreeUnionDiv2 {
public:
	int maximumCycles(vector <string>, vector <string>, int);
};

int TreeUnionDiv2::maximumCycles(vector <string> tree1, vector <string> tree2, int K) {
		int n = tree1.size();
		int t2[10][10];
		int inf = 100;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) 
				t2[i][j] = inf;
		}		
			
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				
				if (tree2[i][j] == 'X') {
					t2[i][j] = 1;
					t2[j][i] = 1;
				}
				
			}
			t2[i][i] = 0;
		}
		
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					t2[i][j] = max(t2[i][j], t2[i][k] + t2[k][j]);
				}
			}
		}
		
		int mp[10];
		vector<int> v;
		for (int i = 0; i < n; i++)
			v.push_back(i);
		
		int res = 0;
		do {
			for (int i = 0; i < n; i++)
				mp[i] = v[i];
			int ans = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (tree1[i][j] == 'X') {
						int x = mp[i];
						int y = mp[j];
						int tmp = 3 + t2[x][y];
						if (tmp == K)
							ans++;
					}
				}
			}
			res = max(res, ans/2);		
		}while (next_permutation(v.begin(), v.end());		
		
		return res;
}


double test0() {
	string t0[] = {"-X",
 "X-"}
;
	vector <string> p0(t0, t0+sizeof(t0)/sizeof(string));
	string t1[] = {"-X",
 "X-"}
;
	vector <string> p1(t1, t1+sizeof(t1)/sizeof(string));
	int p2 = 4;
	TreeUnionDiv2 * obj = new TreeUnionDiv2();
	clock_t start = clock();
	int my_answer = obj->maximumCycles(p0, p1, p2);
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
double test1() {
	string t0[] = {"-X-",
 "X-X",
 "-X-"}
;
	vector <string> p0(t0, t0+sizeof(t0)/sizeof(string));
	string t1[] = {"-X-",
 "X-X",
 "-X-"}
;
	vector <string> p1(t1, t1+sizeof(t1)/sizeof(string));
	int p2 = 5;
	TreeUnionDiv2 * obj = new TreeUnionDiv2();
	clock_t start = clock();
	int my_answer = obj->maximumCycles(p0, p1, p2);
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
	string t0[] = {"-X-",
 "X-X",
 "-X-"};
	vector <string> p0(t0, t0+sizeof(t0)/sizeof(string));
	string t1[] = {"-X-",
 "X-X",
 "-X-"};
	vector <string> p1(t1, t1+sizeof(t1)/sizeof(string));
	int p2 = 3;
	TreeUnionDiv2 * obj = new TreeUnionDiv2();
	clock_t start = clock();
	int my_answer = obj->maximumCycles(p0, p1, p2);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p3 = 0;
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
	string t0[] = {"-X---",
 "X-XXX",
 "-X---",
 "-X---",
 "-X---"}
;
	vector <string> p0(t0, t0+sizeof(t0)/sizeof(string));
	string t1[] = {"-X-X-",
 "X-X-X",
 "-X---",
 "X----",
 "-X---"}
;
	vector <string> p1(t1, t1+sizeof(t1)/sizeof(string));
	int p2 = 6;
	TreeUnionDiv2 * obj = new TreeUnionDiv2();
	clock_t start = clock();
	int my_answer = obj->maximumCycles(p0, p1, p2);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p3 = 5;
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
	string t0[] = {"-XX------",
 "X------X-",
 "X--XX-X--",
 "--X--X---",
 "--X------",
 "---X----X",
 "--X------",
 "-X-------",
 "-----X---"}

;
	vector <string> p0(t0, t0+sizeof(t0)/sizeof(string));
	string t1[] = {"-X-------",
 "X-X------",
 "-X-XX----",
 "--X---X--",
 "--X--X---",
 "----X--XX",
 "---X-----",
 "-----X---",
 "-----X---"}
;
	vector <string> p1(t1, t1+sizeof(t1)/sizeof(string));
	int p2 = 7;
	TreeUnionDiv2 * obj = new TreeUnionDiv2();
	clock_t start = clock();
	int my_answer = obj->maximumCycles(p0, p1, p2);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p3 = 17;
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
	
	if (!errors)
		cout <<"You're a stud (at least on the example cases)!" <<endl;
	else
		cout <<"Some of the test cases had errors." <<endl;
}

//Powered by [KawigiEdit] 2.0!
