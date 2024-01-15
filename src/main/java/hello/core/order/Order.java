package hello.core.order;

public class Order {


    private Long memberId;
    private String itemName;
    private int itemPrive;
    private int discountPrice;

    public Order(Long memberId, String itemName, int itemPrive, int discountPrice) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrive = itemPrive;
        this.discountPrice = discountPrice;
    }

        // 정가 - 할인 = 할인금액
    public int calculatePrice() {
        return itemPrive - discountPrice;
    }


    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemPrive() {
        return itemPrive;
    }

    public void setItemPrive(int itemPrive) {
        this.itemPrive = itemPrive;
    }

    public int getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(int discountPrice) {
        this.discountPrice = discountPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrive=" + itemPrive +
                ", discountPrice=" + discountPrice +
                '}';
    }
}
