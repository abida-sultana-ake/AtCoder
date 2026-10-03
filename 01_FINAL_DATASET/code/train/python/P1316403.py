nl = [int(i) for i in input().split(" ")]
str_list = []
for _ in range(nl[0]):
    str_list.append(input())

for word in sorted(str_list):
    print(word,end="")

print()
