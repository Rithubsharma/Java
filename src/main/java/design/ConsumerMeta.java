package design;

public class ConsumerMeta {
    private String consumerId;
    private Integer offset;

    public ConsumerMeta(String consumerId, Integer offset) {
        this.consumerId = consumerId;
        this.offset = offset;
    }

    public String getConsumerId() {
        return consumerId;
    }

    public Integer getOffset() {
        return offset;
    }

    public void incrementOffset(){
        this.offset = offset+1;
    }
}
