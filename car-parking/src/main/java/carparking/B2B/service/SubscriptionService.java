package carparking.B2B.service;
import carparking.B2B.dao.entity.SubscriptionEntity;
import carparking.B2B.dto.SubscriptionDto;

public interface SubscriptionService {
    SubscriptionEntity addSubscription(SubscriptionDto dto);
}
