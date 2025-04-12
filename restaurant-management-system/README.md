# Restaurant Management System

## Overview
A Java-based restaurant management system with JavaFX GUI that handles menu items, ingredients, and order processing.

## Project Description
This application implements a comprehensive restaurant management system that handles different types of dishes (Appetizers, Main Courses, and Desserts) with their ingredients and pricing calculations.

### Key Components

#### 1. Ingredient System
- **Ingredient Types (IngredientType enum)**:
  - SALTY
  - SWEET
  - NEUTRAL

- **Ingredient Class**
  - Properties:
    - name (String)
    - type (IngredientType)
    - pricePerKg (double)
  - Features:
    - Price calculation for specific quantities
    - Lexicographical comparison by name
    - String format: "name - price/kg"

#### 2. Dish Management

**Abstract Dish Class**
- Properties:
  - name (String)
  - ingredientList (Map<Ingredient, Double>)
  - basePrice (double)
- Features:
  - Automatic base price calculation
  - Abstract price calculation method with discount option

**Specific Dish Types**:
1. **Appetizer**
   - Only allows SALTY and NEUTRAL ingredients
   - 25% discount when applicable

2. **Main Course**
   - Only allows SALTY and NEUTRAL ingredients
   - 10% discount when applicable

3. **Dessert**
   - Only allows SWEET and NEUTRAL ingredients
   - No discount policy

#### 3. Data Management
- **OrderedPair<T1, T2>**: Generic class for paired data storage
- **Restaurant Class**: Main application class (JavaFX)
  - Manages available ingredients
  - Handles menu items and their availability

### File Formats

1. **ingredients.txt**
```
TYPE NAME PRICE_PER_KG
Example:
NEUTRAL eggs 280
SALTY potato 110
SWEET chocolate 1500
```

2. **menu.txt**
```
DISH_TYPE DISH_NAME INGREDIENT1 QUANTITY1 INGREDIENT2 QUANTITY2 ...
Example:
D Bajadera biscuit 150 nuts 80 chocolate 50 sugar 40
M Chicken chicken 300 potato 180 milk 40
```

## Technical Requirements

### Prerequisites
- Java Development Kit (JDK)
- JavaFX SDK
- Compatible IDE (Eclipse, IntelliJ IDEA, etc.)

### Running the Application
1. Ensure all required files are present:
   - ingredients.txt
   - menu.txt
2. Launch the application
3. Select available dishes
4. Calculate total price with applicable discounts

## Author
- [@cherrysview](https://github.com/cherrysview)