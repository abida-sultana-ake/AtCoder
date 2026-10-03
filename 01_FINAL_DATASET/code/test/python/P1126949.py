n = int(input())
sess = []
for _ in range(n):
    s, e = map(int, input().split("-"))
    if s % 5 != 0:
        s = s - s % 5
    if e % 5 != 0:
        e = e + (5 - e % 5)
    if s % 100 == 60:
        s = s - 60 + 100
    if e % 100 == 60:
        e = e - 60 + 100
    sess.append((s, e))

sess = sorted(sess)
div5 = [((s - s % 100) // 100 * 60 + s % 100 , (e - e % 100) // 100 * 60 + e % 100) for (s, e) in sess]
timeline = [0] * 1440
# print(div5)

for s, e in div5:
    timeline[s:e] = [1] * (e - s)

ans = []
is_rained = False
# print(timeline)
for i, t in enumerate(timeline):
    if not is_rained and t == 1:
        st = i
        is_rained = True
    if is_rained and t == 0:
        ans.append((st, i))
        is_rained = False

if timeline[-1] == 1:
    ans.append((st, 1440))

for s, e in ans:
    st = s // 60 * 100 + s % 60
    et = e // 60 * 100 + e % 60
    print("{0:04d}-{1:04d}".format(st, et))