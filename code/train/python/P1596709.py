N = int(input())
K = int(input())
x = input()
split_x = x.split()
int_split_x = [int(i) for i in split_x]
result = 0

for i in range(0, len(int_split_x)):
    if abs(K - int_split_x[i]) > abs(0 - int_split_x[i]):
        result += (abs(0 - int_split_x[i]))*2
    else:
        result += (abs(K - int_split_x[i]))*2

print(result)
