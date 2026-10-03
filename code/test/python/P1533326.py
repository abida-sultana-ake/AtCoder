N = int(input())
T = [0]*2401
for i in range(N):
    t = input()
    start = int(t[:4]) - int(t[:4])%5
    if int(t[5:])%5 == 0:
        end = int(t[5:])
    else:
        end = int(t[5:]) + (5-int(t[5:])%5)
        if end%100 == 60:
            end += 40
    
    T[start] += 1
    T[end] -= 1

count = 0
st = 10**5
en = 10**5
for i in range(2401):
    if T[i] > 0:
        count += T[i]
        if st > 2400:
            st = i
    if T[i] < 0:
        count += T[i]
        if count == 0:
            en = i
            print("%04d-"%st, end="")
            print("%04d"%en)
            
            st = 10**5
            en = 10**5