import itertools
length = int(input())
target = input()
target = [n == "o" for n in target]
for before,after in itertools.product([True,False],repeat = 2):
    tmp_answer = [0 for n in range(length)]
    tmp_answer[0] = before
    tmp_answer[1] = after
    for i in range(1,length-1):
        tmp_answer[i+1] = before ^ after ^ target[i]
        before,after = after,tmp_answer[i+1]

    if tmp_answer[length - 2] ^ tmp_answer [length - 1] ^ target[length - 1]  == tmp_answer[0] and \
    tmp_answer[length - 1] ^ tmp_answer [0] ^ target[0]  == tmp_answer[1]:
        print("".join(["S" if n else "W" for n in tmp_answer]))
        break
else:
    print(-1)