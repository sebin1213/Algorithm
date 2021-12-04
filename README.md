# 👨‍💻 Daily Algorithm



## 💬 language

 ![Python](https://img.shields.io/badge/python-3670A0?style=for-the-badge&logo=python&logoColor=ffdd54)



* ## 📖 Manual

  1. 매일매일 `1`문제 풀이
  2. Weekly Directory Name : `WeekXX`
     - ex) Week01, Week02



## 📚 Weekly Schedule

- 2021.12 
  - 동적계획법





## 함수

**자바**

문자 반복
"0".repeat(i)



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

```python
from collections import Counter

X = ["B", "A", "B"]
y = ["A", "B"]

Counter(X)
# Counter({'B': 2, 'A': 1})

Counter(X)-Counter(y)
# Counter({'B': 1})

```

