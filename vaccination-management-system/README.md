# Vaccination Management System

## Overview
A Java-based vaccination management system with JavaFX GUI that tracks and manages the vaccination process across different cities.

## Project Description
This application implements a comprehensive vaccination tracking system that handles different types of vaccines (Pfizer and SputnikV) and monitors vaccination success rates across various cities.

### Key Features
- **Vaccine Management**:
  - Support for two vaccine types: Pfizer and SputnikV
  - Pfizer vaccines with three strength levels (WEAK, MEDIUM, STRONG) 
    - Success rates: 30%, 60%, 90% respectively
  - SputnikV vaccines with different vectors
    - RNA vector: 100% success rate
    - DNA vector: 50% success rate

- **City Management**:
  - Track vaccinated citizens by city
  - Store citizen IDs and vaccination success status
  - Generate city-wise vaccination reports

- **User Interface Features**:
  - Load vaccines from text file
  - Display available vaccines (sorted/unsorted)
  - Process citizen vaccination
  - Generate vaccination success reports

### Technical Details

#### Class Structure
1. **Abstract Class: `Vaccine`**
   - Base class for all vaccine types
   - Tracks vaccination identifier and total vaccinated count

2. **Enum: `Strength`**
   - Values: WEAK, MEDIUM, STRONG
   - Used for Pfizer vaccine doses

3. **Classes:**
   - `Pfizer` (extends `Vaccine`)
   - `SputnikV` (extends `Vaccine`)
   - `City`
   - `Vaccination` (main JavaFX Application class)

#### Data Storage
- Vaccines are loaded from `vaccines.txt`
- File format:
  ```
  For Pfizer: F-identifier, doseStrength
  For SputnikV: S-identifier, vector, alcoholRestrictionMonths
  ```

#### Sorting Implementation
- Vaccines are sorted by type (Pfizer before SputnikV)
- Pfizer vaccines sorted by dose strength (STRONG → MEDIUM → WEAK)
- SputnikV vaccines sorted by alcohol restriction period

## Usage

### Prerequisites
- Java Development Kit (JDK)
- JavaFX SDK
- Any Java IDE (Eclipse, IntelliJ IDEA, etc.)

### Running the Application
1. Load vaccine data from `vaccines.txt`
2. Select sorting preference (sorted/unsorted)
3. Enter citizen details (City name and ID)
4. Process vaccination
5. Generate reports as needed

### File Format Example
```
F001,STRONG
F002,MEDIUM
S001,RNA,3
S002,DNA,6
```

## Author
- [@cherrysview](https://github.com/cherrysview)
