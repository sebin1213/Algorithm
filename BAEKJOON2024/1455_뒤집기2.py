r,c = map(int,input().split())
coin_state = True

coin_li = [list(map(int, list(input().strip()))) for _ in range(r)]

coin_state = [ [0]*(c+1) for _ in range(r+1) ]

for idx in range(r-1,-1,-1):
    row_count=0
    for c_idx in range(c-1,-1,-1):
        coin_state[idx][c_idx] = coin_state[idx+1][c_idx] + row_count
        if (coin_li[idx][c_idx] + coin_state[idx][c_idx]) % 2 == 1:
            row_count+=1
            coin_state[idx][c_idx]+=1
print(coin_state[0][0])