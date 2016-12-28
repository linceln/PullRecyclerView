package www.lince.com.test.request;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://gank.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
