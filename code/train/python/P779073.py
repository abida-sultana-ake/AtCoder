a,b,k,l = map(int, input().split())

print(((k//l)*b + (k%l)*a < (k//l + 1)*b) and ((k//l)*b + (k%l)*a) or ((k//l + 1)*b))
