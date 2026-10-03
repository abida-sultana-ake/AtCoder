num_list = input().split()
num_before_list = []
count = 0

for num in num_list:
  if num in num_before_list:
    continue
  else:
    count += 1
    num_before_list.append(num)

print(count)