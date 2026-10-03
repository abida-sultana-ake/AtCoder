import calendar

Y = int(input())
if calendar.isleap(Y):
    print("YES")
else:
    print("NO")