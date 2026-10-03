
# Capstone-B AtCoder Dataset

Generated: 2026-10-03T17:13:19

## Source Database

D:\Dataset\AtCoder_Raw\java-python-clones.db

## Raw Data

The source database contains Java and Python submissions.

Unique Java programs after exact-source deduplication:
20,632

Unique Python programs after exact-source deduplication:
21,715

Unique problem groups:
574

Exact duplicate source programs removed:
799

## Final Dataset

Total pairs:
6,000

### Pair Types

- Java-Python: 2,000
  - Positive: 1,000
  - Negative: 1,000

- Python-Python: 2,000
  - Positive: 1,000
  - Negative: 1,000

- Java-Java: 2,000
  - Positive: 1,000
  - Negative: 1,000

### Total

- Positive: 3,000
- Negative: 3,000
- Total: 6,000

## Positive Pair Definition

A positive pair contains two submissions from the same:

    contest_type
    contest_id
    problem_id

Therefore, both submissions belong to the same AtCoder problem.

This should be interpreted as a functional-similarity proxy rather than
manually verified ground-truth clone annotation.

## Negative Pair Definition

A negative pair contains submissions from different problem groups.

Whenever possible, the generator selects different problems from the same
contest to create harder negative examples.

These are constructed negative labels and are not manually verified
semantic non-clones.

## Leakage Prevention

The dataset uses problem-level splitting.

Each complete:

    (contest_type, contest_id, problem_id)

group belongs to exactly one split:

    train
    validation
    test

Therefore, the same problem group cannot appear in more than one split.

Problem split seed:
42

## Exact Source Deduplication

Exact duplicate source programs were detected using SHA-256 hashes.

Duplicate source rows removed globally:
799

## Split

### Train

4,200 pairs:

- 2,100 positive
- 2,100 negative

### Validation

900 pairs:

- 450 positive
- 450 negative

### Test

900 pairs:

- 450 positive
- 450 negative

## Folder Structure

Capstone_B_Dataset/
|
|-- code/
|   |-- train/
|   |   |-- java/
|   |   `-- python/
|   |
|   |-- validation/
|   |   |-- java/
|   |   `-- python/
|   |
|   `-- test/
|       |-- java/
|       `-- python/
|
|-- pairs/
|   |-- all_pairs.csv
|   |-- train.csv
|   |-- validation.csv
|   `-- test.csv
|
|-- metadata/
|   |-- code_metadata.csv
|   |-- dataset_statistics.csv
|   `-- dataset_config.json
|
`-- README.md

## Intended Use

This dataset is intended for the Capstone-B clone-analysis pipeline,
including:

1. Cross-language candidate retrieval
2. Clone verification
3. Structural feature extraction
4. Semantic representation
5. Prioritization experiments
6. Explainability experiments

## Important Limitation

Same-problem membership is used as a functional-similarity proxy.
It does not guarantee that every pair is a manually verified semantic clone.

Similarly, different-problem membership is used to construct negative pairs,
but it does not mathematically guarantee semantic non-clone behavior.
