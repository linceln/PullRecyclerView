package www.lince.com.test.request;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GankService {

    @GET("api/data/福利/10/{page}")
    Call<GankEntity> getGank(@Path("page") int page);
}
