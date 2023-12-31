package com.a548bky4474.intermediatesub.data.retrofit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J%\u0010\u0005\u001a\u00020\u00042\b\b\u0003\u0010\u0006\u001a\u00020\u00072\b\b\u0003\u0010\b\u001a\u00020\u0007H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0003\u0010\u000b\u001a\u00020\u0007H\'J\"\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH\'J,\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0013\u001a\u00020\u000f2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\u000fH\'J?\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u0015\u001a\u00020\u00162\n\b\u0003\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0003\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\'\u00a2\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00032\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u001e"}, d2 = {"Lcom/a548bky4474/intermediatesub/data/retrofit/ApiService;", "", "getStories", "Lretrofit2/Call;", "Lcom/a548bky4474/intermediatesub/data/response/StoryResponse;", "getStoriesForPaging", "page", "", "size", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStoriesWithLocation", "location", "login", "Lcom/a548bky4474/intermediatesub/data/response/LoginResponse;", "email", "", "password", "register", "Lcom/a548bky4474/intermediatesub/data/response/RegisterResponse;", "name", "uploadImage", "file", "Lokhttp3/MultipartBody$Part;", "lat", "", "lon", "description", "Lokhttp3/RequestBody;", "(Lokhttp3/MultipartBody$Part;Ljava/lang/Double;Ljava/lang/Double;Lokhttp3/RequestBody;)Lretrofit2/Call;", "uploadImageWithoutLocation", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.FormUrlEncoded
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.a548bky4474.intermediatesub.data.response.RegisterResponse> register(@retrofit2.http.Field(value = "name")
    @org.jetbrains.annotations.NotNull
    java.lang.String name, @retrofit2.http.Field(value = "email")
    @org.jetbrains.annotations.NotNull
    java.lang.String email, @retrofit2.http.Field(value = "password")
    @org.jetbrains.annotations.NotNull
    java.lang.String password);
    
    @retrofit2.http.FormUrlEncoded
    @retrofit2.http.POST(value = "login")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.a548bky4474.intermediatesub.data.response.LoginResponse> login(@retrofit2.http.Field(value = "email")
    @org.jetbrains.annotations.NotNull
    java.lang.String email, @retrofit2.http.Field(value = "password")
    @org.jetbrains.annotations.NotNull
    java.lang.String password);
    
    @retrofit2.http.GET(value = "stories")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.a548bky4474.intermediatesub.data.response.StoryResponse> getStories();
    
    @retrofit2.http.GET(value = "stories")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getStoriesForPaging(@retrofit2.http.Query(value = "page")
    int page, @retrofit2.http.Query(value = "size")
    int size, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.a548bky4474.intermediatesub.data.response.StoryResponse> $completion);
    
    @retrofit2.http.GET(value = "stories")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.a548bky4474.intermediatesub.data.response.StoryResponse> getStoriesWithLocation(@retrofit2.http.Query(value = "location")
    int location);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST(value = "stories")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.a548bky4474.intermediatesub.data.response.RegisterResponse> uploadImage(@retrofit2.http.Part
    @org.jetbrains.annotations.NotNull
    okhttp3.MultipartBody.Part file, @retrofit2.http.Part(value = "lat")
    @org.jetbrains.annotations.Nullable
    java.lang.Double lat, @retrofit2.http.Part(value = "lon")
    @org.jetbrains.annotations.Nullable
    java.lang.Double lon, @retrofit2.http.Part(value = "description")
    @org.jetbrains.annotations.NotNull
    okhttp3.RequestBody description);
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST(value = "stories")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.a548bky4474.intermediatesub.data.response.RegisterResponse> uploadImageWithoutLocation(@retrofit2.http.Part(value = "description")
    @org.jetbrains.annotations.NotNull
    okhttp3.RequestBody description);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}