A,B = input().split()
MAX_DIG = len(B)+1
A,B = int(A),int(B)

mem = [[] for i in range(MAX_DIG)]
mem[0] = [0,0,0,1,1,1,1,1,2,2] # 1-10
m = 1
for d in range(1,MAX_DIG):
    m *= 10
    for i in range(10):
        if i == 0: # 10,100,1000...
            mem[d].append(mem[d-1][9]) # 10,100,1000...
            continue
        if i == 4 or i == 9: # when 50,500... or 100,1000...
            mem[d].append(mem[d][-1] + m - 1)
            continue
        mem[d].append(mem[d][-1] + mem[d][0])
        if i == 3 or i == 8: # when 40,400... or 90,900...
            mem[d][i] += 1 # count 40, 90...

def count_forbidden(n):
    sn = str(n)
    cnt = 0
    for i in range(len(sn)):
        a = int(sn[i])
        if a == 0: continue
        cnt += mem[len(sn) - i - 1][a-1]
        if (a == 4 or a == 9) and i < len(sn) - 1:
            remain = int(sn[i+1:])
            cnt += remain
            break
    return cnt

print(count_forbidden(B) - count_forbidden(A-1))
