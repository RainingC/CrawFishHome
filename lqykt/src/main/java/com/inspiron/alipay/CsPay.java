package com.inspiron.alipay;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alipay.api.AlipayApiException;

@WebServlet(name = "CsPay")
public class CsPay extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }


    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 参数目前都是 写死的 根据业务需求 写活
        System.out.println("已经成功进入到后台接口");
        Map<String, String> maps = new HashMap<String, String>();
        maps.put("out_trade_no", UtilDate.getOrderNum());
        maps.put("total_amount","1.00");
        maps.put("subject", "Iphone6 16G");
        maps.put("body", "Iphone6 16G");
        //maps.put("product_code", "QUICK_WAP_PAY");
        maps.put("product_code", "FAST_INSTANT_TRADE_PAY");//网页版参数不同
        // 下面两个 参数的 KEY 不要乱写 要和工具类里面对应
        maps.put("ReturnUrl", "http://f8s7ks.natappfree.cc/alipay.trade.wap.pay-java-utf-8/return_url.jsp");
        maps.put("NotifyUrl", "http://f8s7ks.natappfree.cc/alipay.trade.wap.pay-java-utf-8/notify_url.jsp");
        try {
            AlipayClientFactory ali = new AlipayClientFactory();
            String form = ali.Pc_Pay(maps);
            if (!form.equals("err")) {
                response.setContentType("text/html;charset=utf-8");
                response.getWriter().write(form);// 直接将完整的表单html输出到页面
                response.getWriter().flush();
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

    }

}

