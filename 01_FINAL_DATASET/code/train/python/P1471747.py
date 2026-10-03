h, w = list(map(int, input().split(" ")))

minv = 99999999

for i in range(1, h):
    s1 = i*w
    
    if (h-i)*w % 2 == 0:
        s2 = (h-i)* w / 2
        s3 = (h-i)* w / 2
    else:
        s2 = min((h-i), w) * (max((h-i), w)//2)
        s3 = min((h-i), w) * (1+max((h-i), w)//2)
        
    if max(s1, s2, s3) - min(s1, s2, s3) < minv:
        minv = max(s1, s2, s3) - min(s1, s2, s3)
        

for i in range(1, w):
    s1 = i*h
    
    if h*(w-i) % 2 == 0:
        s2 = h*(w-i) / 2
        s3 = h*(w-i) / 2
    else:
        s2 = min(h, (w-i)) * (max(h, (w-i))//2)
        s3 = min(h, (w-i)) * (1+max(h, (w-i))//2)
        
    if max(s1, s2, s3) - min(s1, s2, s3) < minv:
        minv = max(s1, s2, s3) - min(s1, s2, s3)
        
print(int(minv))