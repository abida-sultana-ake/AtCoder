def num_diff(fixed,all):
    count = {chr(c):0 for c in range(ord('a'),ord('z')+1)}

    for s in all:
        count[s] +=1
    for s in fixed:
        count[s] -=1
    for s in all[len(fixed):]:
        count[s] -=1

    ret = sum(map(abs,count.values()))//2
    return ret


N,K = map(int,input().split())
S = [c for c in input()]
not_fixed = sorted(S[:])

fixed = []
n_diff = 0

for s in S:
    if n_diff >= K:
        fixed.append(s)
    else:
        for c in not_fixed:
            fixed_temp = fixed[:]
            fixed_temp.append(c)
            n_diff_adder = (0 if c == s else 1)
            if num_diff(fixed_temp,S) <= (K-(n_diff + n_diff_adder)):
                n_diff += n_diff_adder
                fixed.append(c)
                not_fixed.remove(c)
                break

print("".join(fixed))