from itertools import product as prod

n = int(input())
ss = list(input())

def next_anim(a_0, a_1, s):
    if s == "o":
        if a_1 == "S":
            return a_0
        else:
            return "W" if a_0 == "S" else "S"
    else:
        if a_1 == "S":
            return "W" if a_0 == "S" else "S"
        else:
            return a_0

ans = -1
anims = ["" for _ in range(n)]
for fst, snd in prod(["W", "S"], repeat=2):
    anims[:2] = [fst, snd]
    for i in range(2, n):
        anims[i] = next_anim(anims[i-2], anims[i-1], ss[i-1])
    tmp_anim = next_anim(snd, fst, ss[0])
    tmp_anim2 = next_anim(anims[-2], anims[-1], ss[-1])
    if tmp_anim == anims[-1] and tmp_anim2 == anims[0]:
        ans = "".join(anims)
        break

print(ans)
