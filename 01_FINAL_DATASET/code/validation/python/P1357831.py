def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def ris(): return list(input())
def pli(): return "".join(list(map(str, ans)))

N = ri()
K = ri()
X = ri()
Y = ri()

if(K >= N):
    print(X*N)
else:
    print(K*X+(N-K)*Y)