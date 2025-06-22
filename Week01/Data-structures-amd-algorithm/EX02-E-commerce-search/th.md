## 🛒 Exercise: E-commerce Platform Search Functionality

### 🧠 1. Understanding Asymptotic Notation

**Big O Notation** describes the upper bound of an algorithm's runtime or space usage as input size (`n`) increases. It helps evaluate efficiency and scalability.

#### Common Complexities:

| Complexity   | Description   | Example Use-Case        |
| ------------ | ------------- | ----------------------- |
| `O(1)`       | Constant time | Accessing array element |
| `O(log n)`   | Logarithmic   | Binary search           |
| `O(n)`       | Linear        | Linear search           |
| `O(n log n)` | Quasi-linear  | Merge/Quick sort        |
| `O(n²)`      | Quadratic     | Nested loops            |

#### Search Scenario Cases:

| Case    | Linear Search      | Binary Search     |
| ------- | ------------------ | ----------------- |
| Best    | Target is first    | Middle element    |
| Average | Middle of array    | Logarithmic steps |
| Worst   | Target not present | Logarithmic steps |

---

### 🏗️ 2. Setup

Create a `Product` class with key attributes:

```java
class Product {
    int productId;
    String productName;
    String category;
}
```

Use an array of `Product` objects to perform searches by `productId`.

---

### ⚙️ 3. Implementation Overview

#### 🔎 Linear Search

* Iterate through the list and check each product.
* Time Complexity: **O(n)**

#### 🔍 Binary Search

* Requires the array to be **sorted by `productId`**.
* Divides the search space in half at each step.
* Time Complexity: **O(log n)**

#### Java Snippet:

```java
Product linearSearch(Product[] products, int id) { ... }
Product binarySearch(Product[] products, int id) { ... }
```

---

### 📊 4. Analysis & Comparison

| Feature          | Linear Search | Binary Search    |
| ---------------- | ------------- | ---------------- |
| Data Requirement | Unsorted      | Sorted           |
| Time Complexity  | O(n)          | O(log n)         |
| Simplicity       | Very simple   | Slightly complex |
| Best Case        | O(1)          | O(1)             |
| Worst Case       | O(n)          | O(log n)         |

#### 🔎 Which is Better?

* For **small or unsorted data**, linear search is sufficient.
* For **large, sorted datasets**, binary search is more efficient.
* In a real e-commerce platform, **search indexing**, **hashing**, or **databases with full-text search** would be used for even better performance.

---

### ✅ Key Takeaways

* Big O helps compare algorithm efficiency.
* Linear search is simple but not scalable.
* Binary search is faster on sorted data.
* In real systems, searches are optimized using indexing and caching.

