//package test;
//
//import org.junit.jupiter.api.Test;
//
//import com.example.controller.user.userController;
//import com.example.entity.User;
//import com.example.mapper.UserMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import static org.mockito.Mockito.doNothing;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//
//@AutoConfigureMockMvc
//public class adduserControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private UserMapper userMapper;
//
//    @InjectMocks
//    private userController userController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
//    }
//
//    @Test
//    public void add_UserRegistered_SuccessResponse() throws Exception {
//        User user = new User();
//        user.setUser_name("testUser");
//        user.setPassword("testPassword");
//        user.setTel("1234567890");
//        user.setEmail("test@example.com");
//
//        doNothing().when(userMapper).add(user);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/user/user/register")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"user_name\":\"testUser\",\"password\":\"testPassword\",\"tel\":\"1234567890\",\"email\":\"test@example.com\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.code").value(200))
//                .andExpect(jsonPath("$.data.user_name").value("testUser"))
//                .andExpect(jsonPath("$.data.password").value("testPassword"))
//                .andExpect(jsonPath("$.data.tel").value("1234567890"))
//                .andExpect(jsonPath("$.data.email").value("test@example.com"));
//    }
//}