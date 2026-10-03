N=input()
x=input()
lst = [0]*4
for i in x:
    lst[int(i)-1] +=1
print(max(lst), min(lst))
