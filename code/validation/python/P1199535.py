# -*- coding: utf-8 -*-


def main(n, s):
    count = 0
    max_values = []
    for c in s:
        if c == 'I':
            count += 1
            max_values.append(count)
        else:
            count -= 1
    max_values = max_values if max_values else [0]
    return max(max_values) if 0 < max(max_values) else 0


if __name__ == '__main__':
    n = int(input())
    s = input()
    answer = main(n, s)
    print(answer)