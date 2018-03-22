#include<stdio.h>

float A[1000], B[1000];

int main(){
	int a, b, index, max_a, max_b, exp;
	int i, j, count = 0;
	float coe;

	scanf("%d%d%f", &a, &max_a, &coe);
	A[max_a] = coe;
	for (i = 0;i < a - 1;i++){
		scanf("%d%f", &index, &coe);
		A[index] = coe;
	}

	scanf("%d%d%f", &b, &max_b, &coe);
	B[max_b] = coe;
	for (i = 0;i < b - 1;i++){
		scanf("%d%f", &index, &coe);
		B[index] = coe;
	}

	if(max_a < max_b)
		max_a = max_b;

	for(i = 0;i <= max_a;i++){
		A[i] += B[i];
		if(A[i] != 0.0)
			count++;
	}
	printf("%d", count);
	for(i = max_a;i >= 0;i--){
		if(A[i] != 0)
			printf(" %d %.1f", i, A[i]);
	}
	printf("\n");

	return 0;
}