s= input()
N=len(s)
g_count=s.count('g')
p_count=s.count('p')

score= N//2 -p_count
print(score)