import itertools

def spl(s, t):
    lst = list(s)
    for x in reversed(t):
        lst.insert(x, '+')
    return eval(''.join(lst))


def main():
    nums = input()
    length = len(nums)
    total = 0
    for i in range(length):
        for ts in itertools.combinations(range(1, length), i):
            total += spl(nums, ts)
    print(total)

if __name__ == '__main__':
    main()
