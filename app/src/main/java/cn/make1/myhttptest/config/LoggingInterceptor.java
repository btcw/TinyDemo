package cn.make1.myhttptest.config;

import java.io.IOException;

import cn.make1.myhttptest.utils.MyLogger;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Comment: //网络日志输出
 *
 * @author Jax.zhou in Make1
 * @date 2018/6/1
 * Company:Make1
 * Email:Jax.zhou@make1.cn
 */
public class LoggingInterceptor implements Interceptor {
    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        //这个chain里面包含了request和response，所以你要什么都可以从这里拿
        Request request = chain.request();
        //请求发起的时间
        long t1 = System.nanoTime();
        MyLogger.d("LoggingInterceptor", String.format("发送请求 %s on %s%n%s",
                request.url(), chain.connection(), request.headers()));

        Response response = chain.proceed(request);
        //收到响应的时间
        long t2 = System.nanoTime();

        //这里不能直接使用response.body().string()的方式输出日志
        //因为response.body().string()之后，response中的流会被关闭，程序会报错，我们需要创建出一
        //个新的response给应用层处理
        ResponseBody responseBody = response.peekBody(Long.MAX_VALUE);

        MyLogger.d("LoggingInterceptor", String.format("接收响应: [%s] %n返回json:【%s】 %.1fms%n%s",
                response.request().url(),
                responseBody.string(),
                (t2 - t1) / 1e6d,
                response.headers()));

//        File file= new File(Environment.getExternalStorageDirectory()+"/网络日志输出.text");
//        if (!file.exists()){
//            file.createNewFile();
//        }
//        InputStream inputStream = responseBody.byteStream();
//        FileOutputStream outputStream = new FileOutputStream(file);
//        int length;
//        byte[] bytes ;
//        while ((length = inputStream.read((bytes = new byte[1024])) ) != -1){
//            outputStream.write(bytes,0,length);
//        }
//        outputStream.flush();
//        inputStream.close();
//        outputStream.close();

        return response;
    }
}
