n, k = map(int, input().split())
a = list(map(int, input().split()))

sum = 0
sub_sum = 0
for i in range(k):
    sub_sum += a[i]
sum += sub_sum
for i in range(1, n - k + 1):
    sub_sum = sub_sum -	a[i - 1] + a[i + k - 1]
    sum += sub_sum

print(sum)