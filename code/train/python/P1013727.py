a, b, x = map(int, input().split())
a = (a-1)//x + 1
b = b//x+1
print(max(b-a, 0))