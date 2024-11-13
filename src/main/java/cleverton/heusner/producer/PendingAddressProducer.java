package cleverton.heusner.producer;

import cleverton.heusner.message.PendingAddressMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PendingAddressProducer {

    private static final Logger logger = LoggerFactory.getLogger(PendingAddressProducer.class);

    private final String exchangeName;
    private final String routingKey;
    private final RabbitTemplate rabbitTemplate;

    public PendingAddressProducer(@Value("${exchange.name}") final String exchangeName,
                                  @Value("${routing.key}") final String routingKey,
                                  final RabbitTemplate rabbitTemplate) {
        this.exchangeName = exchangeName;
        this.routingKey = routingKey;
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(final PendingAddressMessage pendingAddressMessage) {
        logger.info("Message '{}' sent.", pendingAddressMessage);
        rabbitTemplate.convertAndSend(exchangeName, routingKey, pendingAddressMessage);
    }
}