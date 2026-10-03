nums = list(map(int,input().split()))
a = nums[0]
b = nums[1]
c = nums[2]
x = [i*a for i in range(100) if i*a % b == c ]
if len(x) != 0 :
    print("YES")
else:
    print("NO")