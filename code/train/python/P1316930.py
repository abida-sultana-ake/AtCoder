n = int(input())

s = []
for i in range(n):
    s.append(input())

alp_list = [chr(i) for i in range(97, 97+26)]
min = 0
ans = ''
for char in alp_list:
    for i in range(n):
        if i==0:
            min = s[i].count(char)

        if s[i].count(char) < min :
            min = s[i].count(char)

    for x in range(min):
        ans += char

print(ans)
