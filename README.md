# Temp File Cleaner

A Java program to clean temporary files from the following directories:

1. System temporary directory (`java.io.tmpdir`).
2. User-specific temporary directory (`%TEMP%`).
3. System-wide temporary directory (`%TMP%`).
4. Windows `Prefetch` directory.

This tool is designed to help clean up unnecessary files and free up disk space.

---

## 🚀 Features

- Deletes files from the system's temporary folders.
- Supports recursive deletion of files in subdirectories.
- Safeguards directories by verifying their existence before deletion.
- Provides real-time logs for deleted and failed-to-delete files.

---

## 🛠️ Prerequisites

- **Java Development Kit (JDK)**: Version 8 or later.
- **Administrator Privileges**: Required to access and delete files in the `Prefetch` directory and other system directories.

---

## 📦 Setup

1. Clone the repository or download the source file.
2. Ensure that you have a Java IDE or `javac` installed for compiling the code.

---

## 🚀 Usage

### Compile the Program
1. Open a terminal in the program's directory.
2. Compile the program using:

   ```bash
   javac TempFileCleaner.java
