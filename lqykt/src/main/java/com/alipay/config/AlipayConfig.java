package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {

//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016091600525791";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCDrpiyf0p7OMlSnr1AtotDjF8fvxZ35ui8nfVOKa4OfP++FW7RlrDcxqewC+zJbFnNciZXPPyLTSK7N5N/l7HPWP/df2BNy9TUuGQ62LiZHx/PVExw4Km8CxPcV4F/Us2i5A7YMDxzHmK+CAjIMhY7DDZ7BqHy+eM2Ew+Su7FYRvk2dRzoT1/Uk+oJBw3zigXW9TNyRkjlc5EphcKcQSdkKTVPHa85gAFyGzRH842uxzGCy/3joVGnJqiL1Z1TSstjmUGa0JkEoV6CALuT8z0D35QSTXvV+56fcF1D/uXNBuuO4zlrUxMWWqGcAmeeDbD/PC66YHw7dpwZWHuAz00LAgMBAAECggEADU0pp34sK95El8/pFgxabOxU/4Px5RKyF7ts+ARFzLjbrHvFwe4S13pJngLWXFJRj+sj7FQAvqGADKFEiPLtxyAaWGlxdOpOCV7G4RrbKrx2Hh9JyW0oOBJ2Yx+DuTTICNg4l6XntUkweDmfiXllvXkyV6MH4N9VEDVEsXG8LEp51ftqPd+VVjp+k3RdyZQeMXX6DG7AXzbxTMwsmHvi/aDR3QE0G6K5pvcS9SRrdaMyFcVNhSBwuJT4cWV94UwyOwuKUdcoH/RoL1d4xKiYiC/50dD3gD8UKqV4A0opA4r07jOU/WCdghGqix2YOilT4bd6Z3mkftv4KIAnnxngQQKBgQDGUcw+I6OJI4liM3hDNtyhmpKaHDNOGR8+0Alopo9zEAMwhsXXHXNKOW9/yBSkme/CZyFOwCLKqX15tnHi4vpqRLg/2gs7VYCrSQK00DOTH0P92iJTiNTXrU1YCBQ7zsMxCkZNP5WFucOC2PuSgwHc2CnGmVvTocQNBTPTAN4K4wKBgQCp+zHpFQkklOU4j66byv03eLRx9CEGUsZ1KclUXZ9RRezOQ4G4Xf1aMRAsrf2Dr0RXZ3wm7IGMrLJFBC8Cabys8cw6AQ/Y2I/pXw66WKfL5JaPMHs7b2Qrk98qo1C+MNjTEVq/5P0D5ko4GX0wr/IShthlYpoVUq4ccMk8Z8EFuQKBgBmE0wQ378YoxXfWaaY0fAVrb2vXLx7giq25dUx7CkBjEhX/cZuxlXE6nMdThpx7lmdsf9OzU4bCcnvj5xmr3U8pUpAczY8v/GON/IQpukk3H7edhwc6tzCdgzNNrtTXUTSRPuSXxvSzJ55Br3V12BqD0jRU7YT47tJCFh4ToX7DAoGABEBC/EhJZT/QB70YKc9Gy+dZ4+uuE8FoMy/rWA/LVzX/eR0ZFmpLVsEZXXSwfWWZuPHemf6aMtFy1+UF4/KPBGg7qkuygMLRvo1hCeoDsEa0OTqGKnNbtvdIwoE5GLiSA51QfrIUXc+ZlZOVnO0ZibsTmF2B6vyZXB65+afCnQkCgYA3atH4Nk4luGhffrVAmX0BdXboZlGFGPEytQrs5p3kNbU+JBUTax1P27SOO2kt9C2Y5J9WuDJLCfKpMzTvMnLbA0djjfDaWJGl95mRhlLBmMgUwGoIW9j9vObLARBXeaOGVlBLVZZPMevNj7oCF+LGoeyyQ/YKCVrBnd+vVGoCmg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtD6CvtoQO8E/oRHipz5pEeP+xVhMaCQvd9imtLgZllKjWfY1iigD6i5c0r4dUXs/eUUeMLSDU+xQXyksAH/K8N+cOEqPsCwhIJbxidw7HRGukOhXEKbEwmIzzcTXX58WOMoBHy0o4c8LUBJeup8b4SnsfiwXvNtiJESctuzcmd4oCZ2o7bXWgPjIicHMzevpW7TBBM5gIbbw3OsEENYQkVnR8eLcuCxTUbhsu7ttYTh02t32OOiN1v4KI6nAq0YET7rAd/nkT1wUDpjPE0f871J8AvUX7EH9hZwvbUrZiFeJ6MTM7nG2mqudk6qeDxR8PtipcKveo/Uw9pD1z9Yl0wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    public static String return_url = "http://47.94.194.28/myOrder.html";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

    public static String FORMAT = "json";
//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

