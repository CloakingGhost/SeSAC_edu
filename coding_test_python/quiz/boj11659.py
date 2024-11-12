"""
누적합

주어진 데이터가 변할 때 대응하지 못함
세그먼트 트리 알고리즘으로 해결
"""

import sys

input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
acc_nums = [0]
for num in nums:
    acc_nums.append(acc_nums[-1] + num)
for _ in range(M):
    i, j = map(int, input().split())
    i -= 1
    print(acc_nums[j] - acc_nums[i])
    
    
    
# from itertools import accumulate

# acc = [0] + accumulate(nums)

# 이렇게 하면 for 안만들어도 됨
