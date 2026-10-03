cards = [int(i) for i in range(1,7)]
origianl = [int(i) for i in range(1,7)]

n = int(input())%30
for i in range(n):
    temp = cards[i%5]
    cards[i%5] = cards[i%5+1]
    cards[i%5+1] = temp

    if origianl == cards:
        print(i+1)
    
print(''.join(list(map(str,cards))))
