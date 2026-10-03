N = int(input())
src = input().split()
count = 0
for s in src:
    s = s.replace('.','')
    if s in ('TAKAHASHIKUN','Takahashikun','takahashikun'):
        count += 1
print(count)
