package com.shfc.cloud.swagger2;

import com.shfc.cloud.JunitBaseMockMvcTest;
import io.github.robwin.markup.builder.MarkupLanguage;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import springfox.documentation.staticdocs.Swagger2MarkupResultHandler;

/**
 * @Package com.shfc.cloud.swagger2.SwaggerDocTest
 * @Description: SwaggerDocTest
 * @Company:上海房产
 * @Copyright: Copyright (c) 2016
 * Author lv bin
 * @date 2017/3/21 16:41
 * version V1.0.0
 */
public class SwaggerDocTest extends JunitBaseMockMvcTest {

    @Test
    public void convertSwaggerToAsciiDoc() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs")
                .accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
                .andDo(Swagger2MarkupResultHandler.outputDirectory("D:/doc/ascii/")
                        .build())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void convertSwaggerToMarkdown() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/v2/api-docs")
                .accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
                .andDo(Swagger2MarkupResultHandler.outputDirectory("D:/doc/markdown/")
                        .withMarkupLanguage(MarkupLanguage.MARKDOWN).build())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
