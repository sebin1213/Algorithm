result = 0
n = int(input())
if n==1:
    print(0)
else:
    i = int(input())
    
    next_i = int(input())
    if i < next_i:
        asc = True
    else:
        asc = False
    min_num, max_num = min(i, next_i),  max(i, next_i)
    
    for _ in range(n-2):
        i = next_i
        next_i = int(input())
        if i > next_i:
            if asc:
                asc = False
                if i < max_num:
                    result += (i - min_num)
                else:
                    result += (max_num - min_num)
                min_num = i
            min_num = min(i, next_i)
        elif i < next_i:
            asc = True
            max_num = max(max_num, next_i)
    
    result += (max_num - min_num)
    print(result)