f_n, r_n = map(int, input().split())

# 친구 관계 그래프 초기화
dance_li = [[False] * f_n for _ in range(f_n)]
f_state = [False] * f_n

for _ in range(r_n):
    f1, f2 = map(int, input().split())
    dance_li[f1 - 1][f2 - 1] = True
    dance_li[f2 - 1][f1 - 1] = True

max_dance = 0

def dfs(depth):
    global max_dance
    if depth == f_n:
        dance_count = sum(f_state)
        if dance_count < f_n:
            dance_count+=1
        max_dance = max(max_dance, dance_count)
        return
    
    # 이미 매칭됐으면 다음 깊이로 이동
    if f_state[depth]:
        dfs(depth + 1)
        return

    # 현재 친구를 매칭하지 않고 넘어가는 경우
    dfs(depth + 1)

    # 현재 친구를 다른 친구와 매칭하는 경우
    for idx in range(depth + 1, f_n):
        if not f_state[depth] and not f_state[idx] and dance_li[depth][idx]:
            f_state[depth], f_state[idx] = True, True
            dfs(depth + 1)
            f_state[depth], f_state[idx] = False, False

dfs(0)
print(max_dance)