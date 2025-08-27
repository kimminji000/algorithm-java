#include <stdio.h>
#include <deque>

int main() {

	int N, M, count = 0;
	scanf("%d %d", &N, &M);

	std::deque<int> d;

	for (int i = 1;  i <= N; i++) {
		d.push_back(i);
	}
	
	int num[50];
	for (int i = 0; i < M; i++) {
		scanf("%d", &num[i]);
	}
	
	for (int i = 0; i < M; i++) {
		int fnum = 0, bnum = 0;
		for (int j = 0; j < d.size(); j++) {
			if (num[i] == d[j]) break;
			fnum++;
		}
		for (int j = d.size() - 1; j >= 0; j--) {
			if (num[i] == d[j]) break;
			bnum++;
		}
		bnum++;

		if (num[i] == d.front()) {
			d.pop_front();
		}
		else if (fnum < bnum) {
			for (int j = 0; j < fnum; j++) {
				d.push_back(d.front());
				d.pop_front();
				count++;
			}
			d.pop_front();
		}
		else {
			for (int j = 0; j < bnum; j++) {
				d.push_front(d.back());
				d.pop_back();
				count++;
			}
			d.pop_front();
		}		
	}
	printf("%d", count);
}