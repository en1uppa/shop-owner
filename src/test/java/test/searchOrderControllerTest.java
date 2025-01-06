package test;

//import com.example.controller.keeper.orderController;
//import com.example.mapper.OrderMapper;
//import com.example.vo.OrderVo;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@AutoConfigureMockMvc
//public class searchOrderControllerTest {
//
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private OrderMapper orderMapper;
//
//    @InjectMocks
//    private orderController orderController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
//    }
//
//    @Test
//    public void getUserOrderForKeeper_ValidUserId_ReturnsOrderList() throws Exception {
//        // 准备
//        List<OrderVo> orderVoList = new ArrayList<>();
//        OrderVo orderVo = new OrderVo();
//        orderVo.setOrder_id(1);
//        orderVo.setUser_name("John Doe");
//        orderVoList.add(orderVo);
//
//        when(orderMapper.getOrderByUserId(1)).thenReturn(orderVoList);
//
//        mockMvc.perform(get("/keeper/order/getByUserId/1")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].order_id").value(1))
//                .andExpect(jsonPath("$[0].user_name").value("John Doe"));
//    }
//
//    @Test
//    public void getUserOrderForKeeper_ValidUserId_ReturnsEmptyList() throws Exception {
//        // 准备
//        when(orderMapper.getOrderByUserId(2)).thenReturn(new ArrayList<>());
//
//        mockMvc.perform(get("/keeper/order/getByUserId/2")
//                        .accept(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isEmpty());
//    }
//}