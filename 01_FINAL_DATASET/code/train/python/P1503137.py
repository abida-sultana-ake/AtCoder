import sys
N = int(input())
n = list(map(int, input().split()))
K = input()
way = list(map(int, input().split()))
n = n + way
new_list = sorted(n)
for i in range(len(new_list) - 1):
    if new_list[i] != new_list[i+1]:
        continue
    elif new_list[i] == new_list[i+1]:
        print("NO")
        sys.exit()
print("YES")
