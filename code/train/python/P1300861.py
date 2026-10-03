h, w = map(int, input().split())


def area(s):
    ans = max(s) - min(s)
    return ans


if h % 3 == 0 or w % 3 == 0:
    ans = 0
else:
    temp = []
    s1 = [round(w / 3) * h, (w - round(w / 3)) * round(h / 2), round(w - w / 3) * (h - round(h / 2))]
    s2 = [round(h / 3) * w, (h - round(h / 3)) * round(w / 2), round(h - h / 3) * (w - round(w / 2))]
    temp.append(area(s1))
    temp.append(area(s2))
    if w > 2:
        s3 = [round(w / 3) * h, (w - round(w / 3) * 2) * h]
        temp.append(area(s3))
    if h > 2:
        s4 = [round(h / 3) * w, (h - round(h / 3) * 2) * w]
        temp.append(area(s4))
    ans = min(temp)
print(ans)
