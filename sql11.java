package li.西二task3;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
public class sql11 {
    public static void main(String args[]) throws IOException {//来获取每个城市的信息，以福州为例
        StringBuffer sb=new StringBuffer();
        try{
            String weather="https://geoapi.qweather.com/v2/city/lookup?location=101230101&key=c0a843c54cdd4d3bbb175d0ab837a187";
            URL url=new URL(weather);
            URLConnection conn=url.openConnection();
            InputStream is=conn.getInputStream();
            GZIPInputStream gain=new GZIPInputStream(is);
            InputStreamReader isr=new InputStreamReader(gain,"utf-8");
            BufferedReader reader=new BufferedReader(isr);
            String line=null;
            while((line=reader.readLine())!=null)
                sb.append(line+"");
            reader.close();
        }catch (IOException e ){
            e.printStackTrace();
        }
        System.out.printf(sb.toString());
    }
}
