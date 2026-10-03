## Folder Structure

```text
01_FINAL_DATASET/
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
├── pairs/
│   ├── all_pairs.csv
│   ├── train.csv
│   ├── validation.csv
│   └── test.csv
│
├── metadata/
│   ├── code_metadata.csv
│   ├── dataset_statistics.csv
│   └── dataset_config.json
│
└── README.md
```

## Intended Use

This dataset is intended for the Capstone-B clone analysis pipeline, including:

1. Cross-language and same-language clone candidate analysis
2. Clone verification and classification
3. Structural feature extraction
4. Semantic code representation
5. Maintenance prioritization
6. Evidence-based explanation
7. Experimental evaluation