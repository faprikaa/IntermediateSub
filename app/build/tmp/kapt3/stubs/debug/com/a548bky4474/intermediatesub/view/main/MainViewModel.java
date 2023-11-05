package com.a548bky4474.intermediatesub.view.main;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0019\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000b2\u0006\u0010\u001a\u001a\u00020\u001bJ\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bJ\u0006\u0010\f\u001a\u00020\u001dJ\u0006\u0010\u001e\u001a\u00020\u001dJ\b\u0010\u001f\u001a\u00020\u001bH\u0002J\u0006\u0010 \u001a\u00020\u001dR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR(\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000f\u00a8\u0006!"}, d2 = {"Lcom/a548bky4474/intermediatesub/view/main/MainViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/a548bky4474/intermediatesub/repository/StoryRepository;", "(Lcom/a548bky4474/intermediatesub/repository/StoryRepository;)V", "_stories", "Landroidx/lifecycle/MutableLiveData;", "Lcom/a548bky4474/intermediatesub/data/response/StoryResponse;", "get_stories", "()Landroidx/lifecycle/MutableLiveData;", "stories", "Landroidx/lifecycle/LiveData;", "getStories", "()Landroidx/lifecycle/LiveData;", "setStories", "(Landroidx/lifecycle/LiveData;)V", "story", "Landroidx/paging/PagingData;", "Lcom/a548bky4474/intermediatesub/data/response/ListStoryItem;", "getStory", "setStory", "userModel", "Lcom/a548bky4474/intermediatesub/data/pref/UserModel;", "getUserModel", "setUserModel", "fetchStory", "token", "", "getSession", "", "getStoriesWithLocation", "getToken", "logout", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.a548bky4474.intermediatesub.repository.StoryRepository repository = null;
    public androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.pref.UserModel> userModel;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.a548bky4474.intermediatesub.data.response.StoryResponse> _stories = null;
    @org.jetbrains.annotations.NotNull
    private androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.response.StoryResponse> stories;
    @org.jetbrains.annotations.Nullable
    private androidx.lifecycle.LiveData<androidx.paging.PagingData<com.a548bky4474.intermediatesub.data.response.ListStoryItem>> story;
    
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
    public final androidx.lifecycle.MutableLiveData<com.a548bky4474.intermediatesub.data.response.StoryResponse> get_stories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.response.StoryResponse> getStories() {
        return null;
    }
    
    public final void setStories(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.response.StoryResponse> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.a548bky4474.intermediatesub.data.response.ListStoryItem>> getStory() {
        return null;
    }
    
    public final void setStory(@org.jetbrains.annotations.Nullable
    androidx.lifecycle.LiveData<androidx.paging.PagingData<com.a548bky4474.intermediatesub.data.response.ListStoryItem>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final androidx.lifecycle.LiveData<androidx.paging.PagingData<com.a548bky4474.intermediatesub.data.response.ListStoryItem>> fetchStory(@org.jetbrains.annotations.NotNull
    java.lang.String token) {
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
    
    public final void getStoriesWithLocation() {
    }
    
    private final java.lang.String getToken() {
        return null;
    }
}