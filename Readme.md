# Project Name
### Load Management System

## Description
The Load Management System is a backend API designed to streamline and automate the management of freight and cargo loads within a logistics environment. The primary objective of this system is to provide an efficient and organized way to handle information related to the transportation of goods, catering to the specific needs of shippers and logistics professionals.

## Table of Contents
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Database Setup](#database-setup)
- [Running the Project](#running-the-project)
- [API Documentation](#api-documentation)
    - [1. Get All Loads](#1-get-all-loads)
    - [2. Add Load by ID](#2-get-load-by-id)
    - [3. Get Loads by Shipper ID](#3-get-loads-by-shipper-id)
    - [4. Save Load Details](#4-save-load-details)
    - [5. Update Load Details](#5-update-load-by-id)
    - [6. Delete Load by ID](#6-delete-load-by-id)

## Getting Started

### Prerequisites
- Java (JDK) installed
- Maven installed
- PostgresSQL installed (if applicable)

### Installation
1. Clone the repository: `git clone https://github.com/AryanKumar36/AryanKumar36-Assignment_1_Liveasy`
2. Navigate to the project directory: `cd AryanKumar36-Assignment_1_Liveasy` 
3. Build the project: `mvn clean install`

## Database Setup
1. Create a Database and Load Table: 
   - Open a PostgreSQL client, such as `psql` or pgAdmin, and create a new database (`liveasyDb`). Then, create the 'load' table using the following SQL command:

    ```sql
    -- Create the 'load' table
      CREATE TABLE load (
        id SERIAL PRIMARY KEY,
        loading_point VARCHAR(255),
        unloading_point VARCHAR(255),
        product_type VARCHAR(255),
        truck_type VARCHAR(255),
        no_of_trucks INTEGER,
        weight DOUBLE PRECISION,
        comment TEXT,
        shipper_id VARCHAR(255),
        date DATE
      );
    ```
    - Insert sample data into the 'load' table using the following SQL commands:
   ```sql
    -- Insert sample data
        INSERT INTO load (loading_point, unloading_point, product_type, truck_type, no_of_trucks, weight, comment, shipper_id, date)
        VALUES
        ('Delhi', 'Jaipur', 'Chemicals', 'Canter', 1, 100, '', 'shipper:123', '2023-01-01'),
        ('Mumbai', 'Bangalore', 'Electronics', 'Truck', 2, 200, 'Fragile items', 'shipper:456', '2023-02-15'),
        ('Kolkata', 'Chennai', 'Textiles', 'Lorry', 3, 150, 'Urgent delivery', 'shipper:789', '2023-03-20');
   ```
2. Update application.properties:
   - Update `spring.datasource.url` with your PostgreSQL JDBC URL.
   - Update `spring.datasource.username` and `spring.datasource.password` with your PostgreSQL credentials.
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/liveasyDb
   spring.datasource.username=your_postgres_username
   spring.datasource.password=your_postgres_password
   ```

## Running the Project
1. Run the application: `mvn spring-boot:run`  
2. All endpoints are relative to the base URL: `http://localhost:8080` (Adjust accordingly)



## API Documentation

### 1. Get All Loads

- **Endpoint**: `GET /load`
- **Description**: Retrieve a list of all loads.
- **Example Request**: `http://localhost:8080/load`

#### Example Response (Success):

```json
[
  {
    "id": "Id",
    "loadingPoint": "LoadingPoint",
    "unloadingPoint": "UnloadingPoint",
    "productType": "Type of product",
    "truckType": "VehicleType",
    "noOfTrucks": "No. of trucks",
    "weight": "weight",
    "comment": "comment",
    "shipperId": "ShipperId",
    "date": "DD-MM-YYYY"
  },
  // Additional load objects...
]
```

### 2. Get Load by ID

- **Endpoint**: `GET /load/{id}`
- **Description**: Retrieve details of a specific load by its ID.
- **Example Request**: `http://localhost:8080/load/{id}`

#### Example Response (Success):

```json
{
  "id": "Id",
  "loadingPoint": "LoadingPoint",
  "unloadingPoint": "UnloadingPoint",
  "productType": "Type of product",
  "truckType": "VehicleType",
  "noOfTrucks": "No. of trucks",
  "weight": "weight",
  "comment": "comment",
  "shipperId": "ShipperId",
  "date": "DD-MM-YYYY"
}
```


### 3. Get Loads by Shipper ID

- **Endpoint**: `GET /load`
- **Description**: Retrieve a list of loads associated with a specific shipper using their Shipper ID.
- **Example Request**: `http://localhost:8080/load?shipperId=shipper:456`

#### Example Response (Success):

```json
[
  {
    "id": "Id1",
    "loadingPoint": "LoadingPoint1",
    "unloadingPoint": "UnloadingPoint1",
    "productType": "Type of product1",
    "truckType": "VehicleType1",
    "noOfTrucks": "No. of trucks1",
    "weight": "weight1",
    "comment": "comment1",
    "shipperId": "shipper:456",
    "date": "DD-MM-YYYY1"
  },
  // Additional load objects...
]
```
### 4. Save Load Details

- **Endpoint**: `POST /load`
- **Description**: Save details of a new load.
- **Example Request**: `POST http://localhost:8080/load`

#### Request Body:

- `load` (body, required): The load details to be saved.

```json
{
  "id": "NewId",
  "loadingPoint": "NewLoadingPoint",
  "unloadingPoint": "NewUnloadingPoint",
  "productType": "NewTypeOfProduct",
  "truckType": "NewVehicleType",
  "noOfTrucks": 3,
  "weight": 300.0,
  "comment": "NewComment",
  "shipperId": "shipper:789",
  "date": "DD-MM-YYYY"
}
```

#### Example Response (Success):

```json
  "loads details added successfully"
```

### 5. Update Load Details

- **Endpoint**: `PUT /load/{loadId}`
- **Description**: Update details of an existing load.
- **Example Request**: `PUT http://localhost:8080/load/1`

#### Parameters:

- `loadId` (path, required): The ID of the load to be updated.

#### Request Body:

- `updatedLoad` (body, required): The updated load details.

```json
{
  "id": 1,
  "loadingPoint": "UpdatedLoadingPoint",
  "unloadingPoint": "UpdatedUnloadingPoint",
  "productType": "UpdatedTypeOfProduct",
  "truckType": "UpdatedVehicleType",
  "noOfTrucks": 4,
  "weight": 400.0,
  "comment": "UpdatedComment",
  "shipperId": "shipper:123",
  "date": "DD-MM-YYYY"
}
```

#### Example Response (Success):

```json
{
  "id": 1,
  "loadingPoint": "UpdatedLoadingPoint",
  "unloadingPoint": "UpdatedUnloadingPoint",
  "productType": "UpdatedTypeOfProduct",
  "truckType": "UpdatedVehicleType",
  "noOfTrucks": 4,
  "weight": 400.0,
  "comment": "UpdatedComment",
  "shipperId": "shipper:123",
  "date": "DD-MM-YYYY"
}
```
### 6. Delete Load by ID

- **Endpoint**: `DELETE /load/{loadId}`
- **Description**: Delete details of a specific load by its ID.
- **Example Request**: `DELETE http://localhost:8080/load/1`

#### Parameters:

- `loadId` (path, required): The ID of the load to be deleted.

#### Example Response (Success):

```json
{
  "message": "Deleted the load with id :: 1"
}
```

