package com.solvd.github.apiclass.email;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.R;

@Endpoint(url = "${config.base_url}/user/email/visibility", methodType = HttpMethodType.PATCH)
@RequestTemplatePath(path = "api/emails/_patch/rq.json")
@ResponseTemplatePath(path = "api/emails/_patch/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class PatchEmailVisibilityMethod extends AbstractApiMethodV2 {

    public PatchEmailVisibilityMethod() {
        setHeader("Authorization", R.API.get("GITHUB_TOKEN"));
        setHeader("Content-Type", "application/json");
    }


}