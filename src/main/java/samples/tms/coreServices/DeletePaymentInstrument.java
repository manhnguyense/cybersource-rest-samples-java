package samples.tms.coreServices;

import java.util.Properties;

import com.cybersource.authsdk.core.MerchantConfig;

import Api.PaymentInstrumentsApi;
import Data.Configuration;
import Invokers.ApiClient;
import Invokers.ApiException;

public class DeletePaymentInstrument {
	private static String profileId = "93B32398-AD51-4CC2-A682-EA3E93614EB1";
	private static String tokenId="79FF4300A1C11276E05340588D0AFA76";
	private static String responseCode = null;
	private static String status = null;
	private static Properties merchantProp;

	public static void main(String args[]) throws Exception {
		process();
	}

	private static void process() throws Exception {

		try {
			/* Read Merchant details. */
			merchantProp = Configuration.getMerchantDetails();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			
			PaymentInstrumentsApi paymentInstrumentApi = new PaymentInstrumentsApi();
			paymentInstrumentApi.tmsV1PaymentinstrumentsTokenIdDelete(profileId, tokenId,merchantConfig);

			responseCode = ApiClient.responseCode;
			status = ApiClient.status;

			System.out.println("ResponseCode :" + responseCode);
			System.out.println("Status :" + status);

		} catch (ApiException e) {

			e.printStackTrace();
		}
	}

}
