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

using namespace std;

class CubeStickers {
public:
	string isPossible(vector <string>);
};

bool cube[6];
int X[6] = {0, 5, 1, 4, 2 ,3};

void fill_cube(int n, int color)
{
	if (n == 0)
		return ;
	
	if (n == 1) {
		for (int i = 0; i < 6; i++) {
			int col = X[i];
			if (cube[col] == false) {
				cube[col] = true;
				return;
			}
		}
	}
	
	if (n > 1) {
		
		if (cube[0] == false && cube[5] == false) {
			cube[0] = cube[5] = true;
			return;
		}
		if (cube[1] == false && cube[4] == false) {
			cube[1] = cube[4] = true;
			return;
		}
		if (cube[2] == false && cube[3] == false) {
			cube[2] = cube[3] = true;
			return;
		}
			
		for (int i = 0; i < 6; i++) {
			int col = X[i];
			if (cube[col] == false) {
				cube[col] = true;
				return;
			}
		}
		
	}
	return;
}
string CubeStickers::isPossible(vector <string> sticker) {
	map<string, int> mp;
	for (int i = 0; i < sticker.size(); i++) {
		mp[sticker[i]]++;
	}
	
	map<string, int> :: iterator it;
	memset(cube, false, sizeof(cube));
	
	int color = 1;
	for (it = mp.begin(); it != mp.end(); it++) {
		fill_cube(it->second, color++);
	}
	
	for (int i = 0; i < 6; i++) {
		if (cube[i] == false)
			return "NO";
	}
	
	return "YES";
}


double test0() {
	string t0[] = {"cyan","magenta","yellow","purple","black","white","purple"};
	vector <string> p0(t0, t0+sizeof(t0)/sizeof(string));
	CubeStickers * obj = new CubeStickers();
	clock_t start = clock();
	string my_answer = obj->isPossible(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	string p1 = "YES";
	cout <<"Desired answer: " <<endl;
	cout <<"\t\"" << p1 <<"\"" <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t\"" << my_answer<<"\"" <<endl;
	if (p1 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test1() {
	string t0[] = {"blue","blue","blue","blue","blue","blue","blue","blue","blue","blue"};
	vector <string> p0(t0, t0+sizeof(t0)/sizeof(string));
	CubeStickers * obj = new CubeStickers();
	clock_t start = clock();
	string my_answer = obj->isPossible(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	string p1 = "NO";
	cout <<"Desired answer: " <<endl;
	cout <<"\t\"" << p1 <<"\"" <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t\"" << my_answer<<"\"" <<endl;
	if (p1 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test2() {
	string t0[] = {"red","yellow","blue","red","yellow","blue","red","yellow","blue"};
	vector <string> p0(t0, t0+sizeof(t0)/sizeof(string));
	CubeStickers * obj = new CubeStickers();
	clock_t start = clock();
	string my_answer = obj->isPossible(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	string p1 = "YES";
	cout <<"Desired answer: " <<endl;
	cout <<"\t\"" << p1 <<"\"" <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t\"" << my_answer<<"\"" <<endl;
	if (p1 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test3() {
	string t0[] = {"purple","orange","orange","purple","black","orange","purple"};
	vector <string> p0(t0, t0+sizeof(t0)/sizeof(string));
	CubeStickers * obj = new CubeStickers();
	clock_t start = clock();
	string my_answer = obj->isPossible(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	string p1 = "NO";
	cout <<"Desired answer: " <<endl;
	cout <<"\t\"" << p1 <<"\"" <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t\"" << my_answer<<"\"" <<endl;
	if (p1 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test4() {
	string t0[] = {"white","gray","green","blue","yellow","red","target","admin"};
	vector <string> p0(t0, t0+sizeof(t0)/sizeof(string));
	CubeStickers * obj = new CubeStickers();
	clock_t start = clock();
	string my_answer = obj->isPossible(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	string p1 = "YES";
	cout <<"Desired answer: " <<endl;
	cout <<"\t\"" << p1 <<"\"" <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t\"" << my_answer<<"\"" <<endl;
	if (p1 != my_answer) {
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
