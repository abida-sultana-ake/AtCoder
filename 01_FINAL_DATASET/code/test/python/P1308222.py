n = int(input())
dict = {}

for i in range(n):
    a = input()
    if (a in dict) == 1:
        dict[a] += 1
    else:
        dict[a] = 1
        
print(max(dict, key=(lambda x:dict[x])))