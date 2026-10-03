S = input()
state = 'A'
count = -1
for c in S:
    if c!=state:
        count+=1
        state=c
print(count)