@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password; // Store hashed password
    private String email;
    // Getters and setters...
}

@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String category;
    // Getters and setters...
}

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String questionText;
    private String type; // e.g., "MCQ", "True/False"
    // More fields for options and answers...
}
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
    List<Quiz> findByCategory(String category);
}
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Hash password and save user
    }

    public User loginUser(String username, String password) {
        // Validate user credentials
    }
}

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }
}
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        // Registration logic
    }
}

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/{category}")
    public List<Quiz> getQuizzesByCategory(@PathVariable String category) {
        return quizService.getQuizzesByCategory(category);
    }
}
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Set up the scene and user interface elements
        primaryStage.setTitle("Quiz Application");
        // Add buttons, forms, etc.
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
