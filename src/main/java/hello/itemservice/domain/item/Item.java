package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//  @Getter @Setter @RequiredArgsConstructor @ToString @EqualsAndHashCode <- 가 다들어가서 위험함
// 그래서 잘 알고 써야만 함!!!!!!
@Data
public class Item {

    private Long id ;
    private String itemName ;
    private Integer price ; // int 형 쓰면 0 이라도 들어갸야함, 즉 NULL이 있다는 가정하에 Integer 사용
    private Integer quantity ;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


}
