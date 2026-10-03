def split_ii(h, w):
    if w==2:
        return h*w
    elif w%3==0:
        return 0
    else:
        return h

def split_t(h, w):
    ans = h*w
    for i in range(h//5, (h+1)//2+1):
        head = i*w
        left = (h-i)*(w//2)
        right = (h-i)*(w - w//2)
        ans = min(ans, max(head, left, right)-min(head, left, right))
    return ans

h, w = map(int, input().split())
print(min(split_ii(h, w), split_ii(w, h), split_t(h, w), split_t(w, h)))