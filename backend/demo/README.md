# Add payments with CURL

curl -X POST http://localhost:8080/payments -H "Content-Type: application/json" -d '{"paymentDate":"2026-09-01","payee":"Save-On-Foods","amount":84.27,"description":"Weekly groceries","category":"Food"}' && \
curl -X POST http://localhost:8080/payments -H "Content-Type: application/json" -d '{"paymentDate":"2026-09-03","payee":"BC Hydro","amount":126.43,"description":"Electricity bill","category":"Utilities"}' && \
curl -X POST http://localhost:8080/payments -H "Content-Type: application/json" -d '{"paymentDate":"2026-09-05","payee":"Marty'\''s Mountain Cycle","amount":23.11,"description":"Bike supplies","category":"Hobbies"}' && \
curl -X POST http://localhost:8080/payments -H "Content-Type: application/json" -d '{"paymentDate":"2026-09-08","payee":"Shell","amount":72.50,"description":"Fuel","category":"Transportation"}' && \
curl -X POST http://localhost:8080/payments -H "Content-Type: application/json" -d '{"paymentDate":"2026-09-10","payee":"Netflix","amount":22.99,"description":"Monthly subscription","category":"Entertainment"}'

# Delete payments by id

curl -X DELETE http://localhost:8080/payments/1
