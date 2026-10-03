input_lines = input()
items = input_lines.split()
N = int(items[0])
T = int(items[1])

input_lines = input()
items = input_lines.split()
As = [int(x) for x in items]

def my_func(N, T, As):
    buys = T // 2
    counts = 0
    val_earn = 0
    val_min = 10E10
    for val in As:
        if val < val_min:
            val_min = val
        else:
            diff = val - val_min
            if diff == val_earn:
                counts += 1
            elif diff > val_earn:
                val_earn = diff
                counts = 1
    print(counts)

my_func(N, T, As)