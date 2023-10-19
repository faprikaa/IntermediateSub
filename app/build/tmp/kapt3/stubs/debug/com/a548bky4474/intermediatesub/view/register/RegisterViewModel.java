package com.a548bky4474.intermediatesub.view.register;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/a548bky4474/intermediatesub/view/register/RegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "storyRepository", "Lcom/a548bky4474/intermediatesub/repository/StoryRepository;", "(Lcom/a548bky4474/intermediatesub/repository/StoryRepository;)V", "_resultRegister", "Landroidx/lifecycle/MutableLiveData;", "Lcom/a548bky4474/intermediatesub/data/response/RegisterResponse;", "resultRegister", "Landroidx/lifecycle/LiveData;", "getResultRegister", "()Landroidx/lifecycle/LiveData;", "registerUser", "", "name", "", "email", "password", "app_debug"})
public final class RegisterViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull
    private final com.a548bky4474.intermediatesub.repository.StoryRepository storyRepository = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.MutableLiveData<com.a548bky4474.intermediatesub.data.response.RegisterResponse> _resultRegister = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.response.RegisterResponse> resultRegister = null;
    
    public RegisterViewModel(@org.jetbrains.annotations.NotNull
    com.a548bky4474.intermediatesub.repository.StoryRepository storyRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final androidx.lifecycle.LiveData<com.a548bky4474.intermediatesub.data.response.RegisterResponse> getResultRegister() {
        return null;
    }
    
    public final void registerUser(@org.jetbrains.annotations.NotNull
    java.lang.String name, @org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
}