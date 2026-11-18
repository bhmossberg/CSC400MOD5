# CSC400MOD5 – LSD Radix Sort

A least-significant-digit (LSD) radix sort for non-negative integers in base 10. Each digit pass uses a stable counting sort, and a test driver sorts a sample array.

## Overview

This is **CSU Global CSC400, Module 5**. It is an Eclipse Java project with its code in the `module5` package under `src/`.

## How the code works

### `RadixSort.java`
- **`sort(Integer[] arr)`** returns right away for a `null` array or one with ≤ 1 element. Otherwise it finds the **maximum** value, then calls `countingSortByDigit(arr, exp)` with `exp = 1, 10, 100, …` until `max / exp` reaches 0. That means one pass for each digit of the largest number, starting from the least significant digit.
- **`countingSortByDigit(Integer[] arr, int exp)`** (private) is a **stable counting sort** on the digit `(value / exp) % 10`:
  1. Count how many values have each digit 0–9.
  2. Turn the counts into running totals (prefix sums), which give each value's final position.
  3. Walk the input **from right to left** and place each value into `output[--count[digit]]`. Going backwards is what keeps the sort stable, and stability is what makes LSD radix sort correct.
  4. Copy `output` back into `arr` with `System.arraycopy`.

**Complexity:** O(d·(n + k)) time, where *d* is the number of digits in the maximum value and *k* = 10, plus O(n + k) extra space. It doesn't compare elements directly. Negative numbers aren't supported.

### `RadixSortTest.java`
Sorts `{783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94}` and prints the array before and after.

## Build and run

JDK 8 or newer:

```bash
mkdir -p bin
javac -d bin src/module5/*.java
java -cp bin module5.RadixSortTest
```

Output (verified):
```
Original: [783, 99, 472, 182, 264, 543, 356, 295, 692, 491, 94]
Sorted:   [94, 99, 182, 264, 295, 356, 472, 491, 543, 692, 783]
```

## Concepts demonstrated
- Non-comparison sorting (radix sort and counting sort)
- Why a stable intermediate sort is required
- Prefix sums for computing positions
- Time and space complexity compared with comparison sorts (Ω(n log n))
