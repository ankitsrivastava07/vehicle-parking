package carparking.B2B.service;
import carparking.B2B.dao.entity.SubscriptionEntity;
import carparking.B2B.dto.SubscriptionDto;
import carparking.convertor.Convertor;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService{

    @Override
    public SubscriptionEntity addSubscription(SubscriptionDto subscriptionDto){
        SubscriptionEntity entity = Convertor.dtoToEntityConversion(subscriptionDto,SubscriptionEntity.class);

        return null;
    }
}
