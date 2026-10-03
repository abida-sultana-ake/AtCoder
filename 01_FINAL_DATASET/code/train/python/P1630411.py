A,B = map(int,input().split())

A = list(str(A))
B = list(str(B))
list_A = list(map(int,A))
list_B = list(map(int,B))
a = [0 for i in range(19)]
a[1] = 2

def dfs(i,n): 
    global a
    if i == n:
        return 
    a[i] = 2*(10**(i-1)) + a[i-1]*8
    return dfs(i+1,n)

def cal(list):
    l = len(list)
    n = l-1
    res = 0
    for k in range(l):
        if list[k] == 4 or list[k] == 9:
            for j in range(k+1,l):
                res += list[j] * (10**(l-1-j))
                list[j] = 0
                if j == l-1:
                    res += 1
    for i in range(l):
        count = 0
        if i == l-1 and list[i] == 4:
            count = 1
        elif 4 < list[i]:
            count = 1
        res += (list[i]-count)*a[n]+(10**n)*count
        #print(res,a[n],list[i],count,(list[i]-count)*a[n]+(10**n)*count)
        n -= 1
    if list[-1] == 9:
        res += 1
    return res

dfs(2,19)
m = cal(list_A)
n = cal(list_B)

if '4' in A or '9' in A:
    m -= 1


print(n-m)