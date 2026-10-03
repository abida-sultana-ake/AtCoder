N = int(input())
T = [int(x) for x in input().split()]
ans = set()
 
if __name__ == '__main__':
    for i in range(N):
        while(T[i] % 2 == 0): T[i] = T[i] // 2
        ans.add(T[i])
    print(len(ans))