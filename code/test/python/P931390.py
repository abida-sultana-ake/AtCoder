import sys

def input_num():
    num = input().split()
    return num

def num_serch(num):
    penki_num = len(num)
    if num[0] == num[1]:
        penki_num = penki_num - 1
    if num[0] == num[2]:
        penki_num = penki_num - 1
    if num[1] == num[2]:
        penki_num = penki_num - 1

    if penki_num == 0:
        penki_num = penki_num + 1

    print(penki_num)

if __name__ == '__main__':
    num = input_num()
    num_serch(num)