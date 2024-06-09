N, C = map(int, input().split())
li = [ int(input()) for _ in range(N)]
li.sort()
max_len = (li[N-1]-li[0])//(C-1)
result=0
def check(wifi_len):
    st_idx=0
    count = 0
    for idx in range(1,N):
        if li[idx] - li[st_idx] >= wifi_len:
            count+=1
            st_idx = idx
        if count == C-1:
            return True
    return False

def search(wifi_len, max_len, min_len):
    global result
    if wifi_len > max_len or wifi_len == 0 or result == wifi_len:
        return
    
    if check(wifi_len):
        min_len = wifi_len + 1
        result = max(result,wifi_len)
        search((max_len+min_len)//2, max_len, wifi_len)
        return
    else:
        max_len = wifi_len - 1
        search((max_len+min_len)//2, max_len, min_len)
        
search(max_len,max_len,1)
print(result)