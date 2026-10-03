N = int(input())

s = []
for _ in range(N):
    s.append(int(input()))
    
s = sorted(s)

if sum(s) % 10 == 0:
    for i in range(len(s)):
        if s[i] % 10 != 0:
            print(sum(s[:i]) + sum(s[i+1:]))
            break
    else:
        print(0)
        
else:
    print(sum(s))