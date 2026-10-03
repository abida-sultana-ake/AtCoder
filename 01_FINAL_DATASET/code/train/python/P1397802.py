n, m = map(int, input().split())
n %= 12
m_t = m*(360/60)
h_t = n*(360/12)+(m*(360/60))/12
# print(m_t, h_t)
print(min(abs(m_t - h_t), 360-abs(m_t - h_t)))
