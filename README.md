# 👨‍💻 Daily Algorithm



## 💬 language

 ![Python](https://img.shields.io/badge/python-3670A0?style=for-the-badge&logo=python&logoColor=ffdd54)



* ## 📖 Manual

  1. 매일매일 `1`문제 풀이









### 파이썬

#### Counter

[URL](https://inkkim.github.io/python/%ED%8C%8C%EC%9D%B4%EC%8D%AC-Counter-%EC%82%AC%EC%9A%A9%EB%B2%95/)

```python
from collections import Counter

X = ["B", "A", "B"]
y = ["A", "B"]

Counter(X)
# Counter({'B': 2, 'A': 1})

Counter(X)-Counter(y)
# Counter({'B': 1})

Counter('AAAAABB')
# Counter({'A': 5, 'B': 2})
```

**Counter.elements()**

Counter 객체의 정보에 따른 리스트 반환 (양수만)

```
>>> c = Counter(a=4, b=2, c=0, d=-2)
Counter({'a': 4, 'b': 2, 'c': 0, 'd': -2})

>>> sorted(c.elements())
['a', 'a', 'a', 'a', 'b', 'b']
```

**Counter.most_common([n])**

Counter 객체의 count의 빈도 상위 n개의 값 반환하는 메소드

```
>>> Counter('abracadabra').most_common(3)
[('a', 5), ('b', 2), ('r', 2)]
```

```
>>> c = Counter(a=4, b=2, c=0, d=-2)
>>> c.values()                          # count 값 리스트로 반환
>>> c.items()                           # (element, count) 값 튜플로 반환
>>> c.clear()                           # count 값 모두 리셋 (빈 카운터 객체 반환)
>>> list(c)                             # element 값 list로 반환
>>> set(c)                              # element 값 set으로 반환
>>> dict(c)                             # {element, count} 값 딕셔너리로 반환
>>> +c                                  # count 값이 양수 값에 해당하는 쌍만 반환
```



### join

**''.join(리스트)**
''.join(리스트)를 이용하면 매개변수로 들어온 **['a', 'b', 'c'] 이런 식의 리스트를 'abc'의 문자열로 합쳐서 반환**해주는 함수인 것입니다.

**- '구분자'.join(리스트)**
'구분자'.join(리스트)를 이용하면 리스트의 값과 값 사이에 '구분자'에 들어온 구분자를 넣어서 하나의 문자열로 합쳐줍니다.
**'_'.join(['a', 'b', 'c']) 라 하면 "a_b_c" 와 같은 형태로** 문자열을 만들어서 반환해 줍니다.





### SORT

정렬, 문자열 길이 순 정렬도 가능

```python
phone_book = ["12","123","1235","567","88"]
phone_book.sort(key=len)

# ['12', '88', '123', '567', '1235']
```



## ZIP

```python
for X, Y in zip(P, P[1:]):
```



### 큐

```python
from collection import deque

queue = deque()

queue.append()

queue.popleft()

queue.reverse()
```



### 최대공약수(유클리드호제법)

X,Y의 최대공약수는 Y 와 R의 최대공약수와 같다

`R = X % Y`

```python
def gcd(x,y):
    if x % y ==0:
        return y
    else:
        return gcd(y, x % y)
```



## enumerate

```python
for i, val in enumerate(i):
	print(i,val)
    # 값, 인덱스 둘다 출력
```



## heapq , deque

**heapq**

```python
import heapq
heap = []
heapq.heappush(heap, 100)
```



**deque**

```python
from collections import deque
deq = deque()
```

