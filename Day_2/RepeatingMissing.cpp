#include<bits/stdc++.h>

using namespace std;

pair<int,int> missingAndRepeating(vector<int> &arr, int n) {
	long long cursum = 0,sqcursum = 0;
	long long actsum = (long long)(n * (n + 1)) / 2,sqactsum = ((long long)n * (long long)(n + 1) * (long long)(2 * n + 1)) / 6;;
	for (auto x : arr) {
		cursum += (long long)x;
		sqcursum += (long long)x * (long long)x;
	}
	long long diff = cursum - actsum, sqdiff = sqcursum - sqactsum;
	long long sum = sqdiff / diff;

	long long repeating = (sum + diff) / 2;
	long long missing = sum - repeating;
	return {(int)missing, (int)repeating};
}

int main() {
    vector<int> arr;
    arr.push_back(6);
    arr.push_back(4);
    arr.push_back(3);
    arr.push_back(5);
    arr.push_back(5);
    arr.push_back(1);
    pair<int,int> p=missingAndRepeating(arr,6);
    cout<<"Missing Number: "<<p.first<<"\nRepeating Number: "<<p.second;
    return 0;
}