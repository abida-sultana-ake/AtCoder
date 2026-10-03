abc = input().split()
a = int(abc[0])
b = int(abc[1])
c = int(abc[2])
d = int(abc[3])
e = int(abc[4])
f = int(abc[5])

x = []
y = []
pair = []
con = []


for i in range(int((f/100)+1)):
    for j in range(int((f/100)+1)):
        canx = ((a*i)+(b*j))*100
        if canx<=f:
            x.append(canx)

if x == []:
    print('x is empty')
            
for i in range(f):
    for j in range(f):
        cany = (c*i)+(d*j)
        if cany<=f:
            y.append(cany)
            
if y == []:
    print('y is empty')
            
for i in x:
    for j in y:
        if i+j<=f:
            if i!=0:
                if 100*j/i<=e:
                    pair.append([i, j])

if pair == []:
    print('pair is empty')

for i in pair:
    if sum(i)!=0:
        con.append(i[1]/sum(i))
    
if con == []:
    print('con is empty')
    
ans = pair[con.index(max(con))]
print(sum(ans), ans[1])