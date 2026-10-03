n, m = map(int, input().split())

students = []
for i in range(n):
    axis = [int(x) for x in input().split()]
    students.append(axis)

checkpoints = []
for i in range(m):
    axis = [int(x) for x in input().split()]
    checkpoints.append(axis)

ans = []
for s_x, s_y in students:
    distances = []
    for c_x, c_y in checkpoints:
        distances.append(abs(s_x - c_x) + abs(s_y - c_y))
    i_c = 0
    i_d = 4 * 10 ** 8 + 1
    for cnt, distance in enumerate(distances, 1):
        if i_d > distance:
            i_d = distance
            i_c = cnt
        else:
            pass
    ans.append(i_c)

for i in ans:
    print(i)