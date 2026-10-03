import math
target = int(input())
answer = dict()
for factorial in range(2,target + 1):
    while factorial > 1:
        for inner in range(2,math.ceil(math.sqrt(factorial))+1):
            if factorial % inner == 0:
                factorial //= inner
                answer[inner] = answer.get(inner,0) + 1
                break
        else:
            answer[factorial] = answer.get(factorial,0) + 1
            factorial = 1
            
sum_answer = 1
for ans in answer.values():
    sum_answer = (sum_answer * (ans + 1)) % (10**9 + 7)

print(sum_answer)
