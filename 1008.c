#include<stdio.h>

int main () {
	int request_num, floor = 0, next, time =0;
	int i;
	scanf("%d", &request_num);
	for(i = 0;i < request_num;i++) {
		scanf("%d", &next);
		if (next > floor)
			time += (next - floor) * 6;
		else if (next < floor)
				time += (floor - next) * 4;
		floor = next;
		time = time + 5;
	}

	printf("%d\n", time);
	return 0;
}