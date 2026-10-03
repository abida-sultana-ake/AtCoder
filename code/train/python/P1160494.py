# coding: utf-8

n_ani = int(input())
l_ans = list(input())


def get_next_animal(pre_ani, now_ani, ans):
    if pre_ani == "S":
        if now_ani == "S":
            if ans == "o":
                return "S"
            else:
                return "W"
        else:
            if ans == "o":
                return "W"
            else:
                return "S"

    else:
        if now_ani == "S":
            if ans == "o":
                return "W"
            else:
                return "S"
        else:
            if ans == "o":
                return "S"
            else:
                return "W"


def solve_question(first_ani, last_ani):
    global l_ani
    l_ani.append(first_ani)
    next_ani = get_next_animal(last_ani, first_ani, l_ans[0])
    l_ani.append(next_ani)
    for i in range(1, (n_ani - 1)):
        next_ani = get_next_animal(l_ani[i - 1], l_ani[i], l_ans[i])
        l_ani.append(next_ani)

    if l_ani[(n_ani - 1)] == last_ani and get_next_animal(l_ani[(n_ani - 2)], l_ani[(n_ani - 1)], l_ans[(n_ani - 1)]) == l_ani[0]:
        return "ok"
    else:
        return "ng"


ng_counter = 0

for i in range(4):
    l_ani = []
    if i == 0:
        fir_ani = "S"
        las_ani = "S"
        if solve_question(fir_ani, las_ani) == "ok":
            print ("".join([i for i in l_ani]))
            break
        else:
            ng_counter += 1

    elif i == 1:
        fir_ani = "S"
        las_ani = "W"
        if solve_question(fir_ani, las_ani) == "ok":
            print ("".join([i for i in l_ani]))
            break
        else:
            ng_counter += 1

    elif i == 2:
        fir_ani = "W"
        las_ani = "S"
        if solve_question(fir_ani, las_ani) == "ok":
            print ("".join([i for i in l_ani]))
            break
        else:
            ng_counter += 1

    elif i == 3:
        fir_ani = "W"
        las_ani = "W"
        if solve_question(fir_ani, las_ani) == "ok":
            print ("".join([i for i in l_ani]))
            break
        else:
            ng_counter += 1

if ng_counter == 4:
    print(-1)
