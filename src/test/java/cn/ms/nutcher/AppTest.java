package cn.ms.nutcher;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.File;

/**
 * Unit test for simple App.
 */
public class AppTest {
    public static void main(String[] args) {
        String url = "http://localhost:8080";
        String filePath = "C:\\Users\\weizheng\\Desktop\\elasticsearch-2.3.2.zip";
        RestTemplate rest = new RestTemplate();
        FileSystemResource resource = new FileSystemResource(new File(filePath));
        MultiValueMap<String, Object> param = new LinkedMultiValueMap<>();
        param.add("fileName", "test.txt");
        param.add("file", resource);
//        String forObject = rest.getForObject(url, String.class, param);
        String string = rest.postForObject(url, param, String.class);
        System.out.println(string);

//        HttpEntity<MultiValueMap<String, Object>> httpEntity = new HttpEntity<MultiValueMap<String,Object>>(param);
//        ResponseEntity<String> responseEntity = rest.exchange(url, HttpMethod.POST, httpEntity, String.class);
//        System.out.println(responseEntity.getBody());
    }
}
