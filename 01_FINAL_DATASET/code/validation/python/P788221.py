input()
a = input()
a = a.split(" ")

member = []

for i in range(len(a)):
    lis = [i+1, int(a[i])]
    member.append(lis)

member = sorted(member, key=lambda x:x[1], reverse=True)

for i in range(len(member)):
    print(member[i][0])
