A,B = map(int,input().split())

diff = int(abs(A-B))
cnt = int(diff/10)
diff -= 10*cnt
if diff % 5 == 4:
    cnt += 2
elif diff % 5 == 3:
    cnt += 3
elif diff == 1 or diff == 5:
    cnt += 1
elif diff < 5:
    cnt += diff
elif diff > 5:
    cnt += diff-4
print(cnt)