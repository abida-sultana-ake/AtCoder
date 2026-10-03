n = input()
n = int(n)
s_1 = input()
s_2 = input()
s_list = []

nagasa = len(s_1)
i = 0
while i < nagasa:
    if s_1[i] == s_2[i]:
        s_list.append(0)
        i += 1
    else:
        s_list.append(1)
        i += 2

if s_list[0]==0:
    kotae = 3
else:
    kotae = 3*2
    
mod = 1000000007
mod = 1000000007
def mul(a, b):
    return ((a % mod) * (b % mod)) % mod

for i in range(len(s_list)-1):
    if s_list[i]==0:
        kotae = mul(kotae,2)
    elif s_list[i]==1 and s_list[i+1]==0:
        pass
    else:
        kotae = mul(kotae,3)
print(kotae)
        