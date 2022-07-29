package hello.itemservice.web.basic;

import hello.itemservice.domain.item.Item;
import hello.itemservice.domain.item.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor
public class BasicItemController {

    private final ItemRepository itemRepository;

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }

    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }
    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

//    @PostMapping("/add")
    public String addItemV1(@RequestParam String itemName,
                       @RequestParam int price,
                       @RequestParam Integer quantity,
                       Model model) {

        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item", item);

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item, Model model) {

        itemRepository.save(item);

//  @ModelAttribute는 2가지를 처리해준다. 보통 모델객체를 만들어주고,
//  해당 모델객체는 뷰에서도 쓰이기 때문에  @ModelAttribute가 지정한 이름 ("item") 으로 자동으로 모델에 넣어준다. 여기서는 화면에서 item이라는 이름을 쓰므로 item으로 설정한 것이다.
//        model.addAttribute("item", item);     // 따라서 자동추가해주므로 생략 가능

        return "basic/item";
    }

//    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) { // @ModelAttribute에 name을 직접 넣지 않으면, 기본적으로 클래스명의 첫글자를 소문자로 바꿔서(ex- Item -> item) @ModelAttribute에 넣어준다.
        itemRepository.save(item);
        return "basic/item";
    }

    @PostMapping("/add")
    public String addItemV4(Item item) { // @ModelAttribute를 생략할 수 있다 (String같이 단순 파라미터가 오면 @RequestParam이 자동적용되고, 이렇게 우리가 만든 Item 객체처럼 임의의 객체인 경우에는 @ModelAttribute가 적용된다.).
        itemRepository.save(item);
        return "basic/item";
    }

    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }
}
