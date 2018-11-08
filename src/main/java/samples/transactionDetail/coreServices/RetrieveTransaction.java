package samples.transactionDetail.coreServices;

import java.util.Properties;

import com.cybersource.authsdk.core.MerchantConfig;

import Api.TransactionDetailsApi;
import Data.Configuration;
import Invokers.ApiClient;
import Invokers.ApiException;

public class RetrieveTransaction {

	private static String responseCode = null;
	private static String status = null;
	private static String id="5408386919326811103004";
	private static Properties merchantProp;

	public static void main(String args[]) throws Exception {
		process();
	}

	private static void process() throws Exception {

		try {
			 /* Read Merchant details. */
			merchantProp = Configuration.getMerchantDetails();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);

			TransactionDetailsApi transactionDetailsApi = new TransactionDetailsApi();
			transactionDetailsApi.getTransaction(id,merchantConfig);

			responseCode = ApiClient.responseCode;
			status = ApiClient.status;
			System.out.println("ResponseCode :" + responseCode);
			System.out.println("ResponseMessage :" + status);

		} catch (ApiException e) {

			e.printStackTrace();
		}
	}

}
