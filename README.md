# Index
- [Pending Address Processor](#pending-address-processor)
- [Prerequisites](#prerequisites)
- [Usage](#usage)

## Pending Address Processor
> This project implements a producer and a consumer using RabbitMQ, with an example of message retries and a dead-letter queue (DLQ). The consumer will attempt to process the message up to three times, and if it fails, the message is sent to the DLQ.

## Prerequisites
- Java `22`
- Windows `11`

## Usage
1. Start the RabbitMQ server (ensure it’s running on the default port);
2. At the root of the project, run the command ```./mvnw spring-boot:run```;
3. Access the API documentation at http://localhost:8080/doc.html;
4. Send a message to the endpoint ```/pending-addresses```;
5. Check the logs to observe the retry attempts;
6. In the RabbitMQ Management panel (http://localhost:15672), verify if the message was sent to the DLQ after the retry attempts failed.