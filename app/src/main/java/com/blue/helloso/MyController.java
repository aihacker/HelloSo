package com.blue.helloso;

import com.blue.helloso.ndktest.NdkTest;
import com.yanzhenjie.andserver.annotation.Controller;
import com.yanzhenjie.andserver.annotation.GetMapping;
import com.yanzhenjie.andserver.annotation.PostMapping;
import com.yanzhenjie.andserver.annotation.RequestParam;
import com.yanzhenjie.andserver.annotation.RestController;
import com.yanzhenjie.andserver.framework.body.JsonBody;
import com.yanzhenjie.andserver.http.HttpRequest;
import com.yanzhenjie.andserver.http.HttpResponse;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MyController {

    @GetMapping("/nightteam_sign")
    public void post_sign(HttpRequest request, HttpResponse response){
        String sign = request.getQuery("sign");
        Map<String ,String> sign_map = new HashMap<>();
        sign = NdkTest.stringFromJNI(sign);
        sign_map.put("signature", sign+" " + MyApplication.getInstance().getApplicationInfo().packageName);
        JSONObject jsonObject = new JSONObject(sign_map);
        response.setBody(new JsonBody(jsonObject));
    }

    @PostMapping("/user/get")
    User login(@RequestParam("id") String id) {
        User user = new User();
        user.setId(id);
        user.setName("AndServer");
        return user;
    }
}
