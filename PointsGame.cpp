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

#define two(x) (1 << (x))
#define contains(s, x) ( (s & two(x)) != 0)
using namespace std;

typedef pair<int, int> pl;

class PointsGame {
public:
	double gameValue(vector <int>, vector <int>);
};

vector<int> px;
vector<int> py;

double dist(int x1, int y1, int x2, int y2)
{
	return sqrt( (x1-x2) * ( x1-x2) + (y1-y2) * (y1-y2));
}
double d[12][12];

map<pl, double> mp;
int n;

double solve(int se1, int se2, int side)
{
	if (mp.count(pl(se1, se2)) != 0)
		return mp[pl(se1, se2)];
		
		
	if ( (se1 + se2) == two(n)-1) {
		double ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if ( contains(se1, i) && contains(se2, j) ) {
					ans += d[i][j];
				}	
			}
		}
		return mp[pl(se1, se2)] = ans;
	}
	
	double ans = (side == 0) ? -1e100 : 1e100;
	for (int i = 0; i < n; i++) {
		if ( !contains(se1, i) && !contains(se2, i) )  {
			double ret = solve(se2, se1 | (1 << i), 1 - side);
			if (side == 0)
				ans = max(ans, ret);
			else
				ans = min(ans, ret);	
		} 
	}
	return mp[pl(se1, se2)] = ans;								
}
double PointsGame::gameValue(vector <int> pointsX, vector <int> pointsY) {
	
	px = pointsX;
	py = pointsY;
	 n = pointsX.size();
	mp.clear();
	
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			d[i][j] = dist(px[i], py[i], px[j], py[j]);
		}
	}
			
	return solve(0,0,0);	 		 
}

double test0() {
	int t0[] = {0,0};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {0,1};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	PointsGame * obj = new PointsGame();
	clock_t start = clock();
	double my_answer = obj->gameValue(p0, p1);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	double p2 = 1.0;
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
	int t0[] = {0,0,1,1};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {0,5,0,5};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	PointsGame * obj = new PointsGame();
	clock_t start = clock();
	double my_answer = obj->gameValue(p0, p1);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	double p2 = 12.198039027185569;
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
	int t0[] = {0,0,0,0};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {0,1,5,6};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	PointsGame * obj = new PointsGame();
	clock_t start = clock();
	double my_answer = obj->gameValue(p0, p1);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	double p2 = 12.0;
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
	int t0[] = {0,1,2,3};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {0,0,0,0};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	PointsGame * obj = new PointsGame();
	clock_t start = clock();
	double my_answer = obj->gameValue(p0, p1);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	double p2 = 6.0;
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
