tmp = input().split();
n = int(tmp[0]);
a = int(tmp[1]);
b = int(tmp[2]);

s = []
d = []
for i in range(n):
    tmp = input().split();
    s.append(tmp[0]);
    d.append(int(tmp[1]));

sum = 0;
for i in range(n):
    if s[i] == "West":
        if d[i] < a: sum -= a;
        elif d[i] > b : sum -= b;
        else : sum -= d[i];
    if s[i] == "East":
        if d[i] < a: sum += a;
        elif d[i] > b : sum += b;
        else : sum += d[i];

if sum < 0 : print("West "+str(-sum));
elif sum == 0 : print(0);
elif sum > 0: print("East "+str(sum));