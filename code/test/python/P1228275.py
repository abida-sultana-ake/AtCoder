N = int(input())
dict = {}
for i in range(N):
    A = input()
    if (A in dict) == 1:
        dict[A] += 1
    else:
        dict[A] = 1
print (max(dict,key=(lambda x:dict[x])))