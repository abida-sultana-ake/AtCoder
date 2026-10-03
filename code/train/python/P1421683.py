s = input().split()
s = [int(i) for i in s]
a = s[0]
b = s[1]

if a % 3 == 0 : print("Possible")
elif b % 3 == 0 : print("Possible")
elif (a + b) % 3 == 0 : print("Possible")
else : print("Impossible")