number_set = set()
N = int(input())

for i in range(N):
    new_num = input()
    if new_num in number_set:
        number_set.remove(new_num)
    else:
        number_set.add(new_num)

print(len(number_set))