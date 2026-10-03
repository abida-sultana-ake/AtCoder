n=int(input());s=input();a=['SS','WS','SW','WW']
for i in range(n):
    for j in range(4):a[j]+='SW'[::-1 if s[i]=='o' else 1][a[j][i]==a[j][i+1]]
for i in range(4):
    if a[i][1]==a[i][n+1] and a[i][0] == a[i][n]:print(a[i][1:n+1]);exit()
print(-1)