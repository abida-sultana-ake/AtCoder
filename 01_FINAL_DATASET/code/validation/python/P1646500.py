
def read_int_list():
    return list(map(int, input().split()))
n = int(input())

a=sorted(read_int_list())[::-1]

t={}
ans = len(a)

for i in a:
    if i in t:
        ans-=1
        continue    
    while i%2 == 0:
        t[int(i/2)] = True
        i = i/2
print(ans)