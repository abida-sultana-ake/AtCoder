n = int(input())
b = [int(input()) for _ in range(n-1)]
a = [[] for _ in range(n)]
for i,b_ in enumerate(b):
    a[b_-1].append(i+1)
salary = []
for a_ in a[::-1]:
    if len(a_) == 0:
        salary.append(1)
    else:
        buka_salary = [salary[n-1-a__] for a__ in a_]
        salary.append(max(buka_salary)+min(buka_salary)+1)
print(salary[-1])