package com.a548bky4474.intermediatesub.data.retrofit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\'J\"\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH\'J/\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\b2\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\"\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\b\u0001\u0010\u0011\u001a\u00020\u0012H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lcom/a548bky4474/intermediatesub/data/retrofit/ApiService;", "", "getStories", "Lretrofit2/Call;", "Lcom/a548bky4474/intermediatesub/data/response/StoryResponse;", "login", "Lcom/a548bky4474/intermediatesub/data/response/LoginResponse;", "email", "", "password", "register", "Lcom/a548bky4474/intermediatesub/data/response/RegisterResponse;", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadImage", "file", "Lokhttp3/MultipartBody$Part;", "description", "Lokhttp3/RequestBody;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.FormUrlEncoded
    @retrofit2.http.POST(value = "register")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object register(@retrofit2.http.Field(value = "name")
    @org.jetbrains.annotations.NotNull
    java.lang.String name, @retrofit2.http.Field(value = "email")
    @org.jetbrains.annotations.NotNull
    java.lang.String email, @retrofit2.http.Field(value = "password")
    @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.a548bky4474.intermediatesub.data.response.RegisterResponse> $completion);
    
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
    
    @retrofit2.http.Multipart
    @retrofit2.http.POST(value = "stories")
    @org.jetbrains.annotations.NotNull
    public abstract retrofit2.Call<com.a548bky4474.intermediatesub.data.response.RegisterResponse> uploadImage(@retrofit2.http.Part
    @org.jetbrains.annotations.NotNull
    okhttp3.MultipartBody.Part file, @retrofit2.http.Part(value = "description")
    @org.jetbrains.annotations.NotNull
    okhttp3.RequestBody description);
}