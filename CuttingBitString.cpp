

#include <string>
#include <iostream>

using namespace std;

#define FOR(i,a,b) for (int i = a; i <= b; i++)

class CuttingBitString {
public:
	bool check(string s) {
		//valid segment must not has a leading zero
		if (s[0] == '0') return false;

		long long t = 0;
		int sz = s.size();

		//calculate the value of s in decimal
		FOR (i, 0, sz - 1)
			t = t * 2 + (s[i] == '1');

		//try to divide s by 5 when it is possible
		while ((t % 5) == 0) t /= 5;

		return t == 1;
	}

	int getmin(string s) {
		//n is length of s
		int n = s.size();
		//the f array in dynamic program
		int f[100];

		FOR (i, 0, n - 1) {
			f[i] = -1;

			//if the prefix of i + 1 first characters of s is a power of 5 in binary
			//and not leading by 0, f[i] = 1.
			if (check(s.substr(0, i + 1))) {
				f[i] = 1;

			}
                        else {
			   // try the possibilities of the last part of s
			     FOR (j, 1, i)
				 	if (check(s.substr(j, i - j + 1)) && f[j - 1] != -1)
				 		if (f[i] == -1 || f[i] > f[j - 1] + 1)
				 			f[i] = f[j - 1] + 1;
                       }
		}

		return f[n - 1];
	}
};

Altern


double test0() {
	string p0 = "101101101";
	CuttingBitString * obj = new CuttingBitString();
	clock_t start = clock();
	int my_answer = obj->getmin(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p1 = 3;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p1 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
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
	string p0 = "1111101";
	CuttingBitString * obj = new CuttingBitString();
	clock_t start = clock();
	int my_answer = obj->getmin(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p1 = 1;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p1 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
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
	string p0 = "00000";
	CuttingBitString * obj = new CuttingBitString();
	clock_t start = clock();
	int my_answer = obj->getmin(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p1 = -1;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p1 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
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
	string p0 = "110011011";
	CuttingBitString * obj = new CuttingBitString();
	clock_t start = clock();
	int my_answer = obj->getmin(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p1 = 3;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p1 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
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
	string p0 = "1000101011";
	CuttingBitString * obj = new CuttingBitString();
	clock_t start = clock();
	int my_answer = obj->getmin(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p1 = -1;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p1 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
	if (p1 != my_answer) {
		cout <<"DOESN'T MATCH!!!!" <<endl <<endl;
		return -1;
	}
	else {
		cout <<"Match :-)" <<endl <<endl;
		return (double)(end-start)/CLOCKS_PER_SEC;
	}
}
double test5() {
	string p0 = "111011100110101100101110111";
	CuttingBitString * obj = new CuttingBitString();
	clock_t start = clock();
	int my_answer = obj->getmin(p0);
	clock_t end = clock();
	delete obj;
	cout <<"Time: " <<(double)(end-start)/CLOCKS_PER_SEC <<" seconds" <<endl;
	int p1 = 5;
	cout <<"Desired answer: " <<endl;
	cout <<"\t" << p1 <<endl;
	cout <<"Your answer: " <<endl;
	cout <<"\t" << my_answer <<endl;
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
	
	time = test5();
	if (time < 0)
		errors = true;
	
	if (!errors)
		cout <<"You're a stud (at least on the example cases)!" <<endl;
	else
		cout <<"Some of the test cases had errors." <<endl;
}

//Powered by [KawigiEdit] 2.0!
