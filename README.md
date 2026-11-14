# banking_transactions
# Banking Data Loader

A small Java program that reads banking data from CSV files, cleans it, loads it into PostgreSQL over JDBC and runs a SQL query across the loaded tables.

I built it to practise plain Java data handling without frameworks: file reading, mapping rows to objects, type conversion and prepared statements.

## What it does

1. **Reads a CSV file** (`CsvReader`). The first line is used as the column names. The rest is returned as a map of column name to list of values, up to a row limit.
2. **Maps each row to an object** (`User`, `Card`) and cleans the raw values on the way:
   - removes `$` and thousands separators from money fields (`$59,696` becomes `59696`)
   - turns `YES` / `NO` into `true` / `false`
   - trims whitespace
3. **Inserts the rows into PostgreSQL** with JDBC prepared statements.
4. **Queries the data** with a join between `users` and `cards` and prints yearly income and total debt per customer.

## Project structure

| File | Purpose |
| --- | --- |
| `Main.java` | Entry point. Reads `cards_data.csv` and starts the user load. |
| `CsvReader.java` | Reads a CSV file into a column-name to values map. |
| `UserToSql.java` | Maps user rows to `User` objects, inserts them, runs the join query. |
| `User.java` | Customer data: age, address, income, debt, credit score. |
| `Card.java` | Card data: brand, type, credit limit, chip, dark-web flag. |
| `Cards.java` | A list of `Card` objects. |
| `Transaction.java` | Transaction data model (not loaded yet, see Limitations). |

## Requirements

- **Java 25**, or Java 21 to 24 with `--enable-preview`. `Main` uses the short `static void main()` form.
- **PostgreSQL** running locally or reachable over the network.
- **PostgreSQL JDBC driver** (`postgresql-<version>.jar`) from https://jdbc.postgresql.org/download/
- **Two CSV files**, `users_data.csv` and `cards_data.csv`, in one folder. They are not included in this repository.

## Setup

### 1. Create the database and tables

```sql
CREATE DATABASE transactions;
```

Connect to it and run:

```sql
CREATE TABLE users (
    id                INTEGER PRIMARY KEY,
    current_age       INTEGER,
    retirement_age    INTEGER,
    birth_year        INTEGER,
    birth_month       INTEGER,
    gender            TEXT,
    address           TEXT,
    latitude          DOUBLE PRECISION,
    longitude         DOUBLE PRECISION,
    per_capita_income INTEGER,
    yearly_income     INTEGER,
    total_debt        INTEGER,
    credit_score      INTEGER,
    num_credit_cards  INTEGER
);

CREATE TABLE cards (
    id                    INTEGER PRIMARY KEY,
    client_id             INTEGER,
    card_brand            TEXT,
    card_type             TEXT,
    card_number           BIGINT,
    expires               TEXT,
    cvv                   INTEGER,
    has_chip              BOOLEAN,
    num_cards_issued      INTEGER,
    credit_limit          INTEGER,
    acct_open_date        TEXT,
    year_pin_last_changed INTEGER,
    card_on_dark_web      BOOLEAN
);
```

### 2. Set the environment variables

No password or personal path is stored in the code. The program reads three variables:

| Variable | Meaning | Example |
| --- | --- | --- |
| `DB_USER` | PostgreSQL user | `postgres` |
| `DB_PASSWORD` | PostgreSQL password | your own |
| `BANKDATA_DIR` | Folder that contains the two CSV files | `/home/me/bankdata` |

Linux and macOS:

```bash
export DB_USER=postgres
export DB_PASSWORD=your-password
export BANKDATA_DIR=/path/to/bankdata
```

Windows (PowerShell):

```powershell
$env:DB_USER = "postgres"
$env:DB_PASSWORD = "your-password"
$env:BANKDATA_DIR = "C:\path\to\bankdata"
```

In IntelliJ, set them under Run → Edit Configurations → Environment variables.

The database URL is `jdbc:postgresql://localhost/transactions`. Change it in `UserToSql.java` and `Main.java` if your database lives elsewhere.

## Run

From the folder that contains the `es/nomann/` source folder:

```bash
javac -d out es/nomann/*.java
java -cp "out:postgresql-<version>.jar" es.nomann.Main
```

On Windows use `;` instead of `:` in the classpath. On Java 21 to 24 add `--release <your version> --enable-preview` to `javac` and `--enable-preview` to `java`.

Or open the project in IntelliJ, add the JDBC driver as a library, and run `Main`.

When it finishes, the program prints the income and debt pairs from the join query, then `ok`.

## Loading the data

The insert steps are switched off in the code so that running the program twice does not insert the same rows twice:

- **Users:** in `UserToSql.java`, uncomment `st.executeUpdate();` to insert the user rows.
- **Cards:** in `Main.java`, uncomment the block that maps and inserts the card rows.

Run once with these enabled to fill the tables, then comment them out again to run only the query.

The row limits are set in the code: 2,000 users (`UserToSql.java`) and 6,000 cards (`Main.java`). A limit must not be higher than the number of rows in its file.

## Limitations

- **Simple CSV parsing.** Lines are split on every comma, so a quoted field that contains a comma is not handled.
- **One insert per row.** There is no batching or transaction handling, so large loads are slow.
- **Transactions are not loaded.** The `Transaction` class exists, but no loader uses it yet.
- **Dates are stored as text.** `expires` and `acct_open_date` are kept as strings.
- **No automated tests.**

## Possible next steps

- Batch inserts with `addBatch()` and a single transaction.
- A loader for the transactions file.
- Proper CSV parsing with a library.
- Maven or Gradle build with the JDBC driver as a dependency.
