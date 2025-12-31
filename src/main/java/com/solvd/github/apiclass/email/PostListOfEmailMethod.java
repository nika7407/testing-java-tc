package com.solvd.github.apiclass.email;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.PropertiesPath;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.R;

@Endpoint(url = "${config.base_url}/user/emails", methodType = HttpMethodType.POST)
@PropertiesPath(path = "api/emails/email.properties")
@RequestTemplatePath(path = "api/emails/_post/rq.json")
@ResponseTemplatePath(path = "api/emails/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostListOfEmailMethod extends AbstractApiMethodV2 {
    public PostListOfEmailMethod() {
        setHeader("Authorization", R.API.get("GITHUB_TOKEN"));
        setHeader("Accept", "application/vnd.github+json");
    }

}
