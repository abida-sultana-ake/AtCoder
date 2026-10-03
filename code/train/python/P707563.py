move = list(input())
mode = input()

pos_x = 0
pos_y = 0
question_mark = 0

for each in move:
    if each == "L":
        pos_x -= 1
    elif each == "R":
        pos_x += 1
    elif each == "D":
        pos_y -= 1
    elif each == "U":
        pos_y += 1
    else:
        question_mark += 1

d = abs(pos_x) + abs(pos_y)

if mode == "2":
    if question_mark <= d:
        print(d - question_mark)
    else:
        print((question_mark - d) % 2)
elif mode == "1":
    print(d + question_mark)
else:
    print("")
