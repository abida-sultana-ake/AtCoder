'''
cat B_test1.txt | python3 B.py
'''

N = int(input())
masu = []
for i in range(N):
    a = input()
    masu.append(a)

i = 0


while i<N:
    j = N-1
    while j>=0:
        print(masu[j][i], end='')
        j -= 1
    print()
    i += 1
