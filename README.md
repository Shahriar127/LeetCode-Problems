# Leetcode Problems

**Binary Search**<br/>

1.Sqrt(x) : [Sqrt(x).pdf](https://github.com/user-attachments/files/17672316/Sqrt.x.pdf)

**Process 1 - Using DP O(n^2)**
   
   **Longest Increasing Subsequence**

To illustrate how the Longest Increasing Subsequence (LIS) is computed with a tree structure, we can visualize the relationships between the elements of the array and the decisions made at each step.

Input Array:
arr[] = {3, 10, 2, 1, 20}

Tree Structure for LIS Calculation:
scss
Copy code
                             (3)
                            / | \
                          /   |   \
                       (10)  (2)  (1)
                        /          \
                    (20)          [None]
                    /
                [None]
Explanation of the Tree:
Root Node: The root represents the first element 3. It can start a new subsequence.

Branching:

From 3, you can go to 10, as 10 > 3.
You cannot go to 2 or 1, since they are less than 3.
From 10, you can go to 20 because 20 > 10.
No further branches:

From 10, you cannot branch to any other numbers since 2 and 1 are not greater.
2 and 1 do not lead to any increasing subsequence.
Final Paths:

The only valid increasing subsequence paths are:
Path 1: 3 -> 10 -> 20, which has a length of 3.
Path 2: 3 alone has a length of 1.
Path 3: 10 alone has a length of 1.
Path 4: 2 and 1 also have a length of 1 each.
Computing the DP Array:
Using the above tree structure, we can compute the dp[] array:

Start with dp[] = {1, 1, 1, 1, 1}.

Building the dp Array:

For 10, dp[1] becomes 2 (dp[0] + 1).
For 2, no updates occur since it’s not greater than 3.
For 1, no updates occur since it’s not greater than 3.
For 20, dp[4] becomes 3 (dp[1] + 1).
Final DP Array:
After all iterations, the dp[] array will be:
dp[] = {1, 2, 1, 1, 3}

Maximum LIS Length:
The maximum value in dp[] is 3, which represents the length of the Longest Increasing Subsequence.

**Process 2 - Using DP + Binary Search O(nlog(n))**

I can reduce the time complexity of the Longest Increasing Subsequence (LIS) problem using a combination of dynamic programming and binary search. The optimized approach achieves a time complexity of 
𝑂(𝑛log𝑛)
O(nlogn) by maintaining a separate array that keeps track of the smallest tail of all increasing subsequences found so far.

Optimized Approach Using Binary Search
Here’s how the optimized approach works:

Use a Tail Array:

Maintain an array (tails) where tails[i] will hold the minimum possible tail value for all increasing subsequences of length 𝑖+1
Binary Search:

For each element in the input array, use binary search to find its position in the tails array. If the element is larger than all elements in tails, it extends the largest increasing subsequence.
If it can replace an existing value in tails, it will do so to maintain the smallest possible tail values.
Final Length:

The length of the tails array at the end will represent the length of the longest increasing subsequence.
