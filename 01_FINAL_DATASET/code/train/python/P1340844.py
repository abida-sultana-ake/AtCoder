n = int(input())
a_list = input().split()
a_list_num = [int(a) for a in a_list]

print(max(a_list_num)-min(a_list_num))