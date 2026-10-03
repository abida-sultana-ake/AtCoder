N = int(input())
src = list(map(int,input().split()))
A = max(src)+1
exist = [0 for i in range(A)]
start = end = 0
maxlen = 1
while end < N:
    if exist[src[end]]:
        for i in range(start,end):
            if src[i] == src[end]:
                start = i+1
                break
            else:
                exist[src[i]] = 0
    else:
        exist[src[end]] = 1
        maxlen = max(maxlen, end - start + 1)
    end += 1
print(maxlen)
