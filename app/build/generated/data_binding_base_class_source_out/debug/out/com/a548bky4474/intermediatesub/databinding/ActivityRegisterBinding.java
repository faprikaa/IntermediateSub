// Generated by view binder compiler. Do not edit!
package com.a548bky4474.intermediatesub.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.a548bky4474.intermediatesub.R;
import com.a548bky4474.intermediatesub.custview.PasswordInputText;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityRegisterBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnLogin;

  @NonNull
  public final Button btnRegister;

  @NonNull
  public final TextInputLayout textInputLayout;

  @NonNull
  public final TextInputLayout textInputLayout2;

  @NonNull
  public final TextInputEditText tiEmail;

  @NonNull
  public final TextInputEditText tiName;

  @NonNull
  public final PasswordInputText tiPassword;

  @NonNull
  public final TextView tvLogin;

  private ActivityRegisterBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnLogin,
      @NonNull Button btnRegister, @NonNull TextInputLayout textInputLayout,
      @NonNull TextInputLayout textInputLayout2, @NonNull TextInputEditText tiEmail,
      @NonNull TextInputEditText tiName, @NonNull PasswordInputText tiPassword,
      @NonNull TextView tvLogin) {
    this.rootView = rootView;
    this.btnLogin = btnLogin;
    this.btnRegister = btnRegister;
    this.textInputLayout = textInputLayout;
    this.textInputLayout2 = textInputLayout2;
    this.tiEmail = tiEmail;
    this.tiName = tiName;
    this.tiPassword = tiPassword;
    this.tvLogin = tvLogin;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityRegisterBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_register, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityRegisterBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnLogin;
      Button btnLogin = ViewBindings.findChildViewById(rootView, id);
      if (btnLogin == null) {
        break missingId;
      }

      id = R.id.btnRegister;
      Button btnRegister = ViewBindings.findChildViewById(rootView, id);
      if (btnRegister == null) {
        break missingId;
      }

      id = R.id.textInputLayout;
      TextInputLayout textInputLayout = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout == null) {
        break missingId;
      }

      id = R.id.textInputLayout2;
      TextInputLayout textInputLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (textInputLayout2 == null) {
        break missingId;
      }

      id = R.id.tiEmail;
      TextInputEditText tiEmail = ViewBindings.findChildViewById(rootView, id);
      if (tiEmail == null) {
        break missingId;
      }

      id = R.id.tiName;
      TextInputEditText tiName = ViewBindings.findChildViewById(rootView, id);
      if (tiName == null) {
        break missingId;
      }

      id = R.id.tiPassword;
      PasswordInputText tiPassword = ViewBindings.findChildViewById(rootView, id);
      if (tiPassword == null) {
        break missingId;
      }

      id = R.id.tvLogin;
      TextView tvLogin = ViewBindings.findChildViewById(rootView, id);
      if (tvLogin == null) {
        break missingId;
      }

      return new ActivityRegisterBinding((ConstraintLayout) rootView, btnLogin, btnRegister,
          textInputLayout, textInputLayout2, tiEmail, tiName, tiPassword, tvLogin);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}