N=int(input());d=[int(input()) for _ in [1]*N]
print(sum(d));print(max(2*max(d)-sum(d),0))