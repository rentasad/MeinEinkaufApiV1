# MeinEinkauf API - Java Client Library

[![Version](https://img.shields.io/badge/version-1.3.0-blue.svg)](https://github.com/yourusername/meineinkauf-api)
[![Java](https://img.shields.io/badge/Java-17+-orange.svg)](https://openjdk.java.net/)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](LICENSE)
[![Status](https://img.shields.io/badge/status-stable-green.svg)]()

A Java implementation of the MeinEinkauf.ch REST API client library for seamless integration with the MeinEinkauf order management system.

## 📋 Table of Contents

- [Features](#-features)
- [Requirements](#-requirements)
- [Installation](#-installation)
- [Quick Start](#-quick-start)
- [Usage Examples](#-usage-examples)
- [API Documentation](#-api-documentation)
- [Configuration](#-configuration)
- [Testing](#-testing)
- [Changelog](#-changelog)
- [Support](#-support)
- [License](#-license)

## ✨ Features

- 🚀 Easy-to-use REST API client for MeinEinkauf.ch
- 📦 Complete object model for orders, customers, shipments, and more
- 🔒 Secure authentication with API key support
- 🏗️ Built with modern Java 17 features
- 📊 Comprehensive error handling and logging
- ✅ Fully tested with unit tests
- 🔄 Support for both GET and POST requests
- 📝 Type-safe API using Lombok data classes

## 🔧 Requirements

- **Java**: JDK 17 or higher
- **Maven**: 3.6+ (for building)
- **Dependencies**:
  - Apache HttpClient 5.x
  - Jackson 2.20.x (JSON processing)
  - Logback 1.5.27 (Logging)
  - Lombok 1.18.42 (Code generation)

## 📦 Installation

### Maven

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>gustini</groupId>
    <artifactId>gustini.library.meinEinkaufApi</artifactId>
    <version>1.3.0</version>
</dependency>
```

### Gradle

```gradle
implementation 'gustini:gustini.library.meinEinkaufApi:1.3.0'
```

## 🚀 Quick Start

### 1. Initialize the API Connector

```java
import org.gustini.library.meinEinkaufApi.MeinEinkaufApiConnector;

// For production
MeinEinkaufApiConnector apiConnector = new MeinEinkaufApiConnector(
    "your-username",
    "YOUR_API_KEY",
    "api.meineinkauf.ch"
);

// For testing
MeinEinkaufApiConnector testConnector = new MeinEinkaufApiConnector(
    "api",
    "YOUR_TEST_API_KEY",
    "api-test.meineinkauf.ch"
);
```

### 2. Send a Simple Request

```java
// Test echo endpoint
String response = apiConnector.sendGetRequest("/v1/echo/HelloWorld/");
System.out.println(response);
```

### 3. Create and Send an Order

```java
import org.gustini.library.meinEinkaufApi.objects.apiObjects.post.*;
import org.gustini.library.meinEinkaufApi.objects.enums.*;

// Create customer
Customer customer = new Customer("CUST-12345", "customer@example.com");

// Create address
Adress invoiceAddress = new Adress(
    Salutation.HERR,
    "Max",
    "Mustermann",
    "Musterstrasse",
    "42",
    "8005",
    "Zürich"
);

// Create order
Order order = new Order(
    "ORDER-12345",
    "2024-02-05",
    Currency.CHF,
    PaymentType.CREDITCARD,
    199.99,
    customer,
    invoiceAddress
);

// Convert to JSON and send
String jsonString = JsonBuilder.getJsonStringFromObject(order);
String response = apiConnector.sendPostRequest(jsonString, "/v1/orders/");
```

## 📚 Usage Examples

### Working with Articles

```java
// Create article with attributes
Article article = new Article(
    "ART-001",
    "Swiss Chocolate Box",
    2,
    49.99,
    VatRate.STANDARD
);

// Add attributes
Attributes attributes = new Attributes();
attributes.setColor("Brown");
attributes.setMaterial("Chocolate");
attributes.setEan("7612345678901");
article.setAttributes(attributes);
```

### Working with Consignments

```java
// Create consignment with tracking
Article[] articles = {article1, article2};
Consignment consignment = new Consignment(articles);
consignment.setGrossWeight(2.5);

Tracking tracking = new Tracking("DHL", "00340433836478263837");
consignment.setTracking(tracking);
```

### Adding Shipping Costs

```java
ShippingCost shippingCost = new ShippingCost(9.90, VatRate.STANDARD);
order.setShippingCost(shippingCost);
```

### Working with Discounts

```java
DiscountRequest discount = new DiscountRequest(
    "Summer Sale 2024",
    -10.00,  // Negative value!
    VatRate.STANDARD
);
order.setDiscounts(new DiscountRequest[]{discount});
```

## 📖 API Documentation

For detailed API documentation, please refer to:

- **Official MeinEinkauf API Docs**: [https://docs.meineinkauf.ch](https://docs.meineinkauf.ch)
- **JavaDoc**: Available in the source code
- **Unit Tests**: See [MeinEinkaufApiConnectorTest.java](src/test/java/org/gustini/library/meinEinkaufApi/MeinEinkaufApiConnectorTest.java)

### Available API Objects

| Object | Description |
|--------|-------------|
| `Order` | Complete order with customer, items, and shipping |
| `Customer` | Customer information with contact details |
| `Adress` | Address information (invoice/shipping) |
| `Article` | Individual article/product in an order |
| `Consignment` | Shipment container for articles |
| `ShippingCost` | Shipping cost information |
| `Tracking` | Tracking information for shipments |
| `Donation` | Optional donation information |
| `DiscountRequest` | Discount/voucher information |
| `InvoiceInformation` | Invoice-specific data |
| `EsrInformation` | Swiss payment slip (ESR) data |
| `Attributes` | Additional article attributes |

### Supported Enums

- `Currency`: `EUR`, `CHF`
- `PaymentType`: `MASTERCARD`, `VISA`, `AMEX`, `CREDITCARD`, `PAYPAL`, `PREPAYMENT`, `INVOICE`, `OTHER`
- `VatRate`: `STANDARD`, `REDUCED`, `NONE`
- `Salutation`: `HERR`, `FRAU`, `NOTHING`

## ⚙️ Configuration

### Logging

The library uses SLF4J with Logback. Configure logging in your `logback.xml`:

```xml
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>

    <logger name="org.gustini.library.meinEinkaufApi" level="INFO"/>

    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```

### Error Handling

```java
try {
    String response = apiConnector.sendPostRequest(jsonString, "/v1/orders/");
    // Process response
} catch (IOException e) {
    log.error("Network error occurred", e);
} catch (URISyntaxException e) {
    log.error("Invalid URL format", e);
}
```

## 🧪 Testing

Run the unit tests:

```bash
mvn test
```

Run specific test class:

```bash
mvn test -Dtest=MeinEinkaufApiConnectorTest
```

### Test Environment

The library includes tests for the MeinEinkauf test environment:
- Test Host: `api-test.meineinkauf.ch`
- Requires test API credentials

## 📋 Changelog

### Version 1.3.0 (2026-02-05)
- ✨ Updated to Java 17
- 🔒 Security update: Logback 1.5.27 (fixes CVE-2025-11226)
- 🏗️ Refactored all API objects with Lombok @Data
- 📝 Improved documentation with English comments
- 🧹 Code cleanup and modernization
- ⚡ Updated dependencies (Jackson 2.20.0, HttpClient 5.4.3)

### Version 1.2.2
- 🐛 Bug fixes and stability improvements

### Version 1.2.1
- ✅ Initial stable release

### Version 1.0.1 (2020-01-21)
- 🐛 Several small bugfixes

### Version 1.0.0 (2019-11-13)
- 🎉 Initial release with MeinEinkauf API implementation

## 💬 Support

For questions, issues, or feature requests:

- **Email**: support@gustini.com
- **API Documentation**: [https://docs.meineinkauf.ch](https://docs.meineinkauf.ch)
- **Issue Tracker**: Contact your internal development team

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

Copyright © 2019-2024 Gustini GmbH

### What does this mean?

✅ **You are free to:**
- Use this library commercially
- Modify the source code
- Distribute the library
- Use it privately

📋 **Under the condition that:**
- You include the original copyright notice and license text

---

**Gustini GmbH** | [www.gustini.com](https://www.gustini.com) | Made with ❤️ in Switzerland 🇨🇭

