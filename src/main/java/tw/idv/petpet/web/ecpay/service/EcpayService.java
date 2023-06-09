package tw.idv.petpet.web.ecpay.service;

import org.springframework.stereotype.Service;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutOneTime;

@Service
public class EcpayService {
	
	public String ecpayCheck() {
		
		AllInOne all = new AllInOne("");
		AioCheckOutOneTime aio = new AioCheckOutOneTime();
		
		aio.setMerchantTradeNo("test1");
		aio.setMerchantTradeDate("2023/01/01 08:05:23");
		aio.setTotalAmount("2000");
		aio.setTradeDesc("test Description");
		aio.setItemName("TestItem");
	// 交易結果回傳網址，只接受 https 開頭的網站，可以使用 ngrok	obj.setReturnURL("http://211.23.128.214:5000");
		aio.setNeedExtraPaidInfo("N");
        // 商店轉跳網址 (Optional)
        aio.setClientBackURL("http://192.168.1.37:8080/");
		String form = all.aioCheckOut(aio, null);
		
		return form;
	}
}
