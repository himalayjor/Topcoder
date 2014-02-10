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

using namespace std;

//typedef pair<int, int> pl;

class CactusCount
{
public:
    bool vis[201];
    int cou[201];
    int G[201][201];
    int par[201];
     int n;
     bool cacti;
     void getnum(string s)
     {
         stringstream st(s);
         pair<int, int> pa;
         char ch;          
         while (st >> pa.first >> pa.second ) {
             G[pa.first][pa.second] = 1;
             G[pa.second][pa.first] = 1;
             st >> ch;   
         }
         return ;
     }
     void dfs(int x, int p)
     {
         vis[x] = true;
         par[x] = p;
         cout << "h " << x << " " << p << endl;
         
         for (int i = 1; i < n+1; i++) {
            if (G[x][i] && !vis[i]) {
                
                dfs(i, x);
            }else if (G[x][i] && i != p) {
               
               int s = x;
               int d = i;
               par[d] = s;
               while (s != d) {
                if (cou[s] == 0)
                    cou[s]++;
                else
                    cacti = false;
                 s = par[s];   
               } 
            }
         }
     }   
    int countCacti(int n, vector <string> edges)
    {
        memset(G, 0, sizeof(G));
        memset(vis, 0, sizeof(vis));
         memset(par, 0, sizeof(par));
        memset(cou, 0, sizeof(cou));
        this->n = n;
         
        string s;
        for (int i = 0; i < edges.size(); i++) {
           s += edges[i];
            
        }
        getnum(s);
        
        int ret = 0;
        
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
            	
                cacti = true;
                dfs(i,i);
                if (cacti) {
                    ret++;
                    cout << i << endl; }
            }
                
        }
        
        return ret;
    }
};
