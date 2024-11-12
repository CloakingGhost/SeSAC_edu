# region 수 찾기

import sys

input = sys.stdin.readline
# 입력 받기
N = int(input())  # 5
A = set(map(int, input().split()))  # '4 1 5 2 3'
M = int(input())  # 5
B = list(map(int, input().split()))  # '1 3 7 9 5'

# 아래에 있는 배열을 선형으로 탐색
for num in B:
    # 위에 있는 배열에 있다면? => 1 출력
    if num in A:  # 만약에 num이 A 안에 있다면
        print(1)
    # 없다면? => 0 출력
    else:
        print(0)


# endregion
