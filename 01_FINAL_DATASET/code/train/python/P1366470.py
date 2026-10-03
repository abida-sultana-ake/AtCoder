n = input()
s = input()
count = 0
countl = 0
for c in s:
    if c=='(':
        count += 1
    else:
        count -= 1
    if count < 0:
        countl += 1
        count = 0
count = 0
countr = 0
for c in s[::-1]:
    if c=='(':
        count -= 1
    else:
        count += 1
    if count < 0:
        countr += 1  
        count = 0
print('('*countl + s + ')'*countr)

