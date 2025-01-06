//package test;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//
//import com.example.controller.keeper.productController;
//import com.example.entity.Product;
//import com.example.mapper.ProductMapper;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.http.MediaType;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.math.BigDecimal;
//
//import static org.mockito.Mockito.doNothing;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@AutoConfigureMockMvc
//public class addProductControllerTest {
//
//
//    private MockMvc mockMvc;
//
//    @Mock
//    private ProductMapper productMapper;
//
//    @InjectMocks
//    private productController productController;
//
//    @BeforeEach
//    public void setup() {
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
//    }
//
//    @Test
//    public void add_ValidProduct_ShouldReturnOk() throws Exception {
//        Product product = new Product();
//        product.setProduct_name("Test Product");
//        product.setProduct_price(new BigDecimal("10.00"));
//        product.setProduct_num(10);
//        product.setDescription("Test Description");
//        product.setImage_url("http://test.com");
//        product.setProduct_type("Test Type");
//
//
//        when(productMapper.addProduct(product)).thenReturn(1);
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/keeper/product/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"product_name\":\"Test Product\",\"product_price\":10.00,\"product_num\":10,\"description\":\"Test Description\",\"image_url\":\"http://test.com\",\"product_type\":\"Test Type\"}"))
//                .andExpect(status().isOk());
//    }
//
//    @Test
//    public void add_InvalidProduct_ShouldReturnBadRequest() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.post("/keeper/product/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\"product_name\":\"\",\"product_price\":null,\"product_num\":null,\"description\":\"\",\"image_url\":\"\",\"product_type\":\"\"}"))
//                .andExpect(status().isBadRequest());
//    }
//}