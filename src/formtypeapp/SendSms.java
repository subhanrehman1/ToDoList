package formtypeapp;
import java.util.Date;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
public class SendSms{
	public static void SendSmsbyapi(String message,String number,String apikey){
		
		try
		{	
		//String apiKey="QUdxSmDXqpnuNRIh9zTgELGvVbHk3F4awyWYZOjClAfocB1MiJpPx3D5LBS2YUlZwNcR6yv4MV7m9TFH";
		String sendId="TXTIND";
		
		message=URLEncoder.encode(message, "UTF-8");
		System.out.println(message);
		String language="english";
		
		String route="p";
		
		
		String myUrl="https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&sender_id="+sendId+"&message="+message+"&route=v3&numbers="+number;
		
		//sending get request using java..
		
		URL url=new URL(myUrl);
		
		HttpsURLConnection con=(HttpsURLConnection)url.openConnection();
		
		
		con.setRequestMethod("GET");
		
		con.setRequestProperty("User-Agent", "Mozilla/5.0");
		con.setRequestProperty("cache-control", "no-cache");
		System.out.println("Wait..............");
		
		int code=con.getResponseCode();
		
		System.out.println("Response code : "+code);
		
		StringBuffer response=new StringBuffer();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		while(true)
		{
			String line=br.readLine();
			if(line==null)
			{
				break;
			}
			response.append(line);
		}
		
		System.out.println(response);
		
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
}

