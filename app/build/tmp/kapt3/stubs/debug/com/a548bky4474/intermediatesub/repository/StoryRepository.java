package com.a548bky4474.intermediatesub.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ!\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\u0014H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015J)\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0007H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u001cJ)\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010!R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006#"}, d2 = {"Lcom/a548bky4474/intermediatesub/repository/StoryRepository;", "", "userPreference", "Lcom/a548bky4474/intermediatesub/data/pref/UserPreference;", "(Lcom/a548bky4474/intermediatesub/data/pref/UserPreference;)V", "getSession", "Lkotlinx/coroutines/flow/Flow;", "Lcom/a548bky4474/intermediatesub/data/pref/UserModel;", "getStoriesRepo", "Lcom/a548bky4474/intermediatesub/data/response/StoryResponse;", "token", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getStoriesWithLocationRepo", "loginUser", "Lcom/a548bky4474/intermediatesub/data/response/LoginResponse;", "email", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerUser", "Lcom/a548bky4474/intermediatesub/data/response/RegisterResponse;", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveSession", "user", "(Lcom/a548bky4474/intermediatesub/data/pref/UserModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadImage", "imageFile", "Ljava/io/File;", "description", "(Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class StoryRepository {
    @org.jetbrains.annotations.NotNull
    private final com.a548bky4474.intermediatesub.data.pref.UserPreference userPreference = null;
    @kotlin.jvm.Volatile
    @org.jetbrains.annotations.Nullable
    private static volatile com.a548bky4474.intermediatesub.repository.StoryRepository instance;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ONRESPONSE_TAG = "Error@StoryRepository#OnResponse";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String ONFAILURE_TAG = "Error@StoryRepository#OnFailure";
    @org.jetbrains.annotations.NotNull
    public static final com.a548bky4474.intermediatesub.repository.StoryRepository.Companion Companion = null;
    
    private StoryRepository(com.a548bky4474.intermediatesub.data.pref.UserPreference userPreference) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object registerUser(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.a548bky4474.intermediatesub.data.response.RegisterResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object loginUser(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.a548bky4474.intermediatesub.data.response.LoginResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getStoriesRepo(@org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.a548bky4474.intermediatesub.data.response.StoryResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getStoriesWithLocationRepo(@org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.a548bky4474.intermediatesub.data.response.StoryResponse> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object saveSession(@org.jetbrains.annotations.NotNull
    com.a548bky4474.intermediatesub.data.pref.UserModel user, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<com.a548bky4474.intermediatesub.data.pref.UserModel> getSession() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object logout(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object uploadImage(@org.jetbrains.annotations.NotNull
    java.io.File imageFile, @org.jetbrains.annotations.NotNull
    java.lang.String description, @org.jetbrains.annotations.NotNull
    java.lang.String token, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.a548bky4474.intermediatesub.data.response.RegisterResponse> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rR\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/a548bky4474/intermediatesub/repository/StoryRepository$Companion;", "", "()V", "ONFAILURE_TAG", "", "getONFAILURE_TAG", "()Ljava/lang/String;", "ONRESPONSE_TAG", "getONRESPONSE_TAG", "instance", "Lcom/a548bky4474/intermediatesub/repository/StoryRepository;", "getInstance", "userPreference", "Lcom/a548bky4474/intermediatesub/data/pref/UserPreference;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.a548bky4474.intermediatesub.repository.StoryRepository getInstance(@org.jetbrains.annotations.NotNull
        com.a548bky4474.intermediatesub.data.pref.UserPreference userPreference) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getONRESPONSE_TAG() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getONFAILURE_TAG() {
            return null;
        }
    }
}