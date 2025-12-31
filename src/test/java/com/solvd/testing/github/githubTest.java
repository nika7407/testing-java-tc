package com.solvd.testing.github;


import com.solvd.github.apiclass.email.DeleteListOfEmailMethod;
import com.solvd.github.apiclass.email.GetListOfEmailMethod;
import com.solvd.github.apiclass.email.PatchEmailVisibilityMethod;
import com.solvd.github.apiclass.email.PostListOfEmailMethod;
import com.solvd.github.apiclass.user.GetUserMethod;
import com.zebrunner.agent.core.annotation.Priority;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class githubTest {

    private static final Logger log = LogManager.getLogger(githubTest.class);

    @BeforeClass
    public void changeVisibilityBack() {
        PatchEmailVisibilityMethod patchEmailVisibilityMethod =
                new PatchEmailVisibilityMethod();
        patchEmailVisibilityMethod.setRequestTemplate("api/emails/_patch/rq-private.json");
        log.info("request body = " + patchEmailVisibilityMethod.getRequestBody());

        patchEmailVisibilityMethod.callAPI();
        log.info("email visibility changed");
    }

    @Test()
    @MethodOwner(owner = "nika7407")
    @Priority(Priority.P2)
    public void testGetUser() {
        GetUserMethod getUserMethod = new GetUserMethod();
        getUserMethod.callAPIExpectSuccess();
        getUserMethod.validateResponse();
        //   getUserMethod.validateResponseAgainstSchema("api/users/_get/rs.json");
    }

    @Test()
    @MethodOwner(owner = "nika7407")
    @Priority(Priority.P2)
    public void testGetEmails() {
        GetListOfEmailMethod getListOfEmailMethod = new GetListOfEmailMethod();
        getListOfEmailMethod.callAPIExpectSuccess();
        //  getListOfEmailMethod.validateResponse();
        //  getListOfEmailMethod.validateResponseAgainstSchema("api/emails/_get/rs.json");
    }

    @Test()
    @MethodOwner(owner = "nika7407")
    @Priority(Priority.P2)
    public void testPostEmails() {
        PostListOfEmailMethod postListOfEmail = new PostListOfEmailMethod();
        postListOfEmail.callAPIExpectSuccess();
        postListOfEmail.validateResponse();
        //       postListOfEmail.validateResponseAgainstSchema("api/emails/_post/rs.json");
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
        patchEmailVisibilityMethod.validateResponse();
        //     patchEmailVisibilityMethod.validateResponseAgainstSchema("api/emails/_patch/rs.json");
    }

}
