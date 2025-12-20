package com.solvd.testing.github;


import com.solvd.testing.github.apiClass.Email.DeleteListOfEmailMethod;
import com.solvd.testing.github.apiClass.Email.GetListOfEmailMethod;
import com.solvd.testing.github.apiClass.Email.PatchEmailVisibilityMethod;
import com.solvd.testing.github.apiClass.Email.PostListOfEmailMethod;
import com.solvd.testing.github.apiClass.User.GetUserMethod;
import com.zebrunner.agent.core.annotation.Priority;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class githubTest {


    @BeforeClass
    public void changeVisibilityBack() {
        PatchEmailVisibilityMethod patchEmailVisibilityMethod =
                new PatchEmailVisibilityMethod();
        patchEmailVisibilityMethod.setRequestBody(
                "{\"visibility\": \"public\" }"
        );
        patchEmailVisibilityMethod.callAPI();
    }

    @Test()
    @MethodOwner(owner = "nika7407")
    @Priority(Priority.P2)
    public void testGetUser() {
        GetUserMethod getUserMethod = new GetUserMethod();
        getUserMethod.callAPIExpectSuccess();
        getUserMethod.validateResponseAgainstSchema("api/users/_get/rs.json");
    }

    @Test()
    @MethodOwner(owner = "nika7407")
    @Priority(Priority.P2)

    public void testGetEmails() {
        GetListOfEmailMethod getListOfEmailMethod = new GetListOfEmailMethod();
        getListOfEmailMethod.callAPIExpectSuccess();
        getListOfEmailMethod.validateResponseAgainstSchema("api/emails/_get/rs.json");
    }

    @Test()
    @MethodOwner(owner = "nika7407")
    @Priority(Priority.P2)
    public void testPostEmails() {
        PostListOfEmailMethod postListOfEmail = new PostListOfEmailMethod();
        postListOfEmail.callAPIExpectSuccess();
        postListOfEmail.validateResponseAgainstSchema("api/emails/_post/rs.json");
    }

    @Test()
    @MethodOwner(owner = "nika7407")
    @Priority(Priority.P1)
    public void testDeleteEmail() {
        DeleteListOfEmailMethod deleteListOfEmailMethod = new DeleteListOfEmailMethod();
        deleteListOfEmailMethod.callAPIExpectSuccess();
    }

    @Test()
    @MethodOwner(owner = "nika7407")
    @Priority(Priority.P2)

    public void testChangeVisibility() {
        PatchEmailVisibilityMethod patchEmailVisibilityMethod = new PatchEmailVisibilityMethod();
        patchEmailVisibilityMethod.callAPIExpectSuccess();
        patchEmailVisibilityMethod.validateResponseAgainstSchema("api/emails/_patch/rs.json");
    }

}

//@Test()
//@MethodOwner(owner = "qpsdemo")
//public void testGetUsers() {
//    GetUserMethods getUsersMethods = new GetUserMethods();
//    getUsersMethods.callAPIExpectSuccess();
//    getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
//    getUsersMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
//}
