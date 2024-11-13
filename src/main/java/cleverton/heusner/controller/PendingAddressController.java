package cleverton.heusner.controller;

import cleverton.heusner.message.PendingAddressMessage;
import cleverton.heusner.producer.PendingAddressProducer;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(
        name = "Incomplete Addresses API",
        description = "Show CPFs with incomplete addresses."
)
@RestController
@RequestMapping("pending-addresses")
public class PendingAddressController {

    private final PendingAddressProducer pendingAddressProducer;

    public PendingAddressController(final PendingAddressProducer pendingAddressProducer) {
        this.pendingAddressProducer = pendingAddressProducer;
    }

    @PostMapping
    public ResponseEntity<Void> sendMessage(@RequestBody final PendingAddressMessage pendingAddressMessage) {
        pendingAddressProducer.sendMessage(pendingAddressMessage);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}