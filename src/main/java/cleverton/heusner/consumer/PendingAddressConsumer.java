package cleverton.heusner.consumer;

import cleverton.heusner.message.PendingAddressMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class PendingAddressConsumer {

    private static final Logger logger = LoggerFactory.getLogger(PendingAddressConsumer.class);

    @RabbitListener(queues = {"${queue.name}"})
    public void consume(final PendingAddressMessage pendingAddressMessage) {
        logger.info("Message '{}' received.", pendingAddressMessage);
        throw new RuntimeException("Message sent to DLQ after 3 retries.");
    }
}