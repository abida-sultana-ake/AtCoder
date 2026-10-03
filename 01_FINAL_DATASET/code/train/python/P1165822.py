# coding: utf-8
num_box, num_ans_candy = map(int, input().split())
l_box = list(map(int, input().split()))

eat_counter = 0
for index in range(num_box - 1):
    double_candy = l_box[index] + l_box[index + 1]
    if double_candy > num_ans_candy:
        num_eat_candy = double_candy - num_ans_candy
        if l_box[index + 1] < num_eat_candy:
            num_eat_candy -= l_box[index + 1]
            eat_counter += l_box[index + 1]
            l_box[index + 1] = 0
            l_box[index] -= num_eat_candy
        else:
            l_box[index + 1] -= num_eat_candy
        eat_counter += num_eat_candy

print(eat_counter)