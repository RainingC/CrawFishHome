package org.lanqiao.miaodiyun.httpApiDemo;


import org.lanqiao.miaodiyun.httpApiDemo.common.Config;

/**
 * 获取开发者账号信息接口调用示例
 * 
 * @ClassName: AccountInfo
 * @Description: 获取开发者账号信息接口调用示例
 *
 */
public class AccountInfo
{
	private static String operation = "/query/accountInfo";

	private static String accountSid = Config.ACCOUNT_SID;

	/**
	 * 获取开发者账号信息
	 */
	public static void execute()
	{
		String url = Config.BASE_URL + operation;
		String body = "accountSid=" + accountSid + org.lanqiao.miaodiyun.httpApiDemo.common.HttpUtil.createCommonParam();

		// 提交请求
		String result = org.lanqiao.miaodiyun.httpApiDemo.common.HttpUtil.post(url, body);
		System.out.println("result:" + System.lineSeparator() + result);
	}
}
