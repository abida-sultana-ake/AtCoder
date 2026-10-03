#K個のみかんを買うことが決まりました。
#みかんは1個A円、さらにL個のセットでB円で売っています。
import math

A,B,K,L = map(int,input().split())
maxsetnum = math.ceil(K/L)
minsetnum = K//L
singlenum = K%L

amount = minsetnum * B + singlenum * A
if amount > maxsetnum * B: amount = maxsetnum * B
print(amount)