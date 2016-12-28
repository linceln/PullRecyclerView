package www.lince.com.test.request;


import retrofit2.Call;
import retrofit2.Callback;

public class Business {

    private static GankService service = HttpManager.getRetrofit().create(GankService.class);

    public static void getGank(int page, Callback<GankEntity> callback) {
        Call<GankEntity> gank = service.getGank(page);
        gank.enqueue(callback);
    }
}
