#include<stdio.h>
#include<string.h>
int main () {
	char a[10], b[10], c[10];
	int tag, radix;
	int i, tmp;
	long known_num = 0, unknown;

	scanf("%s%s%d%d", a, b, &tag, &radix);
	//printf("%s\n%s\n%d %d\n", a, b, tag, radix);

	if(tag == 2){
		strcpy(c, b);
		strcpy(b, a);
		strcpy(a, c);
	}

	i = 0;
	while(a[i] != '\0') {
		if(a[i] >= '0' && a[i] <= '9')
			known_num = known_num * radix + (a[i] - '0' + 0);
		else if(a[i] >= 'a' && a[i] <= 'z')
				known_num = known_num * radix + (a[i] - 'a' + 10);
		i++;
	}
	//printf("%s\n%s\n%ld\n", a, b, known_num);
	i = 0;
	radix = 0;
	while(b[i] != '\0') {
		if(b[i] >= '0' && b[i] <= '9')
			tmp = b[i] - '0';
		else if(b[i] >= 'a' && b[i] <= 'z')
				tmp = b[i] - 'a' + 10;
		if(tmp > radix)
			radix = tmp;
		i++;
		//printf("radix :%d\n", radix);
	}
	
	int low = ++radix;
	int high;
	if(known_num > low)
		high = known_num;
	else high = low;
	//printf("%d %d %d\n", low, high, radix);
	for(;low <= high;) {
		unknown = 0;
		i = 0;
		radix = (low + high) / 2;
		while(b[i] != '\0') {
			if(b[i] >= '0' && b[i] <= '9')
				unknown = unknown * radix + (b[i] - '0' + 0);
			else if(b[i] >= 'a' && b[i] <= 'z')
				unknown = unknown * radix + (b[i] - 'a' + 10);
			i++;
			//printf("**%d**\n", unknown);
		}

		//printf("radix -- %d %ld %ld\n", radix, unknown, known_num);
		if(known_num == unknown)
			break;
		else if(unknown < 0 || unknown > known_num){
				high = radix - 1;
			 }
			 else low = radix + 1;
	}

	//printf("%d\n", (int)sizeof(long));
	//printf("radix -- %d %ld %ld %d %d %d\n", radix, unknown, known_num, llow, high, low);
	if(high >= low)
		printf("%d\n", radix);
	else printf("Impossible\n");

	return 0;
}


/*
#include <iostream>
#include <cctype>
#include <algorithm>
#include <cmath>
using namespace std;
long long convert(string n, long long radix) {
    long long sum = 0;
    int index = 0, temp = 0;
    for (auto it = n.rbegin(); it != n.rend(); it++) {
        temp = isdigit(*it) ? *it - '0' : *it - 'a' + 10;
        sum += temp * pow(radix, index++);
    }
    return sum;
}
long long find_radix(string n, long long num) {
    char it = *max_element(n.begin(), n.end());
    long long low = (isdigit(it) ? it - '0': it - 'a' + 10) + 1;
    long long high = max(num, low);
    while (low <= high) {
        long long mid = (low + high) / 2;
        long long t = convert(n, mid);
        if (t < 0 || t > num) high = mid - 1;
        else if (t == num) return mid;
        else low = mid + 1;
    }
    return -1;
}
int main() {
    string n1, n2;
    long long tag = 0, radix = 0, result_radix;
    cin >> n1 >> n2 >> tag >> radix;
    result_radix = tag == 1 ? find_radix(n2, convert(n1, radix)) : find_radix(n1, convert(n2, radix));
    if (result_radix != -1) {
        printf("%lld", result_radix);
    } else {
        printf("Impossible");
    }   
    return 0;
}
*/
/*
Given a pair of positive integers, for example, 6 and 110, can this equation 6 = 110 be true? The answer is "yes", if 6 is a decimal number and 110 is a binary number.

Now for any pair of positive integers N1 and N2, your task is to find the radix of one number while that of the other is given.

Input Specification:

Each input file contains one test case. Each case occupies a line which contains 4 positive integers:
N1 N2 tag radix
Here N1 and N2 each has no more than 10 digits. A digit is less than its radix and is chosen from the set {0-9, a-z} where 0-9 represent the decimal numbers 0-9, and a-z represent the decimal numbers 10-35. The last number "radix" is the radix of N1 if "tag" is 1, or of N2 if "tag" is 2.

Output Specification:

For each test case, print in one line the radix of the other number so that the equation N1 = N2 is true. If the equation is impossible, print "Impossible". If the solution is not unique, output the smallest possible radix.

Sample Input 1:
6 110 1 10
6 110 2 2
Sample Output 1:
2
Sample Input 2:
1 ab 1 2
1 ab 1 2
Sample Output 2:
Impossible
*/
