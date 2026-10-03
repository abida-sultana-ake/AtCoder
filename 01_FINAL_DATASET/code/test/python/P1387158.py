n = 0
N = int(input())
words = list(input().split(' '))
for x in words:
    if x == 'TAKAHASHIKUN' or x == 'Takahashikun' or x == 'takahashikun' or x == 'TAKAHASHIKUN.' or x == 'Takahashikun.' or x == 'takahashikun.':
        n += 1
print(n)