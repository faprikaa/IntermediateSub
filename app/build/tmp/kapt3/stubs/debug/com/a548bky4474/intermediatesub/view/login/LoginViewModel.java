package com.a548bky4474.intermediatesub.view.login;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u000e\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0014"}, d2 = {"Lcom/a548bky4474/intermediatesub/view/login/LoginViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/a548bky4474/intermediatesub/repository/StoryRepository;", "(Lcom/a548bky4474/intermediatesub/repository/StoryRepository;)V", "_resultLogin", "Landroidx/lifecycle/MutableLiveData;", "Lcom/a548bky4474/intermediatesub/data/response/LoginResponse;", "resultLogin", "Landroidx/lifecycle/LiveData;", "getResultLogin", "()Landroidx/lifecycle/LiveData;", "loginUser", "", "email", "", "password", "saveSession", "user", "Lcom/a548bky4474/intermediatesub/data/pref/UserModel;", "app_debug"})
public final class LoginViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.a548bky4474.intermediatesub.repository.StoryRepository repository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.a548bky4474.intermediatesub.data.response.LoginResponse> _resultLogin = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.response.LoginResponse> resultLogin = null;
    
    public LoginViewModel(@org.jetbrains.annotations.NotNull
    com.a548bky4474.intermediatesub.repository.StoryRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.response.LoginResponse> getResultLogin() {
        return null;
    }
    
    public final void saveSession(@org.jetbrains.annotations.NotNull
    com.a548bky4474.intermediatesub.data.pref.UserModel user) {
    }
    
    public final void loginUser(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
}