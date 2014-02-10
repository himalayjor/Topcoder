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
#define pl pair<int, int>

class MysticAndCandies {
public:
	int minBoxes(int, int, vector <int>, vector <int>);
};

int MysticAndCandies::minBoxes(int C, int X, vector <int> low, vector <int> high) {
	vector<pl> v;
	for (int i = 0; i < low.size(); i++) {
		v.push_back(pl(low[i], high[i]));
	}
	
	sort(v.rbegin(), v.rend());
	
	int have = 0;
	for (int i = 0; i < v.size(); i++) {
		
		 have += v[i].second;
		 if (have < X)
		 	continue;
		 int sum = 0;
		 for (int j = i+1; j < v.size(); j++) {
		 	sum += v[j].second;
		 }
		 if (sum < C-X)
		 	return i+1;	
	}
	return v.size();
}


double test0() {
	int p0 = 15;
	int p1 = 12;
	int t2[] = {1, 2, 3, 4, 5};
	vector <int> p2(t2, t2+sizeof(t2)/sizeof(int));
	int t3[] = {1, 2, 3, 4, 5};
	vector <int> p3(t3, t3+sizeof(t3)/sizeof(int));
	MysticAndCandies * obj = new MysticAndCandies();
	clock_t start = clock();
	int my_answer = obj->minBoxes(p0, p1, p2, p3);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p4 = 3;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p4 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p4 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test1() {
	int p0 = 60;
	int p1 = 8;
	int t2[] = {5, 2, 3};
	vector <int> p2(t2, t2+sizeof(t2)/sizeof(int));
	int t3[] = {49, 48, 47};
	vector <int> p3(t3, t3+sizeof(t3)/sizeof(int));
	MysticAndCandies * obj = new MysticAndCandies();
	clock_t start = clock();
	int my_answer = obj->minBoxes(p0, p1, p2, p3);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p4 = 2;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p4 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p4 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test2() {
	int p0 = 58;
	int p1 = 30;
	int t2[] = {3, 9, 12, 6, 15};
	vector <int> p2(t2, t2+sizeof(t2)/sizeof(int));
	int t3[] = {8, 12, 20, 8, 15};
	vector <int> p3(t3, t3+sizeof(t3)/sizeof(int));
	MysticAndCandies * obj = new MysticAndCandies();
	clock_t start = clock();
	int my_answer = obj->minBoxes(p0, p1, p2, p3);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p4 = 2;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p4 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p4 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test3() {
	int p0 = 207581165;
	int p1 = 172146543;
	int t2[] = {4725448, 2753824, 6019698, 4199708, 4070001, 3589497, 5358499, 3637585, 5393667, 2837466,
2747807, 2918199, 3638042, 5199002, 3072044, 3858909, 3762101, 3657754, 3218704, 3888861,
3195689, 4768935, 3137633, 4124272, 4125056, 6087486, 3632970, 3620489, 2748765, 5917493,
3958996, 3335021, 3517186, 5543440, 2951006, 3403270, 3299481, 3093204, 4092331};
	vector <int> p2(t2, t2+sizeof(t2)/sizeof(int));
	int t3[] = {5702812, 6805664, 6823687, 5337687, 4286533, 4999849, 6567411, 4563235, 6618139, 6260135,
6249469, 3821449, 5963157, 6385012, 4255959, 5786920, 6112817, 4103918, 6371537, 4231698,
3409172, 6806782, 5623563, 4511221, 6407338, 6491490, 5209517, 6076093, 6530132, 6111464,
5833839, 6253088, 5595160, 6236805, 5772388, 5285713, 5617002, 4650978, 5234740};
	vector <int> p3(t3, t3+sizeof(t3)/sizeof(int));
	MysticAndCandies * obj = new MysticAndCandies();
	clock_t start = clock();
	int my_answer = obj->minBoxes(p0, p1, p2, p3);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p4 = 31;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p4 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p4 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test4() {
	int p0 = 43873566;
	int p1 = 32789748;
	int t2[] = {2053198, 2175819, 4260803, 1542497, 1418952, 5000015, 1381849, 2462882, 6466891, 1827580, 6943641, 5775477};
	vector <int> p2(t2, t2+sizeof(t2)/sizeof(int));
	int t3[] = {2827461, 3726335, 5410505, 4781355, 4925909, 5621160, 7325774, 5025476, 7876037, 8072075, 6979462, 6647628};
	vector <int> p3(t3, t3+sizeof(t3)/sizeof(int));
	MysticAndCandies * obj = new MysticAndCandies();
	clock_t start = clock();
	int my_answer = obj->minBoxes(p0, p1, p2, p3);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p4 = 7;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p4 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p4 != my_answer) {
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
