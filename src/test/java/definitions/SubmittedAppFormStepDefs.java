package definitions;

import pages.SubmitAppForm;

public class SubmittedAppFormStepDefs {
    SubmitAppForm submitted = new SubmitAppForm();
/*
    @Then("I verify {string} required fields oop")
    public void iVerifyRequiredFieldsOop1(String userType) {
        Map<String, String> user = TestContext.getData(userType);
        submitted.firstName(user);
        submitted.middleName(user);
        submitted.lastName(user);
        submitted.assertFullName(user);
        submitted.assertEmail(user);
        submitted.assertUsername(user);
        submitted.assertPassword();
        submitted.agreedPrivacy();
    }*/
}
