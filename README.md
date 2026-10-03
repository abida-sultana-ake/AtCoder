# Capstone-B AtCoder Dataset

## Project

**Beyond Clone Detection: An Explainable Multi-Language Framework for Clone Analysis and Maintenance Decision Support**

This repository contains the curated dataset prepared for the Capstone-B project. The dataset is constructed from the AtCoder Java-Python submissions database and is designed for clone detection, verification, structural analysis, and downstream maintenance-oriented experiments.

---

## Dataset Overview

The final dataset contains **6,000 code pairs** across three pair types:

| Pair Type     |  Positive |  Negative |     Total |
| ------------- | --------: | --------: | --------: |
| Java-Java     |     1,000 |     1,000 |     2,000 |
| Python-Java   |     1,000 |     1,000 |     2,000 |
| Python-Python |     1,000 |     1,000 |     2,000 |
| **Total**     | **3,000** | **3,000** | **6,000** |

The dataset contains **8,582 unique code files**:

* **Java:** 4,359
* **Python:** 4,223

---

## Dataset Source

The raw data comes from the **AtCoder Java-Python submissions SQLite database**.

The original database contains:

* Java submissions: 20,828
* Python submissions: 22,318
* Total Java/Python submissions: 43,146

Exact duplicate source programs were removed before constructing the final benchmark.

---

## Pair Construction

### Positive Pairs

A positive pair consists of two submissions belonging to the same:

```text
contest_type
contest_id
problem_id
```

This means both submissions belong to the same AtCoder problem.

For this reason, positive labels should be interpreted as a **same-problem functional-similarity proxy**, rather than manually verified semantic-clone ground truth.

### Negative Pairs

A negative pair consists of two submissions belonging to different problem groups.

Whenever possible, different problems from the same contest are selected to make the negative examples less trivial.

Negative labels are therefore **constructed benchmark negatives** and are not manually verified semantic non-clones.

---

## Duplicate Removal

Exact duplicate source programs were identified using **SHA-256 hashing** and removed globally before pair generation.

This reduces the risk of having identical code instances appear multiple times in the dataset.

---

## Train / Validation / Test Split

The dataset uses a **problem-level split** to reduce data leakage.

The complete:

```text
(contest_type, contest_id, problem_id)
```

problem group is assigned to only one split.

### Train

* 4,200 pairs
* 2,100 positive
* 2,100 negative

### Validation

* 900 pairs
* 450 positive
* 450 negative

### Test

* 900 pairs
* 450 positive
* 450 negative

Therefore, the same problem group is not shared between train, validation, and test.

---

## Repository Structure

```text
AtCoder/
│
├── code/
│   ├── train/
│   │   ├── java/
│   │   └── python/
│   │
│   ├── validation/
│   │   ├── java/
│   │   └── python/
│   │
│   └── test/
│       ├── java/
│       └── python/
│
├── metadata/
│   ├── code_metadata.csv
│   ├── dataset_config.json
│   └── dataset_statistics.csv
│
├── pairs/
│   ├── all_pairs.csv
│   ├── train.csv
│   ├── validation.csv
│   └── test.csv
│
└── README.md
```

---

## Main Files

### `pairs/all_pairs.csv`

Contains all 6,000 pairs.

### `pairs/train.csv`

Training split containing 4,200 pairs.

### `pairs/validation.csv`

Validation split containing 900 pairs.

### `pairs/test.csv`

Test split containing 900 pairs.

### `metadata/code_metadata.csv`

Metadata for the exported code instances, including language, problem information, source length, execution time, token count, and source hash.

### `metadata/dataset_statistics.csv`

Summary statistics describing the generated dataset.

### `metadata/dataset_config.json`

Stores dataset-generation configuration, random seed, split information, pair composition, and label definitions.

---

## Intended Use

The dataset is intended for the Capstone-B research pipeline, including:

1. Same-language and cross-language clone analysis
2. Clone candidate retrieval
3. Clone verification and classification
4. Structural feature extraction
5. Semantic code representation
6. Maintenance prioritization
7. Evidence-based explanation
8. Experimental evaluation

Potential downstream tools include Tree-sitter, NiCad, pretrained code embeddings, vector retrieval, and lightweight machine-learning models.

---

## Important Dataset Limitation

The labels in this dataset are **constructed from AtCoder problem membership**.

A same-problem pair is treated as a positive functional-similarity candidate, but this does not guarantee that the two implementations are semantic clones.

Similarly, a different-problem pair is treated as a negative example, but different problems do not mathematically guarantee complete semantic dissimilarity.

Therefore, the dataset should be described as a **constructed benchmark dataset / functional-similarity proxy dataset**, rather than a manually validated clone ground-truth dataset.

---

## Reproducibility

The dataset was generated from the original AtCoder submissions database using a fixed random seed and problem-level splitting procedure.

The exported metadata files document the dataset configuration and statistics used during construction.

---

## Project Context

This dataset supports the broader Capstone-B objective of moving beyond binary clone detection toward:

```text
Clone Detection
       ↓
Clone Verification
       ↓
Clone Characterisation
       ↓
Maintenance Prioritisation
       ↓
Action Recommendation
       ↓
Evidence-Based Explanation
```

The goal is to provide developers with not only information about whether two code fragments are similar, but also evidence that can support downstream maintenance decisions.