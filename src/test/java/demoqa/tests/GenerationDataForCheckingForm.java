package demoqa.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class GenerationDataForCheckingForm extends TestBase {

    @Test
    @Tag("Jenkins")
    public void fillForm() {
        step("Open url", () -> {
            checkingFormPage.openPage();
        });
        step("Validate Title", () -> {
            checkingFormPage.validateTitle();
        });
        step ("Input Firstname", () -> {
            checkingFormPage.firstNameInput(testData.firstName);
        });
        step ("Input Lastname", () -> {
            checkingFormPage.lastNameInput(testData.lastName);
        });
        step ("Input Email", () -> {
            checkingFormPage.emailInput(testData.email);
        });
        step ("Choose one Gender (radio-button)", () -> {
            checkingFormPage.chooseGender(testData.gender);
        });
        step("Input Mobile Number", () -> {
            checkingFormPage.numberInput(testData.number);
        });
        step ("Choose Date of Birth", () -> {
            checkingFormPage.chooseDateOfBirth(testData.dayOfBirth, testData.stringOfMonth, testData.yearOfBirth);
        });
        step ("Input Subjects", () -> {
            checkingFormPage.subjectsInput(testData.subject);
        });
        step ("Choose Hobbies (one, two or all)", () -> {
            checkingFormPage.chooseHobbies(testData.hobby);
        });
        step ("Upload Picture", () -> {
            checkingFormPage.uploadPicture(testData.picture);
        });
        step ("Input Current Address", () -> {
            checkingFormPage.addressInput(testData.address);
        });
        step ("Select State and City", () -> {
            checkingFormPage.selectStateAndCity(testData.state, testData.city);
        });
        step ("Press button 'Submit'", () -> {
            checkingFormPage.pressButton();
        });

        step ("Check that output data equals input data", () -> {
            checkingFormPage.verifyResultsAppears()
                    .checkAllOutputData(testData.firstName + " " + testData.lastName)
                    .checkAllOutputData(testData.email)
                    .checkAllOutputData(testData.gender)
                    .checkAllOutputData(testData.number)
                    .checkAllOutputData(testData.dayOfBirth + " " + testData.monthOfBirth + "," + testData.yearOfBirth)
                    .checkAllOutputData(testData.subject)
                    .checkAllOutputData(testData.hobby)
                    .checkAllOutputData(testData.address)
                    .checkAllOutputData(testData.state + " " + testData.city);
        });
    }
}

