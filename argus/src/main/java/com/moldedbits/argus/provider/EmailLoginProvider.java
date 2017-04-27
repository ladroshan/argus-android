package com.moldedbits.argus.provider;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.moldedbits.argus.R;
import com.moldedbits.argus.model.ArgusUser;

/**
 * Allow user to login with email and password
 */
public class EmailLoginProvider extends LoginProvider {

    private Context context;

    private EditText usernameInput;
    private EditText passwordInput;

    @Override
    public View inflateLoginView(Context context, ViewGroup parentView) {
        this.context = context;

        View loginView = LayoutInflater.from(context)
                .inflate(R.layout.login_email, parentView, false);

        usernameInput = (EditText) loginView.findViewById(R.id.username);
        passwordInput = (EditText) loginView.findViewById(R.id.password);

        return loginView;
    }

    @Override
    public void performLogin() {
        if (validateInput()) {
            onLoginSuccess(new ArgusUser("Mock User"));
        }
    }

    private boolean validateInput() {
        if (TextUtils.isEmpty(usernameInput.getText())) {
            usernameInput.setError(context.getString(R.string.empty_username));
            return false;
        }

        if (TextUtils.isEmpty(passwordInput.getText())) {
            passwordInput.setError(context.getString(R.string.empty_password));
            return false;
        }

        return true;
    }
}
