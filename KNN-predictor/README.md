# Real Estate Price Predictor using KNN

## Project Overview
A JavaFX application that implements a K-Nearest Neighbors (KNN) algorithm to predict real estate prices based on various features such as square footage, number of rooms, floor level, and distance from city center.

## Features
- KNN-based prediction system
- Support for multiple distance metrics (Euclidean and Manhattan)
- Vector space operations
- Data loading from files
- User-friendly GUI interface

## Technical Details

### Core Components

1. **Vector Class**
- Dynamic vector implementation using ArrayList
- Operations for vector manipulation:
  - Element addition and retrieval
  - Subvector creation
  - Size management
  - String representation

2. **Metric Interface & Implementations**
- Abstract metric interface for distance calculations
- Implementations:
  - Euclidean Distance Metric
  - Manhattan Distance Metric

3. **Vector Space**
- Manages coordinate names and vectors
- File input/output operations
- Data representation and storage

4. **KNN Predictor**
- K-nearest neighbors implementation
- Target variable prediction based on k closest neighbors
- Customizable distance metrics

### Data Format
Example data file structure (nekretnine.txt):
```
square_footage rooms floor_level distance_from_center price
70 2.5 1 15.0 130000
80 3.0 5 12.5 145000
45 1.5 1 7.1 99000
```

## Usage

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- JavaFX SDK
- Any Java IDE (Eclipse, IntelliJ IDEA, etc.)

### Running the Application
1. Load the real estate database file
2. Enter property features:
   - Square footage
   - Number of rooms
   - Floor level
   - Distance from city center
3. Select distance metric (Euclidean or Manhattan)
4. Click "Predict Price" to get the estimated property value

### Input Validation
- All input fields must contain valid numerical values
- Error messages are displayed in red for invalid inputs
- Successful predictions are shown in blue

## Technical Implementation

### Vector Operations
- Dynamic size management
- Subvector extraction
- Element access and modification
- Input validation and error handling

### Distance Calculations
1. **Euclidean Distance**
   - Formula: sqrt(Σ(ui - vi)²)
   - Used for standard geometric distance

2. **Manhattan Distance**
   - Formula: Σ|ui - vi|
   - Used for grid-like distance measurements

### Price Prediction
- Formula: xn-1 = (1/k) * Σ(vi(n-1))
- Where k is the number of nearest neighbors
- vi represents the i-th closest vector

## Author
[Your Name/Username]
