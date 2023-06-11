package tw.idv.petpet.web.clinic.ecpay.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutOneTime;
import tw.idv.petpet.web.clinic.clinicAppointment.entity.ClinicAppointment;
import tw.idv.petpet.web.clinic.clinicAppointment.service.ClinicAppointmentService;

@Service
public class EcpayService {

	@Autowired
	private ClinicAppointmentService clinicAppointmentService;

	@Autowired
	ClinicAppointment clinicAppointment;

	public String ecpayCheck() {

		AllInOne all = new AllInOne("");
		AioCheckOutOneTime aio = new AioCheckOutOneTime();

		// 使MerchantTradeNo產生20碼隨機字串編碼，避免綠界後台訂單編號重複
		ClinicAppointment latestAppointment = clinicAppointmentService.getLatestReservation();
		String reservation = (latestAppointment != null && latestAppointment.getReservationNumber() != null)
				? latestAppointment.getReservationNumber().toString()
				: "";
		StringBuilder stringBuilder = new StringBuilder("No" + reservation + "order");
		if (stringBuilder.length() < 20) {
			String characters = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
			int remainingLength = 20 - stringBuilder.length();
			Random random = new Random();
			for (int i = 0; i < remainingLength; i++) {
				int randomIndex = random.nextInt(characters.length()); // 取隨機數字，取剩餘長度(remainingLength)次數
				char randomChar = characters.charAt(randomIndex);// 將上面隨機數字轉為索引值取出字串中對應文字
				stringBuilder.append(randomChar);
			}
		}
		String tradeNo = stringBuilder.toString();

		// 設定MerchantTradeDate為當下時間
		Date time = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String tradeTime = simpleDateFormat.format(time);

		aio.setMerchantTradeNo(tradeNo);
		aio.setMerchantTradeDate(tradeTime);
		aio.setTotalAmount("2000");
		aio.setTradeDesc("petpet測試");
		aio.setItemName("洗牙、結紮、健康檢查");
		aio.setStoreID("petpet");
		aio.setNeedExtraPaidInfo("N");

		aio.setClientBackURL("http://localhost:8080/petpet/");// 付款完成頁面上顯示[返回商店]的按鈕，放petpet網站首頁網址
		aio.setReturnURL("https://localhost:8080/petpet/return"); // 必是https，尚未測試

		String form = all.aioCheckOut(aio, null);

		return form;
	}

	// 更改付款狀態
	public void updatePayInfo(Integer reservationNumber) {
		clinicAppointmentService.updatePayInfo(reservationNumber);
	}
}
