package com.a548bky4474.intermediatesub.view.main;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\tJ\u0006\u0010\n\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000b\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/a548bky4474/intermediatesub/view/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/a548bky4474/intermediatesub/repository/StoryRepository;", "(Lcom/a548bky4474/intermediatesub/repository/StoryRepository;)V", "_stories", "Landroidx/lifecycle/MutableLiveData;", "Lcom/a548bky4474/intermediatesub/data/response/StoryResponse;", "stories", "Landroidx/lifecycle/LiveData;", "getStories", "()Landroidx/lifecycle/LiveData;", "userModel", "Lcom/a548bky4474/intermediatesub/data/pref/UserModel;", "getUserModel", "setUserModel", "(Landroidx/lifecycle/LiveData;)V", "getSession", "", "logout", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.a548bky4474.intermediatesub.repository.StoryRepository repository = null;
    public androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.pref.UserModel> userModel;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.a548bky4474.intermediatesub.data.response.StoryResponse> _stories = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.response.StoryResponse> stories = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull
    com.a548bky4474.intermediatesub.repository.StoryRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.pref.UserModel> getUserModel() {
        return null;
    }
    
    public final void setUserModel(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.pref.UserModel> p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.response.StoryResponse> getStories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.pref.UserModel> getSession() {
        return null;
    }
    
    public final void logout() {
    }
    
    public final void getStories() {
    }
}