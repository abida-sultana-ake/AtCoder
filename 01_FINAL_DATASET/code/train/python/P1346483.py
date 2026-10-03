n = int(input())
s = input()
copy = s
s_list = list(s)
left_list = []
right_list = []

n = len(s_list)
flag = 1
if len(s_list) > 1:
    while flag == 1:
        flag = 0

        if n>=1:
            for i in range(n-1):
                if s_list[i] == '(' and s_list[i+1] == ')':
                    s_list.pop(i)
                    s_list.pop(i)
                    n -= 2
                    flag = 1
                    break

        else:
            break




for word in s_list:
    if word == ')':
        left_list.insert(0,'(')
    else:
        right_list.insert(len(right_list),')')


word = ""

for lef in left_list:
    word += lef

word += s

for rig in right_list:
    word += rig

print(word)