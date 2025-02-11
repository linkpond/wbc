package ce3.wbc.controller;

import ce3.wbc.controller.rto.response.ChefRes;
import ce3.wbc.dto.ChefDto;
import ce3.wbc.service.ChefService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/chefs")
@RequiredArgsConstructor
public class ChefController {

    private final ChefService chefService;

    @GetMapping
    public String getAllChefs(Model model) {
        List<ChefRes> chefs = chefService.getAllChefs();
        model.addAttribute("chefs", chefs);
        return "chefs";
    }

//  postman에서 json 형식으로 api 확인 용도 (확인 시 RestController로 변경 필요)
    @GetMapping("/groupedByCategory")
    public List<ChefRes> getChefsGroupedByCategory(Model model) {
        Map<String, List<ChefRes>> groupedChefs = chefService.getChefsGroupedByCategory();
        model.addAttribute("groupedChefs", groupedChefs);
//        return "groupedByCategory";
        return groupedChefs.get("B");
    }
}