H, W = list(map(int, input().split()))

mn = min(H, W)
if H % 3 == 0 or W % 3 == 0:
	print(0)
else:
	mn = min(H, W)

	L = []

	l1 = []
	l1.append(H * (W // 3))
	if H % 2 == 0:
		l1.append((H / 2) * (W - (W // 3)))
	else:
		l1.append((H // 2) * (W - (W // 3)))
		l1.append((H // 2 + 1) * (W - (W // 3)))
	L.append(max(l1) - min(l1))

	l2 = []
	l2.append(H * (W // 3 + 1))
	if H % 2 == 0:
		l2.append((H / 2) * (W - (W // 3 + 1)))
	else:
		l2.append((H // 2) * (W - (W // 3 + 1)))
		l2.append((H // 2 + 1) * (W - (W // 3 + 1)))
	L.append(max(l2) - min(l2))

	l3 = []
	l3.append(W * (H // 3))
	if W % 2 == 0:
		l3.append((W / 2) * (H - (H // 3)))
	else:
		l3.append((W // 2) * (H - (H // 3)))
		l3.append((W // 2 + 1) * (H - (H // 3)))
	L.append(max(l3) - min(l3))

	l4 = []
	l4.append(W * (H // 3 + 1))
	if W % 2 == 0:
		l4.append((W / 2) * (H - (H // 3 + 1)))
	else:
		l4.append((W // 2) * (H - (H // 3 + 1)))
		l4.append((W // 2 + 1) * (H - (H // 3 + 1)))
	L.append(max(l4) - min(l4))

	mnmn = min(L)

	mn2 = min(L)

	print(int(min(mn, mn2)))