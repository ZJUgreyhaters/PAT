//char
#include<stdio.h>
#include<string.h>
#include<limits.h>
int main () {
	int i, max = INT_MIN, min = INT_MAX, tmp;
	char id[15], unlock[15], lock[15];
	int h, m, s, lh, lm, ls;
	int record;
	scanf("%d", &record);
	for(i = 0;i < record;i++){
		scanf("%s", id);
		scanf("%d:%d:%d %d:%d:%d", &h, &m, &s, &lh, &lm, &ls);
		tmp = s + m * 60 + h * 60 * 60;
		if(tmp < min){
			min = tmp;
			strcpy(unlock, id);
		}
		tmp = ls + lm * 60 + lh * 60 * 60;
		if(tmp > max){
			max = tmp;
			strcpy(lock, id);
		}
	}
	printf("%s %s\n", unlock, lock);
	return 0;
}