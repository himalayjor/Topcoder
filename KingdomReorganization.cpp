// By Himalay Joriwal


#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <set>
#include <cstring>
#include <algorithm>
#include <sstream>
#include <queue>
#include <climits>
#include <cmath>

using namespace std;

class KingdomReorganization {
	public:
	struct edge
	{
		int s, d, w;
		bool operator<(const edge &e) const
		{
			return w < e.w;
		}
	};
	int sz[51];
	int id[51];
	int cost(char ch)
	{
		if (ch >= 'a' && ch <= 'z')
			return ch -'a' + 26;
		else
		    return ch-'A';	
	}
	int root(int i)
	{
		while (i != id[i]) {
			id[i] = id[id[i]];
			i  = id[i];
		}
		return i;
	}
	bool connected(int s, int d)
	{
		return root(s) == root(d);
	}
	void unionn(int s, int d)
	{
		s = root(s);
		d = root(d);
		
		if (sz[s] < sz[d] ) {
			sz[d] += sz[s];
			id[s] = id[d];
		}else {
			sz[s] += sz[d];
			id[d] = id[s];
		}
	}
	int getCost(vector <string> kingdom, vector <string> build, vector <string> destroy) {
	   vector<edge> v;
	  
	   int n = kingdom.size();
	   for (int i = 0; i < n; i++) {
   			sz[i] = 1;
   			id[i] = i;
   			for (int j = i+1; j < n; j++) {
			   	 if (kingdom[i][j] == '1') {
 	   				edge e;
 	   				e.s = i; e.d= j;
 	   				e.w = -1 * cost(destroy[i][j]);
 	   				v.push_back(e);
  				}else {
				  	edge e;
 	   				e.s = i; e.d= j;
 	   				e.w= cost(build[i][j]);
				  	v.push_back(e);
				  }
			   	 	
			   }
   		}
		 sort(v.begin(), v.end());
		 int amt = 0;
		 int cou = 0;
		 int s, d;
		 
		 for (int i = 0; i < v.size(); i++) {
 			edge e = v[i];
 			s = e.s; d = e.d;
 			if (!connected(s,d)) {
			 	unionn(s,d);
			 	
				if (e.w > 0)
					amt += e.w;			 	
			 }else {
			 	
 				if (e.w < 0)
 				  amt += -1 * e.w;
 			}
 		}  
		 return amt;   		   	
	}
};
