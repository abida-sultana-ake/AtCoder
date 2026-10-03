n = int(input())
ans = []
if n == 1:
    print(0)
    quit()
for i in range(1, n):
    ans.append(abs(i-(n//i))+(n%i))
print(min(ans))