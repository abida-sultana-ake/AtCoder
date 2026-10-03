# -*- coding: utf-8 -*-
"""
http://abc069.contest.atcoder.jp/tasks/abc069_b

"""

def solve(text):
    text_length = len(text)
    return text[0] + str(text_length-2) + text[-1]

def main():
    S = input()
    result = solve(S)
    print(result)


if __name__ == '__main__':
    main()