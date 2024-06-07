N = int(input())
li = [int(input()) for _ in range(N)]

ps = [0] * (2 * N + 1)
for i in range(2 * N):
    ps[i + 1] = ps[i] + li[i % N]

ans = 0
total, right = sum(li), 1
for left in range(2 * N):
    while right < 2 * N + 1 and ps[right] - ps[left] <= total - ps[right] + ps[left]:
        ans = max(ans, ps[right] - ps[left])
        right += 1
print(ans)