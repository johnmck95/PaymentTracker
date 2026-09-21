#!/bin/bash

set -a
source .env
set +a

docker compose up -d

echo "Waiting for MySQL..."

until [ "$(docker inspect -f '{{.State.Health.Status}}' paymenttracker-mysql 2>/dev/null)" = "healthy" ]; do
    sleep 1
done

echo "MySQL is ready."

(cd backend/demo && ./mvnw spring-boot:run) &
BACKEND_PID=$!

(cd frontend/angular-app && npm start) &
FRONTEND_PID=$!

trap "kill $BACKEND_PID $FRONTEND_PID; docker compose down" EXIT

wait