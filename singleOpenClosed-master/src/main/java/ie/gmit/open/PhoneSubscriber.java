package ie.gmit.open;

import java.util.List;

public class PhoneSubscriber extends Subscriber{

    public PhoneSubscriber(Long subscriberId, String address, Long phoneNumber, int baseRate, long freeUsage) {
        super(subscriberId, address, phoneNumber, baseRate, freeUsage);
    }

    public double calculateBill(Long subscriberId, int baseRate) {
        List<CallHistory.Call> sessions = CallHistory.getCurrentCalls(subscriberId);
        long totalDuration = sessions.stream().mapToLong(CallHistory.Call::getDuration).sum();
        return totalDuration*baseRate/100;
    }


}