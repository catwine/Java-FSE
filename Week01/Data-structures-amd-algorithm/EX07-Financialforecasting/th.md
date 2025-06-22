## 📈 Exercise 7: Financial Forecasting (Theory)

### 🔁 1. Understand Recursive Algorithms

**Recursion** is a technique where a function calls itself to solve a smaller instance of the same problem until it reaches a base case.

#### 💡 Why Recursion?

* Recursion simplifies complex problems into smaller sub-problems.
* It's closer to mathematical definitions (e.g., compound interest, Fibonacci).
* Makes code concise and expressive.

#### Example:

```text
future_value(P, rate, n) = P * (1 + rate) * future_value(P, rate, n - 1)
```

---

### ⚙️ 2. Setup

We aim to calculate future financial value using recursive logic.
Given:

* `P₀`: initial principal
* `growthRates[]`: annual growth percentages (e.g., 0.08 for 8%)
* `n`: number of years to forecast

We define a recursive function:

```java
double forecast(double principal, double[] growthRates, int yearsAhead);
```

---

### 🛠️ 3. Implementation Approaches

#### ✅ Method 1: Simple Recursion

* Repeats yearly growth recursively.
* Base case: `yearsAhead == 0`
* Recursive case: apply `growthRates[year]` and call again.

#### ✅ Method 2: Memoized Recursion

* Store already computed results to avoid recalculating.
* Useful in overlapping subproblems (e.g., Fibonacci, dynamic programming).

#### ✅ Method 3: Fast Exponentiation (O(log n))

* Applies when the growth rate is constant.
* Uses divide-and-conquer to reduce recursive calls:

    * `(1 + r)^n = ((1 + r)^(n/2))^2`

---

### 📊 4. Time Complexity Analysis

| Method              | Time Complexity | Space Complexity | Notes                           |
| ------------------- | --------------- | ---------------- | ------------------------------- |
| Simple Recursion    | O(n)            | O(n) stack depth | Risk of stack overflow          |
| Memoized Recursion  | O(n)            | O(n) memory      | Helps with overlapping problems |
| Fast Exponentiation | O(log n)        | O(log n)         | Only for constant growth rate   |

---

### 🧠 5. Optimization Strategies

* **Convert to Iteration**: Avoids stack overflow in deep recursion.
* **Memoization**: Use a hash map to store and reuse previous results.
* **Tail Recursion**: Java doesn't optimize tail recursion, so prefer loops.
* **Fast Powering**: Use mathematical tricks to reduce time from `O(n)` to `O(log n)` when possible.

---

### ✅ Summary

| Technique           | Best For                  | Limitation                        |
| ------------------- | ------------------------- | --------------------------------- |
| Recursion           | Clear, elegant logic      | Stack limit, slower for large `n` |
| Memoization         | Overlapping subproblems   | Extra memory required             |
| Fast Exponentiation | Constant rate compounding | Can't handle varying rates        |
