package com.solvd.github.apiclass.email;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.R;


@Endpoint(url = "${config.base_url}/user/public_emails", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetListOfEmailMethod extends AbstractApiMethodV2 {
    public GetListOfEmailMethod() {
        setHeader("Authorization", R.API.get("GITHUB_TOKEN"));
    }
}
