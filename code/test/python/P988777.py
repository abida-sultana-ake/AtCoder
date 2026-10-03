a, b, c = map(int, input().split())
if a == b == c:
    print('1')
elif a != b and a != c and b != c:
    print('3')
else:
    print('2')
