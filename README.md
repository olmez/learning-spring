# learning-spring
Learning Spring with Spring Boot via LinkedIn Learning

# Add guest via Curl
curl -X POST http://localhost:8080/api/guests -H 'Content-Type: application/json' -d '{"firstName": "John", "lastName": "Zenith"}'

## Get call
curl  http://localhost:8080/api/rooms