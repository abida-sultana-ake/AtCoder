a,b=map(int, input().split())
ma=max([a%100+900, a%10+a//100*100+90,a//10*10+9])
mb=min([b%100+100, b%10+b//100*100,b//10*10])
print(max(ma-b,a-mb))