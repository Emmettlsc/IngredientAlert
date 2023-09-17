import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user-history")
public class UserHistoryController {
    private final UserHistoryService userHistoryService;

    @Autowired
    public UserHistoryController(UserHistoryService userHistoryService) {
        this.userHistoryService = userHistoryService;
    }

    @GetMapping("/")
    public List<UserHistory> getAllUserHistory() {
        return userHistoryService.getAllUserHistory();
    }

    @PostMapping("/")
    public UserHistory addUserHistory(@RequestBody UserHistory userHistory) {
        return userHistoryService.addUserHistory(userHistory);
    }

    @DeleteMapping("/{id}")
    public void removeUserHistory(@PathVariable Long id) {
        userHistoryService.removeUserHistory(id);
    }
}
