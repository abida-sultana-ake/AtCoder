N = int(input())
s = input().split()

# b = ''
# for ss in s:
#     b += ss
#     print(b)
#     b = b[::-1]
# print(" ".join(b))

ans = []
if N % 2 == 1:
    for ss in s[::-1][0::2]:
        ans.append(ss)
    for ss in s[1::2]:
        ans.append(ss)
else:
    for ss in s[::-1][0::2]:
        ans.append(ss)
    for ss in s[0::2]:
        ans.append(ss)
print(" ".join(ans))
