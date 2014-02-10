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

#define two(x) (1 << (x))
#define contains(s,x) ((s & two(x)) != 0)
#define ll long long

#define pl pair<int, int>

class CollectingPostmarks {
public:
	int amountOfMoney(vector <int>, vector <int>, vector <int>, int);
};

vector<pl> getL(int low, int high, vector<int> &price, vector<int> &value)
{
	vector<pl> ret;
	int n = (high - low);
	
	for (int se = 0; se < two(n); se++) {
		int pr = 0, val = 0;
		for (int j = 0; j < n; j++) {
			if (contains(se, j)) {
				pr += price[low + j];
				val += value[low + j];
				
			}
		}
		ret.push_back(pl(val, pr));
	}
	return ret;
}

int CollectingPostmarks::amountOfMoney(vector <int> prices, vector <int> have, vector <int> values, int K) {
	
		int n = prices.size();
		
		int tot = 0;
		for (int i = 0; i < prices.size(); i++) {
			tot += values[i];
		}
		cout << tot << endl;	
		if (tot < K)
			return -1;
		
		int money = 0;
		for (int i = 0; i < have.size(); i++) {
			money += prices[have[i]];
		}
		if (money >= K)
			return 0;
					
		vector<pl> vx = getL(0, n/2, prices, values);
		vector<pl> 	vy = getL(n/2, n, prices, values);
		
		
		sort(vx.begin(), vx.end());
		sort(vy.begin(), vy.end());
		
		ll ans = (ll)(1e12);
		ll mi = (ll)(1e10);
		
		int pos = vy.size()-1;
		
		for (int i = 0; i < vx.size(); i++) {
			
			while (pos >= 0 && vy[pos].first + vx[i].first >= K) {
				mi = min(mi, (ll)vy[pos--].second);
			}
			
			ans = min(ans, mi + vx[i].second);
		}
		
		
			
		return max(ans - money, 0ll);
}


double test0() {
	int t0[] = {2,15};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	vector <int> p1;
	int t2[] = {2,21};
	vector <int> p2(t2, t2+sizeof(t2)/sizeof(int));
	int p3 = 13;
	CollectingPostmarks * obj = new CollectingPostmarks();
	clock_t start = clock();
	int my_answer = obj->amountOfMoney(p0, p1, p2, p3);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p4 = 15;
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
	int t0[] = {9,18,7,6,18};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {4,0};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	int t2[] = {12,27,10,10,25};
	vector <int> p2(t2, t2+sizeof(t2)/sizeof(int));
	int p3 = 67;
	CollectingPostmarks * obj = new CollectingPostmarks();
	clock_t start = clock();
	int my_answer = obj->amountOfMoney(p0, p1, p2, p3);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p4 = 22;
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
	int t0[] = {14,14,12,6};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {3,2,1};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	int t2[] = {19,23,20,7};
	vector <int> p2(t2, t2+sizeof(t2)/sizeof(int));
	int p3 = 10;
	CollectingPostmarks * obj = new CollectingPostmarks();
	clock_t start = clock();
	int my_answer = obj->amountOfMoney(p0, p1, p2, p3);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p4 = 0;
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
	int t0[] = {43,33,14,31,42,37,17,42,40,20};
	vector <int> p0(t0, t0+sizeof(t0)/sizeof(int));
	int t1[] = {6};
	vector <int> p1(t1, t1+sizeof(t1)/sizeof(int));
	int t2[] = {116,71,38,77,87,106,48,107,91,41};
	vector <int> p2(t2, t2+sizeof(t2)/sizeof(int));
	int p3 = 811;
	CollectingPostmarks * obj = new CollectingPostmarks();
	clock_t start = clock();
	int my_answer = obj->amountOfMoney(p0, p1, p2, p3);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p4 = -1;
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
	
	if (!errors)
		cout <<"You're a stud (at least on the example cases)!" <<endl;
	else
		cout <<"Some of the test cases had errors." <<endl;
}

//Powered by [KawigiEdit] 2.0!
