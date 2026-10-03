chara = [chr(c) for c in range(ord('a'), ord('z') + 1)]
count = [50 for _ in range(len(chara))]
n = int(input())
for _ in range(n):
    s = input()
    count = [min(count[i], s.count(chara[i])) for i in range(26)]

ans = [(chara[i] * count[i]) for i in range(26)]
print(''.join(ans))
