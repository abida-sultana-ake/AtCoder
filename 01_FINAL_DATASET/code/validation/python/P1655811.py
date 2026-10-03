N = int(input())
numList = list(map(int, input().split()))
numList.sort(reverse = True)

target1 = False
target2 = False

i = 0

while i < N-1:
    if numList[i] == numList[i+1]:
        if target1 == False:
            num1 = numList[i]
            target1 = True
            i += 1
        elif target1 == True:
            num2 = numList[i]
            target2 = True
    if target1 == True and target2 == True:
        break
    i += 1

if target2 == False:
    print("0")
else:
    print(num1 * num2)
