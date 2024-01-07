package hello.itemservice.domain.item;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import javax.imageio.event.IIOReadWarningListener;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    // @AfterEach 하면 테스트가 하나 하나가 끝날  때 마다 실행
    // test에 지장을 주지 않기 위해 테스트가 끝날 때마다 데이터 초기화 목적
    @AfterEach
    void afterEach(){
        itemRepository.clearStore();
    }

    @Test
    void save(){
        // given
        Item item = new Item("itemA", 10000, 1); // 임의의 아이템 생성

        // when
        Item savedItem = itemRepository.save(item); // 아이템 저장

        // then
        Item findItem = itemRepository.findById(item.getId()); // 임의로 생성한 아이템의 아이디 조회
         assertThat(findItem).isEqualTo(savedItem); // 가, 저장한 아이템과 같은가? // 즉 저장한 값과 조회한 값이 같은가?
    }

    @Test
    void findAll(){
        // given
        Item item1 = new Item("item1", 10000, 1); // 임의의 아이템 생성
        Item item2 = new Item("item2", 20000, 2 ); // 임의의 아이템 생성

        itemRepository.save(item1);
        itemRepository.save(item2);

        // when
        List<Item> result = itemRepository.findAll();

        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(item1, item2);
    }


    @Test
    void updateItem(){
        // given
        Item item = new Item("item1", 10000, 1); // 임의의 아이템 생성

        Item savedItem = itemRepository.save(item); // 생성한 아이템 저장
        Long itemId = savedItem.getId(); // 생성한 아이템의 아이디 가져오기 (조회)

        // when
        Item updateParam = new Item("item2", 20000, 10); // 임의의 뉴 아이템 생성
        itemRepository.update(itemId, updateParam); // 기존의 아이템을 뉴 아템으로 업데이트하기

        // then
        Item findItem = itemRepository.findById(itemId);
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }


}