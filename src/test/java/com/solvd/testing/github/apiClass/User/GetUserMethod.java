package com.solvd.testing.github.apiClass.User;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.R;

@Endpoint(url = "${config.base_url}/user", methodType = HttpMethodType.GET)
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
@ResponseTemplatePath(path = "api/users/_get/rs.json")
public class GetUserMethod extends AbstractApiMethodV2 {
    public GetUserMethod() {
        setHeader("Authorization", R.API.get("GITHUB_TOKEN"));
    }
}