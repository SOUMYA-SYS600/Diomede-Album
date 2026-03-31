# Diomede-Album: Automated DICOM Organization Tool

## 🏥 Overview
**Diomede-Album** is a lightweight Java-based utility designed for medical researchers to automate the organization of locally stored DICOM (Digital Imaging and Communications in Medicine) images. 

Currently, researchers manually sort and share DICOM datasets. This project introduces a metadata-driven approach to automatically group images into "Virtual Albums" based on clinical parameters like `StudyInstanceUID`, making data sharing for research seamless and efficient.

This project is part of a proposal for **GSoC 2026** under the **Alaska Center for Health Analytics and Training (CHAT)**.

## ✨ Key Features (PoC Stage)
- **Metadata Extraction:** High-performance parsing of DICOM headers using the `dcm4che3` library.
- **Automated Grouping:** An $O(n)$ complexity algorithm that identifies and clusters images belonging to the same medical study.
- **Modular Architecture:** Clean separation between the Parser, Service, and Model layers for easy scalability.
- **Fast Indexing:** Optimized to read only metadata tags (skipping heavy pixel data) for rapid folder scanning.

## 🛠️ Tech Stack
- **Language:** Java 17+
- **Build Tool:** Maven
- **Library:** [dcm4che](https://github.com/dcm4che/dcm4che) (High-performance DICOM toolkit)
- **Data Format:** JSON (for future OHIF Viewer integration)

## 📂 Project Structure
```text
Diomede-Album/
├── src/
│   ├── main/
│   │   └── java/com/diomede/album/
│   │       ├── Main.java             # Entry point for the PoC
│   │       ├── parser/               # DICOM parsing logic
│   │       ├── service/              # Album grouping algorithms
│   │       └── model/                # Data structures for Albums/Images
├── pom.xml                           # Maven dependencies
└── README.md                         # Project documentation