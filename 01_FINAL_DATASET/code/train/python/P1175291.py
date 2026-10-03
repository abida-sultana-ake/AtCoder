N = int(input())
arr = [0]
for i in range(N):
    newbox = int(input())
    if max(arr) < newbox:
        arr.append(newbox)
    else:
        arr[1:] = [newbox if arr[i] >= newbox > arr[i-1] else arr[i] for i in range(1, len(arr))]
print (len(arr) - 1)