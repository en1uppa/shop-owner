package test;



//import com.example.controller.user.userController;
//import com.example.entity.User;
//import com.example.mapper.UserMapper;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import static org.mockito.Mockito.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//@SpringBootTest
//@AutoConfigureMockMvc
//public class updateUserControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserMapper userMapper;
//
//    @Test
//    public void update_UserExists_ShouldReturnSuccess() throws Exception {
//        // 模拟数据库中已存在的用户
//        User existingUser = new User();
//        existingUser.setUser_id(1);
//        existingUser.setUser_name("John Doe");
//        existingUser.setPassword("oldPassword");
//        existingUser.setTel("1234567890");
//        existingUser.setEmail("john.doe@example.com");
//
//        // 模拟返回的更新前数据
//        when(userMapper.getUserById(1)).thenReturn(existingUser);
//
//        // 执行请求并验证结果
//        mockMvc.perform(MockMvcRequestBuilders.put("/user/user/update/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"user_name\":\"Jane Doe\", \"password\":\"newPassword\", \"tel\":\"0987654321\", \"email\":\"jane.doe@example.com\"}"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.msg").value("修改个人信息成功"));
//
//        // 验证 updateUserById 调用的参数
//        verify(userMapper, times(1)).updateUserById(argThat(updatedUser ->
//                updatedUser.getUser_id() == 1 &&
//                        updatedUser.getUser_name().equals("Jane Doe") &&
//                        updatedUser.getPassword().equals("newPassword") &&
//                        updatedUser.getTel().equals("0987654321") &&
//                        updatedUser.getEmail().equals("jane.doe@example.com")
//        ));
//    }
//
//    @Test
//    public void update_UserDoesNotExist_ShouldReturnError() throws Exception {
//        // 模拟用户不存在
//        when(userMapper.getUserById(1)).thenReturn(null);
//
//        // 执行请求并验证结果
//        mockMvc.perform(MockMvcRequestBuilders.put("/user/user/update/1")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"user_name\":\"Jane Doe\", \"password\":\"newPassword\", \"tel\":\"0987654321\", \"email\":\"jane.doe@example.com\"}"))
//                .andExpect(status().isInternalServerError())
//                .andExpect(jsonPath("$.msg").value("用户不存在"));
//
//        // 验证未调用 updateUserById 方法
//        verify(userMapper, never()).updateUserById(any(User.class));
//    }
//}
//

