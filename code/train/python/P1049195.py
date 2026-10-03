# coding: utf-8;

def main():
    i = input().split()
    if i.count('5') == 2 and i.count('7') == 1:
        print('YES')
    else:
        print('NO')

if __name__ == '__main__':
    main()
