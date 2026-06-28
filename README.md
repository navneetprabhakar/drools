# Drools Rule Engine with Spring Boot

> A Spring Boot demo that exposes the Drools (KIE) rule engine through a REST API.

A small Spring Boot application that shows how to embed the Drools Business Rule Management System in a service and drive it over REST. The bundled example evaluates an academic marksheet: it sums marks, computes a percentage, and assigns a letter grade — all via business rules defined in a `.drl` file rather than Java code.

## Features

- Spring-managed `KieContainer` for executing Drools rules
- Rules externalised in a `.drl` file under `src/main/resources`, wired up through `kmodule.xml`
- A single REST endpoint that inserts request/response facts into a `KieSession` and fires the rules
- Example marksheet ruleset that calculates total marks, percentage, and grade in sequential, activation-grouped rules

## How It Works

The example rules live in `src/main/resources/sample/sampleRule.drl` and are registered via `src/main/resources/META-INF/kmodule.xml` (knowledge base `sample`, session `sampleSession`). The ruleset runs three rules in order:

1. **Calculate Total** — sums `marks` and `totalMarks` across all subjects
2. **Calculate Percentage** — computes `(marksObtained / total) × 100`
3. **Calculate Grade** — assigns a letter grade by percentage band (`O ≥ 90`, `A ≥ 80`, `B ≥ 70`, `C ≥ 60`, `D ≥ 50`, `E ≥ 40`, `P ≥ 33`, otherwise `F`)

## Tech Stack

- **Java 8**
- **Spring Boot 4.1.0-M1**
- **Drools Core 7.50.0.Final** + **KIE Spring 7.74.1.Final**
- **Lombok**
- **Maven** (with the Maven Wrapper)

## Getting Started

### Prerequisites

- JDK 8+

### Build

```bash
./mvnw clean package
```

### Run

```bash
./mvnw spring-boot:run
```

The service runs on `http://127.0.0.1:8080` under the context path `/Drools`.

## Configuration

Settings live in `src/main/resources/application.properties`:

| Key | Value |
| --- | --- |
| `server.address` | `127.0.0.1` |
| `server.port` | `8080` |
| `server.servlet.context-path` | `/Drools` |

## API

### `POST /Drools/v1/rules/calculateResult`

Evaluates a marksheet and returns the computed result.

**Request body:**

```json
{
  "marksheet": [
    { "subject": "MATHS", "marks": 80, "totalMarks": 100 },
    { "subject": "SCIENCE", "marks": 80, "totalMarks": 100 }
  ]
}
```

**Response:**

```json
{
  "grade": "A",
  "marksObtained": 160,
  "total": 200,
  "percentage": 80.0
}
```

| Field | Type | Description |
| --- | --- | --- |
| `grade` | string | Letter grade (`O`/`A`/`B`/`C`/`D`/`E`/`P`/`F`) |
| `marksObtained` | integer | Sum of `marks` across subjects |
| `total` | integer | Sum of `totalMarks` across subjects |
| `percentage` | double | Computed percentage |

## Learn More

- Drools project: https://www.drools.org/
