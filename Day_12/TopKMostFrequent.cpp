#include<bits/stdc++.h>

using namespace std;


vector<int> KMostFrequent(int n, int k, vector<int> &arr) {
    unordered_map<int,int> hash;

    for (int i=0;i<n;i++) {
        hash[arr[i]]++;
    }

    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> heap;

    for (auto& itr:hash) {
        heap.push({itr.second,itr.first});
        if (heap.size()>k) {
            heap.pop();
        }
    }

    vector<int> ans(k,0);
    int idx=k-1;
    while (heap.size()) {
        ans[idx--]=heap.top().second;
        heap.pop();
    }
    return ans;
}

int main() {
    vector<int> arr;
    arr.push_back(1);
    arr.push_back(2);
    arr.push_back(2);
    arr.push_back(3);
    arr.push_back(3);
    int k=2;
    vector<int> res=KMostFrequent(arr.size(),k,arr);
    for (int& val:res) {
        cout<<val<<" ";
    }
    return 0;
}