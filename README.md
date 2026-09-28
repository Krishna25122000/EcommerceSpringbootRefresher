# Ecommerce backend

Spring Boot API for authentication, products, users, carts, and orders.

## Local setup

Requires Java 17 or 21. The Maven wrapper downloads Maven and dependencies on
the first run; no separate Maven or database installation is needed.

```sh
./mvnw clean verify
./mvnw spring-boot:run -Dspring-boot.run.profiles=local
```

The API runs at http://localhost:8080. The local profile binds to loopback and
stores its H2 database in `.local/ecommerce.mv.db`, preserving data on restart.
Stop with Ctrl+C. Run commands from this backend directory.

```sh
curl http://localhost:8080/api/v1/products
```

An empty database returns `[]`. Register through `POST /auth/register` with
`name`, `email`, and `password`, then log in through `POST /auth/login` with
`email` and `password`. Use the returned token as `Authorization: Bearer <token>`
for authenticated endpoints.

The sibling frontend already proxies `/api` and `/auth` to port 8080.
Start it from its directory with `npm run dev`.

## PostgreSQL

Create an `ecommerce` database and provide credentials via environment variables.
Run without the local profile:

```sh
export DB_URL=jdbc:postgresql://localhost:5432/ecommerce
export DB_USERNAME=postgres
export DB_PASSWORD='your-database-password'
./mvnw spring-boot:run
```

Tests use an isolated, in-memory H2 database. PostgreSQL compatibility is not
covered by those tests. Hibernate currently updates the schema automatically.

This setup is for development. Before a public deployment, replace the existing
hardcoded JWT key and review endpoint authorization.
