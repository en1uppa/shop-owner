package test;//package test;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class searchControllerTest {
//
//    @Test
//    void getByProductName() {
//    }
//}

//package test;
//
//import com.example.entity.Product;
//import com.example.mapper.SearchMapper;
//import com.example.controller.user.searchController;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.junit.jupiter.api.extension.ExtendWith;
//import static org.mockito.Mockito.*;
//
//import java.math.BigDecimal;
//import java.util.Arrays;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@ExtendWith(MockitoExtension.class)
//class searchControllerTest {
//
//    @Mock
//    private SearchMapper searchMapper; // Mock SearchMapper
//
//    @InjectMocks
//    private searchController searchController; // Inject the mocked dependency
//
//    @Test
//    void getByProductName() {
//        // Arrange: 模拟数据
//        String searchTerm = "Laptop";
//        List<Product> mockProducts = Arrays.asList(
//                new Product(1, "Laptop A", new BigDecimal("1000.00"), 10,
//                        "A high-performance laptop", "url1", "Electronics"),
//                new Product(2, "Laptop B", new BigDecimal("1200.00"), 5,
//                        "A premium gaming laptop", "url2", "Electronics")
//        );
//
//        when(searchMapper.getByProductName(searchTerm)).thenReturn(mockProducts);
//
//        // Act: 调用测试方法
//        List<Product> result = searchController.getByProductName(searchTerm);
//
//        // Assert: 验证结果
//        assertNotNull(result, "The result should not be null.");
//        assertEquals(2, result.size(), "The result size should be 2.");
//
//        Product product1 = result.get(0);
//        assertEquals(1, product1.getProduct_id());
//        assertEquals("Laptop A", product1.getProduct_name());
//        assertEquals(new BigDecimal("1000.00"), product1.getProduct_price());
//        assertEquals(10, product1.getProduct_num());
//        assertEquals("A high-performance laptop", product1.getDescription());
//        assertEquals("url1", product1.getImage_url());
//        assertEquals("Electronics", product1.getProduct_type());
//
//        Product product2 = result.get(1);
//        assertEquals(2, product2.getProduct_id());
//        assertEquals("Laptop B", product2.getProduct_name());
//        assertEquals(new BigDecimal("1200.00"), product2.getProduct_price());
//        assertEquals(5, product2.getProduct_num());
//        assertEquals("A premium gaming laptop", product2.getDescription());
//        assertEquals("url2", product2.getImage_url());
//        assertEquals("Electronics", product2.getProduct_type());
//
//        // Verify: 验证方法调用
//        verify(searchMapper, times(1)).getByProductName(searchTerm);
//    }
//}



//import com.example.controller.user.searchController;
//import com.example.entity.Product;
//import com.example.mapper.SearchMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//public class searchControllerTest {
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private SearchMapper searchMapper;
//
//    @InjectMocks
//    private searchController searchController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(searchController).build();
//    }
//
//    @Test
//    public void getByProductName_ProductExists_ReturnsProductList() throws Exception {
//        // 准备
//        List<Product> productList = new ArrayList<>();
//        productList.add(new Product(1, "Test Product", new BigDecimal("10.00"), 10, "Description", "image_url", "Type"));
//        when(searchMapper.getByProductName("Test")).thenReturn(productList);
//
//        mockMvc.perform(get("/user/search/getByProductName")
//                        .param("searchTerm", "Test"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[0].product_name").value("Test Product"));
//    }
//
//    @Test
//    public void getByProductName_ProductDoesNotExist_ReturnsEmptyList() throws Exception {
//        // 准备
//        when(searchMapper.getByProductName("NonExistent")).thenReturn(new ArrayList<>());
//
//        mockMvc.perform(get("/user/search/getByProductName")
//                        .param("searchTerm", "NonExistent"))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isEmpty());
//    }
//
//    @Test
//    public void getByProductName_EmptySearchTerm_ReturnsEmptyList() throws Exception {
//        // 准备
//        when(searchMapper.getByProductName("")).thenReturn(new ArrayList<>());
//
//        mockMvc.perform(get("/user/search/getByProductName")
//                        .param("searchTerm", ""))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$").isEmpty());
//    }
//}
