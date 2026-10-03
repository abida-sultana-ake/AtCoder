S = list(input())

num = ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
target = []
for i in range(len(S)):
    ans = S[i] in num
    if ans == True:
        target.append(S[i])

target = "".join(map(str, target))
print(target)
