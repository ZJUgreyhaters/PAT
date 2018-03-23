//Dijk 
#include<stdio.h>
#define INT_MAX 0x7FFFFFFF

int main(){
	int city, road, place, save;
	int i, j, k, l;
	int tmp;

	int x;

	scanf("%d%d%d%d", &city, &road, &place, &save);
	int rescue[city], map[city][city], dis[city], set[city], max_res[city], count[city];
	
	for(i = 0;i < city;i++){
		scanf("%d", &rescue[i]);
		max_res[i] = rescue[i];
		count[i] = 0;
	}

	for(i = 0;i < city;i++){
		for(j = 0;j < city;j++)	
			map[i][j] = 0;
	}
		
	for(i = 0;i < road;i++){
		scanf("%d%d%d", &j, &k, &l);
		map[j][k] = l;
		map[k][j] = l;
	}
/*
	for(i = 0;i < city;i++){
		for(j = 0;j < city;j++)	
			printf("%d ", map[i][j]);
		printf("\n");
	}
*/
	for(i = 0;i < city;i++){
		if(map[place][i] == 0)
			dis[i] = INT_MAX;
		else {
			dis[i] = map[place][i];
			count[i] = 1;
			}
		}
	dis[place] = 0;
/*
	for(i = 0;i < city;i++){
		printf("%d %d\n", dis[i], count[i]);
	}
*/
	for(i = 0;i < city;i++){
		set[i] = 0;
	}
	set[place] = 1;



    //printf("nice\n");

	for(i = 0;i < city;i++){
		tmp = INT_MAX;
		for(j = 0;j < city;j++){
			if(tmp > dis[j] && (!set[j])){
				tmp = dis[j];
				k = j;
			}
		}
		//printf("k--%d\n", k);
		set[k] = 1;
		for(l = 0;l < city;l++){
			if((!set[l]) && (map[k][l]) && (dis[l] > dis[k] + map[k][l])){
				dis[l] = dis[k] + map[k][l];
				count[l] = 1;
				if(max_res[l] < max_res[k] + rescue[l])
					max_res[l] = max_res[k] + rescue[l];
			}
			else if((!set[l]) && (map[k][l]) && (dis[l] == dis[k] + map[k][l])){
					count[l] += 1;
					if(max_res[l] < max_res[k] + rescue[l])
						max_res[l] = max_res[k] + rescue[l];
			}
					
		}
		/*
		for(x = 0;x < city;x++){
			printf("%d m-%d |", dis[x], max_res[x]);
		}
		printf("-------\n");
		*/
	}

	printf("%d %d\n", count[save], max_res[save] + rescue[place]);

	return 0;
}
