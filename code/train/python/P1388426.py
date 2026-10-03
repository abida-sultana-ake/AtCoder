a=sorted([(int(b),a)for i in [0]*int(input())for a,b in[input().split()]])
print(("atcoder",a[-1][1])[a[-1][0]*2>sum((n for n,m in a))])