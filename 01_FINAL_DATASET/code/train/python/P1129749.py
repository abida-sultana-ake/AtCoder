num = input()

word_list = []
for i in range(int(num)):
    word_list.append(input())


def word_sort(w1, w2):
    min_len = min(len(w1), len(w2))
    for i in range(min_len):
        idx = -i - 1
        if w1[idx] == w2[idx] and (i + 1 == min_len):
            if len(w1) < len(w2):
                return 1
            else:
                return 2
        if w1[idx] == w2[idx]:
            continue
        if w1[idx] < w2[idx]:
            return 1
        else:
            return 2


for i in range(len(word_list)):
    for j in range(len(word_list) - 1 - i):
        result = word_sort(word_list[j], word_list[j + 1])
        if result == 2:
            tmp = word_list[j]
            word_list[j] = word_list[j + 1]
            word_list[j + 1] = tmp


for i in range(len(word_list)):
    print(word_list[i])
