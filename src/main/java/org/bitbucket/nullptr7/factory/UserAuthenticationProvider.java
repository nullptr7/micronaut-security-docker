package org.bitbucket.nullptr7.factory;

import edu.umd.cs.findbugs.annotations.Nullable;
import io.micronaut.http.HttpRequest;
import io.micronaut.security.authentication.AuthenticationFailed;
import io.micronaut.security.authentication.AuthenticationProvider;
import io.micronaut.security.authentication.AuthenticationRequest;
import io.micronaut.security.authentication.AuthenticationResponse;
import io.micronaut.security.authentication.UserDetails;
import io.reactivex.Flowable;
import org.reactivestreams.Publisher;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collections;

@Singleton
public class UserAuthenticationProvider implements AuthenticationProvider {


    @Inject
    UserStore store;

    @Override
    public Publisher<AuthenticationResponse> authenticate(@Nullable HttpRequest<?> httpRequest, AuthenticationRequest<?, ?> req) {
        String username = req.getIdentity()
                             .toString();
        String password = req.getSecret()
                             .toString();
        if (password.equals(store.getUserPassword(username))) {
            final UserDetails details = new UserDetails(username, Collections.singleton(store.getUserRole(username)));
            return Flowable.just(details);
        } else {
            return Flowable.just(new AuthenticationFailed());
        }
    }

}
