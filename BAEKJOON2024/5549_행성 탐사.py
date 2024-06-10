import sys
input = sys.stdin.readline

r, c = map(int,input().split())
n = int(input())
map_li = [[[0,0,0] for _ in range(c)] for _ in range(r)]

def check_area(area, u_li, l_li, d_li, li):
    j_c = u_li[0]+l_li[0]-d_li[0]
    i_c = u_li[1]+l_li[1]-d_li[1]
    o_c = u_li[2]+l_li[2]-d_li[2]
    if area=="J":
        li[0], li[1], li[2] = j_c + 1, i_c, o_c
        return
    elif area=="I":
        li[0], li[1], li[2] = j_c, i_c + 1, o_c
        return
    else:
        li[0], li[1], li[2] = j_c, i_c, o_c + 1
        return

map_row = input()
check_area(map_row[0], [0,0,0], [0,0,0], [0,0,0], map_li[0][0])
for c_idx in range(1, c):
    check_area(map_row[c_idx], [0,0,0],map_li[0][c_idx-1], [0,0,0], map_li[0][c_idx])

for idx in range(1,r):
    map_row = input()
    for c_idx in range(c):
        if c_idx==0:
            check_area(map_row[0], map_li[idx-1][0], [0,0,0], [0,0,0], map_li[idx][0])
        else:
            check_area(map_row[c_idx], map_li[idx-1][c_idx],map_li[idx][c_idx-1], map_li[idx-1][c_idx-1], map_li[idx][c_idx])
for i in range(n):
    st_y, st_x, end_y, end_x = map(int,input().split())
    st_x, st_y, end_x, end_y = st_x-1, st_y-1, end_x-1, end_y-1
    j_c = map_li[end_y][end_x][0]
    i_c = map_li[end_y][end_x][1]
    o_c = map_li[end_y][end_x][2]
    
    if st_x == 0 and st_y == 0:
        print(j_c, o_c, i_c)
        continue
    elif st_x == 0:
        j_c -= map_li[st_y-1][end_x][0]
        i_c -= map_li[st_y-1][end_x][1]
        o_c -= map_li[st_y-1][end_x][2]
    elif st_y == 0:
        j_c -= map_li[end_y][st_x-1][0]
        i_c -= map_li[end_y][st_x-1][1]
        o_c -= map_li[end_y][st_x-1][2]
    else:
        j_c += (map_li[st_y-1][st_x-1][0] - map_li[st_y-1][end_x][0] - map_li[end_y][st_x-1][0])
        i_c += (map_li[st_y-1][st_x-1][1] - map_li[st_y-1][end_x][1] - map_li[end_y][st_x-1][1])
        o_c += (map_li[st_y-1][st_x-1][2] - map_li[st_y-1][end_x][2] - map_li[end_y][st_x-1][2])
    print(j_c, o_c, i_c)