"""
10 2
3 -2 -4 -9 0 3 7 13 8 -3

10 5
3 -2 -4 -9 0 3 7 13 8 -3
"""

'''
구간합
슬라이딩 윈도우 기법
고정된 길이에 대해 값 비교시 사용
'''
import sys

input = sys.stdin.readline

N, K = map(int, input().split())
temper = list(map(int, input().split()))

tmp = max_num = sum(temper[:K])

for idx in range(N - K):
    tmp += temper[idx + K] - temper[idx]
    max_num = max(tmp, max_num)
print(max_num)
