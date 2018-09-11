package org.lanqiao.miaodiyun.httpApiDemo;

import org.lanqiao.miaodiyun.httpApiDemo.common.Config;
import org.lanqiao.miaodiyun.httpApiDemo.common.HttpUtil;

import java.net.URLEncoder;


/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";
	private  String random=Random();

	private static String accountSid = Config.ACCOUNT_SID;
	private  String smsContent = "【蓝桥云课堂】尊敬的用户，您好，您正在注册蓝桥云课堂，您的验证码为"+random+",请于2分钟内正确输入，如非本人操作，请忽略此短信";

	/**
	 * 验证码通知短信
	 */
	public static String Random(){
		StringBuffer str = new StringBuffer();
		for (int i = 0 ; i<6 ;i++){
			str.append((int)(Math.random()*(10)));
		}
		return str.toString();
	}
	public String execute(String to)
	{
		String tmpSmsContent = null;
	    try{
	      tmpSmsContent = URLEncoder.encode(smsContent, "UTF-8");
	    }catch(Exception e){
	      
	    }
	    String url = Config.BASE_URL + operation;
	    String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + tmpSmsContent
	        + HttpUtil.createCommonParam();

	    // 提交请求
	    String result = HttpUtil.post(url, body);
	    System.out.println("result:" + System.lineSeparator() + result);
	    return random;
	}
}
