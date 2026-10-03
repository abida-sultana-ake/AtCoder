day = input()
daylist = ["Saturday", "Friday", "Thursday", "Wednesday", "Tuesday", "Monday"]

if day == "Sunday":
    print(0)
else:
    print(daylist.index(day))
