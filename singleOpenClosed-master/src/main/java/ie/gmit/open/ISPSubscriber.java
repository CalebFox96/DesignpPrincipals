package ie.gmit.open;

import java.util.List;

public class ISPSubscriber extends Subscriber{

    private long freeUsage;

    public ISPSubscriber(Long subscriberId, String address, Long phoneNumber, int baseRate, long freeUsage, long freeUsage1) {
        super(subscriberId, address, phoneNumber, baseRate, freeUsage);
        this.freeUsage = freeUsage1;
    }


    public double calculateBill(Long subscriberId, int baseRate) {
        List<InternetSessionHistory.InternetSession> sessions = InternetSessionHistory.getCurrentSessions(subscriberId);
        long totalData = sessions.stream().mapToLong(InternetSessionHistory.InternetSession::getDataUsed).sum();
        long chargeableData = totalData - freeUsage;
        return chargeableData*baseRate/100;
    }

    public long getFreeUsage() {
        return freeUsage;
    }

    public void setFreeUsage(long freeUsage) {
        this.freeUsage = freeUsage;
    }

}