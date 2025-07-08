# Bookstore - Fawry Rise Journey Challenge

A bookstore system that manages different types of books with inventory management and purchasing capabilities.

## Features

- **Multi-format Book Support**: Handle Paper Books, EBooks, and Demo Books
- **Inventory Management**: Add, remove, and track book quantities
- **Purchase System**: Complete buying process with quantity validation
- **Extensible Design**: Easy to add new book types without system modifications

## Book Types

### Paper Book
- Physical books with stock quantities
- Inventory tracking and stock management

### EBook
- Digital books with file format specification
- No physical inventory constraints

### Demo Book
- Showcase books not available for purchase

## System Architecture

The system follows a clean architecture pattern with:

- **Entities**: Core book models (Book, PaperBook, EBook, DemoBook)
- **Services**: Business logic (BookService, MailService, ShippingService)
- **DTOs**: Data transfer objects
- **Exceptions**: Custom error handling
- **Enums**: Book type definitions

## Core Operations

### Adding Books
Add books to inventory with details:
- ISBN (unique identifier)
- Title
- Publication year
- Price
- Type-specific attributes (stock, file format, etc.)

### Purchasing Books
Buy books with:
- ISBN specification
- Quantity selection
- Customer email and address
- Automatic inventory updates

### Inventory Management
- Remove outdated books by years
- Validate availability before purchase

## Sample Data

| ISBN | Title | Price    | Type | Publication Date | Stock/Format |
|------|-------|----------|------|------------------|--------------|
| 977 | Head First Java | $450.00  | Paper Book | 2017-10-16 | 10 copies |
| 978 | Spring in action | $500.00  | EBook | 2019-05-13 | PDF format |
| 979 | Spring Boot in action | No price | Demo Book | 2018-07-10 | Display only |
| 980 | Efficient MySQL Performance | $375.00  | Paper Book | 2014-01-26 | 3 copies |

## Exception Handling

The system includes comprehensive error handling:
- `BookNotFoundException`: When requested book doesn't exist
- `DuplicateBookException`: When adding existing ISBN
- `InsufficientQuantityException`: When stock is insufficient
- `GlobalExceptionHandler`: Centralized error management

## Testing

![Testing Results Screenshot](/screenshots/1.jpg)
![Testing Results Screenshot](/screenshots/2.jpg)
![Testing Results Screenshot](/screenshots/3.jpg)

Comprehensive test suite with `BookStoreTest` class covering:
- Book addition and removal
- Purchase workflows
- Inventory management

## Getting Started

1. Initialize the bookstore with `BookInitializer`
2. Use `BookService` for all operations

## Future Enhancements

The extensible design allows for easy addition of:

- New Book Formats

- Database Integration
- Advanced Service Integration
- **Email Service Integration**:
  - Automated email delivery for EBooks
  - Purchase confirmation emails

## Finally

---
**I** want to express my sincere gratitude to **Fawry** for this amazing challenge - it was truly an enjoyable and enriching experience.