# coding: utf-8
def get_ln_inputs():
    return input().split()


def get_ln_int_inputs():
    return list(map(int, get_ln_inputs()))


def main():
    n = get_ln_int_inputs()[0]
    a = get_ln_int_inputs()

    ilist = []

    t = n
    while t > 0:
        ilist.append(t)
        t -= 2
    if t == -1:
        t = 2
    else:
        t = 1
    while t < n:
        ilist.append(t)
        t += 2
    
    print(" ".join(str(a[i - 1]) for i in ilist))


main()