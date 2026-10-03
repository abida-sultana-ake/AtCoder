lists = [int(i) for i in input().rstrip().split(" ")]
w_1 = 100 * lists[0]
w_2 = 100 * lists[1]
s_1 = lists[2]
s_2 = lists[3]
sol = lists[4] / (100 + lists[4])
limit = lists[5]

weight = 0
dens = 0
ans = (1,-1)
w_group = set()

for i in range(limit//w_1 + 1):
    for j in range((limit-w_1*i)//w_2 + 1):
        w_group.add(w_1*i + w_2*j)
w_group.remove(0)

s_group = set()

for w_w in w_group:
    for i in range((limit-w_w)//s_1 + 1):
         for j in range((limit-w_w-s_1*i)//s_2 + 1):
             s_group.add(s_1*i + s_2*j)
    for s_s in s_group:
        weight = w_w + s_s
        dens = s_s / weight
        if sol >= dens > ans[1]/ans[0]:
            ans = (weight, s_s)
    s_group.clear()
print("{0} {1}".format(ans[0], ans[1]))