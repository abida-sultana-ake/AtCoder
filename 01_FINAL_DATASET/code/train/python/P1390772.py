N = int(input())
s = []
for _ in range(N):
    s.append(int(input()))


if sum(s) % 10 != 0:
    print (sum(s))
    
else:
    min_s = 0
    sorted_s = sorted(s, reverse=True)
    for ss in sorted_s:
        if ss % 10 != 0:
            min_s = ss

    if min_s == 0:
        print (0)
    else:
        print(sum(s) - min_s)