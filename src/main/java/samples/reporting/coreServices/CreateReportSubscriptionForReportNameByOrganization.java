package samples.reporting.coreServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.cybersource.authsdk.core.MerchantConfig;

import Api.ReportSubscriptionsApi;
import Data.Configuration;
import Invokers.ApiClient;
import Invokers.ApiException;
import Model.RequestBody;
import Model.RequestBody.ReportMimeTypeEnum;

public class CreateReportSubscriptionForReportNameByOrganization {
	private static String responseCode = null;
	private static String status = null;
	private static RequestBody request;
	private static Properties merchantProp;
	
	private static RequestBody getRequest() {
		request = new RequestBody();
		
		request.reportDefinitionName("TransactionRequestClass");
		
		List<String> reportFields=new ArrayList<String>();
		reportFields.add("Request.RequestID");
		reportFields.add("Request.TransactionDate");
		reportFields.add("Request.MerchantID");
		request.reportFields(reportFields);

		
		request.reportFrequency("WEEKLY");
		request.startDay(2);
		request.startTime("0900");
		
		request.reportMimeType(ReportMimeTypeEnum.TEXT_CSV);
		request.reportName("Texture");
		request.timezone("America/Chicago");
		return request;

	}

	public static void main(String args[]) throws Exception {
		process();
	}

	public static void process() throws Exception {

		try {
			request = getRequest();

			/* Read Merchant details. */
			merchantProp = Configuration.getMerchantDetails();
			MerchantConfig merchantConfig = new MerchantConfig(merchantProp);
			
			ReportSubscriptionsApi reportSubscriptionsApi = new ReportSubscriptionsApi();
			reportSubscriptionsApi.createSubscription(request,merchantConfig);
			
			responseCode = ApiClient.responseCode;
			status = ApiClient.status;
		
			System.out.println("ResponseCode :" + responseCode);
			System.out.println("ResponseMessage :" + status);
			

		} catch (ApiException e) {

			e.printStackTrace();
		}
	}

}
