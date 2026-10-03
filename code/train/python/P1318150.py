import sys
N = int(input())
s = [i for i in input()]
animal = ['S','W']

for x in animal:
    ans = [i for i in range(N)]
    ans[-1] = x

    for y in animal:
        ans[0] = y
        for i in range(N):
            if (s[i] == 'o' and ans[i] == 'S') or (s[i] == 'x' and ans[i] == 'W'):
                if i < N-2:
                    ans[i+1] = ans[i-1]
                elif i == N-2:
                    if ans[i-1] != ans[-1]:
                        break
                elif i == N-1:
                    if ans[i-1] == ans[0]:
                        print(''.join(ans))
                        sys.exit()
            elif (s[i] == 'x' and ans[i] == 'S') or (s[i] == 'o' and ans[i] == 'W'):
                if i < N-2:
                    if ans[i-1] == 'S':
                        ans[i+1] = 'W'
                    elif ans[i-1] == 'W':
                        ans[i+1] = 'S'
                elif i == N-2:
                    if ans[i-1] == ans[-1]:
                        break
                elif i == N-1:
                    if ans[i-1] != ans[0]:
                        print(''.join(ans))
                        sys.exit()

print(-1)
