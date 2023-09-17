import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserHistoryService {
    private final UserHistoryRepository userHistoryRepository;

    @Autowired
    public UserHistoryService(UserHistoryRepository userHistoryRepository) {
        this.userHistoryRepository = userHistoryRepository;
    }

    // Implement service methods for UserHistory-related operations

    public List<UserHistory> getAllUserHistory() {
        return userHistoryRepository.findAll();
    }

    public UserHistory addUserHistory(UserHistory userHistory) {
        return userHistoryRepository.save(userHistory);
    }

    public void removeUserHistory(Long id) {
        userHistoryRepository.deleteById(id);
    }
}
